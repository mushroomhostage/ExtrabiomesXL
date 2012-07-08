package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenLeafPile extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.leafPile != null)
        {
            int var6;

            while (Block.byId[var6 = var1.getTypeId(var3, var4, var5)] == null || Block.byId[var6].isLeaves(var1, var3, var4, var5) && var4 > 0)
            {
                --var4;
            }

            for (int var7 = 0; var7 < 128; ++var7)
            {
                int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);

                if (var1.isEmpty(var8, var9, var10) && ExtrabiomesBlock.leafPile.f(var1, var8, var9, var10))
                {
                    var1.setRawTypeId(var8, var9, var10, ExtrabiomesBlock.leafPile.id);
                }
            }
        }

        return true;
    }
}
