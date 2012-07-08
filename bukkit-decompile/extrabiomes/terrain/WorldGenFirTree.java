package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenFirTree extends WorldGenerator
{
    final int blockLeaf;
    final int metaLeaf;
    final int blockWood;
    final int metaWood;

    public WorldGenFirTree(boolean var1)
    {
        super(var1);
        this.blockLeaf = TerrainGenManager.blockFirLeaves.id;
        this.metaLeaf = TerrainGenManager.metaFirLeaves;
        this.blockWood = TerrainGenManager.blockFirWood.id;
        this.metaWood = TerrainGenManager.metaFirWood;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var1.getTypeId(var3, var4 - 1, var5);
        int var7 = var2.nextInt(8) + 24;

        if (TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var6)) && var4 < 256 - var7 - 1)
        {
            if (var4 >= 1 && var4 + var7 + 1 <= 256)
            {
                int var8 = 1 + var2.nextInt(12);
                int var9 = 2 + var2.nextInt(6);
                int var10;
                int var13;
                int var14;
                int var20;

                for (var10 = var4; var10 <= var4 + 1 + var7; ++var10)
                {
                    if (var10 < 0 || var10 >= 256)
                    {
                        return false;
                    }

                    boolean var11 = true;

                    if (var10 - var4 < var8)
                    {
                        var20 = 0;
                    }
                    else
                    {
                        var20 = var9;
                    }

                    for (int var12 = var3 - var20; var12 <= var3 + var20; ++var12)
                    {
                        for (var13 = var5 - var20; var13 <= var5 + var20; ++var13)
                        {
                            var14 = var1.getTypeId(var12, var10, var13);

                            if (Block.byId[var14] != null && !Block.byId[var14].isLeaves(var1, var12, var10, var13))
                            {
                                return false;
                            }
                        }
                    }
                }

                var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
                var10 = var2.nextInt(2);
                var20 = 1;
                boolean var21 = false;
                int var15;

                for (var13 = 0; var13 <= var7 - var8; ++var13)
                {
                    var14 = var4 + var7 - var13;

                    for (var15 = var3 - var10; var15 <= var3 + var10; ++var15)
                    {
                        int var16 = var15 - var3;

                        for (int var17 = var5 - var10; var17 <= var5 + var10; ++var17)
                        {
                            int var18 = var17 - var5;
                            Block var19 = Block.byId[var1.getTypeId(var15, var14, var17)];

                            if ((Math.abs(var16) != var10 || Math.abs(var18) != var10 || var10 <= 0) && (var19 == null || var19.canBeReplacedByLeaves(var1, var15, var14, var17)))
                            {
                                this.setTypeAndData(var1, var15, var14, var17, this.blockLeaf, this.metaLeaf);
                            }
                        }
                    }

                    if (var10 >= var20)
                    {
                        var10 = var21 ? 1 : 0;
                        var21 = true;
                        ++var20;

                        if (var20 > var9)
                        {
                            var20 = var9;
                        }
                    }
                    else
                    {
                        ++var10;
                    }
                }

                var13 = var2.nextInt(3);

                for (var14 = 0; var14 < var7 - var13; ++var14)
                {
                    var15 = var1.getTypeId(var3, var4 + var14, var5);

                    if (Block.byId[var15] == null || Block.byId[var15].isLeaves(var1, var3, var4 + var14, var5))
                    {
                        this.setTypeAndData(var1, var3, var4 + var14, var5, this.blockWood, this.metaWood);
                    }
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
