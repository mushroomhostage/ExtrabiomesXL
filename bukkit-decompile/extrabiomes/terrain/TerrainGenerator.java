package extrabiomes.terrain;

import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.api.IBiomeDecoration;
import extrabiomes.biomes.ExtrabiomeGenBase;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.World;

public class TerrainGenerator
{
    protected static void applyDecorations(Collection var0, World var1, Random var2, int var3, int var4)
    {
        Iterator var5 = var0.iterator();

        while (var5.hasNext())
        {
            IBiomeDecoration var6 = (IBiomeDecoration)var5.next();
            var6.decorate(var1, var2, var3, var4);
        }
    }

    public static void generateSurface(World var0, Random var1, int var2, int var3)
    {
        BiomeBase var4 = var0.getWorldChunkManager().getBiome(var2, var3);
        Collection var5 = (Collection)BiomeDecorationsManager.biomeDecorations.get(var4);
        applyDecorations(var5, var0, var1, var2, var3);

        if (var4 instanceof ExtrabiomeGenBase)
        {
            applyDecorations(BiomeDecorationsManager.commonDecorations, var0, var1, var2, var3);
        }
    }
}
