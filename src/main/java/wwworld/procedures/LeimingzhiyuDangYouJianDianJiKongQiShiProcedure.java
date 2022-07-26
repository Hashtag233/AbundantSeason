package wwworld.procedures;

import wwworld.potion.ParalysisPotionEffect;

import wwworld.WwworldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class LeimingzhiyuDangYouJianDianJiKongQiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WwworldMod.LOGGER.warn("Failed to load dependency itemstack for procedure LeimingzhiyuDangYouJianDianJiKongQiShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double distance = 0;
		entity.getPersistentData().putDouble("lightningTime", 20);
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 6), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 9), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 12), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 15), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 18), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 6), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 9), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 12), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 15), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 18), (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 6))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 9))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 12))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 15))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 18))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 6))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 9))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 12))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 15))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 18))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		entity.getPersistentData().putBoolean("eventEntity", (true));
		{
			List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
					(entity.world
							.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f)
											.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
							.getPos().getX()) - (36 / 2d),
					y - (36 / 2d),
					(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
									entity.getLook(1f).z * distance),
							RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (36 / 2d),
					(entity.world
							.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f)
											.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity))
							.getPos().getX()) + (36 / 2d),
					y + (36 / 2d),
					(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
									entity.getLook(1f).z * distance),
							RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (36 / 2d)),
					null).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
							y,
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
					.collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getPersistentData().getBoolean("eventEntity") == false) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator)
								.addPotionEffect(new EffectInstance(ParalysisPotionEffect.potion, (int) 100, (int) 0, (true), (true)));
				}
			}
		}
		entity.getPersistentData().putBoolean("eventEntity", (false));
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 800);
		}
	}
}
