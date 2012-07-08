package extrabiomes.biomes;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;
import net.minecraft.server.WorldGenBigTree;
import net.minecraft.server.WorldGenTrees;
import net.minecraft.server.WorldGenerator;

public class BiomeAutumnWoods extends ExtrabiomeGenBase
{
    private static boolean shouldChooseColor(Random var0)
    {
        return var0.nextInt(3) == 0;
    }

    private static boolean shouldGrowBigTree(Random var0)
    {
        return var0.nextInt(10) == 0;
    }

    public BiomeAutumnWoods(int var1)
    {
        super(var1);
        this.b(15899665);
        this.a("Autumn Woods");
        this.F = BiomeBase.FOREST.F;
        this.G = BiomeBase.FOREST.G;
        this.D = 0.2F;
        this.E = 0.8F;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(9).grassPerChunk(6).mushroomsPerChunk(3).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        if (!TerrainGenManager.enableAutumnTreeGen)
        {
            return new WorldGenNoOp();
        }
        else
        {
            ITreeFactory.TreeType var2 = null;
            boolean var3 = shouldGrowBigTree(var1);

            if (shouldChooseColor(var1))
            {
                var2 = var3 ? ITreeFactory.TreeType.BROWN_AUTUMN_BIG : ITreeFactory.TreeType.BROWN_AUTUMN;
            }
            else if (shouldChooseColor(var1))
            {
                var2 = var3 ? ITreeFactory.TreeType.ORANGE_AUTUMN_BIG : ITreeFactory.TreeType.ORANGE_AUTUMN;
            }
            else if (shouldChooseColor(var1))
            {
                var2 = var3 ? ITreeFactory.TreeType.PURPLE_AUTUMN_BIG : ITreeFactory.TreeType.PURPLE_AUTUMN;
            }
            else if (shouldChooseColor(var1))
            {
                var2 = var3 ? ITreeFactory.TreeType.YELLOW_AUTUMN_BIG : ITreeFactory.TreeType.YELLOW_AUTUMN;
            }

            return (WorldGenerator)(var2 != null ? TerrainGenManager.treeFactory.makeTreeGenerator(false, var2) : (var3 ? new WorldGenBigTree(false) : new WorldGenTrees(false)));
        }
    }
}
