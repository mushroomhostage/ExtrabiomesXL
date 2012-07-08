package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.Block;
import net.minecraft.server.WorldGenGrass;
import net.minecraft.server.WorldGenerator;

public class BiomeRainforest extends ExtrabiomeGenBase
{
    public BiomeRainforest(int var1)
    {
        super(var1);
        this.b(775718);
        this.a("Rainforest");
        this.F = 1.1F;
        this.G = 1.4F;
        this.D = 0.4F;
        this.E = 1.3F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(7).grassPerChunk(4).flowersPerChunk(2).build();
    }

    public WorldGenerator b(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(4) == 0 ? new WorldGenGrass(Block.LONG_GRASS.id, 2) : super.b(var1));
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(99999) == 0 ? this.P : (var1.nextInt(4) == 0 ? this.O : this.N));
    }
}
