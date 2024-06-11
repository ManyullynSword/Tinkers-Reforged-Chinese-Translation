package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumModifier;
import mrthomas20121.tinkers_reforged.modifier.*;
import mrthomas20121.tinkers_reforged.util.Helpers;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import java.util.Map;

// Some modifier class name are not the same as the modifier name to keep compat with worlds running older version of tinkers reforged
public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    // register traits that can't be JSON.
    public static final Map<EnumModifier, StaticModifier<Modifier>> TRAITS = Helpers.mapOfKeys(EnumModifier.class,
            EnumModifier::hasModifier, (mod) -> MODIFIERS.register(mod.getSerializedName(), mod.getModifier()));
}
