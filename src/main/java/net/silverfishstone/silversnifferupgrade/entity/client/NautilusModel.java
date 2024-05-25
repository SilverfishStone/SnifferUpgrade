package net.silverfishstone.silversnifferupgrade.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.NautilusEntity;

public class NautilusModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart nautilus;
    private final ModelPart head;

    public NautilusModel(ModelPart root) {
        this.nautilus = root.getChild("nautilus");
        this.head = nautilus.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition nautilus = partdefinition.addOrReplaceChild("nautilus", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tentacles = nautilus.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(-2.25F, -11.5937F, -3.0007F));

        PartDefinition bone = tentacles.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 1).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4955F, 8.0937F, 6.853F));

        PartDefinition bone10 = tentacles.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(31, 2).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4955F, 11.0766F, 6.6037F));

        PartDefinition bone6 = tentacles.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(21, 24).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0975F, 10.5011F, 6.3445F));

        PartDefinition bone5 = tentacles.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0045F, 8.4152F, 6.8282F));

        PartDefinition bone4 = tentacles.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(28, 24).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4955F, 8.9435F, 6.8149F));

        PartDefinition bone2 = tentacles.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(28, 24).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.3939F, 8.0937F, 6.8681F));

        PartDefinition bone3 = tentacles.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(1, 28).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4955F, 10.7655F, 6.2155F));

        PartDefinition bone7 = tentacles.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(27, 33).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4955F, 9.5937F, 6.853F));

        PartDefinition bone8 = tentacles.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(8, 28).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.6901F, 9.6937F, 6.9213F));

        PartDefinition bone9 = tentacles.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.5078F, 8.0937F, 6.853F));

        PartDefinition tentacle_r1 = bone9.addOrReplaceChild("tentacle_r1", CubeListBuilder.create().texOffs(28, 17).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition head = nautilus.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.25F, -16.5F, 4.5766F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4955F, 14.5F, -7.2243F, 0.0F, 3.1416F, 0.0F));

        PartDefinition shell = nautilus.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.2455F, -4.8647F, -1.5711F));

        PartDefinition cube_r2 = shell.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 16).addBox(-3.5F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3647F, 2.4234F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r3 = shell.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3647F, -2.4234F, 2.7489F, 0.0F, 3.1416F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animate(((NautilusEntity) entity).idleAnimationState, ModAnimationDefinitions.TENTACLE_IDLE, ageInTicks, 0.6f);
    }


    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        nautilus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return nautilus;
    }

    public ModelPart getHead() {
        return head;
    }
}
