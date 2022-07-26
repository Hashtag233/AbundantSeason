package wwworld.procedures;

import wwworld.WwworldMod;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

public class FuxiushouweiDangShiTiShouShangShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure FuxiushouweiDangShiTiShouShangShi!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FuxiushouweiDangShiTiShouShangShi!");
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
		}.check(entity)) && Math.random() < 0.35) {
			sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		}
	}
}
