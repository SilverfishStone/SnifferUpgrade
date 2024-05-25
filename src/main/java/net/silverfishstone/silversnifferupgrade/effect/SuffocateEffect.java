package net.silverfishstone.silversnifferupgrade.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.silverfishstone.silversnifferupgrade.damage.SnifferDamageSources;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

public class SuffocateEffect extends MobEffect {
    public SuffocateEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        DamageSource suffocate =
                new SnifferDamageSources(pLivingEntity.level().registryAccess()).suffocate();
        if (this == ModMobEffects.OXYGENATED.get()) {
        } else if (this == ModMobEffects.SUFFOCATING.get()) {
            pLivingEntity.hurt(suffocate, 1.5F);
        }

    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
