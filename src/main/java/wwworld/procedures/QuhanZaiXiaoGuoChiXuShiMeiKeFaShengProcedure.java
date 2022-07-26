package wwworld.procedures;

import wwworld.potion.JieshuangPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class QuhanZaiXiaoGuoChiXuShiMeiKeFaShengProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure QuhanZaiXiaoGuoChiXuShiMeiKeFaSheng!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(JieshuangPotionEffect.potion);
		}
	}
}
