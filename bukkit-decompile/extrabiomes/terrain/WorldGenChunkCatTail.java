package extrabiomes.terrain;

import extrabiomes.api.ExtrabiomesBlock;
import java.util.Random;
import net.minecraft.server.World;

public class WorldGenChunkCatTail extends WorldGenCatTail
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        if (ExtrabiomesBlock.catTail != null)
        {
            int var6 = var3 + var2.nextInt(16) + 8;
            int var7 = var2.nextInt(128);
            int var8 = var5 + var2.nextInt(16) + 8;
            return super.a(var1, var2, var6, var7, var8);
        }
        else
        {
            return true;
        }
    }
}
