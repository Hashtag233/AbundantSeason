package wwworld.procedures;

import wwworld.entity.BaoZhaKuaiEntity;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collection;

public class HuoYanLongJuanFengDangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure HuoYanLongJuanFengDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure HuoYanLongJuanFengDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure HuoYanLongJuanFengDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure HuoYanLongJuanFengDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure HuoYanLongJuanFengDangShiTiGengXinKeShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.LEVITATION)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.LEVITATION);
			}
		}
		entity.getPersistentData().putDouble("start", (entity.getPersistentData().getDouble("start") + 1));
		if (entity.getPersistentData().getDouble("start") == 60) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (7 / 2d), y - (7 / 2d), z - (7 / 2d), x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (new Object() {
						int check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.LEVITATION)
										return effect.getDuration();
								}
							}
							return 0;
						}
					}.check(entityiterator) <= 45 || !(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.LEVITATION)
										return true;
								}
							}
							return false;
						}
					}.check(entityiterator))) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 50, (int) 5));
					}
					entityiterator.setFire((int) 5);
				}
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.NONE);
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (7 / 2d), y - (7 / 2d), z - (7 / 2d), x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 15);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 25);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 30);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 35);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 45);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 50);
					}
				}
			}
		}
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		if (entity.getPersistentData().getDouble("time") >= 400) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (7 / 2d), y - (7 / 2d), z - (7 / 2d), x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (new Object() {
						int check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.LEVITATION)
										return effect.getDuration();
								}
							}
							return 0;
						}
					}.check(entityiterator) <= 45 || !(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.LEVITATION)
										return true;
								}
							}
							return false;
						}
					}.check(entityiterator))) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 50, (int) 5));
					}
					entityiterator.setFire((int) 10);
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (7 / 2d), y - (7 / 2d), z - (7 / 2d), x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 15);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 25);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 30);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 35);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 45);
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
								entityiterator.rotationYaw = (float) ((entityiterator.rotationYaw + 10));
								entity.setRenderYawOffset(entity.rotationYaw);
								entity.prevRotationYaw = entity.rotationYaw;
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
									((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
									((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
								}
								entityiterator.rotationPitch = (float) (0);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 50);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("time") >= 600) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.NONE);
			}
		}
		if (entity.getPersistentData().getDouble("time") >= 500) {
			entity.getPersistentData().putDouble("time", 0);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BaoZhaKuaiEntity.CustomEntity(BaoZhaKuaiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 7), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BaoZhaKuaiEntity.CustomEntity(BaoZhaKuaiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 7), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BaoZhaKuaiEntity.CustomEntity(BaoZhaKuaiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 7), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BaoZhaKuaiEntity.CustomEntity(BaoZhaKuaiEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 7), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
