package wwworld.procedures;

import java.util.Map;

public class SijizhihuaFuJiaDeShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (Math.random() < 0.1) {
			return true;
		}
		return false;
	}
}
