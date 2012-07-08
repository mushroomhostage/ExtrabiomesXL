package extrabiomes.biomes;

import net.minecraft.server.Block;

public class BiomeGlacier extends ExtrabiomeGenBase
{
    public BiomeGlacier(int var1)
    {
        super(var1);
        this.K.clear();
        this.A = (byte)Block.SNOW_BLOCK.id;
        this.B = (byte)Block.ICE.id;
        this.b(7841430);
        this.a("Glacier");
        this.b();
        this.F = 0.0F;
        this.G = 0.0F;
        this.D = 1.4F;
        this.E = 2.1F;
    }
}
