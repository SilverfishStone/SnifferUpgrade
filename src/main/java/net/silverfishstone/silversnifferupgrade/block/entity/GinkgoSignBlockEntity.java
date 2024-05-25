package net.silverfishstone.silversnifferupgrade.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GinkgoSignBlockEntity extends SignBlockEntity {
    public GinkgoSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GINKGO_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.GINKGO_SIGN.get();
    }
}
