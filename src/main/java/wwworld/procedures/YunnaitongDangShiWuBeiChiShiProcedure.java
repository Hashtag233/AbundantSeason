package wwworld.procedures;

import wwworld.potion.TengfeiPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class YunnaitongDangShiWuBeiChiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure YunnaitongDangShiWuBeiChiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(TengfeiPotionEffect.potion, (int) 600, (int) 0));
	}
}
