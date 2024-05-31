package net.silverfishstone.silversnifferupgrade.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class PoisonFang extends SwordItem {
    MobEffectInstance effect;
    public PoisonFang(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, MobEffectInstance effects) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.effect = effects;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(effect);
        return true;
    }
}
