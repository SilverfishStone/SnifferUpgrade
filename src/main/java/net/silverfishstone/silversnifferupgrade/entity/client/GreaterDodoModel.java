package net.silverfishstone.silversnifferupgrade.entity.client;// Made with Blockbench 4.9.4


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;

public class GreaterDodoModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart greater_dodo;
	private final ModelPart head;

	public GreaterDodoModel(ModelPart root) {
		this.greater_dodo = root.getChild("greater_dodo");
		this.head = greater_dodo.getChild("head2");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition greater_dodo = partdefinition.addOrReplaceChild("greater_dodo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg2 = greater_dodo.addOrReplaceChild("right_leg2", CubeListBuilder.create().texOffs(32, 32).addBox(-3.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-3.0F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition cube_r1 = right_leg2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, 1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -1.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition cube_r2 = right_leg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 5).addBox(-2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3499F, 0.0F, -2.1951F, 0.0F, 0.4363F, 0.0F));

		PartDefinition left_leg2 = greater_dodo.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(28, 32).addBox(1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 15).addBox(1.0F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition cube_r3 = left_leg2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 5).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1837F, 0.0F, -0.5327F, 0.0F, 0.9163F, 0.0F));

		PartDefinition cube_r4 = left_leg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -1.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition head2 = greater_dodo.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -0.5F, -3.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(21, 5).addBox(-1.0F, 0.5F, -4.8F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 14).addBox(-2.0F, -1.5F, -0.8F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-2.5F, -3.5F, 0.2F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 5).addBox(-2.0F, -2.5F, 4.2F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.5F, -6.2F));

		PartDefinition neck2 = greater_dodo.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, -2.5F, 1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 32).addBox(-1.5F, 0.5F, 1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 27).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 15).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 27).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, -3.0F));

		PartDefinition body2 = greater_dodo.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -1.625F, -7.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-2.5F, -1.625F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 23).addBox(-2.5F, -1.625F, 1.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 0).addBox(-2.0F, -3.625F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.375F, 4.0F));

		PartDefinition left_wing2 = greater_dodo.addOrReplaceChild("left_wing2", CubeListBuilder.create().texOffs(13, 18).addBox(-0.5F, -0.25F, -2.25F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(27, 10).addBox(-0.5F, 3.75F, -2.25F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -9.75F, 0.25F));

		PartDefinition right_wing2 = greater_dodo.addOrReplaceChild("right_wing2", CubeListBuilder.create().texOffs(20, 14).addBox(-0.5F, -0.25F, -2.25F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 27).addBox(-0.5F, 3.75F, -2.25F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -9.75F, 0.25F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.DODO_WALK, limbSwing, limbSwingAmount, 4f, 2f);
		this.animate(((GreaterDodoEntity) entity).idleAnimationState, ModAnimationDefinitions.DODO_IDLE, ageInTicks, 0.2f);
		this.animate(((GreaterDodoEntity) entity).fallingAnimationState, ModAnimationDefinitions.DODO_FLUTTER, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		greater_dodo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return greater_dodo;
	}

	public ModelPart getHead() {
		return head;
	}
}