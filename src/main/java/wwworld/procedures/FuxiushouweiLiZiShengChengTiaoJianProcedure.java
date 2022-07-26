package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class FuxiushouweiLiZiShengChengTiaoJianProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure FuxiushouweiLiZiShengChengTiaoJian!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getHealth()
				: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.25) {
			return true;
		}
		return false;
	}
}
