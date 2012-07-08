package extrabiomes.plugins.redpower;

import extrabiomes.api.IBiomeDecoration;
import extrabiomes.plugins.PluginRedPower;
import java.util.Random;
import net.minecraft.server.World;

public class BiomeDecorationRubberTrees implements IBiomeDecoration
{
    public void decorate(World var1, Random var2, int var3, int var4)
    {
        for (int var5 = 0; var5 < 6; ++var5)
        {
            int var6 = var3 + var2.nextInt(16) + 8;
            int var7 = var4 + var2.nextInt(16) + 8;
            int var8 = var1.getHighestBlockYAt(var6, var7);
            PluginRedPower.newWorldGenRubberTree().a(var1, var2, var6, var8, var7);
        }
    }
}
