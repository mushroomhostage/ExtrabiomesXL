package extrabiomes.terrain;

import java.util.Random;
import net.minecraft.server.World;

public class WorldGenChunkOasis extends WorldGenOasis
{
    public WorldGenChunkOasis()
    {
        super(7);
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var3 + var2.nextInt(16) + 8;
        int var7 = var5 + var2.nextInt(16) + 8;
        return super.a(var1, var2, var6, var1.g(var6, var7), var7);
    }
}
