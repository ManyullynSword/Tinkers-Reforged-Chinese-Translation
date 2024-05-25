package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.*;

public enum EnumMaterial implements EnumData {

    BLAZIUM(2, false, ORDER_NETHER, EnumMaterialPalette.BLAZIUM, EnumMaterialStats.BLAZIUM, TinkersReforgedModifiers.sizzling, EnumFluid.BLAZIUM, "a mix of Blazing Blood and Amethyst", "Increases damage against entity immune to fire."),
    BOMIN(3, false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN, TinkersReforgedModifiers.amplitude, EnumFluid.BOMIN, "Nether Metal material.", "Increases your mining speed by 1.5x and Increases your reach distance by 1."),
    DURALUMIN(2, false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN, TinkersReforgedModifiers.rock_solid, EnumFluid.DURALUMIN, "Overworld Metal material.", "Increases the durability by 1.5."),
    DURASTEEL(5, false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL, TinkersReforgedModifiers.adaptability, EnumFluid.DURASTEEL, "End Metal material.", "Deal bonus damage based on the difference between max and current durability."),
    ELECTRIC_COPPER(2, false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER, TinkersReforgedModifiers.midas_touch, EnumFluid.ELECTRIC_COPPER, "Overworld Metal material.", "Entity drop gold nuggets when killed."),
    ENDER_BONE(2, true, ORDER_GENERAL, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, TinkersReforgedModifiers.slashing, "End Metal material.", "You always Critical Hit."),
    EPIDOTE(2, false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal", TinkersReforgedModifiers.vital, EnumFluid.EPIDOTE, "Overworld gem material.", "Deal more critical hit damage."),
    ETRYX(5, false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX, TinkersReforgedModifiers.diffusing, EnumFluid.ETRYX, "End Metal material.", "Set your mining speed and attack to the highest of the two stats."),
    FEROBOLT(3, false, ORDER_GENERAL, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT, TinkersReforgedModifiers.frozen_arrow, EnumFluid.FEROBOLT, "Overworld Bow Metal material.", "Arrows freeze the target for a few seconds."),
    HORNIUM(5, false, ORDER_GENERAL, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM, TinkersReforgedModifiers.muffled, EnumFluid.HORNIUM, "Overworld Metal material.", "Increases your attack damage by 3 and durability by 1.3x but you cannot critical hit anything."),
    HUREAULITE(2, false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal", TinkersReforgedModifiers.radiant_beam, EnumFluid.HUREAULITE, "Overworld gem material.", "Deal bonus Radiant damage to the target."),
    KEPU(4, false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU, TinkersReforgedModifiers.draconic_scale, EnumFluid.KEPU, "End Metal material..", "Exp drop scale with looting."),
    LAVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM, TinkersReforgedModifiers.infernal, EnumFluid.LAVIUM, "Nether Metal material.", "Deal more damage to entity based on their current health."),
    MOSITE(3, false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE, TinkersReforgedModifiers.under_the_sea, EnumFluid.MOSITE, "Nether Metal material.", "Mine faster the lowest you are under the sea level."),
    QIVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM, TinkersReforgedModifiers.voracious, EnumFluid.QIVIUM, "Nether Metal material.", "Deal more damage to Witches, Villagers, Players and Illagers."),
    RED_BERYL(2, false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal", TinkersReforgedModifiers.headshot, EnumFluid.RED_BERYL, "Overworld gem material.", "Deal more damage to armored targets."),
    TIBERIUM(5, false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM, TinkersReforgedModifiers.gigantic, EnumFluid.TIBERIUM, "End Metal Material.", "Deal more damage to entities with more max health than you."),
    TITANIUM(4, false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM, TinkersReforgedModifiers.weight_ratio, EnumFluid.TITANIUM, "End Metal Material.", "Add your tool's mining speed to the base damage.");

    public final MaterialId id;
    public final int tier;
    public final boolean craftable;
    public final int order;
    public final String fallback;
    public final EnumMaterialStats stats;
    public final EnumMaterialPalette palette;
    public final LazyModifier mod;
    public final EnumFluid fluid;
    public final String materialDesc;
    public final String modifierDesc;

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod, String materialDesc, String modifierDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod, EnumFluid fluid, String materialDesc, String modifierDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, fluid, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod, String materialDesc, String modifierDesc) {
        this(tier, craftable, order, palette, stats, fallback, mod, null, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod, EnumFluid fluid, String materialDesc, String modifierDesc) {
        this.id = create(this.getName());
        this.craftable = craftable;
        this.order = order;
        this.stats = stats;
        this.palette = palette;
        this.fallback = fallback;
        this.tier = tier;
        this.mod = mod;
        this.fluid = fluid;
        this.materialDesc = materialDesc;
        this.modifierDesc = modifierDesc;
    }

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
