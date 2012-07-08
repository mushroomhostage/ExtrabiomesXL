package extrabiomes.biomes;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.Block;
import net.minecraft.server.WorldGenGrass;
import net.minecraft.server.WorldGenerator;

public class BiomeRedwoodLush extends ExtrabiomeGenBase
{
    private WorldGenerator worldGenRedwood = null;
    private WorldGenerator worldGenFirTree = null;

    public BiomeRedwoodLush(int var1)
    {
        super(var1);
        this.b(4900696);
        this.a("Lush Redwoods");
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

    public WorldGenerator b(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(4) == 0 ? new WorldGenGrass(Block.LONG_GRASS.id, 2) : super.b(var1));
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        if (var1.nextInt(2) == 0)
        {
            if (this.worldGenRedwood == null)
            {
                if (TerrainGenManager.enableRedwoodGen)
                {
                    this.worldGenRedwood = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.REDWOOD);
                }
                else
                {
                    this.worldGenRedwood = new WorldGenNoOp();
                }
            }

            return this.worldGenRedwood;
        }
        else
        {
            if (this.worldGenFirTree == null)
            {
                if (TerrainGenManager.enableFirGen)
                {
                    this.worldGenFirTree = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.FIR);
                }
                else
                {
                    this.worldGenFirTree = new WorldGenNoOp();
                }
            }

            return this.worldGenFirTree;
        }
    }
}
