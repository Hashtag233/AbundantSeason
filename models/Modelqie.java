// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelqie extends EntityModel<Entity> {
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer shentihaiyoutou;
	private final ModelRenderer lefthand;
	private final ModelRenderer righthand;
	private final ModelRenderer tou;

	public Modelqie() {
		textureWidth = 64;
		textureHeight = 64;

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.setTextureOffset(46, 22).addBox(-5.0F, -1.0F, -4.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightleg.setTextureOffset(46, 32).addBox(2.0F, -1.0F, -4.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		shentihaiyoutou = new ModelRenderer(this);
		shentihaiyoutou.setRotationPoint(0.0F, 24.0F, 0.0F);
		shentihaiyoutou.setTextureOffset(32, 46).addBox(-6.0F, -15.0F, -2.0F, 12.0F, 14.0F, 4.0F, 0.0F, false);
		shentihaiyoutou.setTextureOffset(56, 12).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(0.0F, 0.0F, 0.0F);
		shentihaiyoutou.addChild(lefthand);
		lefthand.setTextureOffset(28, 3).addBox(-7.0F, -15.0F, -2.0F, 1.0F, 15.0F, 4.0F, 0.0F, false);

		righthand = new ModelRenderer(this);
		righthand.setRotationPoint(0.0F, 0.0F, 0.0F);
		lefthand.addChild(righthand);
		righthand.setTextureOffset(4, 0).addBox(6.0F, -15.0F, -2.0F, 1.0F, 15.0F, 4.0F, 0.0F, false);

		tou = new ModelRenderer(this);
		tou.setRotationPoint(0.0F, 24.0F, 0.0F);
		tou.setTextureOffset(0, 30).addBox(-4.0F, -23.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		tou.setTextureOffset(56, 0).addBox(-1.0F, -19.0F, -6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		tou.setTextureOffset(54, 5).addBox(-1.0F, -18.0F, -7.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		shentihaiyoutou.render(matrixStack, buffer, packedLight, packedOverlay);
		tou.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.tou.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.tou.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}