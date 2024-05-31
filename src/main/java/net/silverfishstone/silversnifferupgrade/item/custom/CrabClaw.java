package net.silverfishstone.silversnifferupgrade.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.silverfishstone.silversnifferupgrade.item.ModItems;

import java.util.UUID;

public class CrabClaw extends SwordItem {
    protected static final UUID BASE_ATTACK_REACH_DAMAGE_UUID = UUID.fromString("CB7F77D3-777C-4F78-A497-9C13A33DB5CF");
    protected static final UUID BASE_MINE_REACH_DAMAGE_UUID = UUID.fromString("FA777E7C-7777-7777-B01B-BCCE9785ACA3");
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final float attackreach;
    private final float minereach;

    public CrabClaw(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, float pAttackReach, float pMineReach, Item.Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.attackreach = (float)pAttackReach;
        this.minereach = (float)pMineReach;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BASE_ATTACK_REACH_DAMAGE_UUID, "Weapon modifier", (double)this.attackreach, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(BASE_MINE_REACH_DAMAGE_UUID, "Weapon modifier", (double)this.minereach, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }


    public float getAttackReach() {
        return this.attackreach;
    }

    public float getMineReach() {
        return this.minereach;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return (pToRepair.is(ModItems.TROPICAL_CRAB_CLAW.get()) ? pRepair.is(ModItems.TROPICAL_CRAB_CLAW.get()) : pRepair.is(ModItems.ROASTED_TROPICAL_CRAB_CLAW.get()));
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND || pEquipmentSlot == EquipmentSlot.OFFHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }


    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return pState.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(2, pEntityLiving, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(Blocks.COBWEB);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
            return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}
