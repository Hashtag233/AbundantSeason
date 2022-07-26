package wwworld.procedures;

import wwworld.block.PutDongxue2Block;
import wwworld.block.Modcaveair2Block;
import wwworld.block.Modcaveair1Block;
import wwworld.block.JishiBlock;

import wwworld.WwworldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class PutDongxueGengXinYouXiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WwworldMod.LOGGER.warn("Failed to load dependency world for procedure PutDongxueGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WwworldMod.LOGGER.warn("Failed to load dependency x for procedure PutDongxueGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WwworldMod.LOGGER.warn("Failed to load dependency y for procedure PutDongxueGengXinYouXiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WwworldMod.LOGGER.warn("Failed to load dependency z for procedure PutDongxueGengXinYouXiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double zs = 0;
		double ys = 0;
		double xs = 0;
		zs = (-75);
		for (int index0 = 0; index0 < (int) (150); index0++) {
			xs = (-75);
			for (int index1 = 0; index1 < (int) (150); index1++) {
				ys = (-12);
				for (int index2 = 0; index2 < (int) (24); index2++) {
					ys = (ys + 1);
					if ((world.getBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)))).getBlock() == Blocks.CAVE_AIR) {
						if (Math.random() < 0.7) {
							world.setBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)),
									Modcaveair1Block.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x + xs), (int) (y + ys), (int) (z + zs)),
									Modcaveair2Block.block.getDefaultState(), 3);
						}
					}
				}
				xs = (xs + 1);
			}
			zs = (zs + 1);
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JishiBlock.block.getDefaultState(), 3);
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PutDongxue2Block.block.getDefaultState(), 3);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 2);
	}
}
