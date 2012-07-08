package extrabiomes.blocks;

import extrabiomes.api.TerrainGenManager;
import forge.ITextureProvider;
import java.util.ArrayList;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCatTail extends BlockFlower implements ITextureProvider
{
    private static boolean canGrownOnBlock(int var0)
    {
        return var0 == Block.GRASS.id && var0 == Block.DIRT.id && var0 == Block.SAND.id;
    }

    public BlockCatTail(int var1)
    {
        super(var1, 79, Material.PLANT);
        this.c(0.0F);
        this.a(Block.g);
        this.s();
        float var2 = 0.375F;
        this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 1.0F, 0.5F + var2);
        TerrainGenManager.enableCattailGen = true;
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
        return this.canPlace(var1, var2, var3, var4);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlace(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3 - 1, var4);
        return var5 != Block.GRASS.id && var5 != Block.DIRT.id ? false : (var1.getMaterial(var2 - 1, var3 - 1, var4) == Material.WATER ? true : (var1.getMaterial(var2 + 1, var3 - 1, var4) == Material.WATER ? true : (var1.getMaterial(var2, var3 - 1, var4 - 1) == Material.WATER ? true : var1.getMaterial(var2, var3 - 1, var4 + 1) == Material.WATER)));
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    /**
     * The type of render function that is called for this block
     */
    public int c()
    {
        return 6;
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
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
        if (!this.f(var1, var2, var3, var4))
        {
            this.b(var1, var2, var3, var4, var1.getData(var2, var3, var4), 0);
            var1.setTypeId(var2, var3, var4, 0);
        }
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean b()
    {
        return false;
    }
}
