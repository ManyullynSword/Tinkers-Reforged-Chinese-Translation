package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

// Some modifier class name are not the same as the modifier name to keep compat with worlds running older version of tinkers reforged
public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    // traits
    public static StaticModifier<AdaptabilityModifier> adaptability = MODIFIERS.register("adaptability", AdaptabilityModifier::new);
    public static StaticModifier<AmplitudeModifier> amplitude = MODIFIERS.register("amplitude", AmplitudeModifier::new);
    public static StaticModifier<VitalModifier> vital = MODIFIERS.register("vital", VitalModifier::new);
    public static StaticModifier<DraconicScaleModifier> draconic_scale = MODIFIERS.register("draconic_scale", DraconicScaleModifier::new);
    public static StaticModifier<FrozenArrowModifier> frozen_arrow = MODIFIERS.register("frozen_arrow", FrozenArrowModifier::new);
    public static StaticModifier<GiganticModifier> gigantic = MODIFIERS.register("gigantic", GiganticModifier::new);
    public static StaticModifier<HeadshotModifier> headshot = MODIFIERS.register("headshot", HeadshotModifier::new);
    public static StaticModifier<InfernalModifier> infernal = MODIFIERS.register("infernal", InfernalModifier::new);
    public static StaticModifier<MidasTouchModifier> midas_touch = MODIFIERS.register("midas_touch", MidasTouchModifier::new);
    public static StaticModifier<MuffledModifier> muffled = MODIFIERS.register("muffled", MuffledModifier::new);
    public static StaticModifier<DiffusingModifier> diffusing = MODIFIERS.register("diffusing", DiffusingModifier::new);
    public static StaticModifier<RadiantBeamModifier> radiant_beam = MODIFIERS.register("radiant_beam", RadiantBeamModifier::new);
    public static StaticModifier<RockSolidModifier> rock_solid = MODIFIERS.register("rock_solid", RockSolidModifier::new);
    public static StaticModifier<SizzlingModifier> sizzling = MODIFIERS.register("sizzling", SizzlingModifier::new);
    public static StaticModifier<SlashingModifier> slashing = MODIFIERS.register("slashing", SlashingModifier::new);
    public static StaticModifier<UnderTheSeaModifier> under_the_sea = MODIFIERS.register("under_the_sea", UnderTheSeaModifier::new);
    public static StaticModifier<VoraciousModifier> voracious = MODIFIERS.register("voracious", VoraciousModifier::new);
    public static StaticModifier<WeightRatioModifier> weight_ratio = MODIFIERS.register("weight_ratio", WeightRatioModifier::new);
}
