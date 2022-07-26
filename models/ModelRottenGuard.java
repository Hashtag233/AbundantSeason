// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelRottenGuard extends EntityModel<Entity> {
	private final ModelRenderer zuojianjia2;
	private final ModelRenderer youjianjia;
	private final ModelRenderer bb_main;

	public ModelRottenGuard() {
		textureWidth = 64;
		textureHeight = 64;

		zuojianjia2 = new ModelRenderer(this);
		zuojianjia2.setRotationPoint(20.0F, 5.0F, -3.0F);
		setRotationAngle(zuojianjia2, 0.0F, 0.0F, -0.2618F);
		zuojianjia2.setTextureOffset(52, 8).addBox(-14.0F, -5.0F, 5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		zuojianjia2.setTextureOffset(13, 49).addBox(-14.0F, -5.0F, 0.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		zuojianjia2.setTextureOffset(0, 34).addBox(-14.0F, 0.0F, 1.0F, 5.0F, 10.0F, 4.0F, 0.0F, false);
		zuojianjia2.setTextureOffset(19, 41).addBox(-14.0F, -6.0F, 0.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		zuojianjia2.setTextureOffset(38, 47).addBox(-9.0F, -5.0F, 0.0F, 1.0F, 5.0F, 6.0F, 0.0F, false);

		youjianjia = new ModelRenderer(this);
		youjianjia.setRotationPoint(21.0F, 6.0F, -3.0F);
		setRotationAngle(youjianjia, 0.0F, 0.0F, 0.2618F);
		youjianjia.setTextureOffset(0, 49).addBox(-31.0F, 5.0F, 5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		youjianjia.setTextureOffset(48, 28).addBox(-31.0F, 5.0F, 0.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		youjianjia.setTextureOffset(37, 13).addBox(-31.0F, 10.0F, 1.0F, 5.0F, 10.0F, 4.0F, 0.0F, false);
		youjianjia.setTextureOffset(33, 0).addBox(-32.0F, 4.0F, 0.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		youjianjia.setTextureOffset(42, 35).addBox(-32.0F, 5.0F, 0.0F, 1.0F, 5.0F, 6.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 17).addBox(-4.0F, -13.0F, -3.0F, 8.0F, 10.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-6.0F, -21.0F, -4.0F, 12.0F, 8.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 28).addBox(-3.0F, -27.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		zuojianjia2.render(matrixStack, buffer, packedLight, packedOverlay);
		youjianjia.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.zuojianjia2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.youjianjia.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}