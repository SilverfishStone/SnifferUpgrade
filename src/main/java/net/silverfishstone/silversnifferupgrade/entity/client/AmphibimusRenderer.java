package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.AmphibimusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;

public class AmphibimusRenderer extends MobRenderer<AmphibimusEntity, AmphibimusModel<AmphibimusEntity>> {
    public AmphibimusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AmphibimusModel<>(pContext.bakeLayer(ModModelLayers.AMPHIBIMUS_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AmphibimusEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/amphibimus.png");
    }

    @Override
    public void render(AmphibimusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
