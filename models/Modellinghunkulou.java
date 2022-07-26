// Made with Blockbench 4.1.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modellinghunkulou extends EntityModel<Entity> {
	private final ModelRenderer head;

	public Modellinghunkulou() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(-18.0F, 20.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(14.0F, 3.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(15.0F, 3.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(15.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(14.0F, 1.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(14.0F, -4.0F, -4.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(15.0F, -4.0F, 3.0F, 6.0F, 8.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(14.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(21.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(17.0F, 0.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(14.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(21.0F, 2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(21.0F, -4.0F, -3.0F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(14.0F, -4.0F, -3.0F, 1.0F, 8.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}