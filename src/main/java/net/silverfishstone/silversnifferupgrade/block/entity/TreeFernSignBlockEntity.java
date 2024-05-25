package net.silverfishstone.silversnifferupgrade.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TreeFernSignBlockEntity extends SignBlockEntity {
    public TreeFernSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TREE_FERN_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.TREE_FERN_SIGN.get();
    }
}
