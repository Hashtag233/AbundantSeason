package wwworld.procedures;

import wwworld.entity.XiaowuyunEntity;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;
import java.util.Collection;

public class WuYunbossDangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure WuYunbossDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure WuYunbossDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure WuYunbossDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure WuYunbossDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure WuYunbossDangShiTiGengXinKeShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("start", (entity.getPersistentData().getDouble("start") + 1));
		if (!(((Entity) world
				.getEntitiesWithinAABB(XiaowuyunEntity.CustomEntity.class,
						new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) && entity.getPersistentData().getDouble("start") == 100) {
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 4),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 4),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 4))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 4))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 7),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 7),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 7))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 10),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 10),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 10))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 10))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 13),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 13),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 13))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 13))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 16),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 16),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 16))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 16))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 19),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 19),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 19))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 19))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 30);
		}
		entity.getPersistentData().putDouble("wuyunboss", (entity.getPersistentData().getDouble("wuyunboss") + 1));
		if (!(((Entity) world
				.getEntitiesWithinAABB(XiaowuyunEntity.CustomEntity.class,
						new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) && entity.getPersistentData().getDouble("wuyunboss") >= 500) {
			entity.getPersistentData().putDouble("wuyunboss", 0);
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 4),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 4),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 4))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 4))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 7),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 7),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 7))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 7))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 10),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 10),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 10))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 10))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 13),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 13),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 13))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 13))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 16),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 16),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 16))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 16))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new XiaowuyunEntity.CustomEntity(XiaowuyunEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 19),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 19),
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) z)));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z + 19))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x,
								(int) (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), (int) (z - 19))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 30);
		}
		entity.getPersistentData().putDouble("mianyi", (entity.getPersistentData().getDouble("mianyi") + 1));
		if (entity.getPersistentData().getDouble("mianyi") >= 700) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 200, (int) 0, (false), (false)));
			entity.getPersistentData().putDouble("mianyi", 0);
		}
		if (new Object() {
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
		}.check(entity)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 9999, (false), (false)));
		}
	}
}
