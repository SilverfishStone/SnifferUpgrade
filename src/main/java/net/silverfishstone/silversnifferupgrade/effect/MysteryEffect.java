package net.silverfishstone.silversnifferupgrade.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

public class MysteryEffect extends MobEffect {
    public MysteryEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == ModMobEffects.MYSTERY.get()) {
            pLivingEntity.turn(0.001F, 0.7F);
            pLivingEntity.setHealth(10);
        }

    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
