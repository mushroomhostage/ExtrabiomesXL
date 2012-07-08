package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;

public class BiomeSnowRainforest extends BiomeTemporateRainforest
{
    public BiomeSnowRainforest(int var1)
    {
        super(var1);
        this.b(3375735);
        this.a("Snowy Rainforest");
        this.F = BiomeBase.TAIGA_HILLS.F;
        this.G = 1.3F;
        this.b();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(17).mushroomsPerChunk(2).grassPerChunk(16).build();
    }
}
