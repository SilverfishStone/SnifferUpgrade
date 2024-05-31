package net.silverfishstone.silversnifferupgrade.potions;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.effect.*;

public class ModMobEffects
{
    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SnifferUpgrade.MODID);

    public static final RegistryObject<MobEffect> OXYGENATED = MOB_EFFECTS.register("oxygenated", () -> new OxygenatedEffect(MobEffectCategory.NEUTRAL, 0x2C8265));
    public static final RegistryObject<MobEffect> SUFFOCATING = MOB_EFFECTS.register("suffocating", () -> new SuffocateEffect(MobEffectCategory.HARMFUL, 0x2C8265));
    public static final RegistryObject<MobEffect> MYSTERY = MOB_EFFECTS.register("mystery", () -> new MysteryEffect(MobEffectCategory.HARMFUL, 0x2C8265));
    public static final RegistryObject<MobEffect> SPICY = MOB_EFFECTS.register("spicy", () -> new SpicyEffect(MobEffectCategory.NEUTRAL, 0x2C8265));
    public static final RegistryObject<MobEffect> DIRTY = MOB_EFFECTS.register("dirty", () -> new DirtyEffect(MobEffectCategory.HARMFUL, 0x67553B)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "1111DE9E-7CE9-9988-930E-514C1F160890", (double)-0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.JUMP_STRENGTH, "3611DE9E-7CE9-1981-930E-599C1F160510", (double)-0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}