package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;

public class GreaterDodoRenderer extends MobRenderer<GreaterDodoEntity, GreaterDodoModel<GreaterDodoEntity>> {
    public GreaterDodoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GreaterDodoModel<>(pContext.bakeLayer(ModModelLayers.GREATER_DODO_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(GreaterDodoEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/greater_dodo.png");
    }

    @Override
    public void render(GreaterDodoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
