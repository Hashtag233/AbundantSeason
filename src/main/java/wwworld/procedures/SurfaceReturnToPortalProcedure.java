package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class SurfaceReturnToPortalProcedure {
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure SurfaceReturnToPortal!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure SurfaceReturnToPortal!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).leftSeasonsDimension == true) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(WwworldModVariables.MapVariables.get(world).surfaceTelePointX,
						(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
								(int) WwworldModVariables.MapVariables.get(world).surfaceTelePointX,
								(int) WwworldModVariables.MapVariables.get(world).surfaceTelePointZ) + 1),
						WwworldModVariables.MapVariables.get(world).surfaceTelePointZ);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(WwworldModVariables.MapVariables.get(world).surfaceTelePointX,
							(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
									(int) WwworldModVariables.MapVariables.get(world).surfaceTelePointX,
									(int) WwworldModVariables.MapVariables.get(world).surfaceTelePointZ) + 1),
							WwworldModVariables.MapVariables.get(world).surfaceTelePointZ, _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			{
				boolean _setval = (false);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.leftSeasonsDimension = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
