package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.*;

public enum EnumMaterial implements EnumData {

    BLAZIUM(2, false, ORDER_NETHER, EnumMaterialPalette.BLAZIUM, EnumMaterialStats.BLAZIUM, EnumModifier.SIZZLING, EnumModifier.ALL_PROTECTION, EnumFluid.BLAZIUM, "Did you hear that sizzling?"),
    BOMIN(3, false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN, EnumModifier.AMPLITUDE, EnumModifier.AMPLIFIER, EnumFluid.BOMIN, "You should crank up the volume."),
    DURALUMIN(2, false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN, EnumModifier.ROCK_SOLID, EnumFluid.DURALUMIN, "That sounded like a better idea in my head."),
    DURASTEEL(5, false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL, EnumModifier.ADAPTABILITY, EnumModifier.MALLEABLE, EnumFluid.DURASTEEL, "Not very durable."),
    ELECTRIC_COPPER(2, false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER, EnumModifier.MIDAS_TOUCH, EnumModifier.MYTHOLOGICAL_RESISTANCE, EnumFluid.ELECTRIC_COPPER, "Have you ever heard of the midas touch?."),
    ENDER_BONE(2, true, ORDER_GENERAL, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, "bone", EnumModifier.SLASHING, EnumModifier.ADRENALINE, "Drink molten ender for stronger bones."),
    EPIDOTE(2, false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal", EnumModifier.VITAL, EnumModifier.LUCKY_CHARM, EnumFluid.EPIDOTE, "You better not go to the center of a earthquake."),
    ETRYX(5, false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX, EnumModifier.DIFFUSING, EnumModifier.GLINT, EnumFluid.ETRYX, "Spookier than all of the scary movies."),
    FEROBOLT(3, false, ORDER_GENERAL, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT, EnumModifier.FROSTY, EnumFluid.FEROBOLT, "Faster than a bullet."),
    HORNIUM(5, false, ORDER_GENERAL, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM, EnumModifier.MUFFLED, EnumModifier.TICKING, EnumFluid.HORNIUM, "Great for sex."),
    HUREAULITE(2, false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal", EnumModifier.RADIANT, EnumModifier.CHILD_PROTECTION, EnumFluid.HUREAULITE, "You're too good to be this radiant."),
    KEPU(4, false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU, EnumModifier.DRACONIC, EnumFluid.KEPU, "Blue ore in the end dimension? how original."),
    LAVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM, EnumModifier.INFERNO, EnumModifier.ADRENALINE, EnumFluid.LAVIUM, "Not my preferred Flavour."),
    MOSITE(3, false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE, EnumModifier.UNDER_THE_SEA, EnumModifier.AQUA_PROTECTION, EnumFluid.MOSITE, "There is always a bigger fish."),
    QIVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM, EnumModifier.VORACIOUS, EnumModifier.RAID_PROTECTION,  EnumFluid.QIVIUM, "Witches be gone."),
    RED_BERYL(2, false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal", EnumModifier.HEADSHOT, EnumModifier.ARMORED_PROTECTION, EnumFluid.RED_BERYL, "Try to stick this in someone's helmet."),
    TIBERIUM(5, false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM, EnumModifier.COLOSSAL, EnumModifier.WEAPON_PROTECTION, EnumFluid.TIBERIUM, "Strong enough to keep the titanic afloat."),
    TITANIUM(4, false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM, EnumModifier.WEIGHT_RATIO, EnumModifier.PREVENTIVE_WEIGHT, EnumFluid.TITANIUM, "This thing is kinda heavy.");

    public static final EnumMaterial[] VALUES = values();

    public final MaterialId id;
    public final int tier;
    public final boolean craftable;
    public final int order;
    public final String fallback;
    public final EnumMaterialStats stats;
    public final EnumMaterialPalette palette;
    public final EnumModifier mod;
    public final EnumModifier armorMod;
    public final EnumFluid fluid;
    public final String materialDesc;

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, EnumModifier mod, String materialDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, EnumModifier mod, EnumFluid fluid, String materialDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, fluid, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, EnumModifier mod, EnumModifier armorMod, EnumFluid fluid, String materialDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, armorMod, fluid, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, EnumModifier mod, String materialDesc) {
        this(tier, craftable, order, palette, stats, fallback, mod, mod, null, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, EnumModifier mod, EnumModifier armorMod, String materialDesc) {
        this(tier, craftable, order, palette, stats, fallback, mod, armorMod, null, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, EnumModifier mod, EnumFluid fluid, String materialDesc) {
        this(tier, craftable, order, palette, stats, fallback, mod, mod, fluid, materialDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, EnumModifier mod, EnumModifier armorMod, EnumFluid fluid, String materialDesc) {
        this.id = create(this.getName());
        this.craftable = craftable;
        this.order = order;
        this.stats = stats;
        this.palette = palette;
        this.fallback = fallback;
        this.tier = tier;
        this.mod = mod;
        this.armorMod = armorMod;
        this.fluid = fluid;
        this.materialDesc = materialDesc;
    }

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
