package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenGrass extends WorldGenerator
{
    final int metaToPlace;

    public WorldGenGrass(int var1)
    {
        this.metaToPlace = var1;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.grass != null)
        {
            int var6;

            while (Block.byId[var6 = var1.getTypeId(var3, var4, var5)] == null || Block.byId[var6].isLeaves(var1, var3, var4, var5) && var4 > 0)
            {
                --var4;
            }

            for (int var7 = 0; var7 < 4; ++var7)
            {
                int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
                int var12 = var1.getTypeId(var8, var9 - 1, var10);
                boolean var11;

                if (this.metaToPlace != 2 && this.metaToPlace != 3 && this.metaToPlace != 4)
                {
                    if (this.metaToPlace != 0 && this.metaToPlace != 1)
                    {
                        var11 = false;
                    }
                    else
                    {
                        var11 = var12 == TerrainGenManager.blockMountainRidge.id && var1.m(var8, var9, var10) >= 8 && var1.isChunkLoaded(var8, var9, var10);
                    }
                }
                else
                {
                    var11 = var12 == Block.SAND.id || var12 == TerrainGenManager.blockWasteland.id && var1.m(var8, var9, var10) >= 8 && var1.isChunkLoaded(var8, var9, var10);
                }

                if (var11 && var1.isEmpty(var8, var9, var10))
                {
                    var1.setRawTypeIdAndData(var8, var9, var10, ExtrabiomesBlock.grass.id, this.metaToPlace);
                }
            }
        }

        return true;
    }
}
