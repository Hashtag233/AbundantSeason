package wwworld.procedures;

import wwworld.potion.QuhanPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class BinglajiaoDangShiWuBeiChiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BinglajiaoDangShiWuBeiChiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(QuhanPotionEffect.potion, (int) 1200, (int) 0));
	}
}
