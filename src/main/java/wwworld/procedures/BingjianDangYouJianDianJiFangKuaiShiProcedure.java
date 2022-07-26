package wwworld.procedures;

import wwworld.particle.XuehuaParticle;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class BingjianDangYouJianDianJiFangKuaiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WwworldMod.LOGGER.warn("Failed to load dependency itemstack for procedure BingjianDangYouJianDianJiFangKuaiShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double distance = 0;
		world.addParticle(XuehuaParticle.particle, (x + 1), y, z, 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, (x - 1), y, z, 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, x, y, (z + 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, x, y, (z - 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, (x + 1), y, (z + 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, (x + 1), y, (z - 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, (x - 1), y, (z + 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, (x - 1), y, (z - 1), 0, 0, 0);
		world.addParticle(XuehuaParticle.particle, x, y, z, 0, 0, 0);
		entity.getPersistentData().putBoolean("eventEntity", (true));
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
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0,
																			entity.getLook(1f).z * 0),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) - (3 / 2d),
											y - (3 / 2d),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(
																	entity.getLook(1f).x * 0, entity.getLook(1f).y * 0, entity.getLook(1f).z * 0),
															RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()) - (3 / 2d),
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0,
																			entity.getLook(1f).z * 0),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) + (3 / 2d),
											y + (3 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0,
															entity.getLook(1f).z * 0),
													RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													+ (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0,
													entity.getLook(1f).z * 0),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									y,
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 0, entity.getLook(1f).y * 0,
													entity.getLook(1f).z * 0),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("eventEntity") == false) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 20);
							if (entityiterator instanceof LivingEntity)
								((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 5));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 1);
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
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																			entity.getLook(1f).z * 1),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) - (3 / 2d),
											y - (3 / 2d),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(
																	entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
															RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()) - (3 / 2d),
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																			entity.getLook(1f).z * 1),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) + (3 / 2d),
											y + (3 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
															entity.getLook(1f).z * 1),
													RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													+ (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
													entity.getLook(1f).z * 1),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									y,
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
													entity.getLook(1f).z * 1),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("eventEntity") == false) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 20);
							if (entityiterator instanceof LivingEntity)
								((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 5));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 2);
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
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
																			entity.getLook(1f).z * 2),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) - (3 / 2d),
											y - (3 / 2d),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(
																	entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
															RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()) - (3 / 2d),
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
																			entity.getLook(1f).z * 2),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) + (3 / 2d),
											y + (3 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
															entity.getLook(1f).z * 2),
													RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													+ (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									y,
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("eventEntity") == false) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 20);
							if (entityiterator instanceof LivingEntity)
								((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 5));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
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
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
																			entity.getLook(1f).z * 3),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) - (3 / 2d),
											y - (3 / 2d),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(
																	entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
															RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()) - (3 / 2d),
											(entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
																			entity.getLook(1f).z * 3),
																	RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) + (3 / 2d),
											y + (3 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
															entity.getLook(1f).z * 3),
													RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													+ (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
													entity.getLook(1f).z * 3),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									y,
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
													entity.getLook(1f).z * 3),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("eventEntity") == false) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 20);
							if (entityiterator instanceof LivingEntity)
								((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 5));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 8);
		{
			double _setval = (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX());
			entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.px = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
			entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.py = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
			entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.pz = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.setMotion(
				(((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WwworldModVariables.PlayerVariables())).px
						- entity.getPosX()) * 0.4),
				0.2,
				(((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WwworldModVariables.PlayerVariables())).pz
						- entity.getPosZ()) * 0.4));
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 400);
		}
	}
}
