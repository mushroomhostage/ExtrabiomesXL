package extrabiomes.blocks;

import forge.ITextureProvider;
import java.util.ArrayList;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockQuickSand extends Block implements ITextureProvider
{
    public BlockQuickSand(int var1)
    {
        super(var1, 1, Material.SAND);
        this.c(4.0F);
        this.a(Block.l);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
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

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean a()
    {
        return false;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void a(World var1, int var2, int var3, int var4, Entity var5)
    {
        var5.u();
    }
}
