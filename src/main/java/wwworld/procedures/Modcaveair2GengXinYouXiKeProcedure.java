package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Modcaveair2GengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Modcaveair2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Modcaveair2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Modcaveair2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Modcaveair2GengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double zsss = 0;
		double zsssss = 0;
		double ysss = 0;
		double xsss = 0;
		double yssss = 0;
		double xssss = 0;
		double xsssss = 0;
		double zssss = 0;
		double yss = 0;
		double zs = 0;
		double xss = 0;
		double ys = 0;
		double xs = 0;
		double zss = 0;
		double ysssss = 0;
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAVE_AIR.getDefaultState(), 3);
		zs = (-1);
		for (int index0 = 0; index0 < (int) (3); index0++) {
			xs = (-1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				ys = (-1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					ys = (ys + 1);
					if (BlockTags.getCollection().getTagByID(new ResourceLocation("wwworld:diaokefangkuai"))
							.contains((world.getBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)))).getBlock())) {
						world.setBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)), Blocks.CAVE_AIR.getDefaultState(), 3);
					}
				}
				xs = (xs + 1);
			}
			zs = (zs + 1);
		}
	}
}
