package extrabiomes.plugins.buildcraft;

import extrabiomes.plugins.PluginBuildCraft;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class OilPopulate
{
    public static void generateSurfaceDeposit(World var0, Random var1, int var2, int var3, int var4, int var5)
    {
        setOilWithProba(var0, var1, 1.0F, var2, var3, var4, true);
        int var6;

        for (var6 = 1; var6 <= var5; ++var6)
        {
            float var7 = (float)(var5 - var6 + 4) / (float)(var5 + 4);

            for (int var8 = -var6; var8 <= var6; ++var8)
            {
                setOilWithProba(var0, var1, var7, var2 + var8, var3, var4 + var6, false);
                setOilWithProba(var0, var1, var7, var2 + var8, var3, var4 - var6, false);
                setOilWithProba(var0, var1, var7, var2 + var6, var3, var4 + var8, false);
                setOilWithProba(var0, var1, var7, var2 - var6, var3, var4 + var8, false);
            }
        }

        for (var6 = var2 - var5; var6 <= var2 + var5; ++var6)
        {
            for (int var9 = var4 - var5; var9 <= var4 + var5; ++var9)
            {
                if (var0.getTypeId(var6, var3 - 1, var9) != PluginBuildCraft.oilStill.id && isOil(var0, var6 + 1, var3 - 1, var9) && isOil(var0, var6 - 1, var3 - 1, var9) && isOil(var0, var6, var3 - 1, var9 + 1) && isOil(var0, var6, var3 - 1, var9 - 1))
                {
                    setOilWithProba(var0, var1, 1.0F, var6, var3, var9, true);
                }
            }
        }
    }

    private static boolean isOil(World var0, int var1, int var2, int var3)
    {
        return var0.getTypeId(var1, var2, var3) == PluginBuildCraft.oilStill.id || var0.getTypeId(var1, var2, var3) == PluginBuildCraft.oilMoving.id;
    }

    public static void setOilWithProba(World var0, Random var1, float var2, int var3, int var4, int var5, boolean var6)
    {
        if (var1.nextFloat() <= var2 && var0.getTypeId(var3, var4 - 2, var5) != 0 || var6)
        {
            boolean var7 = false;

            for (int var8 = -1; var8 <= 1; ++var8)
            {
                if (isOil(var0, var3 + var8, var4 - 1, var5) || isOil(var0, var3 - var8, var4 - 1, var5) || isOil(var0, var3, var4 - 1, var5 + var8) || isOil(var0, var3, var4 - 1, var5 - var8))
                {
                    var7 = true;
                }
            }

            if (var7 || var6)
            {
                if (var0.getTypeId(var3, var4, var5) != Block.WATER.id && var0.getTypeId(var3, var4, var5) != Block.STATIONARY_WATER.id && !isOil(var0, var3, var4, var5))
                {
                    var0.setTypeId(var3, var4, var5, 0);
                }
                else
                {
                    var0.setTypeId(var3, var4, var5, PluginBuildCraft.oilStill.id);
                }

                var0.setTypeId(var3, var4 - 1, var5, PluginBuildCraft.oilStill.id);
            }
        }
    }
}
