package wwworld.procedures;

import wwworld.item.ChunjigushizhizhangItem;

import wwworld.entity.VineQueenEntity;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class TengwanjitanGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure TengwanjitanGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure TengwanjitanGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure TengwanjitanGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure TengwanjitanGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure TengwanjitanGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == ChunjigushizhizhangItem.block && !(new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "allow") == 1)) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("allow", 1);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(ChunjigushizhizhangItem.block);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) (y + 1), (int) z)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
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
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 2), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 2), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 2))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 2))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
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
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 5), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 5), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 5))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 5))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 57);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 8), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 8), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 8))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 8))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 71);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 11), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 11), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 11))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 11))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 82);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 14), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 14), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 14))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 14))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 90);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 5), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 5), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 5))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 5))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 130);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 3), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 3), (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 3))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 3))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 140);
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
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new VineQueenEntity.CustomEntity(VineQueenEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles((Math.ceil(x) + 0.5), y, (Math.ceil(z) + 0.5), world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 150);
		}
	}
}
