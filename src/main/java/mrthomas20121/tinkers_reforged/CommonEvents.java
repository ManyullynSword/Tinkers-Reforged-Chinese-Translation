package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.effect.EffectTicking;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void effectRemove(MobEffectEvent.Remove event) {
        if(event.getEffectInstance() != null && event.getEffectInstance().getEffect() instanceof EffectTicking) {
            int level = event.getEffectInstance().getAmplifier();
            event.getEntity().hurt(new DamageSource("ticking_damage").damageHelmet().setScalesWithDifficulty(), event.getEntity().getHealth()*0.1f*level);
        }
    }

    @SubscribeEvent
    public static void missingMapping(MissingMappingsEvent event) {

        // replace aluminum cast by aluminum brass casts in existing worlds
        event.getMappings(ForgeRegistries.Keys.ITEMS, TinkersReforged.MOD_ID).forEach(mapping -> {
            String oldKey = mapping.getKey().getPath();
            if(oldKey.contains("aluminum_cast")) {
                mapping.remap(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TinkersReforged.MOD_ID, oldKey.replace("aluminum", "aluminum_brass"))));
            }
        });
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
