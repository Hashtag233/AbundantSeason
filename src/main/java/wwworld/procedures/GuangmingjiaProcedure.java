package wwworld.procedures;

import wwworld.item.GuangmingtoukuiItem;

import wwworld.WwworldMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GuangmingjiaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Guangmingjia!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
				.getItem() == GuangmingtoukuiItem.body) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1, (int) 1, (false), (false)));
		}
	}
}
