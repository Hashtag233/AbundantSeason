
package wwworld.world.biome;

import wwworld.block.FuxiuzhiniBlock;
import wwworld.block.FuxiucaofangkuaiBlock;

import wwworld.WwworldModElements;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;

@WwworldModElements.ModElement.Tag
public class GuihunsenlinBiome extends WwworldModElements.ModElement {
	public static Biome biome;

	public GuihunsenlinBiome(WwworldModElements instance) {
		super(instance, 865);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-13948117).setWaterColor(-14869476).setWaterFogColor(-15066855)
						.withSkyColor(-13948117).withFoliageColor(-14672097).withGrassColor(-14145496).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(FuxiucaofangkuaiBlock.block.getDefaultState(),
								FuxiuzhiniBlock.block.getDefaultState(), FuxiuzhiniBlock.block.getDefaultState())));
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.NONE).depth(0f).scale(0f).temperature(0.5f)
						.downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("wwworld:gui_hun_sen_ling"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
