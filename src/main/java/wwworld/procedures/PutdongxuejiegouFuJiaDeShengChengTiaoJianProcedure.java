package wwworld.procedures;

import wwworld.WwworldMod;

import java.util.Map;

public class PutdongxuejiegouFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure PutdongxuejiegouFuJiaDeShengChengTiaoJian!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		boolean found = false;
		double zs = 0;
		double ys = 0;
		double xs = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (y <= 35) {
			return true;
		}
		return false;
	}
}
