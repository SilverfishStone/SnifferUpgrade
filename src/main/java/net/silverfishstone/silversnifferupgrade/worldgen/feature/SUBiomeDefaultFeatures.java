package net.silverfishstone.silversnifferupgrade.worldgen.feature;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.silverfishstone.silversnifferupgrade.worldgen.ModPlacedFeatures;

public class SUBiomeDefaultFeatures {
    public static void addStranipFlowers(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.STRANIP_FLOWER_PATCH_PLACED);
    }
    public static void addAFGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ANCIENT_FIELDS_GRASS_PLACED);
    }
}
