package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenCustomFlower extends WorldGenerator
{
    private int metadata;

    public WorldGenCustomFlower(int var1)
    {
        this.metadata = var1;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.flower != null)
        {
            int var6;

            while ((Block.byId[var6 = var1.getTypeId(var3, var4, var5)] == null || Block.byId[var6].isLeaves(var1, var3, var4, var5)) && var4 > 0)
            {
                --var4;
            }

            for (int var7 = 0; var7 < 128; ++var7)
            {
                int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);

                if (var1.isEmpty(var8, var9, var10) && ExtrabiomesBlock.flower.f(var1, var8, var9, var10))
                {
                    var1.setRawTypeIdAndData(var8, var9, var10, ExtrabiomesBlock.flower.id, this.metadata);
                }
            }
        }

        return true;
    }
}
