package extrabiomes.terrain;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenCustomSwamp extends WorldGenerator
{
    public WorldGenCustomSwamp() {}

    public WorldGenCustomSwamp(boolean var1)
    {
        super(var1);
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        while (var1.getMaterial(var3, var4 - 1, var5) == Material.WATER)
        {
            --var4;
        }

        int var6 = var2.nextInt(4) + 10;

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            int var7;
            int var9;
            int var10;
            int var11;

            for (var7 = var4; var7 <= var4 + 1 + var6; ++var7)
            {
                if (var7 < 0 && var7 >= 256)
                {
                    return false;
                }

                byte var8 = 1;

                if (var7 == var4)
                {
                    var8 = 0;
                }

                if (var7 >= var4 + 1 + var6 - 2)
                {
                    var8 = 3;
                }

                for (var9 = var3 - var8; var9 <= var3 + var8; ++var9)
                {
                    for (var10 = var5 - var8; var10 <= var5 + var8; ++var10)
                    {
                        var11 = var1.getTypeId(var9, var7, var10);

                        if (Block.byId[var11] != null && !Block.byId[var11].isLeaves(var1, var9, var7, var10))
                        {
                            if (var11 != Block.STATIONARY_WATER.id && var11 != Block.WATER.id)
                            {
                                return false;
                            }

                            if (var7 > var4)
                            {
                                return false;
                            }
                        }
                    }
                }
            }

            var7 = var1.getTypeId(var3, var4 - 1, var5);

            if ((var7 == Block.GRASS.id || var7 == Block.DIRT.id) && var4 < 256 - var6 - 1)
            {
                var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
                int var12;
                int var16;

                for (var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16)
                {
                    var9 = var16 - (var4 + var6);
                    var10 = 2 - var9 / 2;

                    for (var11 = var3 - var10; var11 <= var3 + var10; ++var11)
                    {
                        var12 = var11 - var3;

                        for (int var13 = var5 - var10; var13 <= var5 + var10; ++var13)
                        {
                            int var14 = var13 - var5;
                            Block var15 = Block.byId[var1.getTypeId(var11, var16, var13)];

                            if ((Math.abs(var12) != var10 || Math.abs(var14) != var10 || var2.nextInt(2) != 0 && var9 != 0) && (var15 == null || var15.canBeReplacedByLeaves(var1, var11, var16, var13)))
                            {
                                var1.setRawTypeId(var11, var16, var13, Block.LEAVES.id);
                            }
                        }
                    }
                }

                for (var16 = 0; var16 < var6; ++var16)
                {
                    var9 = var1.getTypeId(var3, var4 + var16, var5);

                    if (var9 == 0 || var9 == Block.LEAVES.id || var9 == Block.WATER.id || var9 == Block.STATIONARY_WATER.id)
                    {
                        var1.setRawTypeId(var3, var4 + var16, var5, Block.LOG.id);
                    }
                }

                for (var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16)
                {
                    var9 = var16 - (var4 + var6);
                    var10 = 2 - var9 / 2;

                    for (var11 = var3 - var10; var11 <= var3 + var10; ++var11)
                    {
                        for (var12 = var5 - var10; var12 <= var5 + var10; ++var12)
                        {
                            if (var1.getTypeId(var11, var16, var12) == Block.LEAVES.id)
                            {
                                if (var2.nextInt(4) == 0 && var1.getTypeId(var11 - 1, var16, var12) == 0)
                                {
                                    this.generateVines(var1, var11 - 1, var16, var12, 8);
                                }

                                if (var2.nextInt(4) == 0 && var1.getTypeId(var11 + 1, var16, var12) == 0)
                                {
                                    this.generateVines(var1, var11 + 1, var16, var12, 2);
                                }

                                if (var2.nextInt(4) == 0 && var1.getTypeId(var11, var16, var12 - 1) == 0)
                                {
                                    this.generateVines(var1, var11, var16, var12 - 1, 1);
                                }

                                if (var2.nextInt(4) == 0 && var1.getTypeId(var11, var16, var12 + 1) == 0)
                                {
                                    this.generateVines(var1, var11, var16, var12 + 1, 4);
                                }
                            }
                        }
                    }
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    private void generateVines(World var1, int var2, int var3, int var4, int var5)
    {
        var1.setTypeIdAndData(var2, var3, var4, Block.VINE.id, var5);
        int var6 = 4;

        while (true)
        {
            --var3;

            if (var1.getTypeId(var2, var3, var4) != 0 || var6 <= 0)
            {
                return;
            }

            var1.setTypeIdAndData(var2, var3, var4, Block.VINE.id, var5);
            --var6;
        }
    }
}
