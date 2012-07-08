package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenRedwood extends WorldGenerator
{
    final int blockLeaf;
    final int metaLeaf;
    final int blockWood;
    final int metaWood;

    public WorldGenRedwood(boolean var1)
    {
        super(var1);
        this.blockLeaf = TerrainGenManager.blockRedwoodLeaves.id;
        this.metaLeaf = TerrainGenManager.metaRedwoodLeaves;
        this.blockWood = TerrainGenManager.blockRedwoodWood.id;
        this.metaWood = TerrainGenManager.metaRedwoodWood;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(30) + 32;
        int var7 = 1 + var2.nextInt(12);
        int var8 = var6 - var7;
        int var9 = 2 + var2.nextInt(6);

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            int var10 = var1.getTypeId(var3, var4 - 1, var5);

            if (TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var10)) && var4 < 256 - var6 - 1)
            {
                int var11;
                int var14;
                int var15;
                int var21;

                for (var11 = var4; var11 <= var4 + 1 + var6; ++var11)
                {
                    boolean var12 = true;

                    if (var11 - var4 < var7)
                    {
                        var21 = 0;
                    }
                    else
                    {
                        var21 = var9;
                    }

                    for (int var13 = var3 - var21; var13 <= var3 + var21; ++var13)
                    {
                        for (var14 = var5 - var21; var14 <= var5 + var21; ++var14)
                        {
                            if (var11 < 0 || var11 >= 256)
                            {
                                return false;
                            }

                            var15 = var1.getTypeId(var13, var11, var14);

                            if (Block.byId[var15] != null && Block.byId[var15].isLeaves(var1, var13, var11, var14))
                            {
                                return false;
                            }
                        }
                    }
                }

                var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
                var1.setRawTypeId(var3 - 1, var4 - 1, var5, Block.DIRT.id);
                var1.setRawTypeId(var3, var4 - 1, var5 - 1, Block.DIRT.id);
                var1.setRawTypeId(var3 - 1, var4 - 1, var5 - 1, Block.DIRT.id);
                var11 = var2.nextInt(2);
                var21 = 1;
                boolean var22 = false;
                int var16;

                for (var14 = 0; var14 <= var8; ++var14)
                {
                    var15 = var4 + var6 - var14;

                    for (var16 = var3 - var11; var16 <= var3 + var11; ++var16)
                    {
                        int var17 = var16 - var3;

                        for (int var18 = var5 - var11; var18 <= var5 + var11; ++var18)
                        {
                            int var19 = var18 - var5;
                            Block var20 = Block.byId[var1.getTypeId(var16, var15, var18)];

                            if ((Math.abs(var17) != var11 || Math.abs(var19) != var11 || var11 <= 0) && (var20 == null || var20.canBeReplacedByLeaves(var1, var16, var15, var18)))
                            {
                                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var16, var15, var18, this.blockLeaf, this.metaLeaf);
                                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var16 - 1, var15, var18, this.blockLeaf, this.metaLeaf);
                                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var16, var15, var18 - 1, this.blockLeaf, this.metaLeaf);
                                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var16 - 1, var15, var18 - 1, this.blockLeaf, this.metaLeaf);
                            }
                        }
                    }

                    if (var11 >= var21)
                    {
                        var11 = var22 ? 1 : 0;
                        var22 = true;
                        ++var21;

                        if (var21 > var9)
                        {
                            var21 = var9;
                        }
                    }
                    else
                    {
                        ++var11;
                    }
                }

                var14 = var2.nextInt(3);

                for (var15 = 0; var15 < var6 - var14; ++var15)
                {
                    var16 = var1.getTypeId(var3, var4 + var15, var5);

                    if (Block.byId[var16] == null || Block.byId[var16].isLeaves(var1, var3, var4 + var15, var5))
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3, var4 + var15, var5, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3, var4 + var15, var5, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3 - 1, var4 + var15, var5, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3, var4 + var15, var5 - 1, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3 - 1, var4 + var15, var5 - 1, this.blockWood, this.metaWood);
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
