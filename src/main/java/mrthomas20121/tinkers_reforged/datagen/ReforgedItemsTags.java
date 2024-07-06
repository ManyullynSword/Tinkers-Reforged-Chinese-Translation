package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.tag.MetalTags;
import mrthomas20121.tinkers_reforged.api.tag.RTags;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.registration.CastItemObject;

import javax.annotation.Nullable;

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Items.*;
import static net.minecraftforge.common.Tags.Items.*;
import static slimeknights.tconstruct.common.TinkerTags.Items.*;

public class ReforgedItemsTags extends ItemTagsProvider {

    private static TagKey<Item> create(String name) {
        return ItemTags.create(new ResourceLocation(name));
    }

    public ReforgedItemsTags(DataGenerator gen, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTagsProvider, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        //tag(TinkerTags.Items.BROAD_TOOLS)
        addToolTags(TinkersReforgedItems.GREATSWORD.get(), MULTIPART_TOOL, DURABILITY, HARVEST, MELEE_PRIMARY, INTERACTABLE_RIGHT, SWORD, SMALL_TOOLS, BONUS_SLOTS, AOE);
        addToolTags(TinkersReforgedItems.LONGSWORD.get(), MULTIPART_TOOL, DURABILITY, HARVEST, MELEE_PRIMARY, INTERACTABLE_RIGHT, SWORD, SMALL_TOOLS, BONUS_SLOTS, AOE);
        tag(TinkerTags.Items.MODIFIABLE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MELEE_WEAPON).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MELEE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.SWORD).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MELEE_PRIMARY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.HARVEST).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.HELD).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.DURABILITY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MULTIPART_TOOL).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.BROAD_TOOLS).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.TOOL_PARTS).add(TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.LONG_BLADE.get());
        tag(TinkerTags.Items.INTERACTABLE_RIGHT).add(TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.LONG_BLADE.get());


        // gem tags
        for(EnumGem gem: EnumGem.values()) {
            TagKey<Item> ORE = TinkersReforgedTags.Items.create("forge:ores/%s".formatted(gem.getName()));
            tag(ORE).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().asItem(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().asItem());
            tag(ORES).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().asItem(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().asItem());

            TagKey<Item> PLATES = TinkersReforgedTags.Items.create("forge:plates");

            TagKey<Item> BLOCK = TinkersReforgedTags.Items.create("forge:storage_blocks/%s".formatted(gem.getName()));
            tag(BLOCK).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get().asItem());
            tag(TinkerTags.Items.ANVIL_METAL).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get().asItem());

            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                TagKey<Item> tagKey = TinkersReforgedTags.Items.create("forge:%s/%s".formatted(itemType.getName()+"s", gem.getName()));

                tag(tagKey).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());

                switch (itemType) {
                    case GEM -> tag(GEMS).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                    case DUST -> tag(DUSTS).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                    case PLATE -> tag(PLATES).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                }
            }
        }

        // metal tags
        for(EnumMetal metal: EnumMetal.values()) {
            MetalTags tags = RTags.getTagsForMetal(metal);
            if(metal.isThisOre()) {
                tag(tags.raw_ore).add(TinkersReforgedItems.RAW_ORES.get(metal).get());
                tag(tags.rawBlockItem).add(TinkersReforgedBlocks.RAW_ORES.get(metal).get().asItem());

                TagsProvider.TagAppender<Item> oreTag = tag(tags.oreBlockItem).add(TinkersReforgedBlocks.ORES.get(metal).ore().get().asItem());
                TagsProvider.TagAppender<Item> oresTag = tag(Tags.Items.ORES).add(TinkersReforgedBlocks.ORES.get(metal).ore().get().asItem());
                if(metal.isThisOverworldOre()) {
                    Block overworldBlock = ((OverworldOreBlock)TinkersReforgedBlocks.ORES.get(metal)).deepslateOre().get();
                    oreTag.add(overworldBlock.asItem());
                    oresTag.add(overworldBlock.asItem());
                }
            }

            TagKey<Item> PLATES = TinkersReforgedTags.Items.create("forge:plates");

            tag(tags.storageItem).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get().asItem());
            tag(TinkerTags.Items.ANVIL_METAL).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get().asItem());

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {

                switch (itemType) {
                    case INGOT -> {
                        tag(tags.ingot).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(INGOTS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case NUGGET -> {
                        tag(tags.nugget).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(NUGGETS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case DUST -> {
                        tag(tags.dust).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(DUSTS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case PLATE -> {
                        tag(tags.plate).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(PLATES).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                }
            }
        }

        tag(ItemTags.LECTERN_BOOKS).add(TinkersReforgedItems.book.get());

        TagsProvider.TagAppender<Item> builder = tag(ALUMINUM_BRASS_CASTS);
        for(CastType type: CastType.values()) {
            Item cast = TinkersReforgedItems.ALU_BRASS_CASTS.get(type);
            builder.add(cast);
            TagKey<Item> castTag = create("tconstruct:casts/multi_use/%s".formatted(type.name().toLowerCase()));
            tag(castTag).add(cast);
        }
        tag(TinkerTags.Items.CASTS).addTag(ALUMINUM_BRASS_CASTS);

        addCastTags(TinkersReforgedItems.GREAT_BLADE_CAST);
        addCastTags(TinkersReforgedItems.LONG_BLADE_CAST);
    }

    public void addCastTags(CastItemObject cast) {
        tag(cast.getMultiUseTag()).add(cast.get());
        tag(cast.getSingleUseTag()).add(cast.getSand(), cast.getRedSand());
        tag(TinkerTags.Items.GOLD_CASTS).add(cast.get());
        tag(TinkerTags.Items.SAND_CASTS).add(cast.getSand());
        tag(TinkerTags.Items.RED_SAND_CASTS).add(cast.getRedSand());
    }

    @SafeVarargs
    private void addToolTags(ItemLike tool, TagKey<Item>... tags) {
        Item item = tool.asItem();
        for (TagKey<Item> tag : tags) {
            this.tag(tag).add(item);
        }
    }
}
