package wwworld.procedures;

import wwworld.particle.XuehuaParticle;

import wwworld.entity.BingshuangliehunEntity;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collection;

public class BingShuangShouHuZheDangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure BingShuangShouHuZheDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure BingShuangShouHuZheDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure BingShuangShouHuZheDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure BingShuangShouHuZheDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BingShuangShouHuZheDangShiTiGengXinKeShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		world.setBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), Blocks.PACKED_ICE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), Blocks.PACKED_ICE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), Blocks.PACKED_ICE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), Blocks.PACKED_ICE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), Blocks.PACKED_ICE.getDefaultState(), 3);
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.SLOWNESS)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
			}
		}
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.MINING_FATIGUE)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity)
					((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 3));
				if (entityiterator instanceof LivingEntity)
					((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 20, (int) 3));
			}
		}
		entity.getPersistentData().putDouble("start", (entity.getPersistentData().getDouble("start") + 1));
		if (!(((Entity) world
				.getEntitiesWithinAABB(BingshuangliehunEntity.CustomEntity.class,
						new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) && entity.getPersistentData().getDouble("start") == 100) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 3), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 3), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 3), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 3), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
		entity.getPersistentData().putDouble("bingshuangtime", (entity.getPersistentData().getDouble("bingshuangtime") + 1));
		if (!(((Entity) world
				.getEntitiesWithinAABB(BingshuangliehunEntity.CustomEntity.class,
						new AxisAlignedBB(x - (60 / 2d), y - (60 / 2d), z - (60 / 2d), x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) && entity.getPersistentData().getDouble("bingshuangtime") >= 600) {
			entity.getPersistentData().putDouble("bingshuangtime", 0);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 3), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 3), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 3), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new BingshuangliehunEntity.CustomEntity(BingshuangliehunEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 3), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
		entity.getPersistentData().putDouble("dong", (entity.getPersistentData().getDouble("dong") + 1));
		if (entity.getPersistentData().getDouble("dong") >= 340) {
			world.addParticle(XuehuaParticle.particle, (x + 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x + 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z - 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z - 1), 0, 1, 0);
		}
		if (entity.getPersistentData().getDouble("dong") >= 360) {
			world.addParticle(XuehuaParticle.particle, (x + 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x + 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z - 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z - 1), 0, 1, 0);
		}
		if (entity.getPersistentData().getDouble("dong") >= 380) {
			world.addParticle(XuehuaParticle.particle, (x + 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x + 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), y, z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, (x - 1), (y + 1), z, 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z + 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, y, (z - 1), 0, 1, 0);
			world.addParticle(XuehuaParticle.particle, x, (y + 1), (z - 1), 0, 1, 0);
		}
		if (entity.getPersistentData().getDouble("dong") >= 400) {
			entity.getPersistentData().putDouble("dong", 0);
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (9 / 2d), y - (9 / 2d), z - (9 / 2d), x + (9 / 2d), y + (9 / 2d), z + (9 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 10));
				}
			}
		}
	}
}
