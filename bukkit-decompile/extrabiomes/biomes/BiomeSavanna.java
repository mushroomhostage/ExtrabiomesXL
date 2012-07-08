package extrabiomes.biomes;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.WorldGenerator;

public class BiomeSavanna extends ExtrabiomeGenBase
{
    private WorldGenerator treeGen = null;

    public BiomeSavanna(int var1)
    {
        super(var1);
        this.b(12558915);
        this.a("Savanna");
        this.F = 2.0F;
        this.G = 0.0F;
        this.D = 0.0F;
        this.E = 0.1F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).flowersPerChunk(1).grassPerChunk(17).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        if (this.treeGen == null)
        {
            if (TerrainGenManager.enableAcaciaGen)
            {
                this.treeGen = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.ACACIA);
            }
            else
            {
                this.treeGen = new WorldGenNoOp();
            }
        }

        return this.treeGen;
    }
}
