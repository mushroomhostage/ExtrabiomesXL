package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;

public class BiomeWoodlands extends ExtrabiomeGenBase
{
    public BiomeWoodlands(int var1)
    {
        super(var1);
        this.b(8762686);
        this.a("Woodlands");
        this.F = BiomeBase.FOREST.F;
        this.G = BiomeBase.FOREST.G;
        this.D = 0.2F;
        this.E = 0.4F;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(8).grassPerChunk(3).build();
    }
}
