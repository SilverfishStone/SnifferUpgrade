package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.silverfishstone.silversnifferupgrade.block.properties.Floatable;
import net.silverfishstone.silversnifferupgrade.entity.custom.FloatingBlockEntity;

public class FloatingBlock extends FallingBlock implements Floatable {
    public FloatingBlock(Properties pProperties) {
        super(pProperties);
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        pLevel.scheduleTick(pPos, this, this.getDelayAfterPlace());
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        pLevel.scheduleTick(pCurrentPos, this, this.getDelayAfterPlace());
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (isFloating(pLevel.getBlockState(pPos.above())) && pPos.getY() <= pLevel.getMaxBuildHeight()) {
            FloatingBlockEntity floatingBlockEntity = FloatingBlockEntity.setFloat(pLevel, pPos, pState);
            this.floating(floatingBlockEntity);
        }
    }
    protected void floating(FloatingBlockEntity pEntity) {
    }

    public static boolean isFloating(BlockState pState) {
        return pState.is(Blocks.WATER);
    }

    protected int getDelayAfterPlace() {
        return 1;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet pEnabledFeatures) {
        return super.isEnabled(pEnabledFeatures);
    }

    @Override
    public void onLand(Level pLevel, BlockPos pPos, BlockState pState, BlockState pReplaceableState, FallingBlockEntity pFallingBlock) {
        super.onLand(pLevel, pPos, pState, pReplaceableState, pFallingBlock);
    }

    @Override
    public void onBrokenAfterFall(Level pLevel, BlockPos pPos, FallingBlockEntity pFallingBlock) {
        super.onBrokenAfterFall(pLevel, pPos, pFallingBlock);
    }

    @Override
    public DamageSource getFallDamageSource(Entity pEntity) {
        return super.getFallDamageSource(pEntity);
    }
}
