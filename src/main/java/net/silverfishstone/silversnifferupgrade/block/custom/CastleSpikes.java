package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.silverfishstone.silversnifferupgrade.damage.SnifferDamageSources;

public class CastleSpikes extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    public CastleSpikes(Properties pProperties) {
        super(pProperties);
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        DamageSource spiked =
                new SnifferDamageSources(pEntity.level().registryAccess()).spiked();
        if (pEntity instanceof LivingEntity) {
            pEntity.makeStuckInBlock(pState, new Vec3((double) 0.8F, 0.75D, (double) 0.8F));
            pEntity.hurt(spiked, 1f);
        }
    }
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
