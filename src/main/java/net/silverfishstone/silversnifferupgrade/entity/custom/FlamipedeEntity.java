package net.silverfishstone.silversnifferupgrade.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.silverfishstone.silversnifferupgrade.entity.ai.FlamipedeAttackGoal;

public class FlamipedeEntity extends PathfinderMob {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(FlamipedeEntity.class, EntityDataSerializers.BOOLEAN);
    public FlamipedeEntity(EntityType<? extends FlamipedeEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new FlamipedeAttackGoal(this, 1.0F, false));
        super.registerGoals();
    }
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public void tick() {
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
        super.tick();
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(50) + 50;
            this.idleAnimationState.start(this.tickCount);
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
    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1F);
        }else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2F);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.WITHER_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SPIDER_STEP;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 1F;
    }

    public boolean doHurtTarget(Entity pEntity) {
        if (!super.doHurtTarget(pEntity)) {
            return false;
        } else {
            if (pEntity instanceof LivingEntity) {
                ((LivingEntity)pEntity).setSecondsOnFire(3);
            }

            return true;
        }
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public static boolean checkSpawnRules(EntityType<? extends PathfinderMob> pMob, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return isBrightEnoughToSpawn(pLevel, pPos);
    }
    protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) > 4;
    }
}
