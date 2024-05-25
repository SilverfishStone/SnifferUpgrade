package net.silverfishstone.silversnifferupgrade.entity.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.FrogAi;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.ai.AmphibimusAttackGoal;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.util.ModTags;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class AmphibimusEntity extends Animal {
    protected RandomStrollGoal randomStrollGoal;
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(AmphibimusEntity.class, EntityDataSerializers.BOOLEAN);
    public static final Ingredient TEMPTATION_ITEM = Ingredient.of(Items.TROPICAL_FISH);


    public AmphibimusEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new AmphibimusEntity.AmphibiousControl(this);
    }

    static class AmphibiousControl extends MoveControl {
        private final AmphibimusEntity amphibimus;

        AmphibiousControl(AmphibimusEntity pTurtle) {
            super(pTurtle);
            this.amphibimus = pTurtle;
        }

        private void updateSpeed() {
            if (this.amphibimus.isInWater()) {
                this.amphibimus.setDeltaMovement(this.amphibimus.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            } else if (this.amphibimus.onGround()) {
                this.amphibimus.setSpeed(Math.max(this.amphibimus.getSpeed() + 0.04f, 0.2F));
            }
        }

        public void tick() {
            if (amphibimus.onGround()) {
                this.updateSpeed();
                if (this.operation == MoveControl.Operation.MOVE_TO && !this.amphibimus.getNavigation().isDone()) {
                    double d0 = this.wantedX - this.amphibimus.getX();
                    double d1 = this.wantedY - this.amphibimus.getY();
                    double d2 = this.wantedZ - this.amphibimus.getZ();
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    if (d3 < (double) 1.0E-5F) {
                        this.mob.setSpeed(0.0F);
                    } else {
                        d1 /= d3;
                        float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                        this.amphibimus.setYRot(this.rotlerp(this.amphibimus.getYRot(), f, 90.0F));
                        this.amphibimus.yBodyRot = this.amphibimus.getYRot();
                        float f1 = (float) (this.speedModifier * this.amphibimus.getAttributeValue(Attributes.MOVEMENT_SPEED));
                        this.amphibimus.setSpeed(Mth.lerp(0.125F, this.amphibimus.getSpeed(), f1));
                        this.amphibimus.setDeltaMovement(this.amphibimus.getDeltaMovement().add(0.0D, (double) this.amphibimus.getSpeed() * d1 * 0.1D, 0.0D));
                    }
                } else {
                    this.amphibimus.setSpeed(0.0F);
                }
            } else {
                if (this.operation == Operation.MOVE_TO && !this.amphibimus.getNavigation().isDone()) {
                    Vec3 vec3 = new Vec3(this.wantedX - this.amphibimus.getX(), this.wantedY - this.amphibimus.getY(), this.wantedZ - this.amphibimus.getZ());
                    double d0 = vec3.length();
                    double d1 = vec3.x / d0;
                    double d2 = vec3.y / d0;
                    double d3 = vec3.z / d0;
                    float f = (float)(Mth.atan2(vec3.z, vec3.x) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.amphibimus.setYRot(this.rotlerp(this.amphibimus.getYRot(), f, 90.0F));
                    this.amphibimus.yBodyRot = this.amphibimus.getYRot();
                    float f1 = (float)(this.speedModifier * this.amphibimus.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    float f2 = Mth.lerp(0.125F, this.amphibimus.getSpeed(), f1);
                    this.amphibimus.setSpeed(f2);
                    double d4 = Math.sin((double)(this.amphibimus.tickCount + this.amphibimus.getId()) * 0.5D) * 0.05D;
                    double d5 = Math.cos((double)(this.amphibimus.getYRot() * ((float)Math.PI / 180F)));
                    double d6 = Math.sin((double)(this.amphibimus.getYRot() * ((float)Math.PI / 180F)));
                    double d7 = Math.sin((double)(this.amphibimus.tickCount + this.amphibimus.getId()) * 0.75D) * 0.05D;
                    this.amphibimus.setDeltaMovement(this.amphibimus.getDeltaMovement().add(d4 * d5, d7 * (d6 + d5) * 0.25D + (double)f2 * d2 * 0.1D, d4 * d6));
                    LookControl lookcontrol = this.amphibimus.getLookControl();
                    double d8 = this.amphibimus.getX() + d1 * 2.0D;
                    double d9 = this.amphibimus.getEyeY() + d2 / d0;
                    double d10 = this.amphibimus.getZ() + d3 * 2.0D;
                    double d11 = lookcontrol.getWantedX();
                    double d12 = lookcontrol.getWantedY();
                    double d13 = lookcontrol.getWantedZ();
                    if (!lookcontrol.isLookingAtTarget()) {
                        d11 = d8;
                        d12 = d9;
                        d13 = d10;
                    }

                    this.amphibimus.getLookControl().setLookAt(Mth.lerp(0.125D, d11, d8), Mth.lerp(0.125D, d12, d9), Mth.lerp(0.125D, d13, d10), 10.0F, 40.0F);
                } else {
                    this.amphibimus.setSpeed(0.0F);
                }
            }
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

    public int getHeadRotSpeed() {
        return 35;
    }

    public int getMaxHeadYRot() {
        return 5;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }
    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        if (this.level().isClientSide()) {
            this.swimIdleAnimationState.animateWhen(this.isInWaterOrBubble() && !this.walkAnimation.isMoving(), this.tickCount);
            setupAnimationStates();
        }
        super.tick();
    }

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public final AnimationState swimIdleAnimationState = new AnimationState();
    public final AnimationState crawlAnimationState = new AnimationState();

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

    @Nullable
    public AmphibimusEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.AMPHIBIMUS.get().create(pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.05D)
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }
    protected void registerGoals() {
        this.randomStrollGoal = new RandomStrollGoal(this, 0.3D, 80);
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, this.randomStrollGoal);
        this.randomStrollGoal.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.goalSelector.addGoal(8, new FollowParentGoal(this, 0.2D));
        this.goalSelector.addGoal(9, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(8, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));
        this.goalSelector.addGoal(10, new AmphibimusAttackGoal(this, 0.3D, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, NautilusEntity.class, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

    }

    @Override
    public boolean onGround() {
        return super.onGround();
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.FROG_AMBIENT;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.FROG_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.FROG_DEATH;
    }

    protected void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.FROG_STEP, 0.15F, 1.0F);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(1F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.3D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(pTravelVector);
        }
    }

    public boolean isFood(ItemStack pStack) {
        return TEMPTATION_ITEM.test(pStack);
    }

    public static boolean checkSalamanderSpawnRules(EntityType<? extends Animal> salamander, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getBlockState(pPos.below()).is(BlockTags.MINEABLE_WITH_SHOVEL) && isBrightEnoughToSpawn(pLevel, pPos);
    }
}