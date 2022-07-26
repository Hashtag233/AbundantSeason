
package wwworld.block;

import wwworld.procedures.JingcicongGengXinYouXiKeProcedure;
import wwworld.procedures.JingcicongDangPiLinFangKuaiGengXinShiProcedure;
import wwworld.procedures.JiancicongMobplayerCollidesWithPlantProcedure;

import wwworld.itemgroup.ZhuangtshixingItemGroup;

import wwworld.WwworldModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.BooleanProperty;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import javax.annotation.Nullable;

import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@WwworldModElements.ModElement.Tag
public class JingcicongBlock extends WwworldModElements.ModElement {
	@ObjectHolder("wwworld:jingcicong")
	public static final Block block = null;
	@ObjectHolder("wwworld:jingcicong")
	public static final TileEntityType<CustomTileEntity> tileEntityType = null;

	public JingcicongBlock(WwworldModElements instance) {
		super(instance, 121);
		FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ZhuangtshixingItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	private static class TileEntityRegisterHandler {
		@SubscribeEvent
		public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("jingcicong"));
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block implements IWaterLoggable {
		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 3)
					.doesNotBlockMovement().notSolid().setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
					.setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
			setRegistryName("jingcicong");
		}

		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
			return this.getDefaultState().with(WATERLOGGED, flag);
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(WATERLOGGED);
		}

		@Override
		public FluidState getFluidState(BlockState state) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

		@Override
		public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(blockstate, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}

		@Override
		public void neighborChanged(BlockState blockstate, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
			super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) > 0) {
			} else {
			}

			JingcicongDangPiLinFangKuaiGengXinShiProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
			super.tick(blockstate, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			JingcicongGengXinYouXiKeProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}

		@Override
		public void onBlockClicked(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity) {
			super.onBlockClicked(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			JiancicongMobplayerCollidesWithPlantProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			JiancicongMobplayerCollidesWithPlantProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
		}

		@Override
		public boolean hasTileEntity(BlockState state) {
			return true;
		}

		@Override
		public TileEntity createTileEntity(BlockState state, IBlockReader world) {
			return new CustomTileEntity();
		}

		@Override
		public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, world, pos, eventID, eventParam);
			TileEntity tileentity = world.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
			if (state.getBlock() != newState.getBlock()) {
				TileEntity tileentity = world.getTileEntity(pos);
				if (tileentity instanceof CustomTileEntity) {
					InventoryHelper.dropInventoryItems(world, pos, (CustomTileEntity) tileentity);
					world.updateComparatorOutputLevel(pos, this);
				}

				super.onReplaced(state, world, pos, newState, isMoving);
			}
		}

		@Override
		public boolean hasComparatorInputOverride(BlockState state) {
			return true;
		}

		@Override
		public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof CustomTileEntity)
				return Container.calcRedstoneFromInventory((CustomTileEntity) tileentity);
			else
				return 0;
		}
	}

	public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {
		private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

		protected CustomTileEntity() {
			super(tileEntityType);
		}

		@Override
		public void read(BlockState blockState, CompoundNBT compound) {
			super.read(blockState, compound);
			if (!this.checkLootAndRead(compound)) {
				this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
			}
			ItemStackHelper.loadAllItems(compound, this.stacks);
		}

		@Override
		public CompoundNBT write(CompoundNBT compound) {
			super.write(compound);
			if (!this.checkLootAndWrite(compound)) {
				ItemStackHelper.saveAllItems(compound, this.stacks);
			}
			return compound;
		}

		@Override
		public SUpdateTileEntityPacket getUpdatePacket() {
			return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
		}

		@Override
		public CompoundNBT getUpdateTag() {
			return this.write(new CompoundNBT());
		}

		@Override
		public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
			this.read(this.getBlockState(), pkt.getNbtCompound());
		}

		@Override
		public int getSizeInventory() {
			return stacks.size();
		}

		@Override
		public boolean isEmpty() {
			for (ItemStack itemstack : this.stacks)
				if (!itemstack.isEmpty())
					return false;
			return true;
		}

		@Override
		public ITextComponent getDefaultName() {
			return new StringTextComponent("jingcicong");
		}

		@Override
		public int getInventoryStackLimit() {
			return 64;
		}

		@Override
		public Container createMenu(int id, PlayerInventory player) {
			return ChestContainer.createGeneric9X3(id, player, this);
		}

		@Override
		public ITextComponent getDisplayName() {
			return new StringTextComponent("Thorns");
		}

		@Override
		protected NonNullList<ItemStack> getItems() {
			return this.stacks;
		}

		@Override
		protected void setItems(NonNullList<ItemStack> stacks) {
			this.stacks = stacks;
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return true;
		}

		@Override
		public int[] getSlotsForFace(Direction side) {
			return IntStream.range(0, this.getSizeInventory()).toArray();
		}

		@Override
		public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
			return this.isItemValidForSlot(index, stack);
		}

		@Override
		public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
			return true;
		}

		private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
			if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				return handlers[facing.ordinal()].cast();
			return super.getCapability(capability, facing);
		}

		@Override
		public void remove() {
			super.remove();
			for (LazyOptional<? extends IItemHandler> handler : handlers)
				handler.invalidate();
		}
	}
}
