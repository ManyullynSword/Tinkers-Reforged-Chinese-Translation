package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ValidateModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.RequirementsModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class DiffusingModifier extends Modifier implements ToolStatsModifierHook, ValidateModifierHook {

    public DiffusingModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder
                .addHook(this, ModifierHooks.TOOL_STATS)
                .addHook(this, ModifierHooks.VALIDATE);
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Nullable
    @Override
    public Component validate(IToolStackView tool, ModifierEntry modifier) {
        if(modifier.getId().equals(TinkersReforgedModifiers.weight_ratio.getId())) {
            return Component.translatable("modifier.tinkers_reforged.diffusing.compatible");
        }

        return null;
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        float mining_speed = builder.getStat(ToolStats.MINING_SPEED);
        float atk_dmg = builder.getStat(ToolStats.ATTACK_DAMAGE);

        float max = Math.max(mining_speed, atk_dmg);

        ToolStats.ATTACK_DAMAGE.update(builder, 0f);
        ToolStats.MINING_SPEED.update(builder, 0f);

        ToolStats.ATTACK_DAMAGE.add(builder, max);
        ToolStats.MINING_SPEED.update(builder, max);

    }
}
