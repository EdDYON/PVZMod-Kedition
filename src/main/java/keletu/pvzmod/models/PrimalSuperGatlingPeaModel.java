package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySuperPrimalGatlingPea;
import keletu.pvzmod.models.anim.PSGPModelAnimation;
import keletu.pvzmod.models.anim.SGPAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class PrimalSuperGatlingPeaModel extends HierarchicalModel<EntitySuperPrimalGatlingPea> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PVZMod.MODID, "textures/entity/plant/super_primal_gatling_pea.png"), "main");

    private final ModelPart root;
    private final ModelPart all;
    private final ModelPart head;
    private final ModelPart face;
    private final ModelPart eye;
    private final ModelPart bone6;
    private final ModelPart ye;
    private final ModelPart mouth;
    private final ModelPart qiang;
    private final ModelPart mouth1;
    private final ModelPart hat;
    private final ModelPart star1;
    private final ModelPart star2;
    private final ModelPart star3;
    private final ModelPart star4;
    private final ModelPart star5;
    private final ModelPart star6;
    private final ModelPart jin;
    private final ModelPart jin1;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone;
    private final ModelPart leave5;
    private final ModelPart leave1;
    private final ModelPart leave2;
    private final ModelPart leave3;
    private final ModelPart leave4;

    public PrimalSuperGatlingPeaModel(ModelPart root) {
        this.root = root;
        this.all = root.getChild("all");
        this.head = this.all.getChild("head");
        this.face = this.head.getChild("face");
        this.eye = this.head.getChild("eye");
        this.bone6 = this.head.getChild("bone6");
        this.ye = this.head.getChild("ye");
        this.mouth = this.head.getChild("mouth");
        this.qiang = this.mouth.getChild("qiang");
        this.mouth1 = this.mouth.getChild("mouth1");
        this.hat = this.head.getChild("hat");
        this.star1 = this.hat.getChild("star1");
        this.star2 = this.hat.getChild("star2");
        this.star3 = this.hat.getChild("star3");
        this.star4 = this.hat.getChild("star4");
        this.star5 = this.hat.getChild("star5");
        this.star6 = this.hat.getChild("star6");
        this.jin = this.all.getChild("jin");
        this.jin1 = this.jin.getChild("jin1");
        this.bone2 = this.jin1.getChild("bone2");
        this.bone3 = this.jin1.getChild("bone3");
        this.bone4 = this.jin1.getChild("bone4");
        this.bone5 = this.jin1.getChild("bone5");
        this.bone = this.jin.getChild("bone");
        this.leave5 = this.all.getChild("leave5");
        this.leave1 = this.leave5.getChild("leave1");
        this.leave2 = this.leave5.getChild("leave2");
        this.leave3 = this.leave5.getChild("leave3");
        this.leave4 = this.leave5.getChild("leave4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 67).addBox(0.0141F, 1.4167F, -4.0009F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(26, 67).addBox(0.0141F, 0.2667F, -4.0009F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(36, 56).addBox(0.0141F, 0.2667F, 4.0241F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(36, 56).addBox(0.0141F, 1.4167F, 4.0241F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(0, 18).addBox(-4.0F, -4.0F, -4.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0F)), PartPose.offset(-1.0F, -14.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 116).addBox(0.0F, -1.5F, -3.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.6F, 3.275F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 117).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-4.4293F, 1.6F, 4.2595F, 0.0F, 0.1745F, -0.3491F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(10, 117).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-4.1651F, 2.1F, -4.256F, 0.0F, -0.1745F, -0.3491F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 120).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4743F, 0.5F, 4.3416F, 0.0F, 0.2618F, -0.1745F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 120).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4743F, 0.5F, -4.3416F, 0.0F, -0.2618F, -0.1745F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 117).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.5F, 4.3599F, 4.233F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 114).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.5F, 4.3595F, -4.2339F, -0.1745F, 0.0F, 0.0F));

        PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create().texOffs(24, 46).addBox(-1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(98, 0).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(3.5F, 1.5F, 0.0F));

        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(26, 67).addBox(-1.75F, -1.25F, -4.0438F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(34, 33).addBox(-0.75F, -0.75F, -4.0688F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(34, 34).addBox(-0.75F, -0.75F, 4.0812F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(36, 57).addBox(-1.75F, -1.25F, 4.0313F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0F)), PartPose.offset(1.75F, -1.75F, -0.0063F));

        PartDefinition bone6 = head.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(1.436F, -4.5319F, 0.0F));

        PartDefinition cube_r8 = bone6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 114).addBox(-2.5F, -2.2F, -4.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition ye = head.addOrReplaceChild("ye", CubeListBuilder.create().texOffs(86, 30).addBox(-8.9064F, -0.6715F, -0.0079F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(94, 49).addBox(-7.9064F, 4.8285F, -1.5079F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(104, 30).addBox(-8.9064F, -0.6715F, -0.0079F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0F)), PartPose.offset(-2.0936F, 0.0715F, 0.0079F));

        PartDefinition cube_r9 = ye.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 64).addBox(-1.5F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.6408F, 4.0224F, -0.0079F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r10 = ye.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(14, 67).addBox(-4.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, 0F))
                .texOffs(16, 61).addBox(-4.0F, 1.5F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(16, 53).addBox(-4.5F, -4.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.7185F, 2.4928F, 4.3421F, 0.0879F, 0.151F, -1.0405F));

        PartDefinition cube_r11 = ye.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(14, 67).mirror().addBox(-4.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, 0F)).mirror(false)
                .texOffs(16, 61).addBox(-4.0F, 1.5F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(16, 53).addBox(-4.5F, -4.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.7185F, 2.4928F, -4.3079F, -0.0879F, -0.151F, -1.0405F));

        PartDefinition cube_r12 = ye.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(60, 63).addBox(-3.375F, -2.0612F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(97, 44).addBox(2.1441F, -2.0392F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, 1.9921F, 0.0F, 0.1745F, -0.1745F));

        PartDefinition cube_r13 = ye.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(64, 17).addBox(-2.8848F, 2.0236F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, 1.9921F, 0.139F, 0.1059F, 0.7491F));

        PartDefinition cube_r14 = ye.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(65, 28).addBox(-2.0987F, 1.2006F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F).extend(-0.125F, 0F, 0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, 1.9921F, -0.101F, 0.1426F, -0.794F));

        PartDefinition cube_r15 = ye.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(97, 44).mirror().addBox(2.1441F, -2.0392F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0F)).mirror(false)
                .texOffs(60, 63).addBox(-3.375F, -2.0612F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, -2.0079F, 0.0F, -0.1745F, -0.1745F));

        PartDefinition cube_r16 = ye.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(65, 28).addBox(-2.0987F, 1.2006F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F).extend(-0.125F, 0F, 0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, -2.0079F, 0.101F, -0.1426F, -0.794F));

        PartDefinition cube_r17 = ye.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(64, 17).addBox(-2.8848F, 2.0236F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.4437F, 1.7934F, -2.0079F, -0.139F, -0.1059F, 0.7491F));

        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(34, 61).addBox(-2.6167F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offset(7.6167F, 0.0F, 0.0F));

        PartDefinition qiang = mouth.addOrReplaceChild("qiang", CubeListBuilder.create(), PartPose.offset(2.0974F, 0.0167F, -0.0009F));

        PartDefinition cube_r18 = qiang.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 101).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 1.0035F, 0.0F, -2.3562F, 0.0F, 0.1309F));

        PartDefinition cube_r19 = qiang.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(9, 101).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, -1.0036F, 0.0F, -2.3562F, 0.0F, -0.1309F));

        PartDefinition cube_r20 = qiang.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(9, 101).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.3536F, -1.5708F, 0.1309F, 0.0F));

        PartDefinition cube_r21 = qiang.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(9, 105).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.3536F, -1.5708F, -0.1309F, 0.0F));

        PartDefinition mouth1 = mouth.addOrReplaceChild("mouth1", CubeListBuilder.create().texOffs(0, 53).addBox(-0.325F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.1F))
                .texOffs(58, 45).mirror().addBox(1.325F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0001F)).mirror(false), PartPose.offset(-0.1917F, 0.0F, 0.0F));

        PartDefinition cube_r22 = mouth1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(-3, 112).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.575F, 3.4F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r23 = mouth1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(-5, 112).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.475F, -3.35F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5574F, -4.3774F, -4.0919F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(34, 18).addBox(-5.3074F, -0.3774F, -5.0919F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(35, 33).addBox(0.1927F, -0.3774F, -5.0919F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F).extend(-0.25F, 0F, 0F))
                .texOffs(45, 101).addBox(-0.1573F, -0.3774F, -5.5919F, 7.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(-0.55F, 0.1F, -0.15F))
                .texOffs(36, 33).addBox(-7.5574F, 3.6226F, -5.0919F, 4.8F, 1.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(85, 75).addBox(-7.7824F, 3.6226F, -5.5919F, 5.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(0.125F, 0.1F, -0.15F)), PartPose.offsetAndRotation(-0.0583F, -3.0754F, -0.409F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r24 = hat.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(90, 101).addBox(-3.8959F, -1.0759F, -3.6828F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F).extend(-0.0628F, 0.1222F, -0.16F))
                .texOffs(35, 33).addBox(-3.9129F, -1.0944F, -3.1828F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F).extend(-0.0759F, 0.0094F, 0F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r25 = hat.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(74, 30).addBox(-2.9503F, 1.8971F, -2.9328F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F).extend(-0.25F, 0F, -0.25F))
                .texOffs(38, 74).addBox(-2.9503F, 5.9471F, -0.6828F, 3.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F))
                .texOffs(94, 12).addBox(-2.4503F, -0.4529F, -2.6828F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.25F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r26 = hat.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(66, 72).addBox(-2.4503F, 3.2746F, -1.3651F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F).extend(0F, -0.25F, -0.125F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, -0.48F, 0.0F, -0.3054F));

        PartDefinition cube_r27 = hat.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(26, 68).addBox(6.2406F, 3.5056F, -2.7692F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, 0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r28 = hat.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(26, 67).addBox(6.2406F, 0.6843F, 3.4459F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, -0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r29 = hat.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(26, 67).mirror().addBox(6.2406F, 3.5056F, -2.9692F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)).mirror(false), PartPose.offsetAndRotation(-0.2011F, 1.851F, -1.7917F, 0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r30 = hat.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(26, 67).addBox(0.0F, -0.625F, -1.5F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(3.9105F, -4.3896F, 1.2784F, -0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r31 = hat.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(27, 68).addBox(0.0F, -0.5F, -1.75F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(5.5107F, -2.8049F, 1.5915F, -0.5847F, 0.0F, 0.0F));

        PartDefinition cube_r32 = hat.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(26, 67).addBox(5.6132F, -3.3802F, 2.2645F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.1025F, 1.6747F, -2.3247F, 0.5847F, 0.0F, 0.0F));

        PartDefinition cube_r33 = hat.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 103).mirror().addBox(-1.2817F, -1.5298F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)).mirror(false), PartPose.offsetAndRotation(4.9201F, -1.6787F, 0.4081F, 0.0F, 0.0F, 0.6632F));

        PartDefinition cube_r34 = hat.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0669F, -0.9257F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.1204F, -4.0536F, 0.4081F, 0.0F, 0.0F, 1.0123F));

        PartDefinition cube_r35 = hat.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0559F, -1.0829F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6852F, -4.1516F, 0.4081F, 0.0F, 0.0F, 0.7679F));

        PartDefinition cube_r36 = hat.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0666F, -0.5578F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.7717F, -4.3015F, 0.4081F, 0.0F, 0.0F, 0.4887F));

        PartDefinition cube_r37 = hat.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.1938F, -4.2485F, 0.4081F, 0.0F, 0.0F, 0.7679F));

        PartDefinition cube_r38 = hat.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 106).addBox(-1.4728F, -0.6306F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.8952F, -1.961F, 0.4081F, 0.0F, 0.0F, 0.8378F));

        PartDefinition cube_r39 = hat.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 106).addBox(-0.0396F, -1.5384F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.5574F, 0.6226F, 0.4081F, 0.0F, 0.0F, 0.8378F));

        PartDefinition star1 = hat.addOrReplaceChild("star1", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, -4.1419F));

        PartDefinition cube_r40 = star1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r41 = star1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r42 = star1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r43 = star1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r44 = star1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r45 = star1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r46 = star1.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r47 = star1.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r48 = star1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r49 = star1.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r50 = star1.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r51 = star1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r52 = star1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r53 = star1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r54 = star1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star2 = hat.addOrReplaceChild("star2", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(0.2796F, -2.0959F, -4.1419F));

        PartDefinition cube_r55 = star2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r56 = star2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r57 = star2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r58 = star2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r59 = star2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r60 = star2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r61 = star2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r62 = star2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r63 = star2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r64 = star2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r65 = star2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r66 = star2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r67 = star2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r68 = star2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r69 = star2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star3 = hat.addOrReplaceChild("star3", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, -2.2419F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r70 = star3.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r71 = star3.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r72 = star3.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r73 = star3.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r74 = star3.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r75 = star3.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r76 = star3.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r77 = star3.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r78 = star3.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r79 = star3.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r80 = star3.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r81 = star3.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r82 = star3.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r83 = star3.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r84 = star3.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star4 = hat.addOrReplaceChild("star4", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, 3.0581F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r85 = star4.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r86 = star4.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r87 = star4.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r88 = star4.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r89 = star4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4241F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r90 = star4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r91 = star4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r92 = star4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r93 = star4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r94 = star4.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r95 = star4.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r96 = star4.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r97 = star4.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r98 = star4.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r99 = star4.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star5 = hat.addOrReplaceChild("star5", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-0.1203F, -2.0959F, 4.9331F));

        PartDefinition cube_r100 = star5.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r101 = star5.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r102 = star5.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r103 = star5.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r104 = star5.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r105 = star5.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r106 = star5.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r107 = star5.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r108 = star5.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r109 = star5.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r110 = star5.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r111 = star5.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r112 = star5.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r113 = star5.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r114 = star5.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star6 = hat.addOrReplaceChild("star6", CubeListBuilder.create().texOffs(27, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(27, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, 4.9581F));

        PartDefinition cube_r115 = star6.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r116 = star6.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(27, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r117 = star6.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r118 = star6.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r119 = star6.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r120 = star6.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r121 = star6.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r122 = star6.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r123 = star6.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r124 = star6.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r125 = star6.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r126 = star6.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(27, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r127 = star6.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(27, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r128 = star6.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(27, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r129 = star6.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(27, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition jin = all.addOrReplaceChild("jin", CubeListBuilder.create(), PartPose.offset(-0.2455F, -0.8291F, -0.0501F));

        PartDefinition jin1 = jin.addOrReplaceChild("jin1", CubeListBuilder.create().texOffs(0, 66).addBox(-2.5045F, -5.7732F, -1.5013F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0F)), PartPose.offset(0.25F, -2.3977F, 0.0513F));

        PartDefinition cube_r130 = jin1.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(0, 72).addBox(-1.9371F, 2.3655F, -1.4499F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-1.0075F, -5.4391F, -0.0513F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone2 = jin1.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-0.5443F, 0.015F, -0.0934F));

        PartDefinition cube_r131 = bone2.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(41, 82).addBox(-1.872F, 4.6993F, -1.4499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.7602F, -6.7572F, 0.041F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone3 = jin1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-0.5443F, 0.015F, -0.0934F));

        PartDefinition cube_r132 = bone3.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(41, 82).addBox(-1.872F, 4.6993F, -1.4499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.7602F, -6.7572F, 0.041F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone4 = jin1.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-0.5443F, 0.015F, -0.0934F));

        PartDefinition cube_r133 = bone4.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(41, 82).addBox(-1.872F, 4.6993F, -1.4499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.7602F, -6.7572F, 0.041F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone5 = jin1.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-0.5443F, 0.015F, -0.0934F));

        PartDefinition cube_r134 = bone5.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(41, 82).addBox(-1.872F, 4.6993F, -1.4499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.7602F, -6.7572F, 0.041F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone = jin.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(90, 114).addBox(-3.5F, -1.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0F)), PartPose.offset(-0.2545F, -8.1709F, 0.0501F));

        PartDefinition cube_r135 = bone.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(64, 59).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -3.2F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r136 = bone.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(64, 61).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 3.2F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r137 = bone.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(70, 51).addBox(0.0F, -1.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition leave5 = all.addOrReplaceChild("leave5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2943F, -0.0783F, 0.2009F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leave1 = leave5.addOrReplaceChild("leave1", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r138 = leave1.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(4, 99).addBox(-2.4082F, 5.864F, -0.4499F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(96, 45).addBox(-2.4082F, 7.864F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r139 = leave1.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(96, 38).addBox(7.7096F, 2.2198F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.113F, -8.4618F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition leave2 = leave5.addOrReplaceChild("leave2", CubeListBuilder.create(), PartPose.offset(-0.8F, 0.5F, -0.25F));

        PartDefinition cube_r140 = leave2.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(4, 93).addBox(1.0691F, 5.5642F, -3.5069F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(69, 10).addBox(-2.4309F, 7.5642F, -2.5069F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r141 = leave2.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(69, 15).addBox(-2.4309F, 2.7938F, -12.1885F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -9.4226F, -0.9063F, 0.5672F, 0.0F, 0.0F));

        PartDefinition leave3 = leave5.addOrReplaceChild("leave3", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r142 = leave3.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(10, 99).addBox(-1.5545F, 4.8196F, -0.4499F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(96, 59).addBox(-0.5545F, 6.8196F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r143 = leave3.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(96, 52).addBox(-10.8425F, 3.5446F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.866F, -8.5F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leave4 = leave5.addOrReplaceChild("leave4", CubeListBuilder.create(), PartPose.offset(0.2F, 0.5F, -0.25F));

        PartDefinition cube_r144 = leave4.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(69, 0).addBox(-3.4309F, 2.0957F, 7.484F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -9.4226F, 0.9063F, -0.6545F, 0.0F, 0.0F));

        PartDefinition cube_r145 = leave4.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(10, 93).addBox(0.0691F, 5.6066F, -2.4023F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(69, 5).addBox(-3.4309F, 7.6066F, -2.4023F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(EntitySuperPrimalGatlingPea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimation, PSGPModelAnimation.stand2, ageInTicks, 1.0F);
        this.animate(entity.shootAnimation, PSGPModelAnimation.shoot, ageInTicks, 1.0F);
        this.animate(entity.superAnimation, SGPAnimation.power2, ageInTicks, 1.0F);

        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}