package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;

public class BiomeWasteland extends ExtrabiomeGenBase
{
    public BiomeWasteland(int var1)
    {
        super(var1);
        this.b(10386497);
        this.a("Wasteland");
        this.F = BiomeBase.DESERT.F;
        this.G = BiomeBase.DESERT.G;
        this.D = 0.0F;
        this.E = 0.0F;
        this.H = 15761408;
        this.K.clear();
        this.disableRain();
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).deadBushPerChunk(3).build();
    }
}
