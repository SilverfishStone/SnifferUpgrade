package net.silverfishstone.silversnifferupgrade.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;
import net.silverfishstone.silversnifferupgrade.util.ModTags;

public class GreaterDodoEgg extends Block {
    public static final int MAX_HATCH_LEVEL = 2;
    public static final IntegerProperty HATCH;
    private static final int REGULAR_HATCH_TIME_TICKS = 12000;
    private static final int BOOSTED_HATCH_TIME_TICKS = 6000;
    private static final int RANDOM_HATCH_OFFSET_TICKS = 150;
    private static final VoxelShape SHAPE;

    public GreaterDodoEgg(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(HATCH, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{HATCH});
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public int getHatchLevel(BlockState pState) {
        return (Integer)pState.getValue(HATCH);
    }

    private boolean isReadyToHatch(BlockState pState) {
        return this.getHatchLevel(pState) == 2;
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!this.isReadyToHatch(pState)) {
            pLevel.playSound((Player)null, pPos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + pRandom.nextFloat() * 0.2F);
            pLevel.setBlock(pPos, (BlockState)pState.setValue(HATCH, this.getHatchLevel(pState) + 1), 2);
        } else {
            pLevel.playSound((Player)null, pPos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + pRandom.nextFloat() * 0.2F);
            pLevel.destroyBlock(pPos, false);
            GreaterDodoEntity $$4 = (GreaterDodoEntity) ModEntities.GREATERDODO.get().create(pLevel);
            if ($$4 != null) {
                Vec3 $$5 = pPos.getCenter();
                $$4.setBaby(true);
                $$4.moveTo($$5.x(), $$5.y(), $$5.z(), Mth.wrapDegrees(pLevel.random.nextFloat() * 360.0F), 0.0F);
                pLevel.addFreshEntity($$4);
            }
        }
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        boolean $$5 = hatchBoost(pLevel, pPos);
        if (!pLevel.isClientSide() && $$5) {
            pLevel.levelEvent(3009, pPos, 0);
        }

        int $$6 = $$5 ? 6000 : 12000;
        int $$7 = $$6 / 3;
        pLevel.gameEvent(GameEvent.BLOCK_PLACE, pPos, Context.of(pState));
        pLevel.scheduleTick(pPos, this, $$7 + pLevel.random.nextInt(300));
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    public static boolean hatchBoost(BlockGetter pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).is(ModTags.Blocks.GREATER_DODO_EGG_HATCH_BOOST);
    }

    static {
        HATCH = BlockStateProperties.HATCH;
        SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 14.0, 12.0);
    }
}
