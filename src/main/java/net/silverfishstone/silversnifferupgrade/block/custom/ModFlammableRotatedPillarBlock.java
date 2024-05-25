package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.GINKGO_LOG.get())) {
                return ModBlocks.STRIPPED_GINKGO_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.GINKGO_WOOD.get())) {
                return ModBlocks.STRIPPED_GINKGO_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.SPIKETIP_LOG.get())) {
                return ModBlocks.STRIPPED_SPIKETIP_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.SPIKETIP_WOOD.get())) {
                return ModBlocks.STRIPPED_SPIKETIP_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.TREE_FERN_STEM.get())) {
                return ModBlocks.STRIPPED_TREE_FERN_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.TREE_FERN_WOOD.get())) {
                return ModBlocks.STRIPPED_TREE_FERN_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.GREAT_CANE_LOG.get())) {
                return ModBlocks.STRIPPED_GREAT_CANE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.GREAT_CANE_WOOD.get())) {
                return ModBlocks.STRIPPED_GREAT_CANE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
