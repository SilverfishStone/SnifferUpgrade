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
import net.silverfishstone.silversnifferupgrade.entity.custom.AmphibimusEntity;
import net.silverfishstone.silversnifferupgrade.entity.custom.FlamipedeEntity;

public class FlamipedeModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart blazipede;
	private final ModelPart head;

	public FlamipedeModel(ModelPart root) {
		this.blazipede = root.getChild("blazipede");
		this.head = blazipede.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition blazipede = partdefinition.addOrReplaceChild("blazipede", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition back = blazipede.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment9 = back.addOrReplaceChild("segment9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body9 = segment9.addOrReplaceChild("body9", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, -34.0F));

		PartDefinition cube_r1 = body9.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, 31.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 34.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one9 = segment9.addOrReplaceChild("left_joint_one9", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, -34.0F));

		PartDefinition cube_r2 = left_joint_one9.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, 33.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, 34.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two9 = segment9.addOrReplaceChild("left_joint_two9", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, -34.0F));

		PartDefinition cube_r3 = left_joint_two9.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, 33.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, 34.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three9 = segment9.addOrReplaceChild("left_joint_three9", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, -34.0F));

		PartDefinition cube_r4 = left_joint_three9.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, 33.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, 34.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link9 = segment9.addOrReplaceChild("link9", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, -38.0F));

		PartDefinition cube_r5 = link9.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, 37.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, 38.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three9 = segment9.addOrReplaceChild("right_joint_three9", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, -34.0F));

		PartDefinition cube_r6 = right_joint_three9.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, -35.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, 34.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two9 = segment9.addOrReplaceChild("right_joint_two9", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, -34.0F));

		PartDefinition cube_r7 = right_joint_two9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, -35.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, 34.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one9 = segment9.addOrReplaceChild("right_joint_one9", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, -34.0F));

		PartDefinition cube_r8 = right_joint_one9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, -35.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, 34.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition back2 = back.addOrReplaceChild("back2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment7 = back2.addOrReplaceChild("segment7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body7 = segment7.addOrReplaceChild("body7", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, -18.0F));

		PartDefinition cube_r9 = body7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, 15.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 18.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one7 = segment7.addOrReplaceChild("left_joint_one7", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, -18.0F));

		PartDefinition cube_r10 = left_joint_one7.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, 17.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, 18.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two7 = segment7.addOrReplaceChild("left_joint_two7", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, -18.0F));

		PartDefinition cube_r11 = left_joint_two7.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, 17.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, 18.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three7 = segment7.addOrReplaceChild("left_joint_three7", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, -18.0F));

		PartDefinition cube_r12 = left_joint_three7.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, 17.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, 18.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link7 = segment7.addOrReplaceChild("link7", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, -22.0F));

		PartDefinition cube_r13 = link7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, 21.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, 22.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three7 = segment7.addOrReplaceChild("right_joint_three7", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, -18.0F));

		PartDefinition cube_r14 = right_joint_three7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, -19.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, 18.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two7 = segment7.addOrReplaceChild("right_joint_two7", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, -18.0F));

		PartDefinition cube_r15 = right_joint_two7.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, -19.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, 18.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one7 = segment7.addOrReplaceChild("right_joint_one7", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, -18.0F));

		PartDefinition cube_r16 = right_joint_one7.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, -19.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, 18.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition segment8 = back2.addOrReplaceChild("segment8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -29.0F));

		PartDefinition body8 = segment8.addOrReplaceChild("body8", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, 3.0F));

		PartDefinition cube_r17 = body8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, 23.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 26.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one8 = segment8.addOrReplaceChild("left_joint_one8", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, 3.0F));

		PartDefinition cube_r18 = left_joint_one8.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, 25.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, 26.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two8 = segment8.addOrReplaceChild("left_joint_two8", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, 3.0F));

		PartDefinition cube_r19 = left_joint_two8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, 25.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, 26.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three8 = segment8.addOrReplaceChild("left_joint_three8", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, 3.0F));

		PartDefinition cube_r20 = left_joint_three8.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, 25.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, 26.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link8 = segment8.addOrReplaceChild("link8", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, -1.0F));

		PartDefinition cube_r21 = link8.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, 29.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, 30.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three8 = segment8.addOrReplaceChild("right_joint_three8", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, 3.0F));

		PartDefinition cube_r22 = right_joint_three8.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, -27.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, 26.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two8 = segment8.addOrReplaceChild("right_joint_two8", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, 3.0F));

		PartDefinition cube_r23 = right_joint_two8.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, -27.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, 26.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one8 = segment8.addOrReplaceChild("right_joint_one8", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, 3.0F));

		PartDefinition cube_r24 = right_joint_one8.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, -27.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, 26.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition back3 = back2.addOrReplaceChild("back3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment6 = back3.addOrReplaceChild("segment6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body6 = segment6.addOrReplaceChild("body6", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, -10.0F));

		PartDefinition cube_r25 = body6.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, 7.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 10.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one6 = segment6.addOrReplaceChild("left_joint_one6", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, -10.0F));

		PartDefinition cube_r26 = left_joint_one6.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, 10.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two6 = segment6.addOrReplaceChild("left_joint_two6", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, -10.0F));

		PartDefinition cube_r27 = left_joint_two6.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, 10.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three6 = segment6.addOrReplaceChild("left_joint_three6", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, -10.0F));

		PartDefinition cube_r28 = left_joint_three6.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, 10.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link6 = segment6.addOrReplaceChild("link6", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, -14.0F));

		PartDefinition cube_r29 = link6.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, 13.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, 14.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three6 = segment6.addOrReplaceChild("right_joint_three6", CubeListBuilder.create(), PartPose.offset(14.3758F, -2.6525F, -10.0F));

		PartDefinition cube_r30 = right_joint_three6.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(48, 4).addBox(9.4733F, -9.8572F, -11.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.3758F, -1.8499F, 10.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two6 = segment6.addOrReplaceChild("right_joint_two6", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, -10.0F));

		PartDefinition cube_r31 = right_joint_two6.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, -11.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, 10.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one6 = segment6.addOrReplaceChild("right_joint_one6", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, -10.0F));

		PartDefinition cube_r32 = right_joint_one6.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, -11.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, 10.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition back4 = back3.addOrReplaceChild("back4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment5 = back4.addOrReplaceChild("segment5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body5 = segment5.addOrReplaceChild("body5", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, -2.0F));

		PartDefinition cube_r33 = body5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, -1.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 2.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one5 = segment5.addOrReplaceChild("left_joint_one5", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, -2.0F));

		PartDefinition cube_r34 = left_joint_one5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, 2.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two5 = segment5.addOrReplaceChild("left_joint_two5", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, -2.0F));

		PartDefinition cube_r35 = left_joint_two5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, 2.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three5 = segment5.addOrReplaceChild("left_joint_three5", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, -2.0F));

		PartDefinition cube_r36 = left_joint_three5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, 2.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link5 = segment5.addOrReplaceChild("link5", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, -6.0F));

		PartDefinition cube_r37 = link5.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, 5.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, 6.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three5 = segment5.addOrReplaceChild("right_joint_three5", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, -2.0F));

		PartDefinition cube_r38 = right_joint_three5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, 2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two5 = segment5.addOrReplaceChild("right_joint_two5", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, -2.0F));

		PartDefinition cube_r39 = right_joint_two5.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, 2.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one5 = segment5.addOrReplaceChild("right_joint_one5", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, -2.0F));

		PartDefinition cube_r40 = right_joint_one5.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition back5 = back4.addOrReplaceChild("back5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment4 = back5.addOrReplaceChild("segment4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body4 = segment4.addOrReplaceChild("body4", CubeListBuilder.create(), PartPose.offset(0.584F, -7.5F, 6.0F));

		PartDefinition cube_r41 = body4.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, -9.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 2.9976F, -6.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one4 = segment4.addOrReplaceChild("left_joint_one4", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, 6.0F));

		PartDefinition cube_r42 = left_joint_one4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, -7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, -6.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two4 = segment4.addOrReplaceChild("left_joint_two4", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, 6.0F));

		PartDefinition cube_r43 = left_joint_two4.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, -7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, -6.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three4 = segment4.addOrReplaceChild("left_joint_three4", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, 6.0F));

		PartDefinition cube_r44 = left_joint_three4.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, -7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, -6.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link4 = segment4.addOrReplaceChild("link4", CubeListBuilder.create(), PartPose.offset(0.584F, -7.0F, 2.0F));

		PartDefinition cube_r45 = link4.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, -3.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 2.4976F, -2.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three4 = segment4.addOrReplaceChild("right_joint_three4", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, 6.0F));

		PartDefinition cube_r46 = right_joint_three4.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, -6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two4 = segment4.addOrReplaceChild("right_joint_two4", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, 6.0F));

		PartDefinition cube_r47 = right_joint_two4.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, -6.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one4 = segment4.addOrReplaceChild("right_joint_one4", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, 6.0F));

		PartDefinition cube_r48 = right_joint_one4.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, -6.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition back6 = back5.addOrReplaceChild("back6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition back7 = back6.addOrReplaceChild("back7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition back8 = back7.addOrReplaceChild("back8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment = back8.addOrReplaceChild("segment", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = segment.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, 30.0F));

		PartDefinition cube_r49 = body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, -33.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, -30.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one = segment.addOrReplaceChild("left_joint_one", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, 30.0F));

		PartDefinition cube_r50 = left_joint_one.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, -31.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, -30.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two = segment.addOrReplaceChild("left_joint_two", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, 30.0F));

		PartDefinition cube_r51 = left_joint_two.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, -31.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, -30.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three = segment.addOrReplaceChild("left_joint_three", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, 30.0F));

		PartDefinition cube_r52 = left_joint_three.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, -31.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, -30.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link = segment.addOrReplaceChild("link", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, 26.0F));

		PartDefinition cube_r53 = link.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, -27.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, -26.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three = segment.addOrReplaceChild("right_joint_three", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, 30.0F));

		PartDefinition cube_r54 = right_joint_three.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, 29.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, -30.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two = segment.addOrReplaceChild("right_joint_two", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, 30.0F));

		PartDefinition cube_r55 = right_joint_two.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, 29.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, -30.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one = segment.addOrReplaceChild("right_joint_one", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, 30.0F));

		PartDefinition cube_r56 = right_joint_one.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, 29.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, -30.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition tail = back8.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.584F, -6.25F, 36.5F));

		PartDefinition cube_r57 = tail.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(32, 0).addBox(-3.584F, -3.4976F, -35.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(-6.584F, -4.4976F, -43.0F, 12.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.7476F, -36.5F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone = tail.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(6.8321F, 1.25F, 1.5F));

		PartDefinition cube_r58 = bone.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(46, 39).addBox(5.416F, -1.4976F, 37.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, -38.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = tail.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(10.6447F, 2.0952F, 1.5F));

		PartDefinition cube_r59 = bone2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(46, 28).addBox(8.3235F, -5.4304F, 37.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, -38.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition bone3 = tail.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(14.0F, 4.2452F, 1.5F));

		PartDefinition cube_r60 = bone3.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(44, 24).addBox(10.0785F, -9.5464F, 37.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, -38.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone6 = tail.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(-15.1679F, 4.2452F, 1.5F));

		PartDefinition cube_r61 = bone6.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(20, 44).addBox(10.0785F, -9.5464F, -39.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, -38.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition bone5 = tail.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-11.8126F, 2.0952F, 1.5F));

		PartDefinition cube_r62 = bone5.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(44, 12).addBox(8.3235F, -5.4304F, -39.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, -38.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition bone4 = tail.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-8.0F, 1.25F, 1.5F));

		PartDefinition cube_r63 = bone4.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(8, 44).addBox(5.416F, -1.4976F, -39.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, -38.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone7 = tail.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(-3.0F, 1.25F, 7.5F));

		PartDefinition cube_r64 = bone7.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 44).addBox(1.416F, -1.4976F, -46.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.416F, 0.4976F, -44.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone10 = tail.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(3.0F, 1.25F, 7.5F));

		PartDefinition cube_r65 = bone10.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(40, 43).addBox(-4.584F, -1.4976F, -46.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.584F, 0.4976F, -44.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone11 = tail.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(3.0F, 0.4846F, 11.3478F));

		PartDefinition cube_r66 = bone11.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(42, 18).addBox(-4.584F, 16.1437F, -46.6889F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.584F, 1.263F, -47.8478F, 2.7489F, 0.0F, 3.1416F));

		PartDefinition bone8 = tail.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.4846F, 11.3478F));

		PartDefinition cube_r67 = bone8.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(32, 41).addBox(1.416F, 16.1437F, -46.6889F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.416F, 1.263F, -47.8478F, 2.7489F, 0.0F, 3.1416F));

		PartDefinition bone9 = tail.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.75F, 15.5F));

		PartDefinition cube_r68 = bone9.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(40, 6).addBox(1.416F, -3.4976F, -54.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.416F, 2.4976F, -52.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone12 = tail.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(3.0F, -0.75F, 15.5F));

		PartDefinition cube_r69 = bone12.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(24, 38).addBox(-4.584F, -3.4976F, -54.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.584F, 2.4976F, -52.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition segment2 = back7.addOrReplaceChild("segment2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body2 = segment2.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, 22.0F));

		PartDefinition cube_r70 = body2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, -25.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, -22.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one2 = segment2.addOrReplaceChild("left_joint_one2", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, 22.0F));

		PartDefinition cube_r71 = left_joint_one2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, -23.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, -22.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two2 = segment2.addOrReplaceChild("left_joint_two2", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, 22.0F));

		PartDefinition cube_r72 = left_joint_two2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, -23.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, -22.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three2 = segment2.addOrReplaceChild("left_joint_three2", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, 22.0F));

		PartDefinition cube_r73 = left_joint_three2.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, -23.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, -22.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link2 = segment2.addOrReplaceChild("link2", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, 18.0F));

		PartDefinition cube_r74 = link2.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, -19.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, -18.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three2 = segment2.addOrReplaceChild("right_joint_three2", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, 22.0F));

		PartDefinition cube_r75 = right_joint_three2.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, 21.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, -22.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two2 = segment2.addOrReplaceChild("right_joint_two2", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, 22.0F));

		PartDefinition cube_r76 = right_joint_two2.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, 21.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, -22.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one2 = segment2.addOrReplaceChild("right_joint_one2", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, 22.0F));

		PartDefinition cube_r77 = right_joint_one2.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, 21.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, -22.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition segment3 = back6.addOrReplaceChild("segment3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body3 = segment3.addOrReplaceChild("body3", CubeListBuilder.create(), PartPose.offset(0.584F, -7.5F, 14.0F));

		PartDefinition cube_r78 = body3.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(0, 27).addBox(-6.584F, -4.4976F, -17.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 2.9976F, -14.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_one3 = segment3.addOrReplaceChild("left_joint_one3", CubeListBuilder.create(), PartPose.offset(-7.416F, -5.0F, 14.0F));

		PartDefinition cube_r79 = left_joint_one3.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(48, 43).addBox(5.416F, -1.4976F, -15.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.416F, 0.4976F, -14.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition left_joint_two3 = segment3.addOrReplaceChild("left_joint_two3", CubeListBuilder.create(), PartPose.offset(-11.2287F, -4.1548F, 14.0F));

		PartDefinition cube_r80 = left_joint_two3.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(48, 35).addBox(8.3235F, -5.4304F, -15.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2287F, -0.3476F, -14.0F, -3.1416F, 0.0F, 2.7053F));

		PartDefinition left_joint_three3 = segment3.addOrReplaceChild("left_joint_three3", CubeListBuilder.create(), PartPose.offset(-14.584F, -2.0048F, 14.0F));

		PartDefinition cube_r81 = left_joint_three3.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(10, 48).addBox(10.0785F, -9.5464F, -15.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.584F, -2.4976F, -14.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition link3 = segment3.addOrReplaceChild("link3", CubeListBuilder.create(), PartPose.offset(0.584F, -6.0F, 10.0F));

		PartDefinition cube_r82 = link3.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(30, 27).addBox(-3.584F, -3.4976F, -11.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.4976F, -10.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition right_joint_three3 = segment3.addOrReplaceChild("right_joint_three3", CubeListBuilder.create(), PartPose.offset(14.584F, -2.0048F, 14.0F));

		PartDefinition cube_r83 = right_joint_three3.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(48, 4).addBox(10.0785F, -9.5464F, 13.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.584F, -2.4976F, -14.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition right_joint_two3 = segment3.addOrReplaceChild("right_joint_two3", CubeListBuilder.create(), PartPose.offset(11.2287F, -4.1548F, 14.0F));

		PartDefinition cube_r84 = right_joint_two3.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(48, 0).addBox(8.3235F, -5.4304F, 13.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2287F, -0.3476F, -14.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_joint_one3 = segment3.addOrReplaceChild("right_joint_one3", CubeListBuilder.create(), PartPose.offset(7.416F, -5.0F, 14.0F));

		PartDefinition cube_r85 = right_joint_one3.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(30, 47).addBox(5.416F, -1.4976F, 13.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.416F, 0.4976F, -14.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition head = blazipede.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.584F, -6.5F, -43.0F));

		PartDefinition cube_r86 = head.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(0, 0).addBox(-6.584F, -4.9976F, 39.0F, 12.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.584F, 1.9976F, 43.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone14 = head.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.5F, -6.0F));

		PartDefinition cube_r87 = bone14.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(12, 38).addBox(1.416F, -2.4976F, 47.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.416F, 1.4976F, 49.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone13 = head.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(3.0F, 0.5F, -6.0F));

		PartDefinition cube_r88 = bone13.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(0, 38).addBox(-4.584F, -2.4976F, 47.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.584F, 1.4976F, 49.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone15 = head.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.5F, -9.0F));

		PartDefinition cube_r89 = bone15.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(0, 4).addBox(0.416F, -2.4976F, 51.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.416F, 1.4976F, 52.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone16 = head.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(2.0F, 0.5F, -9.0F));

		PartDefinition cube_r90 = bone16.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(0, 0).addBox(-3.584F, -2.4976F, 51.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.584F, 1.4976F, 52.0F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition bone19 = head.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offset(8.4239F, -0.5F, -4.3827F));

		PartDefinition cube_r91 = bone19.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(34, 37).addBox(-28.9547F, -3.4976F, 39.3287F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0078F, 2.4976F, 47.3827F, 3.1416F, -0.3927F, 3.1416F));

		PartDefinition bone20 = head.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offset(13.4846F, -0.5F, -5.3508F));

		PartDefinition cube_r92 = bone20.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(36, 33).addBox(-10.1371F, -3.4976F, 48.7735F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0685F, 2.4976F, 48.3508F, 3.1416F, 0.1309F, 3.1416F));

		PartDefinition bone17 = head.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(-8.5228F, -0.5F, -4.3456F));

		PartDefinition cube_r93 = bone17.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(32, 18).addBox(28.0481F, -3.4976F, 36.0331F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9388F, 2.4976F, 47.3456F, 3.1416F, 0.5236F, 3.1416F));

		PartDefinition bone18 = head.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(-13.5688F, -0.5F, -5.3879F));

		PartDefinition cube_r94 = bone18.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(32, 14).addBox(10.4848F, -3.4976F, 47.3879F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9848F, 2.4976F, 48.3879F, 3.1416F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.WALK_MILLIPEDE, limbSwing, limbSwingAmount, 10f, 8f);
		this.animate(((FlamipedeEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE_MILLIPEDE, ageInTicks, 1f);
		this.animate(((FlamipedeEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK_MILLIPEDE, ageInTicks, 0.1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		blazipede.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return blazipede;
	}

	public ModelPart getHead() {
		return head;
	}
}