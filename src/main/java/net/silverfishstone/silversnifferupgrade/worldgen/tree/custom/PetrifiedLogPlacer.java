package net.silverfishstone.silversnifferupgrade.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PetrifiedLogPlacer extends TrunkPlacer {
    public static final Codec<PetrifiedLogPlacer> CODEC = RecordCodecBuilder.create(petrifiedLogPlacerInstance ->
            trunkPlacerParts(petrifiedLogPlacerInstance).apply(petrifiedLogPlacerInstance, PetrifiedLogPlacer::new));
    public PetrifiedLogPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PETRIFIED_LOG_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 1);
        int i;
        int min = 0;
        int max = 3;
        int p = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int minu = 0;
        int maxu = 1;
        int u = (int)Math.floor(Math.random() * (max - min + 1) + min);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(0), pConfig);
        int minr = 0;
        int maxr = 7;
        int r = (int)Math.floor(Math.random() * (max - min + 1) + min);
        this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(0), pConfig);
        for (i = 0; i < height; i++) {
            if(u == 1) {
                pBlockSetter.accept(pPos.above(-1).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
                pBlockSetter.accept(pPos.above(0).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            } else {
                if(p == 0) {
                    pBlockSetter.accept(pPos.above(0).relative(Direction.NORTH), ((BlockState)
                            Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                }
                if(p == 1) {
                    pBlockSetter.accept(pPos.above(0).relative(Direction.SOUTH), ((BlockState)
                            Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                }
                if(p == 2) {
                    pBlockSetter.accept(pPos.above(0).relative(Direction.EAST), ((BlockState)
                            Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                }
                if(p == 3) {
                    pBlockSetter.accept(pPos.above(0).relative(Direction.WEST), ((BlockState)
                            Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                }
            }
            if(r == 1) {
                pBlockSetter.accept(pPos.above(-1).west(2).north(2).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 2) {
                pBlockSetter.accept(pPos.above(-1).east(2).north(3).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 3) {
                pBlockSetter.accept(pPos.above(-1).west(3).south(2).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 4) {
                pBlockSetter.accept(pPos.above(-1).east(3).south(2).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 5) {
                pBlockSetter.accept(pPos.above(-1).west(4).north(4).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 6) {
                pBlockSetter.accept(pPos.above(-1).east(5).north(4).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 7) {
                pBlockSetter.accept(pPos.above(-1).west(4).south(4).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(r == 8) {
                pBlockSetter.accept(pPos.above(-1).east(4).south(5).relative(Direction.UP), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y))));
            }
            if(p == 0) {
                pBlockSetter.accept(pPos.north(i).relative(Direction.NORTH), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
            }
            if(p == 1) {
                pBlockSetter.accept(pPos.south(i).relative(Direction.SOUTH), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
            }
            if(p == 2) {
                pBlockSetter.accept(pPos.east(i).relative(Direction.EAST), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
            }
            if(p == 3) {
                pBlockSetter.accept(pPos.west(i).relative(Direction.WEST), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
