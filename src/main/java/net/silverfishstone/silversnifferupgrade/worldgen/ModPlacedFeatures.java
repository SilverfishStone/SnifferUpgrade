package net.silverfishstone.silversnifferupgrade.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.util.ModTags;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY = registerKey("biomite_ore_placed");
    public static final ResourceKey<PlacedFeature> ORE_CHLORITE_PLACED = registerKey("ore_chlorite_placed");
    public static final ResourceKey<PlacedFeature> LARGE_GINKGO_PLACED_KEY = registerKey("large_ginkgo_placed");
    public static final ResourceKey<PlacedFeature> GINKGO_PLACED_KEY = registerKey("ginkgo_placed");
    public static final ResourceKey<PlacedFeature> SPIKETIP_PLACED_KEY = registerKey("spiketip_placed");
    public static final ResourceKey<PlacedFeature> GREAT_CANE_PLACED_KEY = registerKey("great_cane_placed");
    public static final ResourceKey<PlacedFeature> TREE_FERN_PLACED_KEY = registerKey("tree_fern_placed");
    public static final ResourceKey<PlacedFeature> PETRIFIED_TREE_PLACED_KEY = registerKey("petrified_tree_placed");
    public static final ResourceKey<PlacedFeature> PETRIFIED_LOG_PLACED_KEY = registerKey("petrified_log_placed");
    public static final ResourceKey<PlacedFeature> SAND_FOREST_PATCH_PLACED = registerKey("sand_forest_patch_placed");
    public static final ResourceKey<PlacedFeature> STRANIP_FLOWER_PATCH_PLACED = registerKey("stranip_flower_patch_placed");
    public static final ResourceKey<PlacedFeature> CRATERWEED_PATCH_PLACED = registerKey("craterweed_patch_placed");
    public static final ResourceKey<PlacedFeature> ANCIENT_FIELDS_GRASS_PLACED = registerKey("ancient_fields_grass_patch_placed");
    public static final ResourceKey<PlacedFeature> MAGMA_DELTA_PLACED = registerKey("magma_delta_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        final Holder<ConfiguredFeature<?, ?>> SAND_FOREST_PATCH_PLACED = configuredFeatures.getOrThrow(ModConfiguredFeatures.SAND_FOREST_PATCH);
        final Holder<ConfiguredFeature<?, ?>> chlorite = configuredFeatures.getOrThrow(ModConfiguredFeatures.CHLORITE_ORE);

        register(context, ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANCIENT_FIELDS_BIOMITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(1), VerticalAnchor.absolute(80))));

        register(context, GINKGO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GINKGO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.GINKGO_SAPLING.get()));
        register(context, LARGE_GINKGO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_GINKGO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.GINKGO_SAPLING.get()));
        register(context, SPIKETIP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPIKETIP_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.SPIKETIP_SAPLING.get()));
        register(context, TREE_FERN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREE_FERN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.TREE_FERN_SAPLING.get()));
        register(context, GREAT_CANE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GREAT_CANE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 5),
                        Blocks.BAMBOO_SAPLING));
        register(context, PETRIFIED_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PETRIFIED_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));
        register(context, PETRIFIED_LOG_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PETRIFIED_LOG_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));

        register(context, ModPlacedFeatures.SAND_FOREST_PATCH_PLACED, SAND_FOREST_PATCH_PLACED, List.of(CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.RED_SAND)),BiomeFilter.biome()));
        register(context, ModPlacedFeatures.ORE_CHLORITE_PLACED, chlorite, List.of(CountPlacement.of(64), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(ModTags.Blocks.BOULDERSTONE_ORE_REPLACEABLES)),BiomeFilter.biome()));
        register(context, ModPlacedFeatures.STRANIP_FLOWER_PATCH_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRANIP_FLOWER_PATCH),
                VegetationPlacements.worldSurfaceSquaredWithCount(1));
        register(context, ModPlacedFeatures.ANCIENT_FIELDS_GRASS_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANCIENT_FIELDS_GRASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(5));
        register(context, ModPlacedFeatures.CRATERWEED_PATCH_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRATERWEED_PATCH),
                VegetationPlacements.worldSurfaceSquaredWithCount(3));
        register(context, ModPlacedFeatures.MAGMA_DELTA_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAGMA_DELTA), List.of(CountPlacement.of(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(ModBlocks.LATITE.get())),BiomeFilter.biome()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SnifferUpgrade.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}