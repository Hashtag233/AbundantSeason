package wwworld.procedures;

import wwworld.potion.ParalysisPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class LightningSwordLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure LightningSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() < 0.2) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(ParalysisPotionEffect.potion, (int) 40, (int) 0, (false), (false)));
		}
	}
}
