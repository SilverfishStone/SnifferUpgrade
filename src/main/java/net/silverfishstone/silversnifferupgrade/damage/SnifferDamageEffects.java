package net.silverfishstone.silversnifferupgrade.damage;

import com.mojang.serialization.Codec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.silverfishstone.silversnifferupgrade.sounds.SnifferSounds;

public enum SnifferDamageEffects implements StringRepresentable {
    CHOKING("choking", SnifferSounds.CHOKE.get());

    public static final Codec<SnifferDamageEffects> CODEC = StringRepresentable.fromEnum(SnifferDamageEffects::values);
    private final String id;
    private final SoundEvent sound;

    private SnifferDamageEffects(String pId, SoundEvent pSound) {
        this.id = pId;
        this.sound = pSound;
    }

    public String getSerializedName() {
        return this.id;
    }

    public SoundEvent sound() {
        return this.sound;
    }
}