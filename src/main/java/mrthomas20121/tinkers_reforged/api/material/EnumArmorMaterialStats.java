package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.ReforgedTiers;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.tools.stats.*;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.NETHERITE;

public enum EnumArmorMaterialStats implements StringRepresentable {

    BLAZIUM(builder -> builder.durabilityFactor(15).armor(2, 4, 5, 2)),
    BOMIN(builder -> builder.durabilityFactor(20).armor(3, 4, 5, 3)),
    DURALUMIN(builder -> builder.durabilityFactor(20).armor(2, 4, 6, 2)),
    DURASTEEL(builder -> builder.durabilityFactor(20).armor(1, 4, 6, 1)),
    ELECTRIC_COPPER(builder -> builder.durabilityFactor(20).armor(3, 4, 5, 3)),
    ENDER_BONE(builder -> builder.durabilityFactor(5).armor(1, 3, 4, 1)),
    EPIDOTE(builder -> builder.durabilityFactor(15).armor(2, 3, 4, 2)),
    ETRYX(builder -> builder.durabilityFactor(25).armor(3, 4, 5, 3)),
    FEROBOLT(builder -> builder.durabilityFactor(20).armor(2, 4, 5, 2)),
    HORNIUM(builder -> builder.durabilityFactor(20).armor(3, 4, 6, 3)),
    HUREAULITE(builder -> builder.durabilityFactor(15).armor(2, 3, 4, 2)),
    KEPU(builder -> builder.durabilityFactor(15).knockbackResistance(0.1f).armor(2, 3, 4, 2)),
    LAVIUM(builder -> builder.durabilityFactor(30).knockbackResistance(0.3f).armor(3, 4, 5, 3)),
    MOSITE(builder -> builder.durabilityFactor(30).knockbackResistance(0.1f).armor(3, 4, 5, 3)),
    QIVIUM(builder -> builder.durabilityFactor(30).knockbackResistance(0.3f).armor(3, 4, 5, 3)),
    RED_BERYL(builder -> builder.durabilityFactor(15).armor(2, 3, 4, 2)),
    TIBERIUM(builder -> builder.durabilityFactor(40).knockbackResistance(0.3f).armor(5, 6, 7, 5)),
    TITANIUM(builder -> builder.durabilityFactor(20).knockbackResistance(0.1f).armor(4, 5, 6, 4));

    private final PlatingMaterialStats.Builder builder;
    private final StatlessMaterialStats statlessMaterialStats;

    EnumArmorMaterialStats(Function<PlatingMaterialStats.Builder, PlatingMaterialStats.Builder> func) {
        this.builder = func.apply(PlatingMaterialStats.builder());
        this.statlessMaterialStats = StatlessMaterialStats.MAILLE;
    }

    public StatlessMaterialStats getStatlessMaterialStats() {
        return statlessMaterialStats;
    }

    public PlatingMaterialStats.Builder getStats() {
        return this.builder;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
