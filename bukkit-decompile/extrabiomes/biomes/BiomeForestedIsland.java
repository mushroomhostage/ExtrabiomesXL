package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;

public class BiomeForestedIsland extends ExtrabiomeGenBase
{
    public BiomeForestedIsland(int var1)
    {
        super(var1);
        this.b(6471532);
        this.a("Forested Island");
        this.F = BiomeBase.FOREST.F + 0.1F;
        this.G = BiomeBase.FOREST.G;
        this.D = -0.8F;
        this.E = 0.8F;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(7).grassPerChunk(3).build();
    }
}
