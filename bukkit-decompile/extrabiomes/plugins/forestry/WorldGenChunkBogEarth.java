package extrabiomes.plugins.forestry;

import java.util.Random;
import net.minecraft.server.World;

public class WorldGenChunkBogEarth extends WorldGenBogEarth
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < 10; ++var6)
        {
            int var7 = var3 + var2.nextInt(16) + 8;
            int var8 = var2.nextInt(256);
            int var9 = var5 + var2.nextInt(16) + 8;
            super.a(var1, var2, var7, var8, var9);
        }

        return true;
    }
}
