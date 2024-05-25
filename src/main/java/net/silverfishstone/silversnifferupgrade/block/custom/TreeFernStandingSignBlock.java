package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.silverfishstone.silversnifferupgrade.block.entity.GinkgoHangingSignBlockEntity;
import net.silverfishstone.silversnifferupgrade.block.entity.TreeFernSignBlockEntity;

public class TreeFernStandingSignBlock extends StandingSignBlock {
    public TreeFernStandingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TreeFernSignBlockEntity(pPos, pState);
    }
}
