package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.cast.TinkerCastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.CastItemObject;

import java.util.Objects;

public class ReforgedItemModels extends ItemModelProvider {

    public ReforgedItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        itemWithModel(TinkersReforgedItems.book, "item/generated");
        itemWithModel(TinkersReforgedItems.ender_bone, "item/generated");

        for(EnumMetal metal: EnumMetal.values()) {

            if(metal.isThisOre()) {
                itemWithModel(TinkersReforgedItems.RAW_ORES.get(metal), "item/generated");
            }

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {
                itemWithModel(TinkersReforgedItems.METALS.get(metal).get(itemType), "item/generated");
            }
        }

        for(EnumGem gem: EnumGem.values()) {
            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                itemWithModel(TinkersReforgedItems.GEMS.get(gem).get(itemType), "item/generated");
            }
        }

        castModels(TinkersReforgedItems.GREAT_BLADE_CAST, "great_blade");
        castModels(TinkersReforgedItems.LONG_BLADE_CAST, "long_blade");

        for(CastType castType: CastType.values()) {
            castModel(TinkersReforgedItems.ALU_CASTS.get(castType), castType);
        }
    }

    public void itemWithModel(ItemObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void castModel(ItemObject<? extends Item> registryObject, TinkerCastType castType, TinkerCastType.Type type) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/%s/%s".formatted(castType.getName(), type.getName()));
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }

    private ResourceLocation getLoc(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item), "Cast Item cannot be null");
    }

    public void castModels(CastItemObject castItemObject, String name) {
        ResourceLocation goldCast = getLoc(castItemObject.get());
        ResourceLocation sandCast = getLoc(castItemObject.getSand());
        ResourceLocation redSandCast = getLoc(castItemObject.getRedSand());

        ResourceLocation goldCastLoc = new ResourceLocation(goldCast.getNamespace(), "item/cast/gold/%s".formatted(name));
        singleTexture(goldCast.getPath(), new ResourceLocation("item/generated"), "layer0", goldCastLoc);
        ResourceLocation sandCastLoc = new ResourceLocation(goldCast.getNamespace(), "item/cast/sand/%s".formatted(name));
        singleTexture(sandCast.getPath(), new ResourceLocation("item/generated"), "layer0", sandCastLoc);
        ResourceLocation redSandCastLoc = new ResourceLocation(goldCast.getNamespace(), "item/cast/red_sand/%s".formatted(name));
        singleTexture(redSandCast.getPath(), new ResourceLocation("item/generated"), "layer0", redSandCastLoc);
    }

    public void castModel(Item item, CastType castType) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item), "Cast Item cannot be null");
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/%s/%s".formatted("aluminum", castType.getSerializedName()));
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }

    public void castModel(ItemObject<? extends Item> registryObject, CastType castType) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/%s/%s".formatted("aluminum", castType.getSerializedName()));
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }
}
