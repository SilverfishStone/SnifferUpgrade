package net.silverfishstone.silversnifferupgrade.item.armor;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.item.ModItems;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum SilversArmorMaterials implements ArmorMaterial {
    ARTHROPOD("arthropod", 40, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266652_) -> {
        p_266652_.put(ArmorItem.Type.BOOTS, 2);
        p_266652_.put(ArmorItem.Type.LEGGINGS, 4);
        p_266652_.put(ArmorItem.Type.CHESTPLATE, 6);
        p_266652_.put(ArmorItem.Type.HELMET, 8);
    }), 10, SoundEvents.ARMOR_EQUIP_TURTLE, 2.5F, 0.1F, () -> {
        return Ingredient.of(ModItems.ARTHROPOD_ARMOR.get());
    }),

    SEGMENT("segment", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266652_) -> {
        p_266652_.put(ArmorItem.Type.HELMET, 4);
    }), 10, SoundEvents.ARMOR_EQUIP_TURTLE, 1F, 0.07F, () -> {
        return Ingredient.of(ModItems.CHITIN_SEGMENT.get());
    });

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    SilversArmorMaterials(String pName, int pDurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public String getName() {
        return SnifferUpgrade.MODID + ":" + this.name;
    }
}

