package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class SijishijiePlayerLeavesDimensionProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure SijishijiePlayerLeavesDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (true);
			entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.leftSeasonsDimension = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
