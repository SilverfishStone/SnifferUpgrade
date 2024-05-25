package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SnifferUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.GINKGO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGO_LOG.get().asItem())
                .add(ModBlocks.GINKGO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGO_WOOD.get().asItem())
                .add(ModBlocks.SPIKETIP_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SPIKETIP_LOG.get().asItem())
                .add(ModBlocks.SPIKETIP_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SPIKETIP_WOOD.get().asItem())
                .add(ModBlocks.TREE_FERN_STEM.get().asItem())
                .add(ModBlocks.STRIPPED_TREE_FERN_LOG.get().asItem())
                .add(ModBlocks.GREAT_CANE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GREAT_CANE_LOG.get().asItem())
                .add(ModBlocks.GREAT_CANE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GREAT_CANE_WOOD.get().asItem())
                .add(ModBlocks.TREE_FERN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_TREE_FERN_WOOD.get().asItem());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CHITIN_BOOTS.get(),
                        ModItems.CHITIN_CHESTPLATE.get(),
                        ModItems.CHITIN_HELMET.get(),
                        ModItems.CHITIN_SEGMENT.get(),
                        ModItems.CHITIN_LEGGINGS.get());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.GINKGO_PLANKS.get().asItem(),
                        ModBlocks.TREE_FERN_PLANKS.get().asItem(),
                        ModBlocks.SPIKETIP_PLANKS.get().asItem());

        this.tag(ModTags.Items.GINKGO_LOGS)
                .add(ModBlocks.GINKGO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGO_LOG.get().asItem())
                .add(ModBlocks.GINKGO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGO_WOOD.get().asItem());

        this.tag(ModTags.Items.SPIKETIP_LOGS)
                .add(ModBlocks.SPIKETIP_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SPIKETIP_LOG.get().asItem())
                .add(ModBlocks.SPIKETIP_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SPIKETIP_WOOD.get().asItem());

        this.tag(ModTags.Items.TREE_FERN_LOGS)
                .add(ModBlocks.TREE_FERN_STEM.get().asItem())
                .add(ModBlocks.STRIPPED_TREE_FERN_LOG.get().asItem())
                .add(ModBlocks.TREE_FERN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_TREE_FERN_WOOD.get().asItem());

        this.tag(ModTags.Items.GREAT_CANE_LOGS)
                .add(ModBlocks.GREAT_CANE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GREAT_CANE_LOG.get().asItem())
                .add(ModBlocks.GREAT_CANE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_GREAT_CANE_WOOD.get().asItem());

        this.tag(ItemTags.FLOWERS)
                .add(ModBlocks.STRANIP_FLOWER.get().asItem());
        this.tag(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.STRANIP_FLOWER.get().asItem());

        this.tag(ModTags.Items.FEATHERS)
                .add(ModItems.DODO_FEATHER.get())
                .add(Items.FEATHER);
        this.tag(Tags.Items.FEATHERS)
                .add(ModItems.DODO_FEATHER.get());

        this.tag(ItemTags.WOOL)
                .add(ModBlocks.SNIFFER_WOOL.get().asItem());

        this.tag(ItemTags.WOOL_CARPETS)
                .add(ModBlocks.SNIFFER_CARPET.get().asItem());

        this.tag(Tags.Items.COBBLESTONE)
                .add(ModBlocks.BOULDERSTONE.get().asItem());
        this.tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.BOULDERSTONE.get().asItem(),
                        ModBlocks.POWDERSTONE.get().asItem(),
                        ModBlocks.LATITE.get().asItem(),
                        ModBlocks.PUMICE.get().asItem());
    }
}
