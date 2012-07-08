package extrabiomes.biomes;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.Block;
import net.minecraft.server.EntityWolf;
import net.minecraft.server.WorldGenGrass;
import net.minecraft.server.WorldGenerator;

public class BiomeTemporateRainforest extends ExtrabiomeGenBase
{
    protected WorldGenerator treeGen = null;
    protected WorldGenerator treeGen2 = null;

    public BiomeTemporateRainforest(int var1)
    {
        super(var1);
        this.b(3375669);
        this.a("Temperate Rainforest");
        this.F = 0.6F;
        this.G = 0.9F;
        this.D = 0.4F;
        this.E = 1.5F;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(17).mushroomsPerChunk(2).grassPerChunk(16).build();
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
        if (var1.nextInt(3) == 0)
        {
            if (this.treeGen == null)
            {
                if (TerrainGenManager.enableFirGen)
                {
                    this.treeGen = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.FIR);
                }
                else
                {
                    this.treeGen = new WorldGenNoOp();
                }
            }

            return this.treeGen;
        }
        else
        {
            if (this.treeGen2 == null)
            {
                if (TerrainGenManager.enableFirGen)
                {
                    this.treeGen2 = TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.FIR_HUGE);
                }
                else
                {
                    this.treeGen2 = new WorldGenNoOp();
                }
            }

            return this.treeGen2;
        }
    }
}
