
package wwworld.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TengfeiPotionEffect {
	@ObjectHolder("wwworld:tengfei")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {
		public EffectCustom() {
			super(EffectType.BENEFICIAL, -1513240);
			setRegistryName("tengfei");
		}

		@Override
		public String getName() {
			return "effect.tengfei";
		}

		@Override
		public boolean isBeneficial() {
			return true;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
