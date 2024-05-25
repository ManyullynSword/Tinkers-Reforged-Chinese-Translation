package mrthomas20121.tinkers_reforged.util;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.CritModifierHook;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.DeathModifierHook;
import mrthomas20121.tinkers_reforged.util.modifier_hooks.EntityLootModifierHook;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHook;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Function;

public class TinkersReforgedHooks {

    public static ModuleHook<EntityLootModifierHook> ENTITY_LOOT_MODIFIER = register("entity_loot_modifier", EntityLootModifierHook.class, EntityLootModifierHook.SUM_MERGER, EntityLootModifierHook.DEFAULT);
    public static ModuleHook<CritModifierHook> CRIT_MODIFIER = register("crit_modifier", CritModifierHook.class, CritModifierHook.DEFAULT);
    public static ModuleHook<DeathModifierHook> DEATH_MODIFIER = register("death_modifier", DeathModifierHook.class, DeathModifierHook.DEFAULT);

    /** Registers a new modifier hook under {@code tinkers_reforged} */
    private static <T> ModuleHook<T> register(String name, Class<T> filter, @Nullable Function<Collection<T>,T> merger, T defaultInstance) {
        return ModifierHooks.register(new ResourceLocation(TinkersReforged.MOD_ID, name), filter, merger, defaultInstance);
    }

    /** Registers a new modifier hook under {@code tinkers_reforged}  that cannot merge */
    private static <T> ModuleHook<T> register(String name, Class<T> filter, T defaultInstance) {
        return register(name, filter, null, defaultInstance);
    }
}
