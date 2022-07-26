package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class ShizhongDangXiaoGuoJieShuShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure ShizhongDangXiaoGuoJieShuShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setNoGravity((false));
	}
}
