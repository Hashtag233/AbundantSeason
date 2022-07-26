// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelwuyunboss extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer right;
	private final ModelRenderer bone2;
	private final ModelRenderer left;

	public Modelwuyunboss() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-2.0F, 13.0F, 0.0F);
		bone.setTextureOffset(66, 0).addBox(-8.0F, -23.0F, -7.0F, 22.0F, 23.0F, 25.0F, 0.0F, false);
		bone.setTextureOffset(0, 59).addBox(-9.0F, -46.1F, -8.0F, 24.0F, 23.0F, 27.0F, 0.0F, false);

		right = new ModelRenderer(this);
		right.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(right);
		right.setTextureOffset(98, 48).addBox(-21.0F, -16.0F, -5.0F, 13.0F, 16.0F, 18.0F, 0.0F, false);
		right.setTextureOffset(50, 113).addBox(-28.0F, -22.0F, -2.0F, 7.0F, 15.0F, 11.0F, 0.0F, false);
		right.setTextureOffset(0, 31).addBox(-30.0F, -26.0F, -3.0F, 10.0F, 4.0F, 13.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		right.addChild(bone2);
		bone2.setTextureOffset(0, 0).addBox(-30.0F, -44.0F, -3.0F, 10.0F, 18.0F, 13.0F, 0.0F, false);

		left = new ModelRenderer(this);
		left.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(left);
		left.setTextureOffset(82, 89).addBox(14.0F, -15.0F, -5.0F, 18.0F, 15.0F, 20.0F, 0.0F, false);
		left.setTextureOffset(0, 0).addBox(32.0F, -11.0F, -29.0F, 8.0F, 9.0F, 50.0F, 0.0F, false);
		left.setTextureOffset(75, 69).addBox(42.0F, -9.0F, -11.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		left.setTextureOffset(0, 2).addBox(39.0F, -9.0F, -12.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 48).addBox(18.0F, -18.0F, 6.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(4, 4).addBox(17.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 4).addBox(28.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 0).addBox(39.0F, -9.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 109).addBox(30.0F, -13.0F, 17.0F, 11.0F, 12.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}