package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class UnderTheSeaModifier extends Modifier implements BreakSpeedModifierHook {

    public UnderTheSeaModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.BREAK_SPEED);
    }

    private float calcBonusSpeed(int y, int threshold) {
        if(y >= threshold) {
            return 0;
        }
        else {
            return (threshold-y) * 0.1f;
        }
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        event.setNewSpeed(event.getNewSpeed()+calcBonusSpeed(event.getEntity().getBlockY(), event.getEntity().getLevel().getSeaLevel()));
    }
}
