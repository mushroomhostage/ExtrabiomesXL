package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.BiomeMeta;
import net.minecraft.server.EntityWolf;

public class BiomeForestedHills extends ExtrabiomeGenBase
{
    public BiomeForestedHills(int var1)
    {
        super(var1);
        this.a("Forested Hills");
        this.F = BiomeBase.FOREST.F - 0.1F;
        this.G = BiomeBase.FOREST.G;
        this.K.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(7).flowersPerChunk(1).grassPerChunk(5).build();
    }
}
