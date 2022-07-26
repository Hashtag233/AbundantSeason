package wwworld;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class WwworldModVariables {
	public WwworldModVariables(WwworldModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "wwworld_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "wwworld_mapvars";
		public double surfaceTelePointX = 0;
		public double surfaceTelePointZ = 0;
		public double seasonsTelePointX = 0;
		public double seasonsTelePointZ = 0.0;
		public boolean haveMadePortal = false;
		public boolean GoSeasons = false;
		public double seasonsTelePointY = 0.0;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			surfaceTelePointX = nbt.getDouble("surfaceTelePointX");
			surfaceTelePointZ = nbt.getDouble("surfaceTelePointZ");
			seasonsTelePointX = nbt.getDouble("seasonsTelePointX");
			seasonsTelePointZ = nbt.getDouble("seasonsTelePointZ");
			haveMadePortal = nbt.getBoolean("haveMadePortal");
			GoSeasons = nbt.getBoolean("GoSeasons");
			seasonsTelePointY = nbt.getDouble("seasonsTelePointY");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("surfaceTelePointX", surfaceTelePointX);
			nbt.putDouble("surfaceTelePointZ", surfaceTelePointZ);
			nbt.putDouble("seasonsTelePointX", seasonsTelePointX);
			nbt.putDouble("seasonsTelePointZ", seasonsTelePointZ);
			nbt.putBoolean("haveMadePortal", haveMadePortal);
			nbt.putBoolean("GoSeasons", GoSeasons);
			nbt.putDouble("seasonsTelePointY", seasonsTelePointY);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("wwworld", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("leftSeasonsDimension", instance.leftSeasonsDimension);
			nbt.putBoolean("haveSeasonsBook", instance.haveSeasonsBook);
			nbt.putBoolean("isMedallionConferred", instance.isMedallionConferred);
			nbt.putDouble("px", instance.px);
			nbt.putDouble("py", instance.py);
			nbt.putDouble("pz", instance.pz);
			nbt.putBoolean("givebook", instance.givebook);
			nbt.putBoolean("yunguoguaijindu", instance.yunguoguaijindu);
			nbt.putBoolean("givesijizhishu", instance.givesijizhishu);
			nbt.putBoolean("goendseason", instance.goendseason);
			nbt.putBoolean("givelinghuntiao", instance.givelinghuntiao);
			nbt.putDouble("jianlinghun", instance.jianlinghun);
			nbt.putDouble("linghun", instance.linghun);
			nbt.putDouble("qie10", instance.qie10);
			nbt.putDouble("longjuanfeng10", instance.longjuanfeng10);
			nbt.putDouble("yezhu20", instance.yezhu20);
			nbt.putDouble("qianhaihuaquan1200", instance.qianhaihuaquan1200);
			nbt.putDouble("tuboshuzuandi3", instance.tuboshuzuandi3);
			nbt.putDouble("jijingguai20", instance.jijingguai20);
			nbt.putDouble("cuibing40", instance.cuibing40);
			nbt.putDouble("daixuedekuangshidui10", instance.daixuedekuangshidui10);
			nbt.putDouble("sky_tick_say", instance.sky_tick_say);
			nbt.putDouble("sky_say", instance.sky_say);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.leftSeasonsDimension = nbt.getBoolean("leftSeasonsDimension");
			instance.haveSeasonsBook = nbt.getBoolean("haveSeasonsBook");
			instance.isMedallionConferred = nbt.getBoolean("isMedallionConferred");
			instance.px = nbt.getDouble("px");
			instance.py = nbt.getDouble("py");
			instance.pz = nbt.getDouble("pz");
			instance.givebook = nbt.getBoolean("givebook");
			instance.yunguoguaijindu = nbt.getBoolean("yunguoguaijindu");
			instance.givesijizhishu = nbt.getBoolean("givesijizhishu");
			instance.goendseason = nbt.getBoolean("goendseason");
			instance.givelinghuntiao = nbt.getBoolean("givelinghuntiao");
			instance.jianlinghun = nbt.getDouble("jianlinghun");
			instance.linghun = nbt.getDouble("linghun");
			instance.qie10 = nbt.getDouble("qie10");
			instance.longjuanfeng10 = nbt.getDouble("longjuanfeng10");
			instance.yezhu20 = nbt.getDouble("yezhu20");
			instance.qianhaihuaquan1200 = nbt.getDouble("qianhaihuaquan1200");
			instance.tuboshuzuandi3 = nbt.getDouble("tuboshuzuandi3");
			instance.jijingguai20 = nbt.getDouble("jijingguai20");
			instance.cuibing40 = nbt.getDouble("cuibing40");
			instance.daixuedekuangshidui10 = nbt.getDouble("daixuedekuangshidui10");
			instance.sky_tick_say = nbt.getDouble("sky_tick_say");
			instance.sky_say = nbt.getDouble("sky_say");
		}
	}

	public static class PlayerVariables {
		public boolean leftSeasonsDimension = false;
		public boolean haveSeasonsBook = false;
		public boolean isMedallionConferred = false;
		public double px = 0;
		public double py = 0;
		public double pz = 0;
		public boolean givebook = false;
		public boolean yunguoguaijindu = false;
		public boolean givesijizhishu = false;
		public boolean goendseason = false;
		public boolean givelinghuntiao = false;
		public double jianlinghun = 0;
		public double linghun = 0;
		public double qie10 = 0;
		public double longjuanfeng10 = 0;
		public double yezhu20 = 0;
		public double qianhaihuaquan1200 = 0;
		public double tuboshuzuandi3 = 0;
		public double jijingguai20 = 0;
		public double cuibing40 = 0;
		public double daixuedekuangshidui10 = 0;
		public double sky_tick_say = 0;
		public double sky_say = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				WwworldMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.haveSeasonsBook = original.haveSeasonsBook;
		clone.px = original.px;
		clone.py = original.py;
		clone.pz = original.pz;
		clone.givebook = original.givebook;
		clone.givesijizhishu = original.givesijizhishu;
		clone.goendseason = original.goendseason;
		clone.givelinghuntiao = original.givelinghuntiao;
		clone.jianlinghun = original.jianlinghun;
		clone.linghun = original.linghun;
		clone.qie10 = original.qie10;
		clone.longjuanfeng10 = original.longjuanfeng10;
		clone.yezhu20 = original.yezhu20;
		clone.qianhaihuaquan1200 = original.qianhaihuaquan1200;
		clone.tuboshuzuandi3 = original.tuboshuzuandi3;
		clone.jijingguai20 = original.jijingguai20;
		clone.cuibing40 = original.cuibing40;
		clone.daixuedekuangshidui10 = original.daixuedekuangshidui10;
		clone.sky_tick_say = original.sky_tick_say;
		clone.sky_say = original.sky_say;
		if (!event.isWasDeath()) {
			clone.leftSeasonsDimension = original.leftSeasonsDimension;
			clone.isMedallionConferred = original.isMedallionConferred;
			clone.yunguoguaijindu = original.yunguoguaijindu;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.leftSeasonsDimension = message.data.leftSeasonsDimension;
					variables.haveSeasonsBook = message.data.haveSeasonsBook;
					variables.isMedallionConferred = message.data.isMedallionConferred;
					variables.px = message.data.px;
					variables.py = message.data.py;
					variables.pz = message.data.pz;
					variables.givebook = message.data.givebook;
					variables.yunguoguaijindu = message.data.yunguoguaijindu;
					variables.givesijizhishu = message.data.givesijizhishu;
					variables.goendseason = message.data.goendseason;
					variables.givelinghuntiao = message.data.givelinghuntiao;
					variables.jianlinghun = message.data.jianlinghun;
					variables.linghun = message.data.linghun;
					variables.qie10 = message.data.qie10;
					variables.longjuanfeng10 = message.data.longjuanfeng10;
					variables.yezhu20 = message.data.yezhu20;
					variables.qianhaihuaquan1200 = message.data.qianhaihuaquan1200;
					variables.tuboshuzuandi3 = message.data.tuboshuzuandi3;
					variables.jijingguai20 = message.data.jijingguai20;
					variables.cuibing40 = message.data.cuibing40;
					variables.daixuedekuangshidui10 = message.data.daixuedekuangshidui10;
					variables.sky_tick_say = message.data.sky_tick_say;
					variables.sky_say = message.data.sky_say;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
