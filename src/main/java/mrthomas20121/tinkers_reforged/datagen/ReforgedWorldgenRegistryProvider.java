package mrthomas20121.tinkers_reforged.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedWorldGen;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.holdersets.AndHolderSet;
import net.minecraftforge.registries.holdersets.NotHolderSet;
import net.minecraftforge.registries.holdersets.OrHolderSet;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.world.data.WorldgenDatapackRegistryProvider;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


import static net.minecraft.core.HolderSet.direct;

public class ReforgedWorldgenRegistryProvider implements DataProvider {

    private final DataGenerator generator;
    private final ExistingFileHelper existingFileHelper;
    private final RegistryAccess registryAccess = RegistryAccess.builtinCopy();
    private final RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);

    public ReforgedWorldgenRegistryProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        this.generator = generator;
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    public void run(CachedOutput cache) throws IOException {
        Map<String, BiomeModifier> biomeModifiers = new LinkedHashMap<>();
        HolderSet<Biome> overworld = tag(BiomeTags.IS_OVERWORLD);
        HolderSet<Biome> nether = tag(BiomeTags.IS_NETHER);
        HolderSet<Biome> end = tag(BiomeTags.IS_END);

        for(EnumMetal metal: EnumMetal.values()) {
            if(metal.isThisOre()) {
                if(metal.isThisOtherOre()) {
                    biomeModifiers.put(metal.getName()+"_ore", new ForgeBiomeModifiers.AddFeaturesBiomeModifier(end, direct(reference(TinkersReforgedWorldGen.PLACED_METAL_ORES.get(metal).getKey())), GenerationStep.Decoration.UNDERGROUND_DECORATION));
                }
                else {
                    biomeModifiers.put(metal.getName()+"_ore", new ForgeBiomeModifiers.AddFeaturesBiomeModifier(overworld, direct(reference(TinkersReforgedWorldGen.PLACED_METAL_ORES.get(metal).getKey())), GenerationStep.Decoration.UNDERGROUND_DECORATION));
                }
            }
        }

        for(EnumGem gem: EnumGem.values()) {
            biomeModifiers.put(gem.getName()+"ore", new ForgeBiomeModifiers.AddFeaturesBiomeModifier(overworld, direct(reference(TinkersReforgedWorldGen.PLACED_GEM_ORES.get(gem).getKey())), GenerationStep.Decoration.UNDERGROUND_DECORATION));
        }

        registryName(ForgeRegistries.Keys.BIOME_MODIFIERS, biomeModifiers).run(cache);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Biome Modifiers";
    }

    private <T> Holder<T> reference(ResourceKey<T> key) {
        ResourceKey<Registry<T>> registry = ResourceKey.createRegistryKey(key.registry());
        return registryAccess.registryOrThrow(registry).getOrCreateHolderOrThrow(Objects.requireNonNull(key));
    }

    /** Creates a reference to the given registry object */
    private <T> Holder<T> reference(Holder<T> object) {
        return reference(object.unwrapKey().orElseThrow());
    }

    /** Creates a reference to the given registry object */
    private <T> Holder<T> reference(RegistryObject<T> object) {
        return reference(Objects.requireNonNull(object.getKey()));
    }


    /* Holder sets */

    /** Creates a holder set tag for the given registry */
    private <T> HolderSet<T> tag(TagKey<T> key) {
        return registryAccess.registryOrThrow(key.registry()).getOrCreateTag(key);
    }

    /** Ands the holder sets together */
    @SafeVarargs
    private <T> AndHolderSet<T> and(HolderSet<T>... sets) {
        return new AndHolderSet<>(List.of(sets));
    }

    /** Ors the holder sets together */
    @SafeVarargs
    private <T> OrHolderSet<T> or(HolderSet<T>... sets) {
        return new OrHolderSet<>(List.of(sets));
    }

    private <T> NotHolderSet<T> not(ResourceKey<Registry<T>> key, HolderSet<T> set) {
        return new NotHolderSet<>(registryAccess.registryOrThrow(key), set);
    }


    /* Datapack helpers */

    /** Creates a datapack registry with the given entries */
    private <T> DataProvider registryRL(ResourceKey<Registry<T>> registry, Map<ResourceLocation, T> entries) {
        return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, TConstruct.MOD_ID, registryOps, registry, entries);
    }

    /** Creates a datapack registry with the given entries */
    private <T> DataProvider registryName(ResourceKey<Registry<T>> registry, Map<String, T> entries) {
        return registryRL(registry, entries.entrySet().stream().collect(Collectors.toMap(entry -> TConstruct.getResource(entry.getKey()), Map.Entry::getValue)));
    }

    /** Creates a datapack registry with the given entries */
    private <T> DataProvider registryKey(ResourceKey<Registry<T>> registry, Map<ResourceKey<T>, T> entries) {
        return registryRL(registry, entries.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().location(), Map.Entry::getValue)));
    }
}
