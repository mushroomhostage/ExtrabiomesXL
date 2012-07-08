package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenCatTail extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.catTail != null)
        {
            for (int var6 = 0; var6 < 20; ++var6)
            {
                int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
                int var8 = var4;
                int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);

                if (var1.isEmpty(var7, var4, var9) && (var1.getMaterial(var7 - 1, var4 - 1, var9) == Material.WATER || var1.getMaterial(var7 + 1, var4 - 1, var9) == Material.WATER || var1.getMaterial(var7, var4 - 1, var9 - 1) == Material.WATER || var1.getMaterial(var7, var4 - 1, var9 + 1) == Material.WATER))
                {
                    int var10 = 1 + var2.nextInt(var2.nextInt(1) + 1);

                    for (int var11 = 0; var11 < var10; ++var11)
                    {
                        if (ExtrabiomesBlock.catTail.f(var1, var7, var8 + var11, var9))
                        {
                            var1.setRawTypeId(var7, var8 + var11, var9, ExtrabiomesBlock.catTail.id);
                        }
                    }
                }
            }
        }

        return true;
    }
}
