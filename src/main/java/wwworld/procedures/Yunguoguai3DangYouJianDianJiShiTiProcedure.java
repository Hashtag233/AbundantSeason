package wwworld.procedures;

import wwworld.item.YunnaitongItem;
import wwworld.item.FengzhijiaItem;

import wwworld.entity.Yunguoguai4Entity;
import wwworld.entity.Yunguoguai2Entity;

import wwworld.WwworldMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.function.Function;
import java.util.Map;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collection;

public class Yunguoguai3DangYouJianDianJiShiTiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				WwworldMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Yunguoguai3DangYouJianDianJiShiTi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double fangxiang = 0;
		double health = 0;
		double jiaodu = 0;
		if (!(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == FengzhijiaItem.helmet)
				&& ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.BUCKET) {
			if (!entity.world.isRemote())
				entity.remove();
			health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
			jiaodu = (entity.rotationPitch);
			fangxiang = (entity.rotationYaw);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new Yunguoguai4Entity.CustomEntity(Yunguoguai4Entity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
				entityToSpawn.setRenderYawOffset((float) fangxiang);
				entityToSpawn.setRotationYawHead((float) fangxiang);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(Yunguoguai4Entity.CustomEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity)
				((LivingEntity) ((Entity) world
						.getEntitiesWithinAABB(Yunguoguai4Entity.CustomEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).setHealth((float) health);
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(YunnaitongItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
			}
			if (!((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).abilities.isCreativeMode : false)) {
				if (sourceentity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET);
					_setstack.setCount(
							(int) ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getCount() - 1));
					((LivingEntity) sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (sourceentity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) sourceentity).inventory.markDirty();
				}
				if (sourceentity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("wwworld:gong_ji_bing_qu_nai"));
					AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == FengzhijiaItem.helmet || new Object() {
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
				}.check(sourceentity))
				&& ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.BUCKET) {
			if (!entity.world.isRemote())
				entity.remove();
			health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
			jiaodu = (entity.rotationPitch);
			fangxiang = (entity.rotationYaw);
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new Yunguoguai2Entity.CustomEntity(Yunguoguai2Entity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
				entityToSpawn.setRenderYawOffset((float) fangxiang);
				entityToSpawn.setRotationYawHead((float) fangxiang);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (((Entity) world
					.getEntitiesWithinAABB(Yunguoguai2Entity.CustomEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity)
				((LivingEntity) ((Entity) world
						.getEntitiesWithinAABB(Yunguoguai2Entity.CustomEntity.class,
								new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))).setHealth((float) health);
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(YunnaitongItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
			}
			if (!((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).abilities.isCreativeMode : false)) {
				if (sourceentity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET);
					_setstack.setCount(
							(int) ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getCount() - 1));
					((LivingEntity) sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (sourceentity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) sourceentity).inventory.markDirty();
				}
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation(
								"wwworld:zai_you_piao_fu_yao_shui_xiao_guo_huo_dai_shang_feng_mao_de_qing_kuang_xia_qu_yun_guo_guai_de_nai"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
