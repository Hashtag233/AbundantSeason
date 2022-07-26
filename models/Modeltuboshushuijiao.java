// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeltuboshushuijiao extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;

	public Modeltuboshushuijiao() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 28.0F, 0.0F);
		head.setTextureOffset(0, 23).addBox(-3.0F, -9.0F, -12.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(3.0F, -10.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, -10.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 39).addBox(-7.0F, -10.0F, -7.0F, 14.0F, 10.0F, 15.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(48, 25).addBox(-2.0F, -6.0F, 6.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}