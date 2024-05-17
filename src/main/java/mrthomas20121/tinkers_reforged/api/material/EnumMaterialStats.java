package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.ReforgedTiers;
import slimeknights.tconstruct.library.materials.stats.IMaterialStats;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.NETHERITE;

public enum EnumMaterialStats {

    BLAZIUM(
            new HeadMaterialStats(240, 5.5f, DIAMOND, 1f),
            HandleMaterialStats.multipliers().durability(0.80f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(240, 0.1f, -0.1f, 0.5f),
            new GripMaterialStats(1.01f, 0.5f, 0.1f)
    ),
    BOMIN(
            new HeadMaterialStats(300, 5.2f, DIAMOND, 2f),
            HandleMaterialStats.multipliers().attackDamage(1.01f).build(),
            StatlessMaterialStats.BINDING
    ),
    DURALUMIN(
            new HeadMaterialStats(300, 6.5f, DIAMOND, 1f),
            HandleMaterialStats.multipliers().durability(1.01f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(300, 0.1f, 0.3f, -0.5f),
            new GripMaterialStats(1.1f, -0.1f, 0.8f)
    ),
    DURASTEEL(
            new HeadMaterialStats(500, 7f, DIAMOND, 2.5f),
            HandleMaterialStats.multipliers().durability(1.1f).miningSpeed(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(500, 0.1f, 0.1f, 0.2f),
            new GripMaterialStats(1.12f, 0.2f, 1f)
    ),
    ELECTRIC_COPPER(
            new HeadMaterialStats(260, 5.5f, DIAMOND, 1f),
            HandleMaterialStats.multipliers().attackSpeed(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(260, 0.2f, -0.01f, 0.3f),
            new GripMaterialStats(1.1f, 0.3f, 0.2f)
    ),
    ENDER_BONE(
            new HeadMaterialStats(180, 3.3f, DIAMOND, 2.4f),
            HandleMaterialStats.multipliers().attackDamage(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(180, 0.15f, -0.15f, 0.05f),
            new GripMaterialStats(0.9f, -0.1f, 1.1f)
    ),
    EPIDOTE(
            new HeadMaterialStats(300, 5.7f, DIAMOND, 1.3f),
            HandleMaterialStats.multipliers().durability(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(300, 0.15f, -0.15f, 0.3f),
            new GripMaterialStats(0.9f, -0.13f, 0.5f)
    ),
    ETRYX(
            new HeadMaterialStats(555, 4.9f, NETHERITE, 3.4f),
            HandleMaterialStats.multipliers().attackSpeed(1.1f).miningSpeed(0.9f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(555, -0.15f, 0.15f, -0.1f),
            new GripMaterialStats(0.9f, -0.1f, 0.8f)
    ),
    FEROBOLT(
            new LimbMaterialStats(600, 0.15f, -0.1f, 0.2f),
            new GripMaterialStats(0.8f, 0.2f, 3.1f)
    ),
    HORNIUM(
            new HeadMaterialStats(555, 4.9f, NETHERITE, 3.6f),
            HandleMaterialStats.multipliers().attackSpeed(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(555, -0.15f, 0.15f, -0.1f),
            new GripMaterialStats(0.9f, -0.1f, 0.3f)
    ),
    HUREAULITE(
            new HeadMaterialStats(300, 5.7f, DIAMOND, 1.3f),
            HandleMaterialStats.multipliers().durability(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(300, 0.15f, -0.15f, 0.3f),
            new GripMaterialStats(0.9f, -0.13f, 0.3f)
    ),
    KEPU(
            new HeadMaterialStats(333, 5.3f, ReforgedTiers.KEPU, 2f),
            HandleMaterialStats.multipliers().durability(1.1f).attackSpeed(1.1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(333, -0.15f, 0.2f, 0.2f),
            new GripMaterialStats(1f, 0.2f, 1f)
    ),
    LAVIUM(
            new HeadMaterialStats(800, 3f, NETHERITE, 4f),
            HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.05f).attackSpeed(1.05f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(800, 0.07f, 0.07f, 0.07f),
            new GripMaterialStats(1.05f, 0.07f, 2.0f)
    ),
    MOSITE(
            new HeadMaterialStats(600, 5f, NETHERITE, 3.5f),
            HandleMaterialStats.multipliers().durability(1.01f).attackSpeed(1.01f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(600, 0.03f, 0.03f, 0.03f),
            new GripMaterialStats(1.05f, 0.03f, 1.9f)
    ),
    QIVIUM(
            new HeadMaterialStats(800, 6.7f, NETHERITE, 3f),
            HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.05f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(800, 0.07f, 0.07f, 0.07f),
            new GripMaterialStats(1.05f, 0.07f, 2.1f)
    ),
    RED_BERYL(
            new HeadMaterialStats(300, 5.7f, DIAMOND, 1.3f),
            HandleMaterialStats.multipliers().durability(1f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(300, 0.15f, -0.15f, 0.3f),
            new GripMaterialStats(0.9f, -0.13f, 0.3f)
    ),
    TIBERIUM(
            new HeadMaterialStats(555, 6.7f, ReforgedTiers.KEPU, 3f),
            HandleMaterialStats.multipliers().attackSpeed(1.2f).build(),
            StatlessMaterialStats.BINDING,
            new LimbMaterialStats(555, 0.15f, 0.15f, -0.2f),
            new GripMaterialStats(0.9f, -0.2f, 1.1f)
    ),
    TITANIUM(
            new HeadMaterialStats(500, 5.9f, ReforgedTiers.KEPU, 2.5f),
            HandleMaterialStats.multipliers().attackSpeed(0.9f).build(),
            StatlessMaterialStats.BINDING
    );

    public final IMaterialStats[] stats;

    EnumMaterialStats(IMaterialStats... stats) {
        this.stats = stats;
    }
}
