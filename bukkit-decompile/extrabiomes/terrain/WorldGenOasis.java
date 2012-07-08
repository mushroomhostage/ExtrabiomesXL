package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenOasis extends WorldGenerator
{
    private int avgRadius;

    public WorldGenOasis(int var1)
    {
        this.avgRadius = var1;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (var1.getMaterial(var3, var4, var5) != Material.WATER)
        {
            return false;
        }
        else
        {
            int var6 = var2.nextInt(this.avgRadius - 2) + 2;
            boolean var7 = true;

            for (int var8 = var3 - var6; var8 <= var3 + var6; ++var8)
            {
                for (int var9 = var5 - var6; var9 <= var5 + var6; ++var9)
                {
                    int var10 = var8 - var3;
                    int var11 = var9 - var5;

                    if (var10 * var10 + var11 * var11 <= var6 * var6)
                    {
                        for (int var12 = var4 - 2; var12 <= var4 + 2; ++var12)
                        {
                            int var13 = var1.getTypeId(var8, var12, var9);

                            if (var13 == Block.STONE.id || var13 == Block.SAND.id || var13 == Block.SANDSTONE.id || var13 == TerrainGenManager.blockMountainRidge.id)
                            {
                                var1.setRawTypeId(var8, var12, var9, Block.GRASS.id);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
