package net.silverfishstone.silversnifferupgrade.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class TreeFernTrunkPlacer extends TrunkPlacer {
    public static final Codec<TreeFernTrunkPlacer> CODEC = RecordCodecBuilder.create(treeFernTrunkPlacerInstance ->
            trunkPlacerParts(treeFernTrunkPlacerInstance).apply(treeFernTrunkPlacerInstance, TreeFernTrunkPlacer::new));
    public TreeFernTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.TREE_FERN_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 1) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);
        int i;
        for (i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        }
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 1).east(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 1).west(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 1).north(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 1).south(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 2).east(2), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 2).west(2), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 2).north(2), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i + 2).south(2), pConfig);


        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
