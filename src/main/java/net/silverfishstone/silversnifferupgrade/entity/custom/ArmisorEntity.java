package net.silverfishstone.silversnifferupgrade.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class ArmisorEntity extends Monster implements Enemy {
    protected static final int ATTACK_TIME = 80;
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(ArmisorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_ID_MOVING = SynchedEntityData.defineId(ArmisorEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_ATTACK_TARGET = SynchedEntityData.defineId(ArmisorEntity.class, EntityDataSerializers.INT);
    private float clientSideSwimAnimation;
    private float clientSideSwimAnimationSpeed;
    public int posPointer = -1;
    public final double[][] positions = new double[64][3];
    @Nullable
    private LivingEntity clientSideCachedAttackTarget;
    private int clientSideAttackTime;
    private boolean clientSideTouchedGround;
    @Nullable
    protected RandomStrollGoal randomStrollGoal;
    public float yRotA;


    public ArmisorEntity(EntityType<? extends ArmisorEntity> pEntityType, Level pLevel) {
        super(ModEntities.ARMISOR.get(), pLevel);
        this.xpReward = 10;
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new ArmisorMoveControl(this);
        this.clientSideSwimAnimation = this.random.nextFloat();
        this.setHealth(this.getMaxHealth());
    }
    float onHurt(DamageSource pDamageSource, float pAmount) {
        return 5;
    }


    protected void registerGoals() {
        this.randomStrollGoal = new RandomStrollGoal(this, 1.0D, 80);
        this.goalSelector.addGoal(4, new ArmisorAttackGoal(this, 2, true));
        this.goalSelector.addGoal(7, this.randomStrollGoal);
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.randomStrollGoal.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, NautilusEntity.class, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }
    static class ArmisorAttackGoal extends MeleeAttackGoal {
        private final ArmisorEntity armisor;

        public ArmisorAttackGoal(ArmisorEntity armisor, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            super(armisor, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
            this.armisor = armisor;
        }
        public boolean canUse() {
            return super.canUse() && this.armisor.okTarget(this.armisor.getTarget());
        }
        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.armisor.okTarget(this.armisor.getTarget());
        }
    }
    public boolean okTarget(@Nullable LivingEntity p_32396_) {
        if (p_32396_ != null) {
            return p_32396_.isInWater();
        } else {
            return false;
        }
    }
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public static final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public void tick() {
        if (this.level().isClientSide()) {
            this.swimIdleAnimationState.animateWhen(this.isInWaterOrBubble() && !this.walkAnimation.isMoving(), this.tickCount);
            setupAnimationStates();
        }
        super.tick();
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(50) + 50;
            idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20; // Length in ticks of your animation
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(DATA_ID_MOVING, false);
        this.entityData.define(DATA_ID_ATTACK_TARGET, 0);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MAX_HEALTH, 60.0D);
    }

    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean isMoving() {
        return this.entityData.get(DATA_ID_MOVING);
    }

    void setMoving(boolean pMoving) {
        this.entityData.set(DATA_ID_MOVING, pMoving);
    }

    public int getAttackDuration() {
        return 80;
    }

    public boolean hasActiveAttackTarget() {
        return this.entityData.get(DATA_ID_ATTACK_TARGET) != 0;
    }

    @Nullable
    public LivingEntity getActiveAttackTarget() {
        if (!this.hasActiveAttackTarget()) {
            return null;
        } else if (this.level().isClientSide) {
            if (this.clientSideCachedAttackTarget != null) {
                return this.clientSideCachedAttackTarget;
            } else {
                Entity entity = this.level().getEntity(this.entityData.get(DATA_ID_ATTACK_TARGET));
                if (entity instanceof LivingEntity) {
                    this.clientSideCachedAttackTarget = (LivingEntity) entity;
                    return this.clientSideCachedAttackTarget;
                } else {
                    return null;
                }
            }
        } else {
            return this.getTarget();
        }
    }



    protected MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.5F;
    }

    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        return pLevel.getFluidState(pPos).is(FluidTags.WATER) ? 10.0F + pLevel.getPathfindingCostFromLightLevels(pPos) : super.getWalkTargetValue(pPos, pLevel);
    }

    /**
     * Called every tick so the entity can update its state as required. For example, zombies and skeletons use this to
     * react to sunlight and start to burn.
     */
    @org.jetbrains.annotations.Nullable private Player unlimitedLastHurtByPlayer = null;
    public void aiStep() {
        if (this.lastHurtByPlayer != null) this.unlimitedLastHurtByPlayer = lastHurtByPlayer;
        if (this.unlimitedLastHurtByPlayer != null && this.unlimitedLastHurtByPlayer.isRemoved()) this.unlimitedLastHurtByPlayer = null;
        if (this.isDeadOrDying()) {
            swimIdleAnimationState.start(tickCount);
        } else {
            if (this.isNoAi()) {
               swimIdleAnimationState.start(tickCount);
            } else {
                if (this.level().isClientSide) {
                    if (!this.isInWater()) {
                        this.clientSideSwimAnimationSpeed = 2.0F;
                        Vec3 vec3 = this.getDeltaMovement();
                        if (vec3.y > 0.0D && this.clientSideTouchedGround && !this.isSilent()) {
                            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getFlopSound(), this.getSoundSource(), 1.0F, 1.0F, false);
                        }
                        this.clientSideTouchedGround = vec3.y < 0.0D && this.level().loadedAndEntityCanStandOn(this.blockPosition().below(), this);
                    } else if (this.isMoving()) {
                        swimIdleAnimationState.start(tickCount);
                    } else {
                        this.clientSideSwimAnimationSpeed += (0.125F - this.clientSideSwimAnimationSpeed) * 0.2F;
                    }

                    this.clientSideSwimAnimation += this.clientSideSwimAnimationSpeed;

                    if (this.isMoving() && this.isInWater()) {
                        Vec3 vec31 = this.getViewVector(0.0F);

                        for (int i = 0; i < 2; ++i) {
                            this.level().addParticle(ParticleTypes.BUBBLE, this.getRandomX(0.5D) - vec31.x * 1.5D, this.getRandomY() - vec31.y * 1.5D, this.getRandomZ(0.5D) - vec31.z * 1.5D, 0.0D, 0.0D, 0.0D);
                        }
                    }

                    if (this.hasActiveAttackTarget()) {
                        if (this.clientSideAttackTime < this.getAttackDuration()) {
                            ++this.clientSideAttackTime;

                        }
                        LivingEntity livingentity = this.getActiveAttackTarget();
                        if (livingentity != null) {
                            this.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
                            this.getLookControl().tick();
                            double d5 = (double) this.getAttackAnimationScale(0.0F);
                            double d0 = livingentity.getX() - this.getX();
                            double d1 = livingentity.getY(0.5D) - this.getEyeY();
                            double d2 = livingentity.getZ() - this.getZ();
                            double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                            d0 /= d3;
                            d1 /= d3;
                            d2 /= d3;
                            double d4 = this.random.nextDouble();

                            while (d4 < d3) {
                                d4 += 1.8D - d5 + this.random.nextDouble() * (1.7D - d5);
                                this.level().addParticle(ParticleTypes.BUBBLE, this.getX() + d0 * d4, this.getEyeY() + d1 * d4, this.getZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
                            }
                        }
                    }
                }
                if (this.isInWaterOrBubble()) {
                    this.setAirSupply(300);
                } else if (this.onGround()) {
                    this.setDeltaMovement(this.getDeltaMovement().add((double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D, (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F)));
                    this.setYRot(this.random.nextFloat() * 360.0F);
                    this.setOnGround(false);
                    this.hasImpulse = true;
                }

                if (this.hasActiveAttackTarget()) {
                    this.setYRot(this.yHeadRot);
                }
            }
        }

        super.aiStep();
    }
    protected SoundEvent getFlopSound() {
        return SoundEvents.GUARDIAN_FLOP;
    }

    public final AnimationState swimIdleAnimationState = new AnimationState();
    public float getSwimAnimation(float pPartialTick) {
        return Mth.lerp(pPartialTick, this.swimIdleAnimationState.getAccumulatedTime(), this.swimIdleAnimationState.getAccumulatedTime());
    }


    public float getAttackAnimationScale(float pPartialTick) {
        return ((float) this.clientSideAttackTime + pPartialTick) / (float) this.getAttackDuration();
    }

    public boolean checkSpawnObstruction(LevelReader pLevel) {
        return pLevel.isUnobstructed(this);
    }

    public int getMaxHeadXRot() {
        return 5;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(0.1F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (!this.isMoving() && this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(pTravelVector);
        }

    }

    static class ArmisorMoveControl extends MoveControl {
        private final ArmisorEntity armisor;

        public ArmisorMoveControl(ArmisorEntity armisor) {
            super(armisor);
            this.armisor = armisor;
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO && !this.armisor.getNavigation().isDone()) {
                Vec3 vec3 = new Vec3(this.wantedX - this.armisor.getX(), this.wantedY - this.armisor.getY(), this.wantedZ - this.armisor.getZ());
                double d0 = vec3.length();
                double d1 = vec3.x / d0;
                double d2 = vec3.y / d0;
                double d3 = vec3.z / d0;
                float f = (float)(Mth.atan2(vec3.z, vec3.x) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.armisor.setYRot(this.rotlerp(this.armisor.getYRot(), f, 90.0F));
                this.armisor.yBodyRot = this.armisor.getYRot();
                float f1 = (float)(this.speedModifier * this.armisor.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = Mth.lerp(0.125F, this.armisor.getSpeed(), f1);
                this.armisor.setSpeed(f2);
                double d4 = Math.sin((double)(this.armisor.tickCount + this.armisor.getId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.armisor.getYRot() * ((float)Math.PI / 180F)));
                double d6 = Math.sin((double)(this.armisor.getYRot() * ((float)Math.PI / 180F)));
                double d7 = Math.sin((double)(this.armisor.tickCount + this.armisor.getId()) * 0.75D) * 0.05D;
                this.armisor.setDeltaMovement(this.armisor.getDeltaMovement().add(d4 * d5, d7 * (d6 + d5) * 0.25D + (double)f2 * d2 * 0.1D, d4 * d6));
                LookControl lookcontrol = this.armisor.getLookControl();
                double d8 = this.armisor.getX() + d1 * 2.0D;
                double d9 = this.armisor.getEyeY() + d2 / d0;
                double d10 = this.armisor.getZ() + d3 * 2.0D;
                double d11 = lookcontrol.getWantedX();
                double d12 = lookcontrol.getWantedY();
                double d13 = lookcontrol.getWantedZ();
                if (!lookcontrol.isLookingAtTarget()) {
                    d11 = d8;
                    d12 = d9;
                    d13 = d10;
                }

                this.armisor.getLookControl().setLookAt(Mth.lerp(0.125D, d11, d8), Mth.lerp(0.125D, d12, d9), Mth.lerp(0.125D, d13, d10), 10.0F, 40.0F);
                this.armisor.setMoving(true);
            } else {
                this.armisor.setSpeed(0.0F);
                this.armisor.setMoving(false);
                idleAnimationState.stop();
            }
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (DATA_ID_ATTACK_TARGET.equals(pKey)) {
            this.clientSideAttackTime = 0;
            this.clientSideCachedAttackTarget = null;
        }

    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getAmbientSoundInterval() {
        return 160;
    }

    protected SoundEvent getAmbientSound() {
        return this.isInWaterOrBubble() ? SoundEvents.GUARDIAN_AMBIENT : SoundEvents.GUARDIAN_AMBIENT_LAND;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.isInWaterOrBubble() ? SoundEvents.GUARDIAN_HURT : SoundEvents.GUARDIAN_HURT_LAND;
    }

    protected SoundEvent getDeathSound() {
        return this.isInWaterOrBubble() ? SoundEvents.GUARDIAN_DEATH : SoundEvents.GUARDIAN_DEATH_LAND;
    }
}
