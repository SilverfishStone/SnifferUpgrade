package net.silverfishstone.silversnifferupgrade.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class NautilusEntity extends Animal implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(NautilusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.TROPICAL_FISH, Items.COD, Items.SALMON);

    public NautilusEntity(EntityType<? extends NautilusEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new NautilusEntity.NautilusControl(this);
    }
    public boolean canBreatheUnderwater() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean checkSpawnObstruction(LevelReader pLevel) {
        return pLevel.isUnobstructed(this);
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getAmbientSoundInterval() {
        return 120;
    }

    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    protected void handleAirSupply(int pAirSupply) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(pAirSupply - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(this.damageSources().drown(), 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }

    }

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(pTravelVector);
        }
    }
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(SoundEvents.SQUID_AMBIENT);
        }

        super.aiStep();
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(50) + 50;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 2D));
        this.goalSelector.addGoal(3, new NautilusEntity.NautilusSwimGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.3D));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.3D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return this.isBaby() ? pSize.height * 0.2F : pSize.height * 0.4F;
    }
    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 1D);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SQUID_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        return Bucketable.bucketMobPickup(pPlayer, pHand, this).orElse(super.mobInteract(pPlayer, pHand));
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean pFromBucket) {
        this.entityData.set(FROM_BUCKET, pFromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack pStack) {
        Bucketable.saveDefaultDataToBucketTag(this, pStack);
    }

    @Override
    public void loadFromBucketTag(CompoundTag pTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, pTag);
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("FromBucket", this.fromBucket());
    }
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setFromBucket(pCompound.getBoolean("FromBucket"));
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.NAUTILUS_BUCKET.get());
    }

    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }

    protected boolean canRandomSwim() {
        return true;
    }


    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
    }

    @Nullable
    public NautilusEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.NAUTILUS.get().create(pLevel);
    }
    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }

    static class NautilusSwimGoal extends RandomSwimmingGoal {
        private final NautilusEntity nautilus;

        public NautilusSwimGoal(NautilusEntity pFish) {
            super(pFish, 1.0D, 40);
            this.nautilus = pFish;
        }
        public boolean canUse() {
            return this.nautilus.canRandomSwim() && super.canUse();
        }
    }
    static class NautilusControl extends MoveControl {
        private final NautilusEntity nautilus;

        NautilusControl(NautilusEntity pFish) {
            super(pFish);
            this.nautilus = pFish;
        }

        public void tick() {
            if (this.nautilus.isEyeInFluid(FluidTags.WATER)) {
                this.nautilus.setDeltaMovement(this.nautilus.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.nautilus.getNavigation().isDone()) {
                float f = (float)(this.speedModifier * this.nautilus.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.nautilus.setSpeed(Mth.lerp(0.125F, this.nautilus.getSpeed(), f));
                double d0 = this.wantedX - this.nautilus.getX();
                double d1 = this.wantedY - this.nautilus.getY();
                double d2 = this.wantedZ - this.nautilus.getZ();
                if (d1 != 0.0D) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.nautilus.setDeltaMovement(this.nautilus.getDeltaMovement().add(0.0D, (double)this.nautilus.getSpeed() * (d1 / d3) * 0.2D, 0.0D));
                }

                if (d0 != 0.0D || d2 != 0.0D) {
                    float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.nautilus.setYRot(this.rotlerp(this.nautilus.getYRot(), f1, 90.0F));
                    this.nautilus.yBodyRot = this.nautilus.getYRot();
                }

            } else {
                this.nautilus.setSpeed(0.3F);
            }
        }
    }
    public static boolean canNautilusSpawn(EntityType<? extends Mob> nautilus, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j && pPos.getY() <= i && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }
    public static boolean canConeshellSpawn(EntityType<? extends Mob> coneshell, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j && pPos.getY() <= i && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }
    public static boolean canEurypterusSpawn(EntityType<? extends Mob> eurypterus, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j && pPos.getY() <= i && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }
 }
