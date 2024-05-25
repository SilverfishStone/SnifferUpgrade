package net.silverfishstone.silversnifferupgrade.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeMod;
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

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND || pEquipmentSlot == EquipmentSlot.OFFHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }
}
