package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.ModBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagGenerator extends BiomeTagsProvider {
    public ModBiomeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SnifferUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Biomes.IS_DESERT)
                .add(ModBiomes.PETRIFIED_FOREST);

        this.tag(BiomeTags.IS_OCEAN)
                .add(ModBiomes.PRIMAL_OCEAN);

        this.tag(ModTags.Biomes.ANCIENT)
                .add(ModBiomes.GREAT_CANE_FOREST,
                        ModBiomes.PRIMAL_OCEAN,
                        ModBiomes.ANCIENT_GINKGO_FOREST,
                        ModBiomes.LITTLE_MOUNTAINS,
                        ModBiomes.RUMBLING_PEAKS,
                        ModBiomes.ANCIENT_JUNGLE);
    }
}
