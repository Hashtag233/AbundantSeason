package wwworld.procedures;

import wwworld.item.ZhiliaoxiangnangItem;

import wwworld.WwworldMod;

import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class SZhiliaoyaoshuiijiDangShiWuBeiChiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure SZhiliaoyaoshuiijiDangShiWuBeiChiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 150, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(ZhiliaoxiangnangItem.block);
				_setstack.setCount(
						(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
	}
}
