package net.silverfishstone.silversnifferupgrade.block.properties;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.silverfishstone.silversnifferupgrade.entity.custom.FloatingBlockEntity;

public interface Floatable {
    default void inWater(Level pLevel, BlockPos pPos, BlockState pState, BlockState pReplaceableState, FloatingBlockEntity pFloatingBlock) {
    }
    default void onBrokenAfterFloat(Level pLevel, BlockPos pPos, FloatingBlockEntity pFloatingBlock) {
    }
    default DamageSource getFallDamageSource(Entity pEntity) {
        return pEntity.damageSources().fallingBlock(pEntity);
    }
}
