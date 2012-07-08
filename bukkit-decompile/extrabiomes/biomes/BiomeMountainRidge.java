package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;

public class BiomeMountainRidge extends ExtrabiomeGenBase
{
    public BiomeMountainRidge(int var1)
    {
        super(var1);
        this.b(12874287);
        this.a("Mountain Ridge");
        this.F = BiomeBase.DESERT.F;
        this.G = BiomeBase.DESERT.G;
        this.D = 1.7F;
        this.E = 1.7F;
        this.disableRain();
        this.K.clear();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).grassPerChunk(0).build();
    }
}
