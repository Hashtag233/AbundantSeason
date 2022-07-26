package wwworld.procedures;

import wwworld.block.PlantRemoverTechBlockBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.Map;

public class PlantRemoverProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure PlantRemover!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure PlantRemover!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure PlantRemover!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure PlantRemover!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (-1);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			sy = (-1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				sz = (-1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:mushroom"))
							.contains((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)),
								PlantRemoverTechBlockBlock.block.getDefaultState(), 3);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
	}
}
