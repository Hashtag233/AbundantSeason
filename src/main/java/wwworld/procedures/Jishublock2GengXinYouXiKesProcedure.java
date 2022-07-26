package wwworld.procedures;

import wwworld.block.FangzhicuibingBlock;
import wwworld.block.DongzhimuBlock;
import wwworld.block.CuibingBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Jishublock2GengXinYouXiKesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Jishublock2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Jishublock2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Jishublock2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Jishublock2GengXinYouXiKes!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double h = 0;
		for (int index0 = 0; index0 < (int) (200); index0++) {
			h = (h - 1);
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + h + 1), (int) z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(new BlockPos((int) x, (int) (y + h), (int) z))).getBlock() == Blocks.WATER) {
				world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), FangzhicuibingBlock.block.getDefaultState(), 3);
			}
		}
		if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == CuibingBlock.block
				|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == CuibingBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == CuibingBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == CuibingBlock.block) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FangzhicuibingBlock.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DongzhimuBlock.block.getDefaultState(), 3);
		}
	}
}
