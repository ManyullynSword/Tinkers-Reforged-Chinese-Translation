package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class WeightRatioModifier extends Modifier implements ToolStatsModifierHook {

    public WeightRatioModifier() {
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
        float dmg = builder.getStat(ToolStats.ATTACK_DAMAGE);
        float mining_speed = builder.getStat(ToolStats.MINING_SPEED);

        // making sure the tool has a mining speed/attack damage
        if(mining_speed > ToolStats.MINING_SPEED.getDefaultValue() && dmg > ToolStats.ATTACK_DAMAGE.getDefaultValue()) {
            float max = Math.max(dmg, mining_speed);

            ToolStats.MINING_SPEED.update(builder, 0f);
            ToolStats.MINING_SPEED.add(builder, max+modifier.getLevel()*0.5f);
            ToolStats.ATTACK_DAMAGE.update(builder, 0f);
            ToolStats.ATTACK_DAMAGE.add(builder, max+modifier.getLevel()*0.5f);
        }
    }
}
