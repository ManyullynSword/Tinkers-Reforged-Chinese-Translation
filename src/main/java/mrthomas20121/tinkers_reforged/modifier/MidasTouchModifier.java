package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.EntityLootModifierHook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.Collection;

public class MidasTouchModifier extends Modifier implements EntityLootModifierHook {

    public MidasTouchModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, TinkersReforgedHooks.ENTITY_LOOT_MODIFIER);
    }

    @Override
    public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {
        int size = tool.getModifierLevel(this);
        // remove drops and replace them gold nugget
        for(int i = 0; i <= size; i++) {
            BlockPos pos = entity.getOnPos();
            items.add(new ItemEntity(entity.getLevel(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.GOLD_NUGGET)));
        }
    }

    @Override
    public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {

    }
}
