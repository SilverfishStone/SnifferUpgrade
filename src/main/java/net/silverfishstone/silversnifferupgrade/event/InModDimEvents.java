package net.silverfishstone.silversnifferupgrade.event;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;
import net.silverfishstone.silversnifferupgrade.worldgen.dimension.ModDimensions;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InModDimEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player, event.player);
        }
    }

    private static void execute(@Nullable Event event, Entity entity, LivingEntity liEntity) {
        if (entity == null)
            return;
        if ((entity.level().dimension()) == ModDimensions.ANCIENT_FIELDS_LEVEL_KEY) {
            ItemStack itemstack = liEntity.getItemBySlot(EquipmentSlot.HEAD);
            if (!(entity instanceof LivingEntity lEntity && lEntity.hasEffect(ModMobEffects.OXYGENATED.get()))) {
                if (!(itemstack.is(ModItems.CHITIN_HELMET.get()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(ModMobEffects.SUFFOCATING.get(), 1, 0, true, false));
                } else {
                    if (entity instanceof LivingEntity _entity)
                        _entity.removeEffect(ModMobEffects.SUFFOCATING.get());
                }
            }
        } else {
            if (entity instanceof LivingEntity _entity)
                _entity.removeEffect(ModMobEffects.SUFFOCATING.get());
        }
    }
}