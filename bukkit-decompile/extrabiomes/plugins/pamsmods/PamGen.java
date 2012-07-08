package extrabiomes.plugins.pamsmods;

import extrabiomes.Log;
import extrabiomes.api.IBiomeDecoration;
import java.lang.reflect.Constructor;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public enum PamGen implements IBiomeDecoration
{
    BUSHES,
    TREES,
    WARM_BUSHES,
    WARM_TREES;
    private Constructor ctor = null;
    private int rarity = 0;
    private WorldGenerator[] generators = null;

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        if (this.generators == null)
        {
            this.initializeGenerators();
        }

        for (int var5 = 0; var5 < this.rarity; ++var5)
        {
            WorldGenerator[] var6 = this.generators;
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                WorldGenerator var9 = var6[var8];
                int var10 = var3 + var2.nextInt(16);
                int var11 = var2.nextInt(128);
                int var12 = var4 + var2.nextInt(16);
                int var13 = var1.getTypeId(var10, var11 - 1, var12);

                if (this != TREES && this != WARM_TREES || var13 == Block.DIRT.id || var13 == Block.GRASS.id)
                {
                    var9.a(var1, var2, var10, var11, var12);
                }
            }
        }
    }

    private void initializeGenerators()
    {
        this.generators = new WorldGenerator[this == WARM_TREES ? 16 : (this == WARM_BUSHES ? 7 : 8)];

        for (int var1 = 0; var1 < this.generators.length; ++var1)
        {
            this.generators[var1] = this.newInstance(var1);
        }
    }

    public WorldGenerator newInstance(int var1)
    {
        if (this.ctor != null)
        {
            try
            {
                Object[] var2 = new Object[] {Integer.valueOf(var1)};
                return (WorldGenerator)this.ctor.newInstance(var2);
            }
            catch (Exception var3)
            {
                Log.write("Could not create HarvestCraft\'s " + this.toString() + " generator.");
            }
        }

        return null;
    }

    public void setConstructor(Constructor var1)
    {
        this.ctor = var1;
    }

    public void setRarity(int var1)
    {
        this.rarity = var1;
    }
}
