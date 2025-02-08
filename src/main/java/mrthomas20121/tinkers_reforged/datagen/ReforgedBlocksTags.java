package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.tag.MetalTags;
import mrthomas20121.tinkers_reforged.api.tag.RTags;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Blocks.*;

public class ReforgedBlocksTags extends BlockTagsProvider {

    private static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }

    public ReforgedBlocksTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {

        for(EnumGem gem: EnumGem.values()) {
            TagKey<Block> ORE = TinkersReforgedTags.Blocks.create("forge:ores/%s".formatted(gem.getName()));
            tag(ORE).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get());
            tag(Tags.Blocks.ORES).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get());

            TagKey<Block> BLOCK = TinkersReforgedTags.Blocks.create("forge:storage_blocks/%s".formatted(gem.getName()));
            tag(BLOCK).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get(), TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get());
            tag(gem.getBlockTag()).add(
                    TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get(),
                    TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get(),
                    TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get()
            );
            tag(TinkerTags.Blocks.ANVIL_METAL).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
            tag(Tags.Blocks.STORAGE_BLOCKS).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
            tag(BlockTags.BEACON_BASE_BLOCKS).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get());
        }

        //tag(NEED_KEPU_TOOLS).addTags(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        for(EnumMetal metal: EnumMetal.values()) {
            MetalTags tags = RTags.getTagsForMetal(metal);
            if(metal.isThisOre()) {
                tag(tags.rawBlock).add(TinkersReforgedBlocks.RAW_ORES.get(metal).get());
                tag(tags.oreBlock).add(TinkersReforgedBlocks.ORES.get(metal).ore().get());
                if(metal.isThisOverworldOre()) {
                    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(((OverworldOreBlock)TinkersReforgedBlocks.ORES.get(metal)).deepslateOre().get());
                }
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TinkersReforgedBlocks.ORES.get(metal).ore().get());
                TagsProvider.TagAppender<Block> miningTag = tag(metal.getOreMiningTag()).
                        add(TinkersReforgedBlocks.ORES.get(metal).ore().get(), TinkersReforgedBlocks.RAW_ORES.get(metal).get());
                TagsProvider.TagAppender<Block> oresTag = tag(Tags.Blocks.ORES).add(TinkersReforgedBlocks.ORES.get(metal).ore().get());
                if(metal.isThisOverworldOre()) {
                    Block overworldBlock = ((OverworldOreBlock)TinkersReforgedBlocks.ORES.get(metal)).deepslateOre().get();
                    oresTag.add(overworldBlock);
                    miningTag.add(overworldBlock);
                }
            }

            tag(tags.storage).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get());
            tag(Tags.Blocks.STORAGE_BLOCKS).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get());
            tag(BlockTags.BEACON_BASE_BLOCKS).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get());

            // need x tool tag
            tag(metal.getBlockTag()).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get(),
                    TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.PLATFORM).get());

            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get(),
                    TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.PLATFORM).get());

            tag(TinkerTags.Blocks.ANVIL_METAL).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get());
        }
    }
}
