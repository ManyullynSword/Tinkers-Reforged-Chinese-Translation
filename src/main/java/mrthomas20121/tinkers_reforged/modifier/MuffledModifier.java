package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.CritModifierHook;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class MuffledModifier extends Modifier implements CritModifierHook, ToolStatsModifierHook {

    public MuffledModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, TinkersReforgedHooks.CRIT_MODIFIER).addHook(this, ModifierHooks.TOOL_STATS);
    }

    @Override
    public void onCrit(IToolStackView tool, Player player, CriticalHitEvent event) {
        // set the damage modifier to 1
        event.setDamageModifier(1f);
        event.setResult(Event.Result.DENY);
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.add(builder, 3);
        ToolStats.DURABILITY.multiply(builder, 1.3f);
    }
}
