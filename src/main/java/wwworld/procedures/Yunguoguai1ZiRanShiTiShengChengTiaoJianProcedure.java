package wwworld.procedures;

import wwworld.WwworldMod;

import java.util.Map;

public class Yunguoguai1ZiRanShiTiShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Yunguoguai1ZiRanShiTiShengChengTiaoJian!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if (y >= 100) {
			return true;
		}
		return false;
	}
}
