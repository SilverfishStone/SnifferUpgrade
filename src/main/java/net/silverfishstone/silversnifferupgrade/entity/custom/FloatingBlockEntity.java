package net.silverfishstone.silversnifferupgrade.entity.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.block.custom.FloatingBlock;
import net.silverfishstone.silversnifferupgrade.block.properties.Floatable;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nullable;


public class FloatingBlockEntity extends Entity {
    private BlockState blockState = ModBlocks.PUMICE.get().defaultBlockState();
    private boolean cancelDrop;
    private static final Logger LOGGER = LogUtils.getLogger();
    public int time;
    public boolean dropItem = true;
    private boolean hurtEntities;
    private int fallDamageMax = 40;
    private float fallDamagePerDistance;
    @Nullable
    public CompoundTag blockData;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_POS);


    public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private FloatingBlockEntity(Level pLevel, double pX, double pY, double pZ, BlockState pState) {
        this(ModEntities.FLOATING_BLOCK.get(), pLevel);
        this.blockState = pState;
        this.blocksBuilding = true;
        this.setPos(pX, pY, pZ);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
        this.setStartPos(this.blockPosition());
    }

    public static FloatingBlockEntity setFloat(Level pLevel, BlockPos pPos, BlockState pBlockState) {
        FloatingBlockEntity floatingBlockEntity = new FloatingBlockEntity(pLevel, (double) pPos.getX() + 0.5D, (double) pPos.getY(), (double) pPos.getZ() + 0.5D, pBlockState.hasProperty(BlockStateProperties.WATERLOGGED) ? pBlockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)) : pBlockState);
        pLevel.setBlock(pPos, pBlockState.getFluidState().createLegacyBlock(), 3);
        pLevel.addFreshEntity(floatingBlockEntity);
        return floatingBlockEntity;
    }

    public void disableDrop() {
        this.cancelDrop = true;
    }

    public @NotNull BlockState getBlockState() {
        return this.blockState;
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        BlockState blockstate = AnvilBlock.damage(this.blockState);
        if (blockstate == null) {
            this.cancelDrop = true;
        } else {
            this.blockState = blockstate;
        }
        return false;
    }

    public boolean isAttackable() {
        return false;
    }

    public void setStartPos(BlockPos pStartPos) {
        this.entityData.set(DATA_START_POS, pStartPos);
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }

    protected void defineSynchedData() {
        this.entityData.define(DATA_START_POS, BlockPos.ZERO);
    }

    /**
     * Returns {@code true} if other Entities should be prevented from moving through this Entity.
     */
    public boolean isPickable() {
        return !this.isRemoved();
    }


    public void tick() {
        if (this.blockState.isAir()) {
            this.discard();
        } else {
            Block block = this.blockState.getBlock();
            ++this.time;
            if (!this.isNoGravity()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.04D, 0.0D));
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
            if (!this.level().isClientSide) {
                BlockPos blockpos = this.blockPosition();
                BlockState blockstateE = this.level().getBlockState(blockpos.above(1));
                if (blockstateE.is(Blocks.WATER)) {
                    if (!this.level().isClientSide && (this.time > 100 && (blockpos.getY() <= this.level().getMinBuildHeight() || blockpos.getY() > this.level().getMaxBuildHeight()) || this.time > 600)) {
                        if (this.dropItem && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            this.spawnAtLocation(block);
                        }

                        this.discard();
                    }
                } else {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
                    if (!blockstate.is(Blocks.MOVING_PISTON)) {
                        if (!this.cancelDrop) {
                            boolean flag3 = FloatingBlock.isFloating(this.level().getBlockState(blockpos.above()));
                            boolean flag4 = this.blockState.canSurvive(this.level(), blockpos) && !flag3;
                            if (flag4) {
                                if (this.blockState.hasProperty(BlockStateProperties.WATERLOGGED) && this.level().getFluidState(blockpos).getType() == Fluids.WATER) {
                                    this.blockState = this.blockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true));
                                }

                                if (this.level().setBlock(blockpos, this.blockState, 3)) {
                                    ((ServerLevel)this.level()).getChunkSource().chunkMap.broadcast(this, new ClientboundBlockUpdatePacket(blockpos, this.level().getBlockState(blockpos)));
                                    this.discard();
                                    if (block instanceof Floatable) {
                                        ((Floatable)block).inWater(this.level(), blockpos, this.blockState, blockstate, this);
                                    }

                                    if (this.blockData != null && this.blockState.hasBlockEntity()) {
                                        BlockEntity blockentity = this.level().getBlockEntity(blockpos);
                                        if (blockentity != null) {
                                            CompoundTag compoundtag = blockentity.saveWithoutMetadata();

                                            for(String s : this.blockData.getAllKeys()) {
                                                compoundtag.put(s, this.blockData.get(s).copy());
                                            }

                                            try {
                                                blockentity.load(compoundtag);
                                            } catch (Exception exception) {
                                                LOGGER.error("Failed to load block entity from floating block", (Throwable)exception);
                                            }

                                            blockentity.setChanged();
                                        }
                                    }
                                } else if (this.dropItem && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                                    this.discard();
                                    this.callOnBrokenAfterFloat(block, blockpos);
                                    this.spawnAtLocation(block);
                                }
                            } else {
                                this.discard();
                                if (this.dropItem && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                                    this.callOnBrokenAfterFloat(block, blockpos);
                                    this.spawnAtLocation(block);
                                }
                            }
                        } else {
                            this.discard();
                            this.callOnBrokenAfterFloat(block, blockpos);
                        }
                    }
                }
            }

            this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
        }
    }
    public void callOnBrokenAfterFloat(Block pBlock, BlockPos pPos) {
        if (pBlock instanceof Floatable) {
            ((Floatable)pBlock).onBrokenAfterFloat(this.level(), pPos, this);
        }

    }
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.put("BlockState", NbtUtils.writeBlockState(this.blockState));
        pCompound.putInt("Time", this.time);
        pCompound.putBoolean("DropItem", this.dropItem);
        pCompound.putBoolean("HurtEntities", this.hurtEntities);
        pCompound.putFloat("FallHurtAmount", this.fallDamagePerDistance);
        pCompound.putInt("FallHurtMax", this.fallDamageMax);
        if (this.blockData != null) {
            pCompound.put("TileEntityData", this.blockData);
        }

        pCompound.putBoolean("CancelDrop", this.cancelDrop);
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        this.blockState = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), pCompound.getCompound("BlockState"));
        this.time = pCompound.getInt("Time");

        if (pCompound.contains("DropItem", 99)) {
            this.dropItem = pCompound.getBoolean("DropItem");
        }

        if (pCompound.contains("TileEntityData", 10)) {
            this.blockData = pCompound.getCompound("TileEntityData");
        }

        this.cancelDrop = pCompound.getBoolean("CancelDrop");
        if (this.blockState.is(Blocks.WATER)) {
            this.blockState = ModBlocks.PUMICE.get().defaultBlockState();
        }

    }
}


