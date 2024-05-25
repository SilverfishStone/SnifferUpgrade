package net.silverfishstone.silversnifferupgrade.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.sounds.SnifferSounds;
import net.silverfishstone.silversnifferupgrade.worldgen.dimension.ModDimensions;
import net.silverfishstone.silversnifferupgrade.worldgen.portal.AncientTeleporter;

import java.util.function.Predicate;

public class SnifferPedestalBlock extends Block {
    public static final BooleanProperty ACTIVE = BlockStateProperties.LIT;
    public SnifferPedestalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVE, Boolean.valueOf(false)));
    }
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockPos blockpos = pPos.immutable();
        if (pPlayer.isHolding(Item.byId(Item.getId(Items.SNIFFER_EGG)))) {
            if (pLevel.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState blockstate = pState.cycle(ACTIVE);
                pLevel.setBlock(pPos, blockstate, 4);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
                pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SnifferSounds.SNIFFER_PEDESTAL_ACTIVATE.get(), SoundSource.NEUTRAL, 0.2F, 0.3F);
                pPlayer.getItemInHand(pHand).shrink(1);
                return InteractionResult.CONSUME;
            }
        } else {
            if (pState.getValue(ACTIVE)) {
                if (pPlayer.canChangeDimensions()) {
                    handleAncientPortal(pPlayer, pPos);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.CONSUME;
                }
            }else {
                return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
            }
        }
    }
    private void handleAncientPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.ANCIENT_FIELDS_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.ANCIENT_FIELDS_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);

            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.ANCIENT_FIELDS_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new AncientTeleporter(pPos, true));

                } else {
                    player.changeDimension(portalDimension, new AncientTeleporter(pPos, false));
                }
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ACTIVE);
    }
}
