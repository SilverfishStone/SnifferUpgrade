package net.silverfishstone.silversnifferupgrade.entity.client;// Made with Blockbench 4.9.4


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.silverfishstone.silversnifferupgrade.entity.animations.ModAnimationDefinitions;
import net.silverfishstone.silversnifferupgrade.entity.custom.AmphibimusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.EurypterusEntity;

public class EurypterusModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart eurypterus;

	public EurypterusModel(ModelPart root) {
		this.eurypterus = root.getChild("eurypterus");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition eurypterus = partdefinition.addOrReplaceChild("eurypterus", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition main = eurypterus.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = main.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-3.0F, -15.0F, -8.5F));

		PartDefinition left_paddle = legs.addOrReplaceChild("left_paddle", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, 11.5F));

		PartDefinition bone16 = left_paddle.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(20, 88).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 15.0F, -16.0607F));

		PartDefinition bone15 = left_paddle.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(24.0F, 15.5F, -11.0607F));

		PartDefinition bone14 = left_paddle.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(88, 0).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(29.0F, 15.5F, -10.0607F));

		PartDefinition bone13 = left_paddle.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(34.0F, 15.5F, -9.0607F));

		PartDefinition bone17 = left_paddle.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(20.0F, 15.0F, -14.0607F));

		PartDefinition right_paddle = legs.addOrReplaceChild("right_paddle", CubeListBuilder.create(), PartPose.offset(30.5F, -2.0F, 11.0F));

		PartDefinition bone19 = right_paddle.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(64, 12).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-45.5F, 14.0F, -13.5607F));

		PartDefinition bone22 = right_paddle.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-59.5F, 14.5F, -8.5607F));

		PartDefinition bone21 = right_paddle.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(0, 88).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-54.5F, 14.5F, -9.5607F));

		PartDefinition bone20 = right_paddle.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(0, 28).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-49.5F, 14.5F, -10.5607F));

		PartDefinition bone18 = right_paddle.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(64, 6).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-41.5F, 14.0F, -15.5607F));

		PartDefinition left_leg1 = legs.addOrReplaceChild("left_leg1", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, 11.5F));

		PartDefinition bone32 = left_leg1.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(52, 64).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 15.0F, -23.0607F));

		PartDefinition bone31 = left_leg1.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(52, 60).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(20.0F, 15.0F, -23.0607F));

		PartDefinition bone30 = left_leg1.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(52, 56).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(24.0F, 15.0F, -21.0607F));

		PartDefinition bone29 = left_leg1.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(38, 95).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(28.0F, 13.5F, -21.0607F));

		PartDefinition bone28 = left_leg1.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(26, 95).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(32.0F, 13.5F, -21.0607F));

		PartDefinition right_leg1 = legs.addOrReplaceChild("right_leg1", CubeListBuilder.create(), PartPose.offset(5.0F, -3.0F, 11.5F));

		PartDefinition bone27 = right_leg1.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(94, 94).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-32.0F, 13.5F, -21.0607F));

		PartDefinition bone26 = right_leg1.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(94, 51).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, 13.5F, -21.0607F));

		PartDefinition bone25 = right_leg1.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(12, 49).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, 15.0F, -21.0607F));

		PartDefinition bone24 = right_leg1.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-20.0F, 15.0F, -23.0607F));

		PartDefinition bone23 = right_leg1.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(14, 42).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, 15.0F, -23.0607F));

		PartDefinition left_leg2 = legs.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, 11.5F));

		PartDefinition bone36 = left_leg2.addOrReplaceChild("bone36", CubeListBuilder.create().texOffs(76, 72).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, 15.0F, -27.0607F));

		PartDefinition bone35 = left_leg2.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(14, 35).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 15.0F, -28.0607F));

		PartDefinition bone34 = left_leg2.addOrReplaceChild("bone34", CubeListBuilder.create().texOffs(94, 48).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(22.0F, 15.5F, -29.0607F));

		PartDefinition bone33 = left_leg2.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(34, 92).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(26.0F, 15.5F, -28.0607F));

		PartDefinition right_leg_2 = legs.addOrReplaceChild("right_leg_2", CubeListBuilder.create(), PartPose.offset(5.0F, -3.0F, 11.5F));

		PartDefinition bone54 = right_leg_2.addOrReplaceChild("bone54", CubeListBuilder.create().texOffs(88, 24).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-26.0F, 15.5F, -28.0607F));

		PartDefinition bone53 = right_leg_2.addOrReplaceChild("bone53", CubeListBuilder.create().texOffs(88, 15).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-22.0F, 15.5F, -29.0607F));

		PartDefinition bone52 = right_leg_2.addOrReplaceChild("bone52", CubeListBuilder.create().texOffs(14, 28).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.0F, 15.0F, -28.0607F));

		PartDefinition bone51 = right_leg_2.addOrReplaceChild("bone51", CubeListBuilder.create().texOffs(76, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, 15.0F, -27.0607F));

		PartDefinition left_leg_3 = legs.addOrReplaceChild("left_leg_3", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, 11.5F));

		PartDefinition bone40 = left_leg_3.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(76, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, 15.0F, -31.0607F));

		PartDefinition bone39 = left_leg_3.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(64, 72).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 15.0F, -33.0607F));

		PartDefinition bone38 = left_leg_3.addOrReplaceChild("bone38", CubeListBuilder.create().texOffs(84, 52).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0F, 15.5F, -34.0607F));

		PartDefinition bone37 = left_leg_3.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(62, 81).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(21.0F, 15.5F, -36.0607F));

		PartDefinition right_leg3 = legs.addOrReplaceChild("right_leg3", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, 11.5F));

		PartDefinition bone49 = right_leg3.addOrReplaceChild("bone49", CubeListBuilder.create().texOffs(52, 72).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, 15.5F, -34.0607F));

		PartDefinition bone48 = right_leg3.addOrReplaceChild("bone48", CubeListBuilder.create().texOffs(12, 69).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 15.0F, -33.0607F));

		PartDefinition bone47 = right_leg3.addOrReplaceChild("bone47", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 15.0F, -31.0607F));

		PartDefinition bone50 = right_leg3.addOrReplaceChild("bone50", CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.0F, 15.5F, -36.0607F));

		PartDefinition left_leg4 = legs.addOrReplaceChild("left_leg4", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));

		PartDefinition bone41 = left_leg4.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(0, 10).addBox(1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -21.0607F));

		PartDefinition bone42 = left_leg4.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, -26.5607F));

		PartDefinition bone43 = left_leg4.addOrReplaceChild("bone43", CubeListBuilder.create().texOffs(62, 78).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 14.5F, -29.5607F));

		PartDefinition right_leg4 = legs.addOrReplaceChild("right_leg4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone44 = right_leg4.addOrReplaceChild("bone44", CubeListBuilder.create().texOffs(0, 78).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 14.5F, -29.5607F));

		PartDefinition bone45 = right_leg4.addOrReplaceChild("bone45", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, -26.5607F));

		PartDefinition bone46 = right_leg4.addOrReplaceChild("bone46", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 14.0F, -23.5607F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(58, 48).addBox(-8.0F, -0.0222F, -18.2222F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-10.0F, -2.0222F, -16.2222F, 20.0F, 4.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(52, 72).addBox(10.0F, -2.0222F, -12.2222F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-12.0F, -2.0222F, -12.2222F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-8.0F, -4.0222F, -14.2222F, 16.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(52, 56).addBox(-10.0F, -2.0222F, 7.7778F, 20.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 78).addBox(-6.0F, -4.0222F, 11.7778F, 12.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(38, 28).addBox(-10.0F, 2.1778F, -8.2222F, 20.0F, 0.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(0, 56).addBox(-8.0F, 1.9778F, -14.2222F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.9778F, -16.8384F));

		PartDefinition tail = eurypterus.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 4.0F));

		PartDefinition bone = tail.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(76, 72).addBox(-8.0F, -2.0F, -5.0F, 16.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.9393F));

		PartDefinition bone2 = tail.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.3827F, 10.8632F));

		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(88, 9).addBox(-4.0F, -9.419F, -21.3253F, 10.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.3827F, 21.0761F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone3 = tail.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, -2.9134F, 14.5587F));

		PartDefinition cube_r2 = bone3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 86).addBox(-4.0F, -9.419F, -17.3253F, 10.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.9134F, 17.3806F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone4 = tail.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0615F, 17.3304F));

		PartDefinition cube_r3 = bone4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -9.419F, -13.3253F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0615F, 14.609F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone5 = tail.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, -5.9497F, 19.9185F));

		PartDefinition cube_r4 = bone5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 86).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9497F, 12.0208F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone7 = tail.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0208F, 26.9896F));

		PartDefinition cube_r5 = bone7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, -13.0F, 3.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0208F, 4.9497F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone8 = tail.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(0.0F, -15.8492F, 29.818F));

		PartDefinition cube_r6 = bone8.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 63).addBox(-4.0F, -13.0F, 7.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 14.8492F, 2.1213F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone9 = tail.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.0F, -17.9706F, 31.9393F));

		PartDefinition cube_r7 = bone9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(76, 76).addBox(-2.0F, -13.0F, 11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 16.9706F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone10 = tail.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(0.0F, -19.3848F, 33.3536F));

		PartDefinition cube_r8 = bone10.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -13.0F, 13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.3848F, -1.4142F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone11 = tail.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(0.0F, -20.799F, 34.7678F));

		PartDefinition cube_r9 = bone11.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -12.5F, 15.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 19.799F, -2.8284F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone12 = tail.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(0.0F, -22.2132F, 36.182F));

		PartDefinition cube_r10 = bone12.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -12.5F, 17.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.2132F, -4.2426F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bone6 = tail.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0.0F, -9.9567F, 23.9255F));

		PartDefinition cube_r11 = bone6.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -13.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 10).addBox(6.0F, -13.0F, -3.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 78).addBox(-6.0F, -13.0F, -3.0F, 12.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.9567F, 8.0139F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.EURYPTERUS_SWIM, limbSwing, limbSwingAmount, 10f, 8f);
		this.animate(((EurypterusEntity) entity).idleAnimationState, ModAnimationDefinitions.EURYPTERUS_SWIM, ageInTicks, 0.5f);
		this.animate(((EurypterusEntity) entity).attackAnimationState, ModAnimationDefinitions.EURYPTERUS_ATTACK, ageInTicks, 0.1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		eurypterus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return eurypterus;
	}
}