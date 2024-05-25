package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.silverfishstone.silversnifferupgrade.block.entity.GinkgoHangingSignBlockEntity;
import net.silverfishstone.silversnifferupgrade.block.entity.GinkgoSignBlockEntity;

public class GinkgoWallSignBlock extends WallSignBlock {
    public GinkgoWallSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GinkgoSignBlockEntity(pPos, pState);
    }
}
