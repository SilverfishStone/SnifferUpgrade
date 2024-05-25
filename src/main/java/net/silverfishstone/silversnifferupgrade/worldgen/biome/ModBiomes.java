package net.silverfishstone.silversnifferupgrade.worldgen.biome;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.worldgen.ModPlacedFeatures;
import net.silverfishstone.silversnifferupgrade.worldgen.feature.SUBiomeDefaultFeatures;

public class ModBiomes {
    public static final ResourceKey<Biome> ANCIENT_GINKGO_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "ancient_ginkgo_forest"));
    public static final ResourceKey<Biome> LITTLE_MOUNTAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "little_mountains"));
    public static final ResourceKey<Biome> ANCIENT_JUNGLE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "ancient_jungle"));
    public static final ResourceKey<Biome> PETRIFIED_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "petrified_forest"));
    public static final ResourceKey<Biome> PRIMAL_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "primal_ocean"));
    public static final ResourceKey<Biome> MYSTERIOUS_SEA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "mysterious_sea"));
    public static final ResourceKey<Biome> RUMBLING_PEAKS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "rumbling_ridges"));
    public static final ResourceKey<Biome> GREAT_CANE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SnifferUpgrade.MODID, "great_cane_forest"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(ANCIENT_GINKGO_FOREST, ancientGinkgoForest(context));
        context.register(LITTLE_MOUNTAINS, littleMountains(context));
        context.register(ANCIENT_JUNGLE, ancientJungle(context));
        context.register(PETRIFIED_FOREST, petrifiedForest(context));
        context.register(PRIMAL_OCEAN, primalOcean(context));
        context.register(MYSTERIOUS_SEA, mysteriousSea(context));
        context.register(RUMBLING_PEAKS, rumblingPeaks(context));
        context.register(GREAT_CANE_FOREST, greatCaneForest(context));

    }
    public static void globalAncientFieldsGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }
    public static Biome ancientGinkgoForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.GREATERDODO.get(), 5, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SNIFFER, 5, 1, 3));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GINKGO_PLACED_KEY);
        SUBiomeDefaultFeatures.addStranipFlowers(biomeBuilder);
        SUBiomeDefaultFeatures.addAFGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_GINKGO_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPIKETIP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x8ED7F4)
                        .waterFogColor(0x6BBDDE)
                        .grassColorOverride(0x47C922)
                        .foliageColorOverride(0x47C922)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome ancientJungle(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.GREATERDODO.get(), 5, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 2, 1, 2));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SNIFFER, 5, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 1, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 3, 2, 6));
        spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(ModEntities.AMPHIBIMUS.get(), 10, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TREE_FERN_PLACED_KEY);
        BiomeDefaultFeatures.addBambooVegetation(biomeBuilder);
        SUBiomeDefaultFeatures.addStranipFlowers(biomeBuilder);
        SUBiomeDefaultFeatures.addAFGrass(biomeBuilder);
        BiomeDefaultFeatures.addSparseJungleTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0AF5D8)
                        .waterFogColor(0x1CE4CB)
                        .grassColorOverride(0x00D215)
                        .foliageColorOverride(0x00D215)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome littleMountains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.GREATERDODO.get(), 5, 3, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        SUBiomeDefaultFeatures.addStranipFlowers(biomeBuilder);
        SUBiomeDefaultFeatures.addAFGrass(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0050BE)
                        .waterFogColor(0x0062E9)
                        .grassColorOverride(0x158E5D)
                        .foliageColorOverride(0x0DB050)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome petrifiedForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 5, 1, 3));

        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.SAND_FOREST_PATCH_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PETRIFIED_LOG_PLACED_KEY);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PETRIFIED_TREE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0050BE)
                        .waterFogColor(0x0062E9)
                        .grassColorOverride(0x158E5D)
                        .foliageColorOverride(0x0DB050)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome primalOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.warmOceanSpawns(spawnBuilder, 4,2);
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 6, 1, 6));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.CONESHELL.get(), 6, 2, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.EURYPTERUS.get(), 3, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION);
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3AAEE3)
                        .waterFogColor(0x4FB7F8)
                        .grassColorOverride(0x39A962)
                        .foliageColorOverride(0x39A962)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome mysteriousSea(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.warmOceanSpawns(spawnBuilder, 4,2);
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 6, 1, 6));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.CONESHELL.get(), 6, 2, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.EURYPTERUS.get(), 3, 1, 2));
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(-0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x442494)
                        .waterFogColor(0x313AB2)
                        .grassColorOverride(0x39A962)
                        .foliageColorOverride(0x39A962)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome rumblingPeaks(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.FLAMIPEDE.get(), 5, 1, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.MAGMA_DELTA_PLACED);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(1.3f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0050BE)
                        .waterFogColor(0x0062E9)
                        .grassColorOverride(0x158E5D)
                        .foliageColorOverride(0x0DB050)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
    public static Biome greatCaneForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.GREATERDODO.get(), 5, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 2, 1, 2));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SNIFFER, 5, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 1, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 3, 2, 6));
        spawnBuilder.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(ModEntities.AMPHIBIMUS.get(), 10, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalAncientFieldsGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_CHLORITE_PLACED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TREE_FERN_PLACED_KEY);
        SUBiomeDefaultFeatures.addStranipFlowers(biomeBuilder);
        SUBiomeDefaultFeatures.addAFGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GREAT_CANE_PLACED_KEY);
        BiomeDefaultFeatures.addSparseJungleTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0AF5D8)
                        .waterFogColor(0x1CE4CB)
                        .grassColorOverride(0x00D215)
                        .foliageColorOverride(0x00D215)
                        .fogColor(0xE9F8FF)
                        .skyColor(0xB3DCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
}


