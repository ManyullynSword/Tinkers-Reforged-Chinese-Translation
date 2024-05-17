package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.CritModifierHook;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class SlashingModifier extends Modifier implements CritModifierHook {

    public SlashingModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, TinkersReforgedHooks.CRIT_MODIFIER);
    }

    @Override
    public void onCrit(IToolStackView tool, Player player, CriticalHitEvent event) {
        if(event.getResult() != Event.Result.ALLOW) {
            event.setResult(Event.Result.ALLOW);
        }
    }
}
