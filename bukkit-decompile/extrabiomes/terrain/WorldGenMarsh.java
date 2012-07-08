package extrabiomes.terrain;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Direction;
import net.minecraft.server.Facing;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenMarsh extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var3;
        int var7 = var5;

        for (int var8 = var4; var8 < 63; ++var8)
        {
            if (!var1.isEmpty(var6, var8, var7))
            {
                for (int var9 = 2; var9 <= 5; ++var9)
                {
                    if (Block.DIRT.canPlace(var1, var6, var8, var7, var9))
                    {
                        var1.setRawTypeIdAndData(var6, var8, var7, Block.GRASS.id, 1 << Direction.d[Facing.OPPOSITE_FACING[var9]]);
                        break;
                    }
                }
            }
            else
            {
                var6 = var3 + var2.nextInt(4) - var2.nextInt(4);
                var7 = var5 + var2.nextInt(4) - var2.nextInt(4);
            }
        }

        return true;
    }
}
