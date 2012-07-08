package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeDecorator;

public class BiomeMeadow extends ExtrabiomeGenBase
{
    public BiomeMeadow(int var1)
    {
        super(var1);
        this.a("Meadow");
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).grassPerChunk(12).flowersPerChunk(9).build();
    }
}
