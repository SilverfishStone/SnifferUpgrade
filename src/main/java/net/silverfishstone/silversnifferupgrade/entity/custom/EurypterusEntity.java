package net.silverfishstone.silversnifferupgrade.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.ai.EurypterusAttackGoal;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class EurypterusEntity extends Animal {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(EurypterusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.TROPICAL_FISH, Items.COD, Items.SALMON);

    public EurypterusEntity(EntityType<? extends EurypterusEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new SmoothSwimmingMoveControl(this, 65, 10, 0.04F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
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

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20) + 110;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 30; // Length in ticks of your animation
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }
    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(8, new EurypterusSwimGoal(this));
        this.goalSelector.addGoal(5, new BreedGoal(this, 1.3D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.3D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(9, new EurypterusAttackGoal(this, 1D, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return this.isBaby() ? pSize.height * 0.2F : pSize.height * 0.4F;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 1D)
                .add(Attributes.ATTACK_DAMAGE, 10D);
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

    protected boolean canRandomSwim() {
        return true;
    }


    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
    }

    @Nullable
    public EurypterusEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.EURYPTERUS.get().create(pLevel);
    }
    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }

    static class EurypterusSwimGoal extends RandomSwimmingGoal {
        private final EurypterusEntity eurypterus;

        public EurypterusSwimGoal(EurypterusEntity pFish) {
            super(pFish, 1.0D, 40);
            this.eurypterus = pFish;
        }

        public boolean canUse() {
            return this.eurypterus.canRandomSwim() && super.canUse();
        }
    }
    static class EurypterusControl extends MoveControl {
        private final EurypterusEntity nautilus;

        EurypterusControl(EurypterusEntity pFish) {
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
                double d2 = this.wantedZ - this.nautilus.getZ();
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
 }
