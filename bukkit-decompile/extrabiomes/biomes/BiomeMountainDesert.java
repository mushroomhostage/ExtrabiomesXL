package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenDesertWell;

public class BiomeMountainDesert extends ExtrabiomeGenBase
{
    public BiomeMountainDesert(int var1)
    {
        super(var1);
        this.b(16421912);
        this.a("Mountainous Desert");
        this.F = BiomeBase.DESERT_HILLS.F;
        this.G = BiomeBase.DESERT_HILLS.G;
        this.D = 0.4F;
        this.E = 1.4F;
        this.A = (byte)Block.SAND.id;
        this.B = (byte)Block.SAND.id;
        this.K.clear();
        this.disableRain();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).deadBushPerChunk(2).reedsPerChunk(50).cactiPerChunk(10).build();
    }

    public void a(World var1, Random var2, int var3, int var4)
    {
        super.a(var1, var2, var3, var4);

        if (var2.nextInt(1000) == 0)
        {
            int var5 = var3 + var2.nextInt(16) + 8;
            int var6 = var4 + var2.nextInt(16) + 8;
            WorldGenDesertWell var7 = new WorldGenDesertWell();
            var7.a(var1, var2, var5, var1.getHighestBlockYAt(var5, var6) + 1, var6);
        }
    }
}
