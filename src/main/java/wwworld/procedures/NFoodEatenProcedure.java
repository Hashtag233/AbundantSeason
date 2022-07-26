package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class NFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure NFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() < 0.4) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) 2);
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) Math.random());
		}
	}
}
