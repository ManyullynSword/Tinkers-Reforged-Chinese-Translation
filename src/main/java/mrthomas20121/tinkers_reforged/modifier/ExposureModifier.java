package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.api.material.EnumModifier;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ValidateModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ExposureModifier extends Modifier implements BreakSpeedModifierHook {

    public ExposureModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder
                .addHook(this, ModifierHooks.BREAK_SPEED);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(!isEffective || event.getEntity().isUnderWater()) {
            event.setNewSpeed(event.getOriginalSpeed()*2f*modifier.getEffectiveLevel());
        }
    }
}
