package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;
import net.minecraft.server.WorldGenTaiga1;
import net.minecraft.server.WorldGenTaiga2;
import net.minecraft.server.WorldGenerator;

public class BiomeMountainTaiga extends ExtrabiomeGenBase
{
    public BiomeMountainTaiga(int var1)
    {
        super(var1);
        this.b(747097);
        this.a("Mountain Taiga");
        this.F = 0.0F;
        this.G = BiomeBase.TAIGA_HILLS.G;
        this.D = 0.3F;
        this.E = 1.2F;
        this.K.add(new BiomeMeta(EntityWolf.class, 8, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(10).grassPerChunk(1).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
    }
}
