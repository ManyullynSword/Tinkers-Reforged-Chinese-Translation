package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.EntityLootModifierHook;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.data.ModifierIds;

import java.util.Collection;

public class DraconicScaleModifier extends Modifier implements EntityLootModifierHook {

    public DraconicScaleModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, TinkersReforgedHooks.ENTITY_LOOT_MODIFIER);
    }

    @Override
    public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {

    }

    @Override
    public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {
        // check if the tool has looting
        int level = tool.getModifierLevel(ModifierIds.looting);
        if(level > 0) {
            int expDropped = event.getDroppedExperience();

            event.setDroppedExperience(expDropped + tool.getModifierLevel(this) + expDropped/2*level);
        }
    }
}
