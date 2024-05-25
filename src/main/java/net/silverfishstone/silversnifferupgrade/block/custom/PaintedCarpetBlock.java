package net.silverfishstone.silversnifferupgrade.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.block.properties.CarpetSide;

import java.util.Map;

public class PaintedCarpetBlock extends CarpetBlock {
    public static final EnumProperty<CarpetSide> EAST_EDGE = EnumProperty.create("east_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> NORTH_EDGE = EnumProperty.create("north_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> SOUTH_EDGE = EnumProperty.create("south_edge", CarpetSide.class);
    public static final EnumProperty<CarpetSide> WEST_EDGE = EnumProperty.create("west_edge", CarpetSide.class);
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");

    public PaintedCarpetBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MIDDLE, Boolean.valueOf(true)).setValue(NORTH_EDGE, CarpetSide.NONE).setValue(EAST_EDGE, CarpetSide.NONE).setValue(SOUTH_EDGE, CarpetSide.NONE).setValue(WEST_EDGE, CarpetSide.NONE));
    }

    private ImmutableMap<Object, Object> makeShapes(float pWidth, float pDepth, float pWallPostHeight, float pWallMinY, float pWallLowHeight, float pWallTallHeight) {
        float f = 8.0F - pWidth;
        float f1 = 8.0F + pWidth;
        float f2 = 8.0F - pDepth;
        float f3 = 8.0F + pDepth;
        ImmutableMap.Builder<Object, Object> builder = ImmutableMap.builder();
        for(Boolean obool : MIDDLE.getPossibleValues()) {
            for(CarpetSide carpetSide : EAST_EDGE.getPossibleValues()) {
                for(CarpetSide wallside1 : NORTH_EDGE.getPossibleValues()) {
                    for(CarpetSide wallside2 : WEST_EDGE.getPossibleValues()) {
                        for(CarpetSide wallside3 : SOUTH_EDGE.getPossibleValues()) {
                            BlockState blockstate = this.defaultBlockState().setValue(MIDDLE, obool).setValue(EAST_EDGE, carpetSide).setValue(WEST_EDGE, wallside2).setValue(NORTH_EDGE, wallside1).setValue(SOUTH_EDGE, wallside3);
                            builder.put((Map.Entry<?, ?>) blockstate.setValue(MIDDLE, Boolean.valueOf(false)));
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelReader levelreader = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.above();
        BlockState blockstate = levelreader.getBlockState(blockpos1);
        BlockState blockstate1 = levelreader.getBlockState(blockpos2);
        BlockState blockstate2 = levelreader.getBlockState(blockpos3);
        BlockState blockstate3 = levelreader.getBlockState(blockpos4);
        BlockState blockstate4 = levelreader.getBlockState(blockpos5);
        boolean flag = this.connectsTo(blockstate, blockstate.isFaceSturdy(levelreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.connectsTo(blockstate1, blockstate1.isFaceSturdy(levelreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.connectsTo(blockstate2, blockstate2.isFaceSturdy(levelreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.connectsTo(blockstate3, blockstate3.isFaceSturdy(levelreader, blockpos4, Direction.EAST), Direction.EAST);
        BlockState blockstate5 = this.defaultBlockState();
        return this.updateShape(levelreader, blockstate5, blockpos5, blockstate4, flag, flag1, flag2, flag3);
    }
    private boolean connectsTo(BlockState pState, boolean pside, Direction pDirection) {
        Block block = pState.getBlock();
        return pState.is(ModBlocks.SNIFFER_CARPET.get());
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
            if (canSurvive(pState, pLevel, pCurrentPos)) {
                return pFacing == Direction.UP ? this.topUpdate(pLevel, pState, pFacingPos, pFacingState) : this.sideUpdate(pLevel, pCurrentPos, pState, pFacingPos, pFacingState, pFacing);
            } else {
                return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : this.updateShape(pState,pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
            }
    }

    private static boolean isConnected(BlockState pState, Property<CarpetSide> pHeightProperty) {
        return pState.getValue(pHeightProperty) != CarpetSide.NONE;
    }

    private BlockState topUpdate(LevelReader pLevel, BlockState pState, BlockPos pPos, BlockState pSecondState) {
        boolean flag = isConnected(pState, NORTH_EDGE);
        boolean flag1 = isConnected(pState, EAST_EDGE);
        boolean flag2 = isConnected(pState, SOUTH_EDGE);
        boolean flag3 = isConnected(pState, WEST_EDGE);
        return this.updateShape(pLevel, pState, pPos, pSecondState, flag, flag1, flag2, flag3);
    }

    private BlockState sideUpdate(LevelReader pLevel, BlockPos pFirstPos, BlockState pFirstState, BlockPos pSecondPos, BlockState pSecondState, Direction pDir) {
        Direction direction = pDir.getOpposite();
        boolean flag = pDir == Direction.NORTH ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, NORTH_EDGE);
        boolean flag1 = pDir == Direction.EAST ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, EAST_EDGE);
        boolean flag2 = pDir == Direction.SOUTH ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, SOUTH_EDGE);
        boolean flag3 = pDir == Direction.WEST ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, WEST_EDGE);
        BlockPos blockpos = pFirstPos.above();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        return this.updateShape(pLevel, pFirstState, blockpos, blockstate, flag, flag1, flag2, flag3);
    }

    private BlockState updateShape(LevelReader pLevel, BlockState pState, BlockPos pPos, BlockState pNeighbour, boolean pNorthConnection, boolean pEastConnection, boolean pSouthConnection, boolean pWestConnection) {
        BlockState blockstate = this.updateSides(pState, pNorthConnection, pEastConnection, pSouthConnection, pWestConnection);
        return blockstate.setValue(MIDDLE, Boolean.valueOf(String.valueOf(MIDDLE)));
    }

    private BlockState updateSides(BlockState pState, boolean pNorthConnection, boolean pEastConnection, boolean pSouthConnection, boolean pWestConnection) {
        return pState.setValue(NORTH_EDGE, this.makeCarpetState(pNorthConnection))
                .setValue(EAST_EDGE, this.makeCarpetState(pEastConnection))
                .setValue(SOUTH_EDGE, this.makeCarpetState(pSouthConnection))
                .setValue(WEST_EDGE, this.makeCarpetState(pWestConnection));
    }

    private CarpetSide makeCarpetState(boolean pAllowConnection) {
        if (pAllowConnection) {
            return CarpetSide.BASE;
        } else {
            return CarpetSide.NONE;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(NORTH_EDGE, SOUTH_EDGE, EAST_EDGE, WEST_EDGE, MIDDLE);
    }
}
