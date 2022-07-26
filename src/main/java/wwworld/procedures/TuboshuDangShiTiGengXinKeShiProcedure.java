package wwworld.procedures;

import wwworld.entity.TuboshujiaoEntity;
import wwworld.entity.TuboshufatEntity;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class TuboshuDangShiTiGengXinKeShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure TuboshuDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure TuboshuDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure TuboshuDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure TuboshuDangShiTiGengXinKeShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure TuboshuDangShiTiGengXinKeShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double health = 0;
		double fangxiang = 0;
		double jiaodu = 0;
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("wwworld:han_chao_lin"))) {
			entity.getPersistentData().putDouble("zhangmao", (entity.getPersistentData().getDouble("zhangmao") + 1));
		} else {
			entity.getPersistentData().putDouble("zhangmao", 0);
		}
		if (entity.getPersistentData().getDouble("zhangmao") == 100) {
			if (!entity.world.isRemote())
				entity.remove();
			health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
			jiaodu = (entity.rotationPitch);
			fangxiang = (entity.rotationYaw);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new TuboshufatEntity.CustomEntity(TuboshufatEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
				entityToSpawn.setRenderYawOffset((float) fangxiang);
				entityToSpawn.setRotationYawHead((float) fangxiang);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(TuboshufatEntity.CustomEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity)
				((LivingEntity) ((Entity) world
						.getEntitiesWithinAABB(TuboshufatEntity.CustomEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).setHealth((float) health);
		}
		if (entity.getPersistentData().getDouble("kewa") == 1) {
			entity.getPersistentData().putDouble("wa", (entity.getPersistentData().getDouble("wa") + 1));
		}
		if (entity.getPersistentData().getDouble("wa") == 40) {
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
		}
		if (entity.getPersistentData().getDouble("wa") == 80) {
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
		}
		if (entity.getPersistentData().getDouble("wa") == 120) {
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
		}
		if (entity.getPersistentData().getDouble("wa") == 160) {
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
		}
		if (entity.getPersistentData().getDouble("wa") == 200) {
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) Math.floor(z)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)))).getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) + 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) + 1)), false);
			}
			if (!((world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1))))
					.getBlock() == Blocks.BEDROCK)) {
				world.destroyBlock(new BlockPos((int) (Math.floor(x) - 1), (int) (y - 1), (int) (Math.floor(z) - 1)), false);
			}
			entity.getPersistentData().putDouble("kewa", 0);
			entity.getPersistentData().putDouble("wa", 0);
		}
		if (!(entity.getPersistentData().getDouble("kewa") == 1) && Math.random() < 0.001) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"playsound wwworld:tuboshuzhenjiao ambient @a");
			}
			if (!entity.world.isRemote())
				entity.remove();
			health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
			jiaodu = (entity.rotationPitch);
			fangxiang = (entity.rotationYaw);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new TuboshujiaoEntity.CustomEntity(TuboshujiaoEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
				entityToSpawn.setRenderYawOffset((float) fangxiang);
				entityToSpawn.setRotationYawHead((float) fangxiang);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(TuboshujiaoEntity.CustomEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity)
				((LivingEntity) ((Entity) world
						.getEntitiesWithinAABB(TuboshujiaoEntity.CustomEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).setHealth((float) health);
		}
	}
}
