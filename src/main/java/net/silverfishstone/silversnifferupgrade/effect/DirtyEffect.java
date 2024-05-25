package net.silverfishstone.silversnifferupgrade.effect;

import net.minecraft.client.gui.Gui;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidType;
import net.silverfishstone.silversnifferupgrade.damage.SnifferDamageSources;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;
import net.silverfishstone.silversnifferupgrade.sounds.SnifferSounds;

public class DirtyEffect extends MobEffect {
    public DirtyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        DamageSource choke =
                new SnifferDamageSources(pLivingEntity.level().registryAccess()).choke();
            pLivingEntity.hurt(choke, 0.01f);
            pLivingEntity.sinkInFluid(Fluids.WATER.getFluidType());
            pLivingEntity.setSwimming(false);
            pLivingEntity.setSprinting(false);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
