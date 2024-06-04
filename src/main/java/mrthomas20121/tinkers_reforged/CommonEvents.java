package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.effect.EffectTicking;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class CommonEvents {

    public static UUID ATTACK_RANGE = UUID.fromString("4d951952-b1eb-4a4e-908a-046f24a11795");
    public static UUID ATTACK_SPEED = UUID.fromString("abf1b64d-892b-4e3f-bdfd-2d4130c9fe9e");
    public static AttributeModifier ATTACK_RANGE_MOD = new AttributeModifier(ATTACK_RANGE, "reforged_attack_range",1.5d, AttributeModifier.Operation.ADDITION);
    public static AttributeModifier ATTACK_SPEED_MOD = new AttributeModifier(ATTACK_SPEED, "reforged_attack_speed",-0.3d, AttributeModifier.Operation.ADDITION);

    @SubscribeEvent
    public static void effectRemove(MobEffectEvent.Remove event) {
        if(Objects.requireNonNull(event.getEffectInstance()).getEffect() instanceof EffectTicking) {
            int level = event.getEffectInstance().getAmplifier();
            event.getEntity().hurt(new DamageSource("ticking_damage").damageHelmet().setScalesWithDifficulty(), event.getEntity().getHealth()*0.1f*level);
        }
    }
    @SubscribeEvent
    public static void itemAttributeEvent(ItemAttributeModifierEvent event) {
        if(event.getSlotType().equals(EquipmentSlot.MAINHAND)) {
            if(event.getItemStack().is(TinkersReforgedItems.LONGSWORD.get())) {
                event.addModifier(ForgeMod.ATTACK_RANGE.get(), ATTACK_RANGE_MOD);
            }
            else if(event.getItemStack().is(TinkersReforgedItems.GREATSWORD.get())) {
                event.addModifier(Attributes.ATTACK_SPEED, ATTACK_SPEED_MOD);
            }
        }
    }

    @SubscribeEvent
    public static void deathEvent(LivingDeathEvent event) {
        if(!event.isCanceled()) {
            if(event.getSource() instanceof EntityDamageSource source) {
                Entity entity = source.getEntity();
                if(entity instanceof LivingEntity e) {
                    if(e.getMainHandItem().is(TinkerTags.Items.MODIFIABLE)) {
                        IToolStackView toolStack = ToolStack.from(e.getMainHandItem());
                        toolStack.getModifierList().forEach(mod -> mod.getHook(TinkersReforgedHooks.DEATH_MODIFIER).onDeath(toolStack, e, source, event.getEntity()));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void critEvent(CriticalHitEvent event) {
        if(event.getEntity() != null) {
            if(event.getEntity().getMainHandItem().is(TinkersReforgedItems.GREATSWORD.get())) {
                event.setDamageModifier(4f);
            }
            else {
                ItemStack stack = event.getEntity().getMainHandItem();
                if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                    IToolStackView toolstack = ToolStack.from(stack);
                    toolstack.getModifierList().forEach(mod -> mod.getHook(TinkersReforgedHooks.CRIT_MODIFIER).onCrit(toolstack, event.getEntity(), event));
                }
            }
        }
    }

    @SubscribeEvent
    public static void lootEvent(LivingDropsEvent event) {
        int looting = event.getLootingLevel();
        DamageSource source = event.getSource();
        LivingEntity entity = event.getEntity();
        boolean isRecentlyHit = event.isRecentlyHit();

        if(source.getDirectEntity() instanceof LivingEntity attacker) {
            ItemStack stack = attacker.getMainHandItem();
            if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                IToolStackView toolstack = ToolStack.from(stack);
                toolstack.getModifierList().forEach(mod -> mod.getHook(TinkersReforgedHooks.ENTITY_LOOT_MODIFIER).onLootDrop(toolstack, attacker, event.getDrops(), looting, source, entity, isRecentlyHit, event));
            }
        }
    }

    @SubscribeEvent
    public static void expDropEvent(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if(player != null) {
            ItemStack stack = player.getMainHandItem();
            if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                IToolStackView toolstack = ToolStack.from(stack);
                toolstack.getModifierList().forEach(mod -> mod.getHook(TinkersReforgedHooks.ENTITY_LOOT_MODIFIER).onExperienceDrop(toolstack, player, event));
            }
        }
    }
}
