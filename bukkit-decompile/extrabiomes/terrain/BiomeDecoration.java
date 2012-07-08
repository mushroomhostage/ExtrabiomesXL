package extrabiomes.terrain;

import extrabiomes.api.IBiomeDecoration;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class BiomeDecoration implements IBiomeDecoration
{
    public final int attempts;
    public final WorldGenerator worldGen;

    private BiomeDecoration()
    {
        this(0, (WorldGenerator)null);
    }

    public BiomeDecoration(int var1, WorldGenerator var2)
    {
        this.attempts = var1;
        this.worldGen = var2;
    }

    public BiomeDecoration(WorldGenerator var1)
    {
        this(1, var1);
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        for (int var5 = 0; var5 < this.attempts; ++var5)
        {
            this.worldGen.a(var1, var2, var3, 0, var4);
        }
    }
}
