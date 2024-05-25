package net.silverfishstone.silversnifferupgrade.worldgen.biome.surface;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.ModBiomes;

public class GinkgoSurfaceRules
{
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(ModBlocks.ANCIENT_SOIL.get());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(ModBlocks.ANCIENT_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource MUDDY = makeStateRule(ModBlocks.MUDDY_SOIL.get());
    private static final SurfaceRules.RuleSource MOSSY_GRASS_BLOCK = makeStateRule(ModBlocks.MOSSY_SOIL.get());
    private static final SurfaceRules.RuleSource BOULDERSTONE = makeStateRule(ModBlocks.BOULDERSTONE.get());
    private static final SurfaceRules.RuleSource GRASSY_BOULDERSTONE = makeStateRule(ModBlocks.GRASSY_BOULDERSTONE.get());
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource POWDERSTONE = makeStateRule(ModBlocks.POWDERSTONE.get());
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource VOLCANIC = makeStateRule(ModBlocks.LATITE.get());


    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource ginkgoForest = SurfaceRules.isBiome(ModBiomes.ANCIENT_GINKGO_FOREST);
        SurfaceRules.ConditionSource littleMountains = SurfaceRules.isBiome(ModBiomes.LITTLE_MOUNTAINS);
        SurfaceRules.ConditionSource ancientJungle = SurfaceRules.isBiome(ModBiomes.ANCIENT_JUNGLE, ModBiomes.GREAT_CANE_FOREST);
        SurfaceRules.ConditionSource petrified = SurfaceRules.isBiome(ModBiomes.PETRIFIED_FOREST);
        SurfaceRules.ConditionSource volcano = SurfaceRules.isBiome(ModBiomes.RUMBLING_PEAKS);
        SurfaceRules.ConditionSource ocean = SurfaceRules.isBiome(ModBiomes.PRIMAL_OCEAN, ModBiomes.MYSTERIOUS_SEA);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource mudGrass = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, MOSSY_GRASS_BLOCK), MUDDY);
        SurfaceRules.RuleSource boulderstone = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASSY_BOULDERSTONE), BOULDERSTONE);
        SurfaceRules.RuleSource volcanic = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, VOLCANIC), VOLCANIC);
        SurfaceRules.RuleSource sand = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, RED_SAND), RED_SANDSTONE);
        SurfaceRules.RuleSource biomeGrass = SurfaceRules.sequence(SurfaceRules.ifTrue(ginkgoForest, grassSurface), SurfaceRules.ifTrue(littleMountains, boulderstone), SurfaceRules.ifTrue(ancientJungle, mudGrass), SurfaceRules.ifTrue(petrified, sand), SurfaceRules.ifTrue(ocean, SAND), SurfaceRules.ifTrue(volcano, VOLCANIC));
        SurfaceRules.RuleSource biomeDirt = SurfaceRules.sequence(SurfaceRules.ifTrue(ginkgoForest, DIRT), SurfaceRules.ifTrue(littleMountains, BOULDERSTONE), SurfaceRules.ifTrue(ancientJungle, MUDDY), SurfaceRules.ifTrue(petrified, RED_SAND), SurfaceRules.ifTrue(ocean, SAND), SurfaceRules.ifTrue(volcano, VOLCANIC));
        SurfaceRules.RuleSource biomeStone = SurfaceRules.sequence(SurfaceRules.ifTrue(ginkgoForest, grassSurface), SurfaceRules.ifTrue(littleMountains, POWDERSTONE), SurfaceRules.ifTrue(ancientJungle, POWDERSTONE), SurfaceRules.ifTrue(petrified, RED_SANDSTONE), SurfaceRules.ifTrue(ocean, SANDSTONE), SurfaceRules.ifTrue(volcano, VOLCANIC));
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, biomeGrass),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, biomeDirt),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, biomeStone),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ANCIENT_JUNGLE), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ANCIENT_GINKGO_FOREST), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LITTLE_MOUNTAINS), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.PRIMAL_OCEAN), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.MYSTERIOUS_SEA), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.RUMBLING_PEAKS), POWDERSTONE),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.GREAT_CANE_FOREST), POWDERSTONE)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
