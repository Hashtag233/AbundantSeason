package wwworld.procedures;

import wwworld.item.ZongziItem;
import wwworld.item.ZhirejianItem;
import wwworld.item.LingguangkuijiaItem;
import wwworld.item.JudukuijiaItem;
import wwworld.item.GuangmingtoukuiItem;
import wwworld.item.AixinItem;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.function.Function;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Comparator;

public class ArmorAdvancementTriggerProcedure {
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
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure ArmorAdvancementTrigger!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure ArmorAdvancementTrigger!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure ArmorAdvancementTrigger!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure ArmorAdvancementTrigger!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure ArmorAdvancementTrigger!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double sxx = 0;
		double syy = 0;
		double szz = 0;
		boolean found = false;
		boolean found2 = false;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == LingguangkuijiaItem.helmet) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:wear_light_helmet"));
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
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
				.getItem() == JudukuijiaItem.body) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:wear_toxic_chestplate"));
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
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == GuangmingtoukuiItem.helmet
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
						.getItem() == GuangmingtoukuiItem.body) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:wear_light_chestplate"));
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
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == AixinItem.helmet
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
						.getItem() == AixinItem.body
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
						.getItem() == AixinItem.legs
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
						.getItem() == AixinItem.boots) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:wear_loving_chestplate"));
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
		if (((Entity) world
				.getEntitiesWithinAABB(ItemEntity.class,
						new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
			if ((new Object() {
				public ItemStack entityToItem(Entity _ent) {
					if (_ent instanceof ItemEntity) {
						return ((ItemEntity) _ent).getItem();
					}
					return ItemStack.EMPTY;
				}
			}.entityToItem(((Entity) world
					.getEntitiesWithinAABB(ItemEntity.class,
							new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))).getItem() == ZhirejianItem.block && ((Entity) world
							.getEntitiesWithinAABB(BoatEntity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
				sx = (-3);
				found = (false);
				for (int index0 = 0; index0 < (int) (7); index0++) {
					sy = (-3);
					for (int index1 = 0; index1 < (int) (7); index1++) {
						sz = (-3);
						for (int index2 = 0; index2 < (int) (7); index2++) {
							if ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == Blocks.WATER) {
								found = (true);
							}
							sz = (sz + 1);
						}
						sy = (sy + 1);
					}
					sx = (sx + 1);
				}
				if (found == true) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:cheng_chuan_reng_zhi_re_shuang_jian_jin_shui_zhong"));
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
		if (((Entity) world
				.getEntitiesWithinAABB(ItemEntity.class,
						new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
			if ((new Object() {
				public ItemStack entityToItem(Entity _ent) {
					if (_ent instanceof ItemEntity) {
						return ((ItemEntity) _ent).getItem();
					}
					return ItemStack.EMPTY;
				}
			}.entityToItem(((Entity) world
					.getEntitiesWithinAABB(ItemEntity.class,
							new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))).getItem() == ZongziItem.block && ((Entity) world
							.getEntitiesWithinAABB(BoatEntity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
				sxx = (-2);
				found2 = (false);
				for (int index3 = 0; index3 < (int) (5); index3++) {
					syy = (-2);
					for (int index4 = 0; index4 < (int) (5); index4++) {
						szz = (-2);
						for (int index5 = 0; index5 < (int) (5); index5++) {
							if ((world.getBlockState(new BlockPos((int) (x + sxx), (int) (y + syy), (int) (z + szz)))).getBlock() == Blocks.WATER) {
								found2 = (true);
							}
							szz = (szz + 1);
						}
						syy = (syy + 1);
					}
					sxx = (sxx + 1);
				}
				if (found2 == true) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:reng_zong_zi"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:sha_si_10_zhi_qi_e")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).qie10 >= 10) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:sha_si_10_zhi_qi_e"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:jisha_10zhilongjuanfeng")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).longjuanfeng10 >= 10) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:jisha_10zhilongjuanfeng"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:jisha_10zhiyezhu")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).yezhu20 >= 20) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:jisha_10zhiyezhu"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:dai_shang_qian_hai_hua_quan_zai_shui_zhong_dai_1_fen_zhong")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).qianhaihuaquan1200 >= 1200) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:dai_shang_qian_hai_hua_quan_zai_shui_zhong_dai_1_fen_zhong"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:shi_tu_bo_shu_zuan_di_3_ci")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).tuboshuzuandi3 >= 3) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:shi_tu_bo_shu_zuan_di_3_ci"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:ji_sha_20_zhi_ji_jing_guai")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).jijingguai20 >= 20) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:ji_sha_20_zhi_ji_jing_guai"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:cai_sui_40_ge_cui_bing")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).cuibing40 >= 40) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:cai_sui_40_ge_cui_bing"));
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
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("wwworld:wa_10_ci_dai_xue_de_kuang_shi_dui")))
						.isDone()
				: false)
				&& (entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).daixuedekuangshidui10 >= 10) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("wwworld:wa_10_ci_dai_xue_de_kuang_shi_dui"));
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
