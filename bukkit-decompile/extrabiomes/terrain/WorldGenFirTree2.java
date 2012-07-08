package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenFirTree2 extends WorldGenerator
{
    final int blockLeaf;
    final int metaLeaf;
    final int blockWood;
    final int metaWood;

    private static void setBlockandMetadataIfChunkExists(World var0, int var1, int var2, int var3, int var4, int var5)
    {
        if (var0.q().isChunkLoaded(var1 >> 4, var3 >> 4))
        {
            var0.setRawTypeIdAndData(var1, var2, var3, var4, var5);
        }
    }

    public WorldGenFirTree2(boolean var1)
    {
        super(var1);
        this.blockLeaf = TerrainGenManager.blockFirLeaves.id;
        this.metaLeaf = TerrainGenManager.metaFirLeaves;
        this.blockWood = TerrainGenManager.blockFirWood.id;
        this.metaWood = TerrainGenManager.metaFirWood;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(16) + 32;
        int var7 = 1 + var2.nextInt(12);
        int var8 = var6 - var7;
        int var9 = 2 + var2.nextInt(9);

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            int var10;
            int var12;
            int var14;
            int var21;

            for (var10 = var4; var10 <= var4 + 1 + var6; ++var10)
            {
                if (var10 < 0 && var10 >= 256)
                {
                    return false;
                }

                boolean var11 = true;

                if (var10 - var4 < var7)
                {
                    var21 = 0;
                }
                else
                {
                    var21 = var9;
                }

                for (var12 = var3 - var21; var12 <= var3 + var21; ++var12)
                {
                    for (int var13 = var5 - var21; var13 <= var5 + var21; ++var13)
                    {
                        if (!var1.q().isChunkLoaded(var12 >> 4, var13 >> 4))
                        {
                            return false;
                        }

                        var14 = var1.getTypeId(var12, var10, var13);

                        if (Block.byId[var14] != null && !Block.byId[var14].isLeaves((World)null, var12, var10, var13))
                        {
                            return false;
                        }
                    }
                }
            }

            var10 = var1.getTypeId(var3, var4 - 1, var5);

            if (TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var10)) && var4 < 256 - var6 - 1)
            {
                var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
                var1.setRawTypeId(var3 - 1, var4 - 1, var5, Block.DIRT.id);
                var1.setRawTypeId(var3, var4 - 1, var5 - 1, Block.DIRT.id);
                var1.setRawTypeId(var3 - 1, var4 - 1, var5 - 1, Block.DIRT.id);
                var21 = var2.nextInt(2);
                var12 = 1;
                boolean var22 = false;
                int var15;
                int var16;

                for (var14 = 0; var14 <= var8; ++var14)
                {
                    var15 = var4 + var6 - var14;

                    for (var16 = var3 - var21; var16 <= var3 + var21; ++var16)
                    {
                        int var17 = var16 - var3;

                        for (int var18 = var5 - var21; var18 <= var5 + var21; ++var18)
                        {
                            int var19 = var18 - var5;
                            Block var20 = Block.byId[var1.getTypeId(var16, var15, var18)];

                            if ((Math.abs(var17) != var21 || Math.abs(var19) != var21 || var21 <= 0) && (var20 == null || var20.canBeReplacedByLeaves(var1, var16, var15, var18)))
                            {
                                setBlockandMetadataIfChunkExists(var1, var16, var15, var18, this.blockLeaf, this.metaLeaf);
                                setBlockandMetadataIfChunkExists(var1, var16 - 1, var15, var18, this.blockLeaf, this.metaLeaf);
                                setBlockandMetadataIfChunkExists(var1, var16, var15, var18 - 1, this.blockLeaf, this.metaLeaf);
                                setBlockandMetadataIfChunkExists(var1, var16 - 1, var15, var18 - 1, this.blockLeaf, this.metaLeaf);
                            }
                        }
                    }

                    if (var21 >= var12)
                    {
                        var21 = var22 ? 1 : 0;
                        var22 = true;
                        ++var12;

                        if (var12 > var9)
                        {
                            var12 = var9;
                        }
                    }
                    else
                    {
                        ++var21;
                    }
                }

                var14 = var2.nextInt(3);

                for (var15 = 0; var15 < var6 - var14; ++var15)
                {
                    var16 = var1.getTypeId(var3, var4 + var15, var5);

                    if (Block.byId[var16] == null || Block.byId[var16].isLeaves(var1, var3, var4 + var15, var5))
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3, var4 + var15, var5, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3 - 1, var4 + var15, var5, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3, var4 + var15, var5 - 1, this.blockWood, this.metaWood);
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var3 - 1, var4 + var15, var5 - 1, this.blockWood, this.metaWood);
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
}
