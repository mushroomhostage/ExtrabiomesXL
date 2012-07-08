package extrabiomes.blocks;

import forge.ITextureProvider;
import forge.MinecraftForge;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCustomFlower extends Block implements ITextureProvider
{
    public static final int metaAutumnShrub = 0;
    public static final int metaHydrangea = 1;
    public static final int metaOrange = 2;
    public static final int metaPurple = 3;
    public static final int metaTinyCactus = 4;
    public static final int metaRoot = 5;
    public static final int metaToadstool = 6;
    public static final int metaWhite = 7;

    public BlockCustomFlower(int var1)
    {
        super(var1, Material.PLANT);
        this.textureId = 32;
        this.a(true);
        float var2 = 0.2F;
        this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var2 * 3.0F, 0.5F + var2);
        this.c(0.0F);
        this.a(Block.g);
        MinecraftForge.addGrassPlant(var1, 0, 2);
        MinecraftForge.addGrassPlant(var1, 1, 2);
        MinecraftForge.addGrassPlant(var1, 2, 5);
        MinecraftForge.addGrassPlant(var1, 3, 5);
        MinecraftForge.addGrassPlant(var1, 7, 5);
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this, 1, 0));
        var1.add(new ItemStack(this, 1, 1));
        var1.add(new ItemStack(this, 1, 2));
        var1.add(new ItemStack(this, 1, 3));
        var1.add(new ItemStack(this, 1, 4));
        var1.add(new ItemStack(this, 1, 5));
        var1.add(new ItemStack(this, 1, 6));
        var1.add(new ItemStack(this, 1, 7));
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean f(World var1, int var2, int var3, int var4)
    {
        return (var1.m(var2, var3, var4) >= 8 || var1.isChunkLoaded(var2, var3, var4)) && this.canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlace(World var1, int var2, int var3, int var4)
    {
        return super.canPlace(var1, var2, var3, var4) && this.canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1)
    {
        return var1 == Block.GRASS.id || var1 == Block.DIRT.id || var1 == Block.SOIL.id;
    }

    protected final void checkFlowerChange(World var1, int var2, int var3, int var4)
    {
        if (!this.f(var1, var2, var3, var4))
        {
            this.b(var1, var2, var3, var4, var1.getData(var2, var3, var4), 0);
            var1.setTypeId(var2, var3, var4, 0);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int getDropData(int var1)
    {
        return var1;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return super.a(var1, var2) + var2;
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
        return 1;
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
