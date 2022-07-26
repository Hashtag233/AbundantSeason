package wwworld.procedures;

import wwworld.block.Shuidao4Block;
import wwworld.block.Shuidao3Block;
import wwworld.block.Shuidao1Block;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class Shuidao2GengXinYouXiKesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Shuidao2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Shuidao2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Shuidao2GengXinYouXiKes!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Shuidao2GengXinYouXiKes!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Shuidao1Block.block)) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
		if (Math.random() < 0.001) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Shuidao3Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Shuidao4Block.block.getDefaultState(), 3);
		}
	}
}