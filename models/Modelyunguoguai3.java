// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelyunguoguai3 extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer piao;

	public Modelyunguoguai3() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 28.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);
		bone.setTextureOffset(81, 7).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(79, 2).addBox(3.0F, -26.0F, -3.0F, 1.0F, 5.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(79, 2).addBox(-4.0F, -26.0F, -3.0F, 1.0F, 5.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(40, 0).addBox(-3.0F, -25.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(97, 0).addBox(-2.0F, -22.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(2.0F, -21.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(2.0F, -21.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(-4.0F, -21.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(3.0F, -21.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(-4.0F, -21.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(-4.0F, -21.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(3.0F, -21.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(78, 16).addBox(-4.0F, -21.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(77, 0).addBox(-4.0F, -26.0F, 3.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-1.0F, 28.0F, 0.0F);
		setRotationAngle(bone2, 0.0F, 0.0F, 0.0F);
		bone2.setTextureOffset(7, 25).addBox(-8.0F, -17.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(1.0F, -16.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-1.0F, -18.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(3.0F, -13.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(2.0F, -14.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-4.0F, -13.0F, 6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-1.0F, -12.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-8.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(9.0F, -15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-8.0F, -13.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(0.0F, -18.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(3.0F, -15.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-3.0F, -12.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(9.0F, -13.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-8.0F, -13.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-7.0F, -18.0F, -6.0F, 1.0F, 9.0F, 10.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(8.0F, -18.0F, -6.0F, 1.0F, 9.0F, 10.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(9.0F, -18.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-1.0F, -17.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(1.0F, -18.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-2.0F, -12.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-1.0F, -11.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-4.0F, -19.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-5.0F, -13.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(4.0F, -13.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(6.0F, -19.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(5.0F, -12.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-4.0F, -11.0F, -8.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 25).addBox(-3.0F, -19.0F, -8.0F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 31).addBox(-2.0F, -7.0F, -3.0F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		bone2.setTextureOffset(0, 31).addBox(-4.0F, -8.0F, -6.0F, 10.0F, 1.0F, 11.0F, 0.0F, false);
		bone2.setTextureOffset(0, 31).addBox(-4.0F, -20.0F, -6.0F, 10.0F, 1.0F, 11.0F, 0.0F, false);
		bone2.setTextureOffset(30, 60).addBox(-6.0F, -19.0F, -7.0F, 14.0F, 11.0F, 13.0F, 0.0F, false);

		piao = new ModelRenderer(this);
		piao.setRotationPoint(0.0F, 31.0F, 0.0F);
		piao.setTextureOffset(0, 0).addBox(12.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-15.0F, -16.0F, -4.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-14.0F, -18.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-14.0F, -17.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-16.0F, -16.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-3.0F, -17.0F, 13.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-3.0F, -18.0F, 13.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-5.0F, -16.0F, 13.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(-3.0F, -16.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(0, 0).addBox(0.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(7, 25).addBox(14.0F, -17.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(7, 25).addBox(13.0F, -16.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(7, 25).addBox(13.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		piao.setTextureOffset(7, 25).addBox(15.0F, -15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		piao.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.piao.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone2.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone2.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.bone.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}