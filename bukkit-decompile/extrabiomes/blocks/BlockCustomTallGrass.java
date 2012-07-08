package extrabiomes.blocks;

import extrabiomes.api.TerrainGenManager;
import forge.ForgeHooks;
import forge.IShearable;
import forge.ITextureProvider;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCustomTallGrass extends BlockFlower implements IShearable, ITextureProvider
{
    public static final int metaBrown = 0;
    public static final int metaShortBrown = 1;
    public static final int metaDead = 2;
    public static final int metaDeadTall = 3;
    public static final int metaDeadYellow = 4;

    public BlockCustomTallGrass(int var1)
    {
        super(var1, 48, Material.REPLACEABLE_PLANT);
        float var2 = 0.4F;
        this.a(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
        this.c(0.0F);
        this.a(g);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this, 1, 0));
        var1.add(new ItemStack(this, 1, 1));
        var1.add(new ItemStack(this, 1, 2));
        var1.add(new ItemStack(this, 1, 3));
        var1.add(new ItemStack(this, 1, 4));
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean f(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getData(var2, var3, var4);
        int var6 = var1.getTypeId(var2, var3 - 1, var4);
        return (var5 == 0 || var5 == 1) && var6 == TerrainGenManager.blockMountainRidge.id || (var5 == 2 || var5 == 3 || var5 == 4) && var6 == TerrainGenManager.blockWasteland.id || super.f(var1, var2, var3, var4);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlace(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4);
        return var5 == TerrainGenManager.blockMountainRidge.id || var5 == TerrainGenManager.blockWasteland.id || super.canPlace(var1, var2, var3, var4);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d(int var1)
    {
        return var1 == TerrainGenManager.blockMountainRidge.id || var1 == TerrainGenManager.blockWasteland.id || super.d(var1);
    }

    public ArrayList getBlockDropped(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        int var8 = 8;

        if (var5 == 2 || var5 == 3 || var5 == 4)
        {
            var8 *= 2;
        }

        if (var1.random.nextInt(var8) != 0)
        {
            return var7;
        }
        else
        {
            ItemStack var9 = ForgeHooks.getGrassSeed(var1);

            if (var9 != null)
            {
                var7.add(var9);
            }

            return var7;
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return super.a(var1, var2) + var2;
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void a(World var1, EntityHuman var2, int var3, int var4, int var5, int var6)
    {
        super.a(var1, var2, var3, var4, var5, var6);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return 0;
    }

    public boolean isBlockReplaceable(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        var7.add(new ItemStack(this, 1, var2.getData(var3, var4, var5)));
        return var7;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int getDropCount(int var1, Random var2)
    {
        return 1 + var2.nextInt(var1 * 2 + 1);
    }
}
