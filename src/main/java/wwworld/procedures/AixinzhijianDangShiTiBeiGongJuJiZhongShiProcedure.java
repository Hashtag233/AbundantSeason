package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class AixinzhijianDangShiTiBeiGongJuJiZhongShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AixinzhijianDangShiTiBeiGongJuJiZhongShi!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (Math.random() < 0.28) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity)
						.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) + 2));
		}
	}
}
