package net.silverfishstone.silversnifferupgrade.enchantments.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.material.Fluids;

public class OxygenPlusEnchantment extends Enchantment {
    public OxygenPlusEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level().isClientSide()) {
            if(pLevel == 1) {
                if (pTarget.isInFluidType(Fluids.WATER.defaultFluidState())) {
                    pTarget.hurt(pAttacker.damageSources().drown(), 2);
                }
            }
            if(pLevel == 2) {
                if (pTarget.isInFluidType(Fluids.WATER.defaultFluidState())) {
                    pTarget.hurt(pAttacker.damageSources().drown(), 3);
                }
            }
            if(pLevel == 3) {
                if (pTarget.isInFluidType(Fluids.WATER.defaultFluidState())) {
                    pTarget.hurt(pAttacker.damageSources().drown(), 4);
                }
            }
            if(pLevel == 4) {
                if (pTarget.isInFluidType(Fluids.WATER.defaultFluidState())) {
                    pTarget.hurt(pAttacker.damageSources().drown(), 5);
                }
            }
            if(pLevel == 5) {
                if (pTarget.isInFluidType(Fluids.WATER.defaultFluidState())) {
                    pTarget.hurt(pAttacker.damageSources().drown(), 6);
                }
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 * pEnchantmentLevel;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 35;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    public int getMaxLevel() {
        return 5;
    }
}
