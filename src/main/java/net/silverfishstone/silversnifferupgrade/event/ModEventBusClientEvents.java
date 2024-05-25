package net.silverfishstone.silversnifferupgrade.event;


import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.entity.ModBlockEntities;
import net.silverfishstone.silversnifferupgrade.entity.client.*;

@Mod.EventBusSubscriber(modid = SnifferUpgrade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GREATER_DODO_LAYER, GreaterDodoModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NAUTILUS_LAYER, NautilusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CONESHELL_LAYER, ConeshellModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.AMPHIBIMUS_LAYER, AmphibimusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ARMISOR_LAYER, ArmisorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ANCIENT_ZOMBIE_LAYER, AncientZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EURYPTERUS_LAYER, EurypterusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FLAMIPEDE_LAYER, FlamipedeModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.GINKGO_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.GINKGO_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.SPIKETIP_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.SPIKETIP_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.TREE_FERN_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.TREE_FERN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GINKGO_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.GINKGO_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SPIKETIP_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SPIKETIP_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.TREE_FERN_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.TREE_FERN_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
