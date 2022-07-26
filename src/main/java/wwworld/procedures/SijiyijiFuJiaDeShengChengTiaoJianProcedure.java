package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class SijiyijiFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure SijiyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure SijiyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure SijiyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure SijiyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double num = 0;
		sx = (-3);
		found = (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			sy = 0;
			for (int index1 = 0; index1 < (int) (4); index1++) {
				sz = (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == Blocks.AIR) {
						num = (num + 1);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		if (num <= 2) {
			return true;
		}
		return false;
	}
}
