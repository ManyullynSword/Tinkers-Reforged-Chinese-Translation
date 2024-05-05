package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import mrthomas20121.tinkers_reforged.modifier.HeadshotModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

// Some modifier class name are not the same as the modifier name to keep compat with worlds running older version of tinkers reforged
public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    // tools modifiers
    public static StaticModifier<LongRangeModifier> long_range = MODIFIERS.register("long_range", LongRangeModifier::new);

    // traits
    public static StaticModifier<AdaptabilityModifier> adaptability = MODIFIERS.register("adaptability", AdaptabilityModifier::new);
    public static StaticModifier<BiomeEffectModifier> biome_effect = MODIFIERS.register("biome_effect", BiomeEffectModifier::new);
    public static StaticModifier<MythicalPushModifier> mythical_push = MODIFIERS.register("mythical_push", MythicalPushModifier::new);
    public static StaticModifier<ExcavationModifier> excavation = MODIFIERS.register("excavation", ExcavationModifier::new);
    public static StaticModifier<ExtinguishModifier> extinguish = MODIFIERS.register("extinguish", ExtinguishModifier::new);
    public static StaticModifier<FrozenBladeModifier> frozen_blade = MODIFIERS.register("frozen_blade", FrozenBladeModifier::new);
    public static StaticModifier<GiganticModifier> gigantic = MODIFIERS.register("gigantic", GiganticModifier::new);
    public static StaticModifier<HeadshotModifier> headshot = MODIFIERS.register("headshot", HeadshotModifier::new);
    public static StaticModifier<HellFireModifier> hellfire = MODIFIERS.register("hellfire", HellFireModifier::new);
    public static StaticModifier<HellishRepairModifier> hellish_repair = MODIFIERS.register("hellish_repair", HellishRepairModifier::new);
    public static StaticModifier<WitherVirusModifier> wither_virus = MODIFIERS.register("wither_virus", WitherVirusModifier::new);
    public static StaticModifier<OverheatedModifier> overheated = MODIFIERS.register("overheated", OverheatedModifier::new);
    public static StaticModifier<RockSolidModifier> rock_solid = MODIFIERS.register("rock_solid", RockSolidModifier::new);
    public static StaticModifier<SeasonedModifier> seasoned = MODIFIERS.register("seasoned", SeasonedModifier::new);
    public static StaticModifier<ForceCannonModifier> force_cannon = MODIFIERS.register("force_cannon", ForceCannonModifier::new);
    public static StaticModifier<SupernaturalModifier> supernatural = MODIFIERS.register("supernatural", SupernaturalModifier::new);
    public static StaticModifier<MushModifier> mush = MODIFIERS.register("mush", MushModifier::new);
    public static StaticModifier<WitherArrowModifier> wither_arrow = MODIFIERS.register("wither_arrow", WitherArrowModifier::new);
}
