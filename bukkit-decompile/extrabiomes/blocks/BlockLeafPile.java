package extrabiomes.blocks;

import forge.ITextureProvider;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockLeafPile extends Block implements ITextureProvider
{
    private static boolean canThisPlantGrowOnThisBlockID(int var0)
    {
        return var0 == Block.GRASS.id || var0 == Block.DIRT.id;
    }

    public BlockLeafPile(int var1)
    {
        super(var1, 64, Material.REPLACEABLE_PLANT);
        float var2 = 0.5F;
        float var3 = 0.015625F;
        this.a(true);
        this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var3, 0.5F + var2);
        this.a(g);
        Block.setBurnProperties(var1, 30, 60);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean f(World var1, int var2, int var3, int var4)
    {
        return canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlace(World var1, int var2, int var3, int var4)
    {
        return super.canPlace(var1, var2, var3, var4) && canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    private void checkFlowerChange(World var1, int var2, int var3, int var4)
    {
        if (!this.f(var1, var2, var3, var4))
        {
            this.b(var1, var2, var3, var4, var1.getData(var2, var3, var4), 0);
            var1.setTypeId(var2, var3, var4, 0);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
    }

    public boolean isBlockReplaceable(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean a()
    {
        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        super.doPhysics(var1, var2, var3, var4, var5);
        this.checkFlowerChange(var1, var2, var3, var4);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean b()
    {
        return false;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        this.checkFlowerChange(var1, var2, var3, var4);
    }
}
