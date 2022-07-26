package wwworld.procedures;

import wwworld.item.QianHaiHuaQuanItem;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class PlayerJinduProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJindu!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == QianHaiHuaQuanItem.helmet
				&& entity.isInWater()
				&& !(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("wwworld:dai_shang_qian_hai_hua_quan_zai_shui_zhong_dai_1_fen_zhong")))
								.isDone()
						: false)) {
			{
				double _setval = ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).qianhaihuaquan1200 + 1);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.qianhaihuaquan1200 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
