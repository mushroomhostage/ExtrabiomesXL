package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenCustomSwamp;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.WorldGenerator;

public class BiomeGreenSwamp extends ExtrabiomeGenBase
{
    private static WorldGenerator genCustomSwampTree = null;

    public BiomeGreenSwamp(int var1)
    {
        super(var1);
        this.b(6866036);
        this.a("Green Swamplands");
        this.F = BiomeBase.SWAMPLAND.F - 0.1F;
        this.G = BiomeBase.SWAMPLAND.G;
        this.D = -0.2F;
        this.E = 0.1F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(4).flowersPerChunk(0).deadBushPerChunk(0).mushroomsPerChunk(8).reedsPerChunk(10).clayPerChunk(1).waterlilyPerChunk(4).sandPerChunk(0, 0).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        if (var1.nextInt(5) == 0)
        {
            return this.Q;
        }
        else
        {
            if (genCustomSwampTree == null)
            {
                genCustomSwampTree = new WorldGenCustomSwamp();
            }

            return genCustomSwampTree;
        }
    }
}
