package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class LuweiFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure LuweiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure LuweiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure LuweiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure LuweiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 2), (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 2), (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) (z + 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) (z - 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 2), (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 2), (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) (z + 2)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) (z - 2)))).getBlock() == Blocks.WATER) {
			return true;
		}
		return false;
	}
}
