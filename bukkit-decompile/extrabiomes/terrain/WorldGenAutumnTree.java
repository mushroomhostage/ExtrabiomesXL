package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenAutumnTree extends WorldGenerator
{
    private static final int BASE_HEIGHT = 4;
    private static final int CANOPY_HEIGHT = 3;
    private static final int CANOPY_RADIUS_EXTRA_RADIUS = 0;
    private static final int MAX_VARIANCE_HEIGHT = 2;
    private final ItemStack leaf;
    private final ItemStack wood;

    private static boolean isBlockSuitableForGrowing(World var0, int var1, int var2, int var3)
    {
        int var4 = var0.getTypeId(var1, var2, var3);
        return TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var4));
    }

    private static boolean isRoomToGrow(World var0, int var1, int var2, int var3, int var4)
    {
        for (int var5 = var2; var5 <= var2 + 1 + var4; ++var5)
        {
            if (var5 < 0 || var5 >= 256)
            {
                return false;
            }

            byte var6 = 1;

            if (var5 == var2)
            {
                var6 = 0;
            }

            if (var5 >= var2 + 1 + var4 - 2)
            {
                var6 = 2;
            }

            for (int var7 = var1 - var6; var7 <= var1 + var6; ++var7)
            {
                for (int var8 = var3 - var6; var8 <= var3 + var6; ++var8)
                {
                    int var9 = var0.getTypeId(var7, var5, var8);

                    if (Block.byId[var9] != null && !Block.byId[var9].isLeaves(var0, var7, var5, var8) && var9 != Block.GRASS.id && !Block.byId[var9].isWood(var0, var7, var5, var8))
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public WorldGenAutumnTree(boolean var1, ItemStack var2, ItemStack var3)
    {
        super(var1);
        this.leaf = var2;
        this.wood = var3;
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(3) + 4;

        if (var4 >= 1 && var4 + var6 + 1 <= 256)
        {
            if (!isBlockSuitableForGrowing(var1, var3, var4 - 1, var5))
            {
                return false;
            }
            else if (!isRoomToGrow(var1, var3, var4, var5, var6))
            {
                return false;
            }
            else
            {
                var1.setRawTypeId(var3, var4 - 1, var5, Block.DIRT.id);
                this.growLeaves(var1, var2, var3, var4, var5, var6);
                this.growTrunk(var1, var3, var4, var5, var6);
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    private void growLeaves(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        for (int var7 = var4 - 3 + var6; var7 <= var4 + var6; ++var7)
        {
            int var8 = var7 - (var4 + var6);
            int var9 = 1 - var8 / 2;

            for (int var10 = var3 - var9; var10 <= var3 + var9; ++var10)
            {
                int var11 = var10 - var3;

                for (int var12 = var5 - var9; var12 <= var5 + var9; ++var12)
                {
                    int var13 = var12 - var5;
                    Block var14 = Block.byId[var1.getTypeId(var10, var7, var12)];

                    if ((Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) && (var14 == null || var14.canBeReplacedByLeaves(var1, var10, var7, var12)))
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var10, var7, var12, this.leaf.getItem().id, this.leaf.getData());
                    }
                }
            }
        }
    }

    private void growTrunk(World var1, int var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < var5; ++var6)
        {
            int var7 = var1.getTypeId(var2, var3 + var6, var4);

            if (Block.byId[var7] == null || Block.byId[var7].isLeaves(var1, var2, var3 + var6, var4))
            {
                this.setTypeAndData((org.bukkit.BlockChangeDelegate)var1, var2, var3 + var6, var4, this.wood.getItem().id, this.wood.getData());
            }
        }
    }
}
