// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modellongjuanfengguai extends EntityModel<Entity> {
	private final ModelRenderer tou;
	private final ModelRenderer bb_main;

	public Modellongjuanfengguai() {
		textureWidth = 64;
		textureHeight = 64;

		tou = new ModelRenderer(this);
		tou.setRotationPoint(0.0F, 24.0F, 0.0F);
		tou.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-19.0F, -20.0F, -9.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-19.0F, -17.0F, 4.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(5.0F, -20.0F, -20.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-8.0F, -13.0F, -20.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(52, 0).addBox(-6.0F, -30.0F, -14.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(52, 0).addBox(4.0F, -30.0F, -14.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-8.0F, -26.0F, -20.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(14.0F, -13.0F, -8.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(21.0F, -22.0F, -8.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(14.0F, -13.0F, 12.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, 12.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-9.0F, -19.0F, 15.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(6.0F, -21.0F, 15.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(-5.0F, -21.0F, 22.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(14.0F, -26.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(0, 0).addBox(19.0F, -26.0F, 9.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(48, 20).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(40, 18).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(56, 29).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 20).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(24, 17).addBox(-5.0F, -17.0F, -5.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);
		bb_main.setTextureOffset(16, 16).addBox(-6.0F, -20.0F, -6.0F, 12.0F, 3.0F, 12.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 17).addBox(-7.0F, -23.0F, -7.0F, 14.0F, 3.0F, 14.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 16).addBox(-8.0F, -26.0F, -8.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 34).addBox(-11.0F, -32.0F, -11.0F, 23.0F, 6.0F, 24.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		tou.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.tou.rotateAngleY = f3 / (180F / (float) Math.PI);
	}
}