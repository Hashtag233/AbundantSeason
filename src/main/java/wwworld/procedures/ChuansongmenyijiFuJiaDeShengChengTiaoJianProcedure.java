package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class ChuansongmenyijiFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure ChuansongmenyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure ChuansongmenyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure ChuansongmenyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure ChuansongmenyijiFuJiaDeShengChengTiaoJian!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double sxx = 0;
		double syy = 0;
		double szz = 0;
		sx = (-3);
		for (int index0 = 0; index0 < (int) (7); index0++) {
			sy = (-1);
			for (int index1 = 0; index1 < (int) (1); index1++) {
				sz = (-3);
				for (int index2 = 0; index2 < (int) (7); index2++) {
					if (!world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz))).isSolid()) {
						return false;
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		return true;
	}
}
