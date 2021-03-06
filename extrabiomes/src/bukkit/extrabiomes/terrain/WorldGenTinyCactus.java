
package extrabiomes.terrain;

import java.util.Random;

import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.Block;
import extrabiomes.api.ExtrabiomesBlock;

public class WorldGenTinyCactus extends WorldGenerator {
	public WorldGenTinyCactus() {}

	public boolean a(World world, Random random, int i, int j, int k) {
		if (ExtrabiomesBlock.flower != null)
			for (int l = 0; l < 10; l++) {
				final int i1 = i + random.nextInt(8)
						- random.nextInt(8);
				final int j1 = j + random.nextInt(4)
						- random.nextInt(4);
				final int k1 = k + random.nextInt(8)
						- random.nextInt(8);

				if (!world.isEmpty(i1, j1, k1)) continue;

				final int l1 = 1 + random
						.nextInt(random.nextInt(3) + 1);

				for (int i2 = 0; i2 < l1; i2++)
					if (world.getTypeId(i1, j1 + i2 - 1, k1) == Block.SAND.id)
						world.setRawTypeIdAndData(i1, j1 + i2, k1,
								ExtrabiomesBlock.flower.id, 4);
			}

		return true;
	}
}
