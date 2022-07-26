package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class LinghuntiaoDangMingLingBeiZhiXingShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure LinghuntiaoDangMingLingBeiZhiXingShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new WwworldModVariables.PlayerVariables())).linghun + 40);
			entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.linghun = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
