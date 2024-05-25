package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.EurypterusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.FlamipedeEntity;

public class FlamipedeRenderer extends MobRenderer<FlamipedeEntity, FlamipedeModel<FlamipedeEntity>> {
    public FlamipedeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FlamipedeModel<>(pContext.bakeLayer(ModModelLayers.FLAMIPEDE_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(FlamipedeEntity pEntity) {
        return new ResourceLocation(SnifferUpgrade.MODID, "textures/entity/flamipede.png");
    }

    @Override
    public void render(FlamipedeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
