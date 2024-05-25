package net.silverfishstone.silversnifferupgrade.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;

public interface SnifferDamageTypes {
    ResourceKey<DamageType> SUFFOCATE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(SnifferUpgrade.MODID, "over_cd"));
    ResourceKey<DamageType> SPIKED = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(SnifferUpgrade.MODID, "spiked"));
    ResourceKey<DamageType> CHOKE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(SnifferUpgrade.MODID, "choke"));
    static void bootstrap(BootstapContext<DamageType> pContext) {
        pContext.register(SUFFOCATE, new DamageType("over_cd", 0.1F));
        pContext.register(SPIKED, new DamageType("spiked", 0.1F, DamageEffects.POKING));
        pContext.register(CHOKE, new DamageType("choke", 0.1F, DamageEffects.valueOf(SnifferDamageEffects.CHOKING.name())));
    }
}
