package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SnifferUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BOULDERSTONE.get(),
                        ModBlocks.BOULDERSTONE_BRICKS.get(),
                        ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get(),
                        ModBlocks.POLISHED_POWDERSTONE.get(),
                        ModBlocks.BIOMITE_BLOCK.get(),
                        ModBlocks.POWDERSTONE.get(),
                        ModBlocks.GRASSY_BOULDERSTONE.get(),
                        ModBlocks.PETRIFIED_LOG.get(),
                        ModBlocks.PETRIFIED_WOOD.get(),
                        ModBlocks.BOULDERSTONE_STAIRS.get(),
                        ModBlocks.BOULDERSTONE_SLAB.get(),
                        ModBlocks.BOULDERSTONE_WALL.get(),
                        ModBlocks.POLISHED_POWDERSTONE_STAIRS.get(),
                        ModBlocks.POLISHED_POWDERSTONE_SLAB.get(),
                        ModBlocks.POLISHED_POWDERSTONE_WALL.get(),
                        ModBlocks.BOULDERSTONE_BRICK_STAIRS.get(),
                        ModBlocks.BOULDERSTONE_BRICK_SLAB.get(),
                        ModBlocks.BOULDERSTONE_BRICK_WALL.get(),
                        ModBlocks.PUMICE.get(),
                        ModBlocks.LATITE.get(),
                        ModBlocks.POLISHED_CHLORITE_BRICKS.get(),
                        ModBlocks.CHLORITE.get(),
                        ModBlocks.POLISHED_CHLORITE.get(),
                        ModBlocks.CHLORITE_STAIRS.get(),
                        ModBlocks.CHLORITE_SLAB.get(),
                        ModBlocks.CHLORITE_WALL.get(),
                        ModBlocks.POLISHED_CHLORITE_STAIRS.get(),
                        ModBlocks.POLISHED_CHLORITE_SLAB.get(),
                        ModBlocks.POLISHED_CHLORITE_WALL.get(),
                        ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS.get(),
                        ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get(),
                        ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get(),

                        ModBlocks.SMOOTH_PETRIFIED_LOG.get(),
                        ModBlocks.BONE_SLAB.get(),
                        ModBlocks.BIOMITE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ANCIENT_GRASS_BLOCK.get(),
                        ModBlocks.MUDDY_SOIL.get(),
                        ModBlocks.MOSSY_SOIL.get(),
                        ModBlocks.ANCIENT_SOIL.get());

        this.tag(BlockTags.WOOL)
                .add(ModBlocks.SNIFFER_WOOL.get());

        this.tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(ModBlocks.LATITE.get());

        this.tag(BlockTags.FLOWERS)
                .add(ModBlocks.STRANIP_FLOWER.get());
        this.tag(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.STRANIP_FLOWER.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.INCUBATION_BENCH.get(),
                        ModBlocks.GINKGO_LOG.get(),
                        ModBlocks.STRIPPED_GINKGO_LOG.get(),
                        ModBlocks.GINKGO_WOOD.get(),
                        ModBlocks.GINKGO_DOOR.get(),
                        ModBlocks.GINKGO_TRAPDOOR.get(),
                        ModBlocks.GINKGO_FENCE_GATE.get(),
                        ModBlocks.GINKGO_FENCE.get(),
                        ModBlocks.GINKGO_SLAB.get(),
                        ModBlocks.GINKGO_STAIRS.get(),
                        ModBlocks.GINKGO_BUTTON.get(),
                        ModBlocks.GINKGO_PRESSURE_PLATE.get(),
                        ModBlocks.STRIPPED_GINKGO_WOOD.get(),
                        ModBlocks.SPIKETIP_LOG.get(),
                        ModBlocks.STRIPPED_SPIKETIP_LOG.get(),
                        ModBlocks.SPIKETIP_WOOD.get(),
                        ModBlocks.SPIKETIP_DOOR.get(),
                        ModBlocks.SPIKETIP_TRAPDOOR.get(),
                        ModBlocks.SPIKETIP_FENCE_GATE.get(),
                        ModBlocks.SPIKETIP_FENCE.get(),
                        ModBlocks.SPIKETIP_SLAB.get(),
                        ModBlocks.SPIKETIP_STAIRS.get(),
                        ModBlocks.SPIKETIP_BUTTON.get(),
                        ModBlocks.SPIKETIP_PRESSURE_PLATE.get(),
                        ModBlocks.STRIPPED_SPIKETIP_WOOD.get(),
                        ModBlocks.TREE_FERN_STEM.get(),
                        ModBlocks.STRIPPED_TREE_FERN_LOG.get(),
                        ModBlocks.TREE_FERN_WOOD.get(),
                        ModBlocks.TREE_FERN_DOOR.get(),
                        ModBlocks.TREE_FERN_TRAPDOOR.get(),
                        ModBlocks.TREE_FERN_FENCE_GATE.get(),
                        ModBlocks.TREE_FERN_FENCE.get(),
                        ModBlocks.TREE_FERN_SLAB.get(),
                        ModBlocks.TREE_FERN_STAIRS.get(),
                        ModBlocks.TREE_FERN_BUTTON.get(),
                        ModBlocks.TREE_FERN_PRESSURE_PLATE.get(),
                        ModBlocks.CASTLE_SPIKES.get(),
                        ModBlocks.BAMBOO_PILLAR_LIGHT.get(),
                        ModBlocks.ACACIA_PILLAR_LIGHT.get(),
                        ModBlocks.BAMBOO_PILLAR_LIGHT.get(),
                        ModBlocks.BIRCH_PILLAR_LIGHT.get(),
                        ModBlocks.CHERRY_PILLAR_LIGHT.get(),
                        ModBlocks.CRIMSON_PILLAR_LIGHT.get(),
                        ModBlocks.DARK_OAK_PILLAR_LIGHT.get(),
                        ModBlocks.GINKGO_PILLAR_LIGHT.get(),
                        ModBlocks.JUNGLE_PILLAR_LIGHT.get(),
                        ModBlocks.MANGROVE_PILLAR_LIGHT.get(),
                        ModBlocks.OAK_PILLAR_LIGHT.get(),
                        ModBlocks.SPIKETIP_PILLAR_LIGHT.get(),
                        ModBlocks.SPRUCE_PILLAR_LIGHT.get(),
                        ModBlocks.TREE_FERN_PILLAR_LIGHT.get(),
                        ModBlocks.WARPED_PILLAR_LIGHT.get(),
                        ModBlocks.GREAT_CANE_WOOD.get(),
                        ModBlocks.GREAT_CANE_LOG.get(),
                        ModBlocks.STRIPPED_GREAT_CANE_WOOD.get(),
                        ModBlocks.STRIPPED_GREAT_CANE_LOG.get(),
                        ModBlocks.STRIPPED_TREE_FERN_WOOD.get());

        this.tag(BlockTags.DIRT)
                .add(ModBlocks.ANCIENT_GRASS_BLOCK.get(),
                        ModBlocks.ANCIENT_SOIL.get(),
                        ModBlocks.MOSSY_SOIL.get(),
                        ModBlocks.MUDDY_SOIL.get(),
                        ModBlocks.ANCIENT_FARMLAND.get(),
                        ModBlocks.GRASSY_BOULDERSTONE.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.GINKGO_FENCE.get(),
                        ModBlocks.TREE_FERN_FENCE.get(),
                        ModBlocks.SPIKETIP_FENCE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.GINKGO_FENCE.get(),
                        ModBlocks.TREE_FERN_FENCE.get(),
                        ModBlocks.SPIKETIP_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.GINKGO_FENCE_GATE.get(),
                        ModBlocks.TREE_FERN_FENCE_GATE.get(),
                        ModBlocks.SPIKETIP_FENCE_GATE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BIOMITE_BLOCK.get(),
                        ModBlocks.BIOMITE_ORE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PETRIFIED_PLANKS.get());

        this.tag(ModTags.Blocks.GREATER_DODO_EGG_HATCH_BOOST)
                .add(Blocks.HAY_BLOCK,
                        ModBlocks.INCUBATION_BENCH.get());

        this.tag(BlockTags.SNIFFER_EGG_HATCH_BOOST)
                .add(ModBlocks.INCUBATION_BENCH.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.GINKGO_LOG.get(),
                ModBlocks.STRIPPED_GINKGO_LOG.get(),
                ModBlocks.GINKGO_WOOD.get(),
                ModBlocks.STRIPPED_GINKGO_WOOD.get(),
                        ModBlocks.STRIPPED_GREAT_CANE_WOOD.get(),
                        ModBlocks.STRIPPED_GREAT_CANE_LOG.get(),
                        ModBlocks.GREAT_CANE_WOOD.get(),
                        ModBlocks.GREAT_CANE_LOG.get(),
                        ModBlocks.SPIKETIP_LOG.get(),
                        ModBlocks.STRIPPED_SPIKETIP_LOG.get(),
                        ModBlocks.SPIKETIP_WOOD.get(),
                        ModBlocks.STRIPPED_SPIKETIP_WOOD.get(),
                        ModBlocks.TREE_FERN_STEM.get(),
                        ModBlocks.STRIPPED_TREE_FERN_LOG.get(),
                        ModBlocks.TREE_FERN_WOOD.get(),
                        ModBlocks.STRIPPED_TREE_FERN_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.GINKGO_PLANKS.get(),
                        ModBlocks.SPIKETIP_PLANKS.get(),
                        ModBlocks.TREE_FERN_PLANKS.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.BOULDERSTONE_BRICK_WALL.get(),
                        ModBlocks.BOULDERSTONE_WALL.get(),
                        ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get(),
                        ModBlocks.POLISHED_CHLORITE_WALL.get(),
                        ModBlocks.CHLORITE_WALL.get(),
                        ModBlocks.POLISHED_POWDERSTONE_WALL.get());

        this.tag(ModTags.Blocks.BOULDERSTONE_ORE_REPLACEABLES)
                .add(ModBlocks.POWDERSTONE.get(),
                        ModBlocks.BOULDERSTONE.get());

        this.tag(BlockTags.WOOL)
                .add(ModBlocks.SNIFFER_WOOL.get());
        this.tag(BlockTags.WOOL_CARPETS)
                .add(ModBlocks.SNIFFER_CARPET.get());
    }
}
