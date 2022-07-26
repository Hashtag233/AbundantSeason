// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelhuangjinjiboss extends EntityModel<Entity> {
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer shenti;
	private final ModelRenderer weiba;
	private final ModelRenderer tou;
	private final ModelRenderer cube_r1;
	private final ModelRenderer lefthand;
	private final ModelRenderer righthand;

	public Modelhuangjinjiboss() {
		textureWidth = 128;
		textureHeight = 128;

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.setTextureOffset(22, 32).addBox(-6.0F, -1.0F, -4.0F, 3.0F, 1.0F, 7.0F, 0.0F, false);
		leftleg.setTextureOffset(32, 49).addBox(-6.0F, -4.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightleg.setTextureOffset(32, 49).addBox(3.0F, -4.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 32).addBox(3.0F, -1.0F, -4.0F, 3.0F, 1.0F, 7.0F, 0.0F, false);

		shenti = new ModelRenderer(this);
		shenti.setRotationPoint(0.0F, 24.0F, 0.0F);
		shenti.setTextureOffset(0, 41).addBox(-8.0F, -25.0F, -1.0F, 16.0F, 21.0F, 7.0F, 0.0F, false);

		weiba = new ModelRenderer(this);
		weiba.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(weiba, 0.2182F, 0.0F, 0.0F);
		weiba.setTextureOffset(0, 28).addBox(-3.0F, -13.0F, 9.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		weiba.setTextureOffset(13, 23).addBox(1.0F, -13.0F, 10.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		weiba.setTextureOffset(28, 23).addBox(-1.0F, -13.0F, 10.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		weiba.setTextureOffset(49, 32).addBox(-3.0F, -13.0F, 10.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		tou = new ModelRenderer(this);
		tou.setRotationPoint(0.0F, -1.0F, 0.0F);
		tou.setTextureOffset(87, 1).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F, false);
		tou.setTextureOffset(98, 24).addBox(-1.0F, -11.0F, -5.0F, 2.0F, 2.0F, 13.0F, 0.0F, false);
		tou.setTextureOffset(118, 50).addBox(-1.0F, -16.0F, 0.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		tou.setTextureOffset(120, 61).addBox(-1.0F, -16.0F, 6.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		tou.setTextureOffset(120, 75).addBox(-1.0F, -16.0F, -5.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 25.0F, 0.0F);
		tou.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -28.0F, -8.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(8.0F, 2.0F, 2.0F);
		lefthand.setTextureOffset(99, 91).addBox(0.0F, -2.0F, -2.0F, 1.0F, 16.0F, 5.0F, 0.0F, true);

		righthand = new ModelRenderer(this);
		righthand.setRotationPoint(-8.0F, 3.0F, 2.0F);
		righthand.setTextureOffset(116, 90).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 16.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		shenti.render(matrixStack, buffer, packedLight, packedOverlay);
		weiba.render(matrixStack, buffer, packedLight, packedOverlay);
		tou.render(matrixStack, buffer, packedLight, packedOverlay);
		lefthand.render(matrixStack, buffer, packedLight, packedOverlay);
		righthand.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.lefthand.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.righthand.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.tou.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.tou.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}