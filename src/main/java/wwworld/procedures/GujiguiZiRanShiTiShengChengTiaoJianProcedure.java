package wwworld.procedures;

import java.util.Map;

public class GujiguiZiRanShiTiShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (Math.random() < 0.01) {
			return true;
		}
		return false;
	}
}
