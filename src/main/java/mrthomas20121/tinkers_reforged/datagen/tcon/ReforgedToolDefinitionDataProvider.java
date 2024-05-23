package mrthomas20121.tinkers_reforged.datagen.tcon;

import com.google.common.collect.ImmutableMap;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedToolDefinitions;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.definition.module.ToolModule;
import slimeknights.tconstruct.library.tools.definition.module.build.MultiplyStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolActionsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolSlotsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.IsEffectiveModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.MiningSpeedModifierModule;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.tools.TinkerToolParts.toolHandle;

public class ReforgedToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public ReforgedToolDefinitionDataProvider(DataGenerator generator) {
        super(generator, TinkersReforged.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {
        RandomMaterial tier1Material = RandomMaterial.random().tier(1).build();
        DefaultMaterialsModule defaultThreeParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material, tier1Material).build();
        DefaultMaterialsModule defaultFourParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material, tier1Material, tier1Material).build();

        ToolModule[] swordHarvest = {
                IsEffectiveModule.tag(TinkerTags.Blocks.MINABLE_WITH_SWORD),
                MiningSpeedModifierModule.blocks(7.5f, Blocks.COBWEB),
                MiningSpeedModifierModule.blocks(100f, Blocks.BAMBOO, Blocks.BAMBOO_SAPLING)
        };

        define(TinkersReforgedToolDefinitions.GREATSWORD)
                // parts
                .module(PartStatsModule.parts()
                        .part(TinkersReforgedItems.GREAT_BLADE)
                        .part(toolHandle)
                        .part(toolHandle).build())
                .module(defaultThreeParts)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 4f)
                        .set(ToolStats.ATTACK_SPEED, 1.1f)
                        .build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.ATTACK_SPEED, 0.4f)
                        .set(ToolStats.MINING_SPEED, 0.5f)
                        .set(ToolStats.DURABILITY, 1.1f)
                        .build()))
                .module(new ToolSlotsModule(ImmutableMap.of(SlotType.UPGRADE, 2, SlotType.ABILITY, 2)))
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                .module(swordHarvest);

        define(TinkersReforgedToolDefinitions.LONGSWORD)
                // parts
                .module(PartStatsModule.parts()
                        .part(TinkersReforgedItems.LONG_BLADE)
                        .part(toolHandle)
                        .part(toolHandle).build())
                .module(defaultThreeParts)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.6f)
                        .build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.MINING_SPEED, 0.5f)
                        .set(ToolStats.DURABILITY, 1.1f)
                        .build()))
                .module(new ToolSlotsModule(ImmutableMap.of(SlotType.UPGRADE, 2, SlotType.ABILITY, 2)))
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                .module(swordHarvest);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Tool Definitions";
    }
}
