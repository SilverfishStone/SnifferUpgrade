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

public class PetrifiedTrunkPlacer extends TrunkPlacer {
    public static final Codec<PetrifiedTrunkPlacer> CODEC = RecordCodecBuilder.create(petrifiedTrunkPlacerInstance ->
            trunkPlacerParts(petrifiedTrunkPlacerInstance).apply(petrifiedTrunkPlacerInstance, PetrifiedTrunkPlacer::new));
    public PetrifiedTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PETRIFIED_TREE_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 1) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);
        int i;
        for (i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        }
        int min = 0;
        int max = 1;
        int n = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int min2 = 0;
        int max2 = 1;
        int j = (int)Math.floor(Math.random() * (max2 - min2 + 1) + min2);
        int min3 = 0;
        int max3 = 1;
        int k = (int)Math.floor(Math.random() * (max3 - min3 + 1) + min3);
        int min4 = 0;
        int max4 = 1;
        int l = (int)Math.floor(Math.random() * (max4 - min4 + 1) + min4);
        int min5 = 0;
        int max5 = 1;
        int m = (int)Math.floor(Math.random() * (max5 - min5 + 1) + min5);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 3).east(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 4).west(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 2).north(1), pConfig);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 3).south(1), pConfig);
        if (n == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 2).east(2), pConfig);
        }
        if (j == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 3).west(2), pConfig);
        }
        if (k == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 1).north(2), pConfig);
        }
        if (l == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 2).south(2), pConfig);
        }
        if (m == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i - 1).south(1), pConfig);
        }
        if (n == 1) {
        }else {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i).south(1), pConfig);
        }


        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
