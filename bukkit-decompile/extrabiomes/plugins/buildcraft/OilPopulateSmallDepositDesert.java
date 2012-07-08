package extrabiomes.plugins.buildcraft;

import extrabiomes.api.IBiomeDecoration;
import extrabiomes.plugins.PluginBuildCraft;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class OilPopulateSmallDepositDesert extends OilPopulate implements IBiomeDecoration
{
    public void decorate(World var1, Random var2, int var3, int var4)
    {
        if (PluginBuildCraft.modifyWorld)
        {
            if ((double)var2.nextFloat() > 0.97D)
            {
                int var5 = var2.nextInt(10) + 2;
                int var6 = var2.nextInt(10) + 2;

                for (int var7 = 128; var7 > 65; --var7)
                {
                    int var8 = var5 + var3;
                    int var9 = var6 + var4;

                    if (var1.getTypeId(var8, var7, var9) != 0)
                    {
                        if (var1.getTypeId(var8, var7, var9) == Block.SAND.id)
                        {
                            generateSurfaceDeposit(var1, var2, var8, var7, var9, 3);
                        }

                        break;
                    }
                }
            }
        }
    }
}
