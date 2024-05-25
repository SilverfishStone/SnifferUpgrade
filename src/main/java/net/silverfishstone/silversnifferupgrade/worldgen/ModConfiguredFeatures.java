package net.silverfishstone.silversnifferupgrade.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_FIELDS_BIOMITE_ORE_KEY = registerKey("biomite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_KEY = registerKey("ginkgo_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREAT_CANE_KEY = registerKey("great_cane_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GINKGO_KEY = registerKey("large_ginkgo_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIKETIP_KEY = registerKey("spiketip_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_FERN_KEY = registerKey("tree_fern_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_KEY = registerKey("petrified_tree_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED_LOG_KEY = registerKey("petrified_log_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAND_FOREST_PATCH = registerKey("sand_forest_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRANIP_FLOWER_PATCH = registerKey("stranip_flower_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_FIELDS_GRASS = registerKey("ancient_fields_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHLORITE_ORE = registerKey("chlorite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGMA_DELTA = registerKey("magma_delta");
    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest boulderstoneReplaceable = new TagMatchTest(ModTags.Blocks.BOULDERSTONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> ancientFieldBiomiteOres = List.of((OreConfiguration.target(boulderstoneReplaceable,
                        ModBlocks.BIOMITE_ORE.get().defaultBlockState())));
        register(context, ANCIENT_FIELDS_BIOMITE_ORE_KEY, Feature.ORE, new OreConfiguration(ancientFieldBiomiteOres, 10));

        register(context, GINKGO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.GINKGO_LOG.get()),
                new StraightTrunkPlacer(3, 3, 3),
                BlockStateProvider.simple(ModBlocks.GINKGO_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(0, 0, 1)).build());

        register(context, LARGE_GINKGO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.GINKGO_LOG.get()),
                new DarkOakTrunkPlacer(5, 4, 3),
                BlockStateProvider.simple(ModBlocks.GINKGO_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SPIKETIP_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SPIKETIP_LOG.get()),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.simple(ModBlocks.SPIKETIP_LEAVES.get()),
                new SpiketipFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), 4),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, TREE_FERN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.TREE_FERN_STEM.get()),
                new TreeFernTrunkPlacer(1, 1, 1),

                BlockStateProvider.simple(ModBlocks.TREE_FERN_LEAVES.get()),
                new TreeFernFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, GREAT_CANE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.GREAT_CANE_LOG.get()),
                new StraightTrunkPlacer(9, 4, 3),

                BlockStateProvider.simple(ModBlocks.GREAT_CANE_LEAVES.get()),
                new GreatCaneFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), 4),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PETRIFIED_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PETRIFIED_LOG.get()),
                new PetrifiedTrunkPlacer(1, 1, 1),

                BlockStateProvider.simple(Blocks.AIR),
                new TreeFernFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PETRIFIED_LOG_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PETRIFIED_LOG.get()),
                new PetrifiedLogPlacer(1, 2, 0),

                BlockStateProvider.simple(Blocks.AIR),
                new TreeFernFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 1)).build());

        FeatureUtils.register(context, SAND_FOREST_PATCH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SAND))));
        FeatureUtils.register(context, STRANIP_FLOWER_PATCH, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.STRANIP_FLOWER.get()), 5));
        FeatureUtils.register(context, ANCIENT_FIELDS_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.GRASS), 32));
        FeatureUtils.register(context, CHLORITE_ORE, Feature.ORE, new OreConfiguration(boulderstoneReplaceable, ModBlocks.CHLORITE.get().defaultBlockState(), 64));
        FeatureUtils.register(context, MAGMA_DELTA, Feature.DELTA_FEATURE, new DeltaFeatureConfiguration(Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), UniformInt.of(3, 7), UniformInt.of(0, 2)));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SnifferUpgrade.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}