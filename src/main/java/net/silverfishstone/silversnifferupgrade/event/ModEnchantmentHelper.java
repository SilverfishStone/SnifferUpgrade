package net.silverfishstone.silversnifferupgrade.event;

import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.enchantments.SnifferEnchantments;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.item.armor.SilversHelmetItem;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Mod.EventBusSubscriber
public class ModEnchantmentHelper {
    private static final UUID SPEED_MODIFIER_MER_UUID = UUID.fromString("191A7B0D-DA3E-7C7C-7777-77EA7777778D");

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        mermaidEnchant(event, event.getEntity(), event.getEntity());
        ChitinHelmetTick(event.getEntity());
    }

    private static void mermaidEnchant(@Nullable Event event, Entity entity, LivingEntity lEntity) {
        if (entity == null)
            return;
        if (EnchantmentHelper.getItemEnchantmentLevel(SnifferEnchantments.MERMAID.get(), (entity instanceof LivingEntity EntGetArmor ? EntGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0) {
            if (lEntity.isInWater()) {
                RemoveMermEnch(lEntity);
                tryAddMermEnch(lEntity);
            }
            ItemStack itemstack = lEntity.getItemBySlot(EquipmentSlot.HEAD);
            if (itemstack.is(ModItems.CHITIN_HELMET.get()) || itemstack.is(Items.TURTLE_HELMET)) {
                if (!lEntity.isEyeInFluid(FluidTags.WATER)) {
                    lEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (lEntity.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(SnifferEnchantments.MERMAID.get()) * 200) + 200, 0, false, false, true));
                }
            } else {
                if (!lEntity.isEyeInFluid(FluidTags.WATER)) {
                    lEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, lEntity.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(SnifferEnchantments.MERMAID.get()) * 200, 0, false, false, true));
                }
            }
        }
    }

    protected static void tryAddMermEnch(LivingEntity entity) {
        if (!entity.getBlockStateOn().isAir()) {
            int i = EnchantmentHelper.getEnchantmentLevel(SnifferEnchantments.MERMAID.get(), entity);
            if (i > 0 && entity.isInWater()) {
                AttributeInstance attributeinstance = entity.getAttribute(ForgeMod.SWIM_SPEED.get());
                if (attributeinstance == null) {
                    return;
                }

                attributeinstance.addTransientModifier(new AttributeModifier(SPEED_MODIFIER_MER_UUID, "Merfolk boost", (double) (0.03F * (3.0F + (float) i * 0.35F)), AttributeModifier.Operation.ADDITION));
            }
        }
    }

    protected static void RemoveMermEnch(LivingEntity entity) {
        AttributeInstance attributeinstance = entity.getAttribute(ForgeMod.SWIM_SPEED.get());
        if (attributeinstance != null) {
            if (attributeinstance.getModifier(SPEED_MODIFIER_MER_UUID) != null) {
                attributeinstance.removeModifier(SPEED_MODIFIER_MER_UUID);
            }
        }
    }
    private static void ChitinHelmetTick(LivingEntity lEntity) {
        ItemStack itemstack = lEntity.getItemBySlot(EquipmentSlot.HEAD);
        if (itemstack.is(ModItems.CHITIN_HELMET.get()) && !lEntity.isEyeInFluid(FluidTags.WATER)) {
            lEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
        }
    }
}

