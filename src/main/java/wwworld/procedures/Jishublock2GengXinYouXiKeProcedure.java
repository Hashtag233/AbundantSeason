package wwworld.procedures;

import wwworld.block.CuibingBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Jishublock2GengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Jishublock2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Jishublock2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Jishublock2GengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Jishublock2GengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean found = false;
		double sx = 0;
		double sz = 0;
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CuibingBlock.block.getDefaultState(), 3);
		sx = (-2);
		for (int index0 = 0; index0 < (int) (5); index0++) {
			sz = (-2);
			for (int index1 = 0; index1 < (int) (5); index1++) {
				if (Math.abs(sx * sz) != 4) {
					if ((world.getBlockState(new BlockPos((int) (x + sx), (int) y, (int) (z + sz)))).getBlock() == Blocks.WATER) {
						world.setBlockState(new BlockPos((int) (x + sx), (int) y, (int) (z + sz)), CuibingBlock.block.getDefaultState(), 3);
					}
				}
				sz = (sz + 1);
			}
			sx = (sx + 1);
		}
	}
}
