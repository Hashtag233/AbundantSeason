package wwworld.procedures;

import wwworld.potion.TengfeiPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

public class FtengfeiAnXiaAnJianShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure FtengfeiAnXiaAnJianShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == TengfeiPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			entity.setMotion(0, 0.5, 0);
		}
	}
}
