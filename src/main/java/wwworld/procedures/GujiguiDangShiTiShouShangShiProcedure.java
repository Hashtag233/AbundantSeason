package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

public class GujiguiDangShiTiShouShangShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure GujiguiDangShiTiShouShangShi!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure GujiguiDangShiTiShouShangShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof PlayerEntity && !(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.GLOWING)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) && Math.random() < 0.4) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 80, (int) 0));
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 80, (int) 2));
		}
	}
}
