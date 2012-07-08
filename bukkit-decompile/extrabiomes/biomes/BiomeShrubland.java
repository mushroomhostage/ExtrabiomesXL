package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.WorldGenGroundBush;
import net.minecraft.server.WorldGenerator;

public class BiomeShrubland extends ExtrabiomeGenBase
{
    public BiomeShrubland(int var1)
    {
        super(var1);
        this.b(5354877);
        this.a("Shrubland");
        this.F = 0.4F;
        this.G = 0.6F;
        this.D = 0.1F;
        this.E = 0.3F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).flowersPerChunk(3).grassPerChunk(1).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(3) <= 1 ? new WorldGenGroundBush(3, var1.nextInt(3)) : new WorldGenNoOp());
    }
}
