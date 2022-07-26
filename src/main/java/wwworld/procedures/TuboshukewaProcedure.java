package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class TuboshukewaProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Tuboshukewa!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity.getPersistentData().getDouble("kewa") == 1)) {
			return true;
		}
		return false;
	}
}
