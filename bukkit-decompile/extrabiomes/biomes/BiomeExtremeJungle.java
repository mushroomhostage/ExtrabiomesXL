package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.Block;
import net.minecraft.server.EntityChicken;
import net.minecraft.server.EntityOcelot;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenGrass;
import net.minecraft.server.WorldGenGroundBush;
import net.minecraft.server.WorldGenMegaTree;
import net.minecraft.server.WorldGenTrees;
import net.minecraft.server.WorldGenVines;
import net.minecraft.server.WorldGenerator;

public class BiomeExtremeJungle extends ExtrabiomeGenBase
{
    public void a(World var1, Random var2, int var3, int var4)
    {
        super.a(var1, var2, var3, var4);
        WorldGenVines var5 = new WorldGenVines();

        for (int var6 = 0; var6 < 50; ++var6)
        {
            int var7 = var3 + var2.nextInt(16) + 8;
            int var8 = var4 + var2.nextInt(16) + 8;
            var5.a(var1, var2, var7, 64, var8);
        }
    }

    public BiomeExtremeJungle(int var1)
    {
        super(var1);
        this.b(2900485);
        this.a("Extreme Jungle");
        this.F = BiomeBase.JUNGLE.F;
        this.G = BiomeBase.JUNGLE.G;
        this.D = 2.1F;
        this.E = 2.3F;
        this.J.add(new BiomeMeta(EntityOcelot.class, 2, 1, 1));
        this.K.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(50).grassPerChunk(25).flowersPerChunk(4).build();
    }

    public WorldGenerator func_48440_b(Random var1)
    {
        return var1.nextInt(4) == 0 ? new WorldGenGrass(Block.LONG_GRASS.id, 2) : new WorldGenGrass(Block.LONG_GRASS.id, 1);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(10) == 0 ? this.O : (var1.nextInt(2) == 0 ? new WorldGenGroundBush(3, 0) : (var1.nextInt(3) == 0 ? new WorldGenMegaTree(false, 10 + var1.nextInt(20), 3, 3) : new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true))));
    }
}
