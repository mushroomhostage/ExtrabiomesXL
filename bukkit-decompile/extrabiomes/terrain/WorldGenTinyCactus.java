package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenTinyCactus extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.flower != null)
        {
            for (int var6 = 0; var6 < 10; ++var6)
            {
                int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);

                if (var1.isEmpty(var7, var8, var9))
                {
                    int var10 = 1 + var2.nextInt(var2.nextInt(3) + 1);

                    for (int var11 = 0; var11 < var10; ++var11)
                    {
                        if (var1.getTypeId(var7, var8 + var11 - 1, var9) == Block.SAND.id)
                        {
                            var1.setRawTypeIdAndData(var7, var8 + var11, var9, ExtrabiomesBlock.flower.id, 4);
                        }
                    }
                }
            }
        }

        return true;
    }
}
