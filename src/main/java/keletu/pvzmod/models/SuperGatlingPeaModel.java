package keletu.pvzmod.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySuperGatlingPea;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SuperGatlingPeaModel extends HierarchicalModel<EntitySuperGatlingPea> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PVZMod.MODID, "textures/entity/plant/super_gatling_pea.png"), "main");

    private final ModelPart root;
    private final ModelPart all;
    private final ModelPart head;
    private final ModelPart face;
    private final ModelPart eye;
    private final ModelPart ye;
    private final ModelPart mouth;
    private final ModelPart mouth1;
    private final ModelPart qiang;
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

    public SuperGatlingPeaModel(ModelPart root) {
        this.root = root;
        this.all = root.getChild("all");
        this.head = this.all.getChild("head");
        this.face = this.head.getChild("face");
        this.eye = this.head.getChild("eye");
        this.ye = this.head.getChild("ye");
        this.mouth = this.head.getChild("mouth");
        this.mouth1 = this.mouth.getChild("mouth1");
        this.qiang = this.mouth.getChild("qiang");
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

        PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 17).addBox(0.0141F, 1.4167F, 4.0241F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-4.0F, -4.0F, -4.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(45, 17).addBox(0.0141F, 0.2667F, -4.0009F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(45, 17).addBox(0.0141F, 1.4167F, -4.0009F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(42, 17).addBox(0.0141F, 0.2667F, 4.0241F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -14.0F, 0.0F));

        PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create().texOffs(24, 46).addBox(-1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(98, 0).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(3.5F, 1.5F, 0.0F));

        PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(26, 67).addBox(-1.75F, -1.25F, -4.0438F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(34, 33).addBox(-0.25F, -0.75F, -4.0688F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(34, 33).addBox(-0.25F, -0.75F, 4.0812F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(26, 67).addBox(-1.75F, -1.25F, 4.0313F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -1.75F, -0.0063F));

        PartDefinition ye = head.addOrReplaceChild("ye", CubeListBuilder.create().texOffs(16, 53).addBox(-8.9064F, -1.6715F, -0.0079F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(64, 28).addBox(-7.9064F, 3.8285F, -1.5079F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 65).addBox(-0.9144F, -1.684F, -1.5079F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 53).addBox(-8.9064F, -1.6715F, -0.0079F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0936F, 0.9715F, 0.0079F));

        PartDefinition cube_r1 = ye.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 64).addBox(-1.5F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6408F, 3.0224F, -0.0079F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r2 = ye.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 67).addBox(-4.0F, -1.0F, -1.5F, 0.0F, 2.5F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 61).addBox(-4.0F, 1.5F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 53).addBox(-4.5F, -4.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7185F, 1.4928F, 4.3421F, 0.0879F, 0.151F, -1.0405F));

        PartDefinition cube_r3 = ye.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 67).addBox(-4.0F, -1.0F, -1.5F, 0.0F, 2.5F, 3.0F, new CubeDeformation(0.0001F))
                .texOffs(16, 61).addBox(-4.0F, 1.5F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 53).addBox(-4.5F, -4.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7185F, 1.4928F, -4.3079F, -0.0879F, -0.151F, -1.0405F));

        PartDefinition cube_r4 = ye.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 63).addBox(-3.375F, -2.0612F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(14, 67).addBox(2.1441F, -2.0392F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, 1.9921F, 0.0F, 0.1745F, -0.1745F));

        PartDefinition cube_r5 = ye.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 17).addBox(-2.8848F, 2.0236F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, 1.9921F, 0.139F, 0.1059F, 0.7491F));

        PartDefinition cube_r6 = ye.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(64, 28).addBox(-1.9737F, 1.2006F, -1.5F, 3.75F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, 1.9921F, -0.101F, 0.1426F, -0.794F));

        PartDefinition cube_r7 = ye.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 67).addBox(2.1441F, -2.0392F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(60, 63).addBox(-3.375F, -2.0612F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, -2.0079F, 0.0F, -0.1745F, -0.1745F));

        PartDefinition cube_r8 = ye.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(64, 28).addBox(-1.9737F, 1.2006F, -1.5F, 3.75F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, -2.0079F, 0.101F, -0.1426F, -0.794F));

        PartDefinition cube_r9 = ye.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 17).addBox(-2.8848F, 2.0236F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4437F, 0.7934F, -2.0079F, -0.139F, -0.1059F, 0.7491F));

        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(34, 61).addBox(-2.6167F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.6167F, 0.0F, 0.0F));

        PartDefinition mouth1 = mouth.addOrReplaceChild("mouth1", CubeListBuilder.create().texOffs(0, 53).addBox(-0.325F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.1F))
                .texOffs(58, 45).addBox(1.325F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1917F, 0.0F, 0.0F));

        PartDefinition qiang = mouth.addOrReplaceChild("qiang", CubeListBuilder.create(), PartPose.offset(2.0974F, 0.0167F, -0.0009F));

        PartDefinition cube_r10 = qiang.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(9, 113).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 1.0035F, 0.0F, -2.3562F, 0.0F, 0.1309F));

        PartDefinition cube_r11 = qiang.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(9, 109).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -1.0036F, 0.0F, -2.3562F, 0.0F, -0.1309F));

        PartDefinition cube_r12 = qiang.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 109).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.3536F, -1.5708F, 0.1309F, 0.0F));

        PartDefinition cube_r13 = qiang.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(9, 101).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.3536F, -1.5708F, -0.1309F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5574F, -4.3774F, -4.0919F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(34, 18).addBox(-5.3074F, -0.3774F, -5.0919F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(0.4426F, -0.3774F, -5.0919F, 7.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(45, 101).addBox(0.4926F, -0.3774F, -5.5919F, 7.0F, 1.0F, 12.0F, new CubeDeformation(0.1F))
                .texOffs(36, 33).addBox(-7.5574F, 3.7826F, -5.0919F, 4.8F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(85, 75).addBox(-8.0074F, 3.8726F, -5.5919F, 5.05F, 1.0F, 12.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.093F, -3.2724F, -0.409F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r14 = hat.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(1, 34).addBox(-3.837F, -1.1036F, -3.1828F, 5.8483F, 1.0187F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(84, 101).addBox(-4.0488F, -1.1081F, -3.6828F, 6.0F, 1.0644F, 12.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r15 = hat.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(74, 30).addBox(-2.9503F, 1.8971F, -2.9328F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F))
                .texOffs(38, 74).addBox(-3.0753F, 5.822F, -0.6828F, 3.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F))
                .texOffs(95, 13).addBox(-2.4503F, -0.723F, -2.1828F, 2.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r16 = hat.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(66, 72).addBox(-2.4503F, 3.2745F, -1.2401F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.1025F, 1.851F, -1.9091F, -0.48F, 0.0F, -0.3054F));

        PartDefinition cube_r17 = hat.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(23, 70).addBox(6.2406F, 3.5056F, -2.7692F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, 0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r18 = hat.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(23, 70).addBox(6.2406F, 0.6843F, 3.4459F, 0.0F, 1.25F, 3.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-2.9525F, 1.851F, -1.9091F, -0.6545F, 0.0F, -1.5708F));

        PartDefinition cube_r19 = hat.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(23, 70).addBox(6.2406F, 3.5056F, -2.9692F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.2011F, 1.851F, -1.7917F, 0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r20 = hat.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(23, 70).addBox(0.0F, -0.625F, -1.5F, 0.0F, 1.2F, 3.2F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(3.9105F, -4.3896F, 1.2784F, -0.6109F, 0.0F, -1.5708F));

        PartDefinition cube_r21 = hat.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(23, 70).addBox(0.0F, -0.5F, -1.75F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(5.5107F, -2.8049F, 1.5915F, -0.5847F, 0.0F, 0.0F));

        PartDefinition cube_r22 = hat.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(25, 70).addBox(5.6132F, -3.3803F, 2.2645F, 0.0F, 1.0F, 3.25F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.1025F, 1.6747F, -2.3247F, 0.5847F, 0.0F, 0.0F));

        PartDefinition star1 = hat.addOrReplaceChild("star1", CubeListBuilder.create().texOffs(32, 72).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, -4.1419F));

        PartDefinition cube_r23 = star1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r24 = star1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(32, 72).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r25 = star1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r26 = star1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r27 = star1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r28 = star1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r29 = star1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r30 = star1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r31 = star1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r32 = star1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r33 = star1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r34 = star1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r35 = star1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r36 = star1.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r37 = star1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(32, 72).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star2 = hat.addOrReplaceChild("star2", CubeListBuilder.create().texOffs(31, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(31, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(0.2796F, -2.0959F, -4.1419F));

        PartDefinition cube_r38 = star2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(31, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r39 = star2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(31, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r40 = star2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(31, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r41 = star2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(31, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r42 = star2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(31, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r43 = star2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(31, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r44 = star2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(31, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r45 = star2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(31, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r46 = star2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(31, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r47 = star2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(31, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r48 = star2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(31, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r49 = star2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(31, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r50 = star2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(31, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r51 = star2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(31, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r52 = star2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(31, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star3 = hat.addOrReplaceChild("star3", CubeListBuilder.create().texOffs(33, 70).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(33, 70).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, -2.2419F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r53 = star3.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(33, 70).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r54 = star3.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(33, 70).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r55 = star3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(33, 70).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r56 = star3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(33, 70).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r57 = star3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(33, 70).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r58 = star3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(33, 70).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r59 = star3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(33, 70).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r60 = star3.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(33, 70).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r61 = star3.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(33, 70).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r62 = star3.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(33, 70).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r63 = star3.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(33, 70).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r64 = star3.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(33, 70).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r65 = star3.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(33, 70).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r66 = star3.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(33, 70).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r67 = star3.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(33, 70).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star4 = hat.addOrReplaceChild("star4", CubeListBuilder.create().texOffs(29, 72).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 72).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.9204F, -4.3959F, 3.0581F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r68 = star4.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(29, 72).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r69 = star4.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(29, 72).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r70 = star4.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(29, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r71 = star4.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(29, 72).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r72 = star4.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(29, 72).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r73 = star4.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(29, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r74 = star4.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(29, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r75 = star4.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(29, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r76 = star4.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(29, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r77 = star4.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(29, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r78 = star4.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(29, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r79 = star4.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(29, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r80 = star4.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(29, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r81 = star4.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(29, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r82 = star4.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(29, 72).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star5 = hat.addOrReplaceChild("star5", CubeListBuilder.create().texOffs(29, 71).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(29, 71).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-0.1204F, -2.0959F, 4.9331F));

        PartDefinition cube_r83 = star5.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(29, 71).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r84 = star5.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(29, 71).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r85 = star5.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(29, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r86 = star5.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(29, 71).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r87 = star5.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(29, 71).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r88 = star5.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(29, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r89 = star5.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(29, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r90 = star5.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(29, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r91 = star5.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(29, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r92 = star5.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(29, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r93 = star5.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(29, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r94 = star5.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(29, 71).addBox(-0.2896F, -0.2896F, -1.0F, 0.1564F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r95 = star5.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(29, 71).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r96 = star5.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(29, 71).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r97 = star5.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(29, 71).addBox(-0.275F, -0.3724F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition star6 = hat.addOrReplaceChild("star6", CubeListBuilder.create().texOffs(32, 72).addBox(-0.537F, -0.7469F, 0.0F, 1.0F, 1.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.737F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.937F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.263F, 0.4531F, 0.0F, 0.4F, 0.4F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.563F, 0.7531F, 0.0F, 0.3F, 0.3F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.237F, -1.5469F, 0.0F, 0.4F, 0.8F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-0.787F, -0.5219F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.713F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-1.287F, -0.5219F, 0.0F, 0.5F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(0.713F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F))
                .texOffs(32, 72).addBox(-1.087F, -0.3219F, 0.0F, 0.3F, 0.2F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offset(-4.1204F, -2.0959F, 4.9581F));

        PartDefinition cube_r98 = star6.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1442F, -0.3185F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r99 = star6.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(32, 72).addBox(0.0256F, -0.2771F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition cube_r100 = star6.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r101 = star6.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition cube_r102 = star6.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2518F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-1.4242F, -0.5549F, 1.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r103 = star6.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -1.7453F));

        PartDefinition cube_r104 = star6.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.8362F));

        PartDefinition cube_r105 = star6.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.8713F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.2253F));

        PartDefinition cube_r106 = star6.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.2253F));

        PartDefinition cube_r107 = star6.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, -2.9671F));

        PartDefinition cube_r108 = star6.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(0.7972F, 1.0739F, 1.0F, 0.0F, 0.0F, 2.8362F));

        PartDefinition cube_r109 = star6.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(32, 72).addBox(-0.2896F, -0.2896F, -1.0F, 0.1565F, 0.1565F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r110 = star6.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(32, 72).addBox(-0.1954F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r111 = star6.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(32, 72).addBox(-0.0546F, -0.2519F, -1.0F, 0.25F, 1.175F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(-0.037F, -1.5719F, 1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r112 = star6.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(32, 72).addBox(-0.275F, -0.3724F, -1.0F, 0.1564F, 0.1564F, 0.0F, new CubeDeformation(0.0001F)), PartPose.offsetAndRotation(1.2834F, -0.606F, 1.0F, 0.0F, 0.0F, 2.0508F));

        PartDefinition jin = all.addOrReplaceChild("jin", CubeListBuilder.create(), PartPose.offset(-0.2455F, -0.8291F, -0.0501F));

        PartDefinition jin1 = jin.addOrReplaceChild("jin1", CubeListBuilder.create().texOffs(0, 65).addBox(-2.0045F, -8.6709F, -0.9499F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 0.5F, 0.0F));

        PartDefinition cube_r113 = jin1.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(64, 20).addBox(-1.4371F, 2.3655F, -0.9499F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-1.0F, -8.25F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone2 = jin1.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-0.5443F, -2.8827F, -0.042F));

        PartDefinition cube_r114 = bone2.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(66, 12).addBox(-1.4371F, 4.3655F, -0.9499F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.4557F, -5.3673F, 0.042F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone3 = jin1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-0.5443F, -2.8827F, -0.042F));

        PartDefinition cube_r115 = bone3.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(66, 12).addBox(-1.4371F, 4.3655F, -0.9499F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.4557F, -5.3673F, 0.042F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone4 = jin1.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-0.5443F, -2.8827F, -0.042F));

        PartDefinition cube_r116 = bone4.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(66, 12).addBox(-1.4371F, 4.3655F, -0.9499F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.4557F, -5.3673F, 0.042F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone5 = jin1.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-0.5443F, -2.8827F, -0.042F));

        PartDefinition cube_r117 = bone5.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(66, 12).addBox(-1.4371F, 4.3655F, -0.9499F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.4557F, -5.3673F, 0.042F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bone = jin.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(58, 57).addBox(-2.5F, -1.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2545F, -8.1709F, 0.0501F));

        PartDefinition leave5 = all.addOrReplaceChild("leave5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2943F, -0.0783F, 0.4009F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leave1 = leave5.addOrReplaceChild("leave1", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r118 = leave1.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(78, 8).addBox(-2.4082F, 7.864F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r119 = leave1.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(0, 46).addBox(7.7096F, 2.2198F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.113F, -8.4618F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition leave2 = leave5.addOrReplaceChild("leave2", CubeListBuilder.create(), PartPose.offset(-0.8F, 0.5F, -0.25F));

        PartDefinition cube_r120 = leave2.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(58, 0).addBox(-2.4309F, 7.5642F, -2.5069F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r121 = leave2.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(42, 12).addBox(-2.4309F, 2.7938F, -12.1885F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.4226F, -0.9063F, 0.5672F, 0.0F, 0.0F));

        PartDefinition leave3 = leave5.addOrReplaceChild("leave3", CubeListBuilder.create(), PartPose.offset(0.3F, -0.5F, 0.25F));

        PartDefinition cube_r122 = leave3.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(90, 61).addBox(-0.5545F, 6.8196F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r123 = leave3.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(-4, 78).addBox(-10.8425F, 3.5446F, -3.9499F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.866F, -8.5F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leave4 = leave5.addOrReplaceChild("leave4", CubeListBuilder.create(), PartPose.offset(0.2F, 0.5F, -0.25F));

        PartDefinition cube_r124 = leave4.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(70, 48).addBox(-3.4309F, 2.0957F, 7.484F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.4226F, 0.9063F, -0.6545F, 0.0F, 0.0F));

        PartDefinition cube_r125 = leave4.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(92, 42).addBox(-3.4309F, 7.6066F, -2.4023F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(EntitySuperGatlingPea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimation, SuperGatlingPeaModelAnimation.stand, ageInTicks, 1.0F);
        this.animate(entity.shootAnimation, SuperGatlingPeaModelAnimation.shoot, ageInTicks, 1.0F);

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