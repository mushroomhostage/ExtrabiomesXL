package extrabiomes.terrain;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import extrabiomes.api.TerrainGenManager;

public class WorldGenOasis extends WorldGenerator {
	private int avgRadius;

	public WorldGenOasis(int radius) {
		this.avgRadius = radius;
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {

		if (world.getBlockMaterial(x, y, z) != Material.water) {
			return false;
		}

		final int xzRadius = rand.nextInt(avgRadius - 2) + 2;
		final int yRadius = 2;

		for (int x1 = x - xzRadius; x1 <= x + xzRadius; x1++) {
			for (int z1 = z - xzRadius; z1 <= z + xzRadius; z1++) {
				final int a = x1 - x;
				final int b = z1 - z;

				if (a * a + b * b > xzRadius * xzRadius) {
					continue;
				}

				for (int y1 = y - yRadius; y1 <= y + yRadius; y1++) {
					int blocktoReplace = world.getBlockId(x1, y1, z1);

					if (blocktoReplace == Block.stone.blockID
							|| blocktoReplace == Block.sand.blockID
							|| blocktoReplace == Block.sandStone.blockID
							|| blocktoReplace == TerrainGenManager.blockMountainRidge.blockID) {
						world.setBlock(x1, y1, z1, Block.grass.blockID);
					}
				}
			}
		}

		return true;
	}
}
