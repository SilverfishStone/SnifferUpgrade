package net.silverfishstone.silversnifferupgrade.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;

public class SnifferSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SnifferUpgrade.MODID);

    public static final RegistryObject<SoundEvent> SNIFFER_PEDESTAL_ACTIVATE = registerSoundEvents("block.sniffer_pedestal.active");
    public static final RegistryObject<SoundEvent> CHOKE = registerSoundEvents("entity.damage.choking");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SnifferUpgrade.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
