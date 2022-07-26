package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

public class SijishijiePlayerEntersDimensionProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure SijishijiePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure SijishijiePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure SijishijiePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure SijishijiePlayerEntersDimension!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(x, (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(x,
						(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z, _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
		if (WwworldModVariables.MapVariables.get(world).haveMadePortal == false) {
			WwworldModVariables.MapVariables.get(world).seasonsTelePointX = x;
			WwworldModVariables.MapVariables.get(world).syncData(world);
			WwworldModVariables.MapVariables.get(world).seasonsTelePointY = (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x,
					(int) z));
			WwworldModVariables.MapVariables.get(world).syncData(world);
			WwworldModVariables.MapVariables.get(world).seasonsTelePointZ = z;
			WwworldModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("wwworld", "seasons_portal"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world,
							new BlockPos((int) x, (int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
			WwworldModVariables.MapVariables.get(world).haveMadePortal = (true);
			WwworldModVariables.MapVariables.get(world).syncData(world);
		} else {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(WwworldModVariables.MapVariables.get(world).seasonsTelePointX,
						WwworldModVariables.MapVariables.get(world).seasonsTelePointY, WwworldModVariables.MapVariables.get(world).seasonsTelePointZ);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(WwworldModVariables.MapVariables.get(world).seasonsTelePointX,
							WwworldModVariables.MapVariables.get(world).seasonsTelePointY,
							WwworldModVariables.MapVariables.get(world).seasonsTelePointZ, _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
		}
		if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).givesijizhishu == false) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"give @s patchouli:guide_book{\"patchouli:book\" : \"wwworld:sijizhishu\"} 1");
				}
			}
			{
				boolean _setval = (true);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.givesijizhishu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (WwworldModVariables.MapVariables.get(world).GoSeasons == false && entity instanceof PlayerEntity) {
					WwworldModVariables.MapVariables.get(world).GoSeasons = (true);
					WwworldModVariables.MapVariables.get(world).syncData(world);
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), ("tellraw @s {\"text\":\"" + ""
													+ new TranslationTextComponent("chat.wwworld.guide_1").getString() + "\"}"));
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (!PatchouliCheckProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
														("tellraw @s {\"text\":\"" + ""
																+ new TranslationTextComponent("chat.wwworld.guide_check").getString()
																+ "\",\"color\":\"red\"" + "}"));
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 80);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 200);
	}
}
