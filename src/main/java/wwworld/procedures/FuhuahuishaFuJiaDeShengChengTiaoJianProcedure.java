package wwworld.procedures;

import wwworld.WwworldMod;

import java.util.Map;

public class FuhuahuishaFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure FuhuahuishaFuJiaDeShengChengTiaoJian!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if (y >= 70) {
			return true;
		}
		return false;
	}
}
