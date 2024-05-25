package net.silverfishstone.silversnifferupgrade.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.ModBiomes;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> ANCIENT_FIELDS_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(SnifferUpgrade.MODID, "ancient_fields"));
    public static final ResourceKey<Level> ANCIENT_FIELDS_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(SnifferUpgrade.MODID, "ancient_fields"));
    public static final ResourceKey<DimensionType> ANCIENT_FIELDS_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(SnifferUpgrade.MODID, "ancient_fields"));


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(ANCIENT_FIELDS_DIM_TYPE, new DimensionType(
                OptionalLong.of(6000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.ANCIENT_GINKGO_FOREST)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(1.3F, 1.1F, 1.2F, 0.3F, 0.0F, 0.1F, 1.0F), biomeRegistry.getOrThrow(ModBiomes.ANCIENT_GINKGO_FOREST)),
                                Pair.of(
                                        Climate.parameters(-1F, 0.3F, 2.0F, 0.5F, 0.0F, -0.5F, 0.6F), biomeRegistry.getOrThrow(ModBiomes.LITTLE_MOUNTAINS)),
                                Pair.of(
                                        Climate.parameters(1.4F, 1F, -1.2F, 0.4F, 0.0F, 0.6F, 1.0F), biomeRegistry.getOrThrow(ModBiomes.PRIMAL_OCEAN)),
                                Pair.of(
                                        Climate.parameters(1.7F, 1.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ANCIENT_JUNGLE)),

                                Pair.of(
                                        Climate.parameters(1.3F, 0F, 1.6F, 0.5F, -0.1F, -1.3F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RUMBLING_PEAKS)),
                                Pair.of(
                                        Climate.parameters(-1F, 1.3F, -2F, 0.0F, 0.0F, 0.0F, 0.2F), biomeRegistry.getOrThrow(ModBiomes.MYSTERIOUS_SEA)),
                                Pair.of(
                                        Climate.parameters(1.2F, 1.4F, 1F, 1.0F, 0.0F, 0.0F, 0.7F), biomeRegistry.getOrThrow(ModBiomes.GREAT_CANE_FOREST))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.ANCIENT_FIELDS_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(ANCIENT_FIELDS_KEY, stem);
    }
}
