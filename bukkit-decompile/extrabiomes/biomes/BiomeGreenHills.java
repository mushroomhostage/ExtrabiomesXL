package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;

public class BiomeGreenHills extends ExtrabiomeGenBase
{
    public BiomeGreenHills(int var1)
    {
        super(var1);
        this.b(6866036);
        this.a("Green Hills");
        this.F = BiomeBase.FOREST.F - 0.1F;
        this.G = BiomeBase.FOREST.G + 0.1F;
        this.D = 0.6F;
        this.E = 1.2F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(1).build();
    }
}
