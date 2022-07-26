package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

public class BoluoDangShengWuWanJiaYuZhiWuXiangZhuangShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BoluoDangShengWuWanJiaYuZhiWuXiangZhuangShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.POISON)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity) <= 75 || !(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.POISON)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 1));
		}
	}
}
