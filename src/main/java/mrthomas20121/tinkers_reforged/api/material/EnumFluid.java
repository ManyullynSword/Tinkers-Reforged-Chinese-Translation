package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.Arrays;

public enum EnumFluid implements EnumData {
    PROTO_LAVA(2000, 0xA48538, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    ALUMINUM_BRASS(900, 0xC79326, TinkerTags.Fluids.CHEAP_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    BLAZIUM(1700, EnumMaterialPalette.BLAZIUM, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    BOMIN(1500, EnumMaterialPalette.BOMIN, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    DURALUMIN(1000, EnumMaterialPalette.DURALUMIN, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    DURASTEEL(1800, EnumMaterialPalette.DURASTEEL, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    ELECTRIC_COPPER(1100, EnumMaterialPalette.ELECTRIC_COPPER, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    EPIDOTE(1100, EnumMaterialPalette.EPIDOTE, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.LARGE_GEM_TOOLTIPS),
    ETRYX(1300, EnumMaterialPalette.ETRYX, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    FEROBOLT(1300, EnumMaterialPalette.FEROBOLT, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    GALLIUM(1500, 0x6F8F82, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    HORNIUM(1800, EnumMaterialPalette.HORNIUM, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    HUREAULITE(1100, EnumMaterialPalette.HUREAULITE, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.LARGE_GEM_TOOLTIPS),
    KEPU(1600, EnumMaterialPalette.KEPU, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    LAVIUM(1400, EnumMaterialPalette.LAVIUM, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    MOSITE(1400, EnumMaterialPalette.MOSITE, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    QIVIUM(1400, EnumMaterialPalette.QIVIUM, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    RED_BERYL(1100, EnumMaterialPalette.RED_BERYL, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.LARGE_GEM_TOOLTIPS),
    TIBERIUM(1800, EnumMaterialPalette.TIBERIUM, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    TITANIUM(1600, EnumMaterialPalette.TITANIUM, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING);

    private final int temp;
    private final int color;
    private final TagKey<Fluid>[] fluids;

    @SafeVarargs
    EnumFluid(int temp, int color, TagKey<Fluid> ...fluids) {
        this.temp = temp;
        this.color = color;
        this.fluids = fluids;
    }

    @SafeVarargs
    EnumFluid(int temp, EnumMaterialPalette color, TagKey<Fluid> ...fluids) {
        this.temp = temp;
        this.color = color.baseColor;
        this.fluids = fluids;
    }

    public boolean hasAlloy() {
        return Arrays.stream(EnumFluidAlloy.values()).anyMatch(e -> e.getName().equals(this.getName()));
    }

    public EnumFluidAlloy getAlloy() {
        return EnumFluidAlloy.valueOf(getName());
    }

    public TagKey<Fluid>[] getFluid() {
        return fluids;
    }

    public int getColor() {
        return color;
    }

    public int getTemp() {
        return temp;
    }
}
