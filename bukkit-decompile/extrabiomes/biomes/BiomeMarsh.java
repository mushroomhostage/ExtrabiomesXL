package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenDirtBed;
import extrabiomes.terrain.WorldGenMarsh;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.World;

public class BiomeMarsh extends ExtrabiomeGenBase
{
    private static WorldGenMarsh genMarsh = null;
    private static WorldGenDirtBed genDirtBed = null;

    public BiomeMarsh(int var1)
    {
        super(var1);
        this.b(255);
        this.a("Marsh");
        this.F = BiomeBase.SWAMPLAND.F;
        this.G = BiomeBase.SWAMPLAND.G;
        this.D = -0.4F;
        this.E = 0.0F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).grassPerChunk(999).build();
    }

    public void a(World var1, Random var2, int var3, int var4)
    {
        super.a(var1, var2, var3, var4);

        if (genMarsh == null)
        {
            genMarsh = new WorldGenMarsh();
        }

        int var5;
        int var6;
        int var7;

        for (var5 = 0; var5 < 127; ++var5)
        {
            var6 = var3 + var2.nextInt(16) + 8;
            var7 = var4 + var2.nextInt(16) + 8;
            genMarsh.a(var1, var2, var6, 0, var7);
        }

        if (genDirtBed == null)
        {
            genDirtBed = new WorldGenDirtBed();
        }

        for (var5 = 0; var5 < 256; ++var5)
        {
            var6 = var3 + var2.nextInt(1) + 8;
            var7 = var4 + var2.nextInt(1) + 8;
            genDirtBed.a(var1, var2, var6, 0, var7);
        }
    }
}
