package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;

public class BiomeSnowForest extends ExtrabiomeGenBase
{
    public BiomeSnowForest(int var1)
    {
        super(var1);
        this.b(6006413);
        this.a("Snow Forest");
        this.F = BiomeBase.TAIGA_HILLS.F;
        this.G = BiomeBase.TAIGA_HILLS.G;
        this.D = 0.1F;
        this.E = 0.5F;
        this.b();
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(8).flowersPerChunk(1).grassPerChunk(4).build();
    }
}
