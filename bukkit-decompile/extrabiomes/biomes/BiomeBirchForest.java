package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;
import net.minecraft.server.WorldGenerator;

public class BiomeBirchForest extends ExtrabiomeGenBase
{
    public BiomeBirchForest(int var1)
    {
        super(var1);
        this.b(6471532);
        this.a("Birch Forest");
        this.F = 0.4F;
        this.G = 0.7F;
        this.D = 0.0F;
        this.E = 0.4F;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(7).grassPerChunk(1).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(100) == 0 ? (var1.nextInt(100) == 0 ? this.O : this.N) : this.P);
    }
}
