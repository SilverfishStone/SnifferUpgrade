package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PillarLight extends Block{
    private static final VoxelShape PILLAR = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public PillarLight(Properties pProperties) {
        super(pProperties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return PILLAR;
    }
}

