package net.silverfishstone.silversnifferupgrade.event;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.client.GreaterDodoModel;
import net.silverfishstone.silversnifferupgrade.entity.client.ModModelLayers;
import net.silverfishstone.silversnifferupgrade.entity.custom.*;

@Mod.EventBusSubscriber(modid = SnifferUpgrade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GREATERDODO.get(), GreaterDodoEntity.createAttributes().build());
        event.put(ModEntities.AMPHIBIMUS.get(), AmphibimusEntity.createAttributes().build());
        event.put(ModEntities.NAUTILUS.get(), NautilusEntity.createAttributes().build());
        event.put(ModEntities.CONESHELL.get(), ConeshellEntity.createAttributes().build());
        event.put(ModEntities.ANCIENTZOMBIE.get(), AncientZombieEntity.createAttributes().build());
        event.put(ModEntities.ARMISOR.get(), ArmisorEntity.createAttributes().build());
        event.put(ModEntities.EURYPTERUS.get(), EurypterusEntity.createAttributes().build());
        event.put(ModEntities.FLAMIPEDE.get(), FlamipedeEntity.createAttributes().build());
    }
}
