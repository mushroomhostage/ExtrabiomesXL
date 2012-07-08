package extrabiomes.biomes;

import extrabiomes.terrain.CustomBiomeDecorator;
import net.minecraft.server.BiomeDecorator;
import net.minecraft.server.Block;

public class BiomeIceWasteland extends ExtrabiomeGenBase
{
    public BiomeIceWasteland(int var1)
    {
        super(var1);
        this.K.clear();
        this.A = (byte)Block.SNOW_BLOCK.id;
        this.B = (byte)Block.SNOW_BLOCK.id;
        this.b();
        this.b(8233141);
        this.a("Ice Wasteland");
        this.F = 0.0F;
        this.G = 0.1F;
        this.D = 0.3F;
        this.E = 0.4F;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator a()
    {
        return (new CustomBiomeDecorator.Builder(this)).treesPerChunk(0).build();
    }
}
