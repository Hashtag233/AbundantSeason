// Made with Blockbench 4.1.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelleech extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer neck_r1;
	private final ModelRenderer tail1;
	private final ModelRenderer tail1_r1;
	private final ModelRenderer head;
	private final ModelRenderer tail2;
	private final ModelRenderer tail2_r1;
	private final ModelRenderer tail2_r2;

	public Modelleech() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(26, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 22).addBox(-2.75F, -3.5F, 2.0F, 5.0F, 3.0F, 4.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 24.0F, 0.0F);
		neck.setTextureOffset(22, 12).addBox(-3.5F, -4.5F, -3.0F, 7.0F, 4.0F, 4.0F, 0.0F, false);

		neck_r1 = new ModelRenderer(this);
		neck_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		neck.addChild(neck_r1);
		setRotationAngle(neck_r1, 0.2618F, 0.0F, 0.0F);
		neck_r1.setTextureOffset(0, 0).addBox(-2.5F, -5.2247F, -4.7071F, 5.0F, 4.0F, 8.0F, 0.0F, false);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 24.0F, 0.0F);

		tail1_r1 = new ModelRenderer(this);
		tail1_r1.setRotationPoint(0.0F, -0.3294F, -0.0365F);
		tail1.addChild(tail1_r1);
		setRotationAngle(tail1_r1, -0.2618F, 0.0F, 0.0F);
		tail1_r1.setTextureOffset(0, 12).addBox(-2.5F, -5.8625F, 0.3598F, 5.0F, 4.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(44, 12).addBox(-2.25F, -4.0F, -8.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(18, 22).addBox(-1.25F, -0.75F, -8.5F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(34, 22).addBox(-1.25F, -4.75F, -8.25F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 29).addBox(1.75F, -3.25F, -8.25F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(14, 29).addBox(-3.25F, -3.25F, -8.25F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 24.0F, 0.0F);
		tail2.setTextureOffset(0, 37).addBox(-1.25F, -2.7098F, 10.5725F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		tail2_r1 = new ModelRenderer(this);
		tail2_r1.setRotationPoint(0.0F, 0.5655F, 1.9316F);
		tail2.addChild(tail2_r1);
		setRotationAngle(tail2_r1, -0.0873F, 0.0F, 0.0F);
		tail2_r1.setTextureOffset(28, 29).addBox(-1.5F, -4.5255F, 6.5405F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		tail2_r2 = new ModelRenderer(this);
		tail2_r2.setRotationPoint(0.0F, -0.362F, 1.9261F);
		tail2.addChild(tail2_r2);
		setRotationAngle(tail2_r2, -0.1745F, 0.0F, 0.0F);
		tail2_r2.setTextureOffset(38, 29).addBox(-1.75F, -4.4282F, 4.5708F, 3.0F, 3.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		tail1.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		tail2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}