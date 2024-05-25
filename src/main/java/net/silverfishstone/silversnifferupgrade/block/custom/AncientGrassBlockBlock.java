package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;

import javax.annotation.Nullable;

public abstract class AncientGrassBlockBlock extends SnowyDirtBlock {
    public AncientGrassBlockBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    private static boolean canBeAncientGrass(BlockState pState, LevelReader pLevelReader, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevelReader.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(pLevelReader, pState, pPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(pLevelReader, blockpos));
            return i < pLevelReader.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        return canBeAncientGrass(pState, pLevel, pPos) && !pLevel.getFluidState(blockpos).is(FluidTags.WATER);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!canBeAncientGrass(pState, pLevel, pPos)) {
            if (!pLevel.isAreaLoaded(pPos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            pLevel.setBlockAndUpdate(pPos, ModBlocks.ANCIENT_SOIL.get().defaultBlockState());
        } else {
            if (!pLevel.isAreaLoaded(pPos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (pLevel.getMaxLocalRawBrightness(pPos.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
                    if (pLevel.getBlockState(blockpos).is(ModBlocks.ANCIENT_SOIL.get()) && canPropagate(blockstate, pLevel, blockpos)) {
                        pLevel.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(pLevel.getBlockState(blockpos.above()).is(Blocks.SNOW))));
                    }
                }
            }

        }
    }

    //I used Regions Unexplored as a base here. https://www.curseforge.com/minecraft/mc-mods/regions-unexplored
    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
        if (ToolActions.SHOVEL_FLATTEN == action && context.getItemInHand().canPerformAction(ToolActions.SHOVEL_FLATTEN)) {
            Block block = state.getBlock();
            if (block == ModBlocks.ANCIENT_GRASS_BLOCK.get()) {
                return Blocks.DIRT_PATH.defaultBlockState();}
            else{
                return null;
            }

        }
        if (ToolActions.HOE_TILL == action && context.getItemInHand().canPerformAction(ToolActions.HOE_TILL)) {
            Block block = state.getBlock();
            if (block == ModBlocks.ANCIENT_GRASS_BLOCK.get()) {
                return ModBlocks.ANCIENT_FARMLAND.get().defaultBlockState();}
            else{
                return null;
            }

        }
        return null;
    }
}

