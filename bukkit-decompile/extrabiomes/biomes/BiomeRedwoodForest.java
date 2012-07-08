package extrabiomes.biomes;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.WorldGenerator;

public class BiomeRedwoodForest extends ExtrabiomeGenBase
{
    private WorldGenerator treeGen = null;

    public BiomeRedwoodForest(int var1)
    {
        super(var1);
        this.b(775718);
        this.a("Redwood Forest");
        this.F = 1.1F;
        this.G = 1.4F;
        this.D = 0.9F;
        this.E = 1.5F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(17).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        if (this.treeGen == null)
        {
            if (TerrainGenManager.enableRedwoodGen)
            {
                this.treeGen = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.REDWOOD);
            }
            else
            {
                this.treeGen = new WorldGenNoOp();
            }
        }

        return this.treeGen;
    }
}
