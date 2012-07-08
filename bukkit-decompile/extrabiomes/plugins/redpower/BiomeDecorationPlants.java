package extrabiomes.plugins.redpower;

import extrabiomes.api.IBiomeDecoration;
import extrabiomes.plugins.PluginRedPower;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenFlowers;

public class BiomeDecorationPlants implements IBiomeDecoration
{
    private final int iterations;
    private static boolean generatePlants = true;

    public BiomeDecorationPlants()
    {
        this(1);
    }

    public BiomeDecorationPlants(int var1)
    {
        this.iterations = var1;
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        for (int var5 = 0; var5 < this.iterations; ++var5)
        {
            int var6 = var3 + var2.nextInt(16) + 8;
            int var7 = var2.nextInt(128);
            int var8 = var4 + var2.nextInt(16) + 8;
            (new WorldGenFlowers(PluginRedPower.idPlants)).a(var1, var2, var6, var7, var8);
        }
    }
}
