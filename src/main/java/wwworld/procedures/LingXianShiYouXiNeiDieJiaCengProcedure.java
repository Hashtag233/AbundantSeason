package wwworld.procedures;

import wwworld.WwworldModVariables;

import wwworld.WwworldMod;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class LingXianShiYouXiNeiDieJiaCengProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure LingXianShiYouXiNeiDieJiaCeng!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(WwworldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WwworldModVariables.PlayerVariables())).givelinghuntiao == true && !(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity))) {
			return true;
		}
		return false;
	}
}
