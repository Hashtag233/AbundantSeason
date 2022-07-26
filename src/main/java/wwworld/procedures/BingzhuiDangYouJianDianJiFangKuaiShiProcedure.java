package wwworld.procedures;

import wwworld.item.BingzhuiItem;

import wwworld.block.SssmallbingzhuiblockBlock;
import wwworld.block.SmallbingzhuiblockBlock;
import wwworld.block.BigBingzhuiblockBlock;

import wwworld.WwworldMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class BingzhuiDangYouJianDianJiFangKuaiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				WwworldMod.LOGGER.warn("Failed to load dependency direction for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WwworldMod.LOGGER.warn("Failed to load dependency entity for procedure BingzhuiDangYouJianDianJiFangKuaiShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR)
				&& (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SssmallbingzhuiblockBlock.block
				&& direction == Direction.DOWN) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BigBingzhuiblockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SmallbingzhuiblockBlock.block.getDefaultState(), 3);
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(BingzhuiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR)
				&& (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmallbingzhuiblockBlock.block
				&& direction == Direction.DOWN) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BigBingzhuiblockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SmallbingzhuiblockBlock.block.getDefaultState(), 3);
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(BingzhuiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR) && direction == Direction.DOWN
				&& world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).isSolid()) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SssmallbingzhuiblockBlock.block.getDefaultState(), 3);
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(BingzhuiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		}
	}
}
