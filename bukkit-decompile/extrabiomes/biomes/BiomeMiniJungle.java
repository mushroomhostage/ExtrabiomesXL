package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenPit;
import extrabiomes.terrain.WorldGenPit2;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.Block;
import net.minecraft.server.EntityChicken;
import net.minecraft.server.EntityOcelot;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenGrass;
import net.minecraft.server.WorldGenerator;

public class BiomeMiniJungle extends ExtrabiomeGenBase
{
    public BiomeMiniJungle(int var1)
    {
        super(var1);
        this.b(4315427);
        this.a("Mini Jungle");
        this.F = BiomeBase.JUNGLE.F;
        this.G = BiomeBase.JUNGLE.G;
        this.D = 0.2F;
        this.E = 0.6F;
        this.H = 2404380;
        this.J.add(new BiomeMeta(EntityOcelot.class, 2, 1, 1));
        this.K.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(15).grassPerChunk(9).flowersPerChunk(5).reedsPerChunk(70).clayPerChunk(3).mushroomsPerChunk(2).waterlilyPerChunk(12).build();
    }

    public void a(World var1, Random var2, int var3, int var4)
    {
        super.a(var1, var2, var3, var4);
        int var5;
        int var6;

        if (var2.nextInt(1) == 0)
        {
            var5 = var3 + var2.nextInt(16) + 8;
            var6 = var4 + var2.nextInt(16) + 8;
            WorldGenPit2 var7 = new WorldGenPit2();
            var7.a(var1, var2, var5, var1.getHighestBlockYAt(var5, var6) + 1, var6);
            var7.a(var1, var2, var5, var1.getHighestBlockYAt(var5, var6) + 1, var6);
            var7.a(var1, var2, var5, var1.getHighestBlockYAt(var5, var6) + 1, var6);
        }

        if (var2.nextInt(1) == 0)
        {
            var5 = var3 + var2.nextInt(16) + 8;
            var6 = var4 + var2.nextInt(16) + 8;
            WorldGenPit var8 = new WorldGenPit();
            var8.a(var1, var2, var5, var1.getHighestBlockYAt(var5, var6) + 1, var6);
        }
    }

    public WorldGenerator func_48440_b(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(4) == 0 ? new WorldGenGrass(Block.LONG_GRASS.id, 2) : super.func_48440_b(var1));
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator a(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(2) == 0 ? this.Q : (var1.nextInt(100) == 0 ? this.N : this.O));
    }
}
