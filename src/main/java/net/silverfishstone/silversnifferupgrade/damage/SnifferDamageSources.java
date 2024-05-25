package net.silverfishstone.silversnifferupgrade.damage;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class SnifferDamageSources {
    private final Registry<DamageType> damageTypes;
    private final DamageSource suffocate;
    private final DamageSource spiked;
    private final DamageSource choke;


    public SnifferDamageSources(RegistryAccess pRegistry) {
        this.damageTypes = pRegistry.registryOrThrow(Registries.DAMAGE_TYPE);
        this.suffocate = this.source(SnifferDamageTypes.SUFFOCATE);
        this.spiked = this.source(SnifferDamageTypes.SPIKED);
        this.choke = this.source(SnifferDamageTypes.CHOKE);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pEntity);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pCausingEntity, @Nullable Entity pDirectEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pCausingEntity, pDirectEntity);
    }

    public DamageSource suffocate() {
        return this.suffocate;
    }
    public DamageSource spiked() {
        return this.spiked;
    }
    public DamageSource choke() {
        return this.choke;
    }
}
