package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.worldgen.ModBiomeModifiers;
import net.silverfishstone.silversnifferupgrade.worldgen.ModConfiguredFeatures;
import net.silverfishstone.silversnifferupgrade.worldgen.ModPlacedFeatures;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.ModBiomes;
import net.silverfishstone.silversnifferupgrade.worldgen.dimension.ModDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(ForgeRegistries.Keys.BIOMES, ModBiomes::bootstrap)
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem);


    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, Set<String> modIds) {
        super(output, registries, BUILDER,Set.of(SnifferUpgrade.MODID));
    }
}
