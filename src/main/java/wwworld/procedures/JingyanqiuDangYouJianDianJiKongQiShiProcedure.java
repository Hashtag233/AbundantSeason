package wwworld.procedures;

import wwworld.item.JingyanqiuItem;

import wwworld.WwworldMod;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class JingyanqiuDangYouJianDianJiKongQiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure JingyanqiuDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).giveExperiencePoints((int) 10);
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(JingyanqiuItem.block);
			_setstack.setCount(
					(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount() - 1));
			((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}
