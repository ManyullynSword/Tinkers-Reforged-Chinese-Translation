package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class WeightExchangeModifier extends Modifier implements ToolStatsModifierHook {

    public WeightExchangeModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {

        float mining_speed = builder.getStat(ToolStats.MINING_SPEED);
        ToolStats.ATTACK_DAMAGE.add(builder, mining_speed*0.5f);
    }
}
