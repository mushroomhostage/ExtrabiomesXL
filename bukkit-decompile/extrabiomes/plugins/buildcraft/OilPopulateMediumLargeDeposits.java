package extrabiomes.plugins.buildcraft;

import extrabiomes.api.BiomeManager;
import extrabiomes.api.IBiomeDecoration;
import extrabiomes.plugins.PluginBuildCraft;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class OilPopulateMediumLargeDeposits extends OilPopulate implements IBiomeDecoration
{
    public void decorate(World var1, Random var2, int var3, int var4)
    {
        if (PluginBuildCraft.modifyWorld)
        {
            BiomeBase var5 = var1.getWorldChunkManager().getBiome(var3, var4);
            boolean var6 = var2.nextDouble() <= 0.0015D;
            boolean var7 = var2.nextDouble() <= (var5.id != BiomeManager.wasteland.id ? 0.005D : 0.02D) / 100.0D;

            if (var6 || var7)
            {
                int var8 = var3;
                int var9 = 20 + var2.nextInt(10);
                int var10 = var4;
                int var11 = 0;

                if (var7)
                {
                    var11 = 8 + var2.nextInt(9);
                }
                else if (var6)
                {
                    var11 = 4 + var2.nextInt(4);
                }

                int var12 = var11 * var11;
                int var14;
                int var15;
                int var16;

                for (int var13 = -var11; var13 <= var11; ++var13)
                {
                    for (var14 = -var11; var14 <= var11; ++var14)
                    {
                        for (var15 = -var11; var15 <= var11; ++var15)
                        {
                            var16 = var13 * var13 + var14 * var14 + var15 * var15;

                            if (var16 <= var12)
                            {
                                var1.setTypeId(var13 + var8, var14 + var9, var15 + var10, PluginBuildCraft.oilStill.id);
                            }
                        }
                    }
                }

                boolean var18 = false;

                for (var14 = 128; var14 >= var9; --var14)
                {
                    var15 = var1.getTypeId(var8, var14, var10);

                    if (!var18 && Block.byId[var15] != null && !Block.byId[var15].isLeaves(var1, var8, var14, var10) && !Block.byId[var15].isLeaves(var1, var8, var14, var10) && var15 != Block.GRASS.id)
                    {
                        var18 = true;

                        if (var7)
                        {
                            generateSurfaceDeposit(var1, var2, var8, var14, var10, 20 + var2.nextInt(20));
                        }
                        else if (var6)
                        {
                            generateSurfaceDeposit(var1, var2, var8, var14, var10, 5 + var2.nextInt(5));
                        }

                        var16 = 0;

                        if (var7)
                        {
                            var16 = var14 + 30 < 128 ? var14 + 30 : 128;
                        }
                        else if (var6)
                        {
                            var16 = var14 + 4 < 128 ? var14 + 4 : 128;
                        }

                        for (int var17 = var14 + 1; var17 <= var16; ++var17)
                        {
                            var1.setTypeId(var8, var17, var10, PluginBuildCraft.oilStill.id);
                        }
                    }
                    else if (var18)
                    {
                        var1.setTypeId(var8, var14, var10, PluginBuildCraft.oilStill.id);
                    }
                }
            }
        }
    }
}
