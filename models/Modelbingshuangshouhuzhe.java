// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelbingshuangshouhuzhe extends EntityModel<Entity> {
	private final ModelRenderer quan;
	private final ModelRenderer up;
	private final ModelRenderer bone;
	private final ModelRenderer chest;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer head;
	private final ModelRenderer leftarm;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer rightarm;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer bottom;

	public Modelbingshuangshouhuzhe() {
		textureWidth = 128;
		textureHeight = 128;

		quan = new ModelRenderer(this);
		quan.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(quan, 0.0F, 1.5708F, 0.0F);

		up = new ModelRenderer(this);
		up.setRotationPoint(0.0F, 0.0F, 0.0F);
		quan.addChild(up);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 1.0F);
		up.addChild(bone);
		bone.setTextureOffset(31, 18).addBox(-7.0F, -13.0F, -8.0F, 0.0F, 1.0F, 14.0F, 0.0F, false);
		bone.setTextureOffset(26, 0).addBox(7.0F, -14.0F, -1.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(46, 27).addBox(-7.0F, -13.0F, -8.0F, 14.0F, 1.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(19, 34).addBox(7.0F, -13.0F, -8.0F, 0.0F, 1.0F, 14.0F, 0.0F, false);
		bone.setTextureOffset(46, 25).addBox(-7.0F, -13.0F, 6.0F, 14.0F, 1.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(34, 34).addBox(0.0F, -14.0F, -8.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(0, 35).addBox(0.0F, -14.0F, 6.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(0, 21).addBox(-7.0F, -14.0F, -2.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(2, 53).addBox(-2.0F, -12.0F, 5.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(25, 50).addBox(-2.0F, -12.0F, -9.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		up.addChild(chest);
		chest.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -6.0F, 6.0F, 7.0F, 13.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(12, 50).addBox(-2.0F, -12.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(46, 11).addBox(-3.0F, -20.0F, -2.0F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3054F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 5).addBox(-2.0F, -27.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3054F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -27.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(head);
		head.setTextureOffset(43, 46).addBox(-1.0F, -31.0F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, -24.0F, 8.0F);
		chest.addChild(leftarm);
		setRotationAngle(leftarm, 0.0F, 0.2182F, 1.3963F);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.8873F, 22.1867F, -7.9976F);
		leftarm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.2182F, 0.0F);
		cube_r4.setTextureOffset(26, 55).addBox(15.0F, -26.0F, 13.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.8873F, -2.8133F, 0.0024F);
		leftarm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.48F, 0.0F);
		cube_r5.setTextureOffset(26, 0).addBox(-1.694F, 0.0F, -1.0961F, 17.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.8873F, 22.1867F, -7.9976F);
		leftarm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.0436F, 0.0F);
		cube_r6.setTextureOffset(57, 46).addBox(13.0F, -24.0F, 13.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r6.setTextureOffset(0, 58).addBox(13.0F, -21.0F, 17.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.8873F, 22.1867F, -7.9976F);
		leftarm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.3491F, 0.0F);
		cube_r7.setTextureOffset(39, 56).addBox(17.0F, -23.0F, 13.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.8873F, 22.1867F, -7.9976F);
		leftarm.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.4363F, 0.0F);
		cube_r8.setTextureOffset(0, 48).addBox(17.0F, -25.0F, 11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(0.0F, -24.0F, -6.0F);
		chest.addChild(rightarm);
		setRotationAngle(rightarm, 0.0F, -0.2182F, 1.309F);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.455F, 22.5445F, 6.0448F);
		rightarm.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.4363F, 0.0F);
		cube_r9.setTextureOffset(46, 29).addBox(17.0F, -25.0F, -11.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.455F, -0.4555F, -0.9552F);
		rightarm.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.48F, 0.0F);
		cube_r10.setTextureOffset(0, 21).addBox(-1.2322F, -2.0F, -3.7909F, 17.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.455F, 22.5445F, 6.0448F);
		rightarm.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0436F, 0.0F);
		cube_r11.setTextureOffset(39, 11).addBox(12.0F, -21.0F, -17.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r11.setTextureOffset(52, 56).addBox(13.0F, -24.0F, -13.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.455F, 22.5445F, 6.0448F);
		rightarm.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.3927F, 0.0F);
		cube_r12.setTextureOffset(13, 55).addBox(17.0F, -23.0F, -12.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.455F, 22.5445F, 6.0448F);
		rightarm.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.2182F, 0.0F);
		cube_r13.setTextureOffset(0, 10).addBox(15.0F, -26.0F, -13.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bottom = new ModelRenderer(this);
		bottom.setRotationPoint(0.0F, -5.0F, 0.0F);
		quan.addChild(bottom);
		bottom.setTextureOffset(0, 32).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 10.0F, 0.0F, false);
		bottom.setTextureOffset(5, 32).addBox(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bottom.setTextureOffset(0, 32).addBox(5.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bottom.setTextureOffset(23, 32).addBox(-6.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bottom.setTextureOffset(27, 34).addBox(-6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bottom.setTextureOffset(34, 34).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 5.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		quan.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bottom.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}