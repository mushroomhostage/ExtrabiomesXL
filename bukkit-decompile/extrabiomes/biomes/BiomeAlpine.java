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
import net.minecraft.server.WorldGenerator;

public class BiomeAlpine extends ExtrabiomeGenBase
{
    public BiomeAlpine(int var1)
    {
        super(var1);
        this.A = (byte)Block.STONE.id;
        this.B = (byte)Block.STONE.id;
        this.b(9284804);
        this.b();
        this.a("Alpine");
        this.F = 0.0F;
        this.G = 0.1F;
        this.D = 1.3F;
        this.E = 2.1F;
        this.K.add(new BiomeMeta(EntityWolf.class, 8, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(7).flowersPerChunk(0).grassPerChunk(0).build();
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(TerrainGenManager.enableFirGen ? TerrainGenManager.treeFactory.makeTreeGenerator(false, ITreeFactory.TreeType.FIR) : new WorldGenNoOp());
    }
}
