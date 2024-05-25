package net.silverfishstone.silversnifferupgrade.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeMod;
import net.silverfishstone.silversnifferupgrade.damage.SnifferDamageSources;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;

public class OxygenatedEffect extends MobEffect {
    public OxygenatedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == ModMobEffects.OXYGENATED.get()) {
            pLivingEntity.setAirSupply(100);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
