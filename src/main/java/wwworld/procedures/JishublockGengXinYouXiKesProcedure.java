package wwworld.procedures;

import wwworld.block.ShengchengbingzhuiBlock;
import wwworld.block.JishiBlock;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class JishublockGengXinYouXiKesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure JishublockGengXinYouXiKes!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure JishublockGengXinYouXiKes!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure JishublockGengXinYouXiKes!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure JishublockGengXinYouXiKes!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double h = 0;
		for (int index0 = 0; index0 < (int) (100); index0++) {
			h = (h - 1);
			if ((world.getBlockState(new BlockPos((int) x, (int) ((y + h) - 1), (int) z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(new BlockPos((int) x, (int) (y + h), (int) z))).getBlock() == JishiBlock.block) {
				world.setBlockState(new BlockPos((int) x, (int) (y + h), (int) z), ShengchengbingzhuiBlock.block.getDefaultState(), 3);
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}