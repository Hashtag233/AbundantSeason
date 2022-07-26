
package wwworld.entity;

import wwworld.procedures.LiulangguiDangShiTiShouShangShiProcedure;
import wwworld.procedures.GujiguiZiRanShiTiShengChengTiaoJianProcedure;
import wwworld.procedures.GujiguiDangShiTiBeiShaSiShiProcedure;
import wwworld.procedures.FuxiushouweiLiZiShengChengTiaoJianProcedure;

import wwworld.particle.LinghunParticle;

import wwworld.itemgroup.DddItemGroup;

import wwworld.entity.renderer.LiulangguiRenderer;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class LiulangguiEntity extends WwworldModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(1.2f, 0.5f)).build("liulanggui").setRegistryName("liulanggui");

	public LiulangguiEntity(WwworldModElements instance) {
		super(instance, 315);
		FMLJavaModLoadingContext.get().getModEventBus().register(new LiulangguiRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -10066330, -16696546, new Item.Properties().group(DddItemGroup.tab))
				.setRegistryName("liulanggui_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("wwworld:gui_hun_sen_ling").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(entity, 20, 1, 1));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					return GujiguiZiRanShiTiShengChengTiaoJianProcedure.executeProcedure(Collections.EMPTY_MAP);
				});
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.29);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 16);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();

			LiulangguiDangShiTiShouShangShiProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.WITHER)
				return false;
			if (source.getDamageType().equals("witherSkull"))
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;

			GujiguiDangShiTiBeiShaSiShiProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (FuxiushouweiLiZiShengChengTiaoJianProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				for (int l = 0; l < 4; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(LinghunParticle.particle, d0, d1, d2, d3, d4, d5);
				}
		}
	}
}
