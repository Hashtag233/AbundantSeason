package wwworld.procedures;

import wwworld.potion.QuhanPotionEffect;
import wwworld.potion.JieshuangPotionEffect;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class SetsProcedure {
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
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure Sets!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure Sets!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure Sets!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure Sets!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure Sets!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.SLOW_FALLING)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity) <= 15 || !(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.SLOW_FALLING)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("wwworld:zhui_luo_tian_kong"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 20, (int) 2));
		}
		if ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.SPEED)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity) <= 15 || !(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.SPEED)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("wwworld:zhui_luo_tian_kong"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 20, (int) 2));
		}
		if (!((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).sky_tick_say >= 400)) {
			{
				double _setval = ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new WwworldModVariables.PlayerVariables())).sky_tick_say + 1);
				entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sky_tick_say = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.getPosY() >= 90 && (new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == QuhanPotionEffect.potion)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity) <= 95 || !(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == QuhanPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("wwworld:han_chao_lin"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(JieshuangPotionEffect.potion, (int) 100, (int) 0));
			if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new WwworldModVariables.PlayerVariables())).sky_tick_say >= 400) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								("tellraw @s {\"text\":\"" + "" + new TranslationTextComponent("chat.wwworld.guide_sky").getString() + "\"}"));
					}
				}
				{
					double _setval = 0;
					entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sky_tick_say = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
