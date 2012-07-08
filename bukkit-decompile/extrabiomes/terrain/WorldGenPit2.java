package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenPit2 extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.quickSand != null)
        {
            while (var1.isEmpty(var3, var4, var5) && var4 > 2)
            {
                --var4;
            }

            if (var1.getTypeId(var3, var4, var5) != Block.GRASS.id)
            {
                return false;
            }

            int var6;
            int var7;

            for (var6 = -2; var6 <= 2; ++var6)
            {
                for (var7 = -2; var7 <= 2; ++var7)
                {
                    if (var1.isEmpty(var3 + var6, var4 - 1, var5 + var7) && var1.isEmpty(var3 + var6, var4 - 2, var5 + var7))
                    {
                        return false;
                    }
                }
            }

            for (var6 = -1; var6 <= 1; ++var6)
            {
                for (var7 = -1; var7 <= 1; ++var7)
                {
                    for (int var8 = -2; var8 <= 0; ++var8)
                    {
                        var1.setRawTypeId(var3 + var6, var4 + var8, var5 + var7, ExtrabiomesBlock.quickSand.id);
                    }
                }
            }
        }

        return true;
    }
}
