package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeDecorator;

public class BiomeTundra extends ExtrabiomeGenBase
{
    public BiomeTundra(int var1)
    {
        super(var1);
        this.b(3168901);
        this.a("Tundra");
        this.F = 0.0F;
        this.G = 0.0F;
        this.D = 0.0F;
        this.E = 0.2F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).flowersPerChunk(0).grassPerChunk(0).sandPerChunk(0, 0).build();
    }
}
