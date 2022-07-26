// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rotation;
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r1;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r2;
	private final ModelRenderer right_wing;
	private final ModelRenderer left_wing;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.setTextureOffset(50, 40).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F, true);
		head.setTextureOffset(52, 10).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(56, 16).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(2.0F, 19.0F, 1.0F);
		right_leg.setTextureOffset(4, 24).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(0, 17).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_leg.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 3).addBox(-1.0F, 5.0F, -1.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(-1.0F, 19.0F, 1.0F);
		left_leg.setTextureOffset(0, 24).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		left_leg.setTextureOffset(0, 14).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(3.0F, 0.0F, 0.0F);
		left_leg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-1.0F, 5.0F, 2.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(-3.0F, 13.0F, 0.0F);
		right_wing.setTextureOffset(14, 14).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(3.0F, 13.0F, 0.0F);
		left_wing.setTextureOffset(0, 14).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_wing.render(matrixStack, buffer, packedLight, packedOverlay);
		left_wing.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}