package extrabiomes.blocks;

import extrabiomes.api.TerrainGenManager;
import forge.ITextureProvider;
import java.util.ArrayList;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.EnumCreatureType;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockRedRock extends Block implements ITextureProvider
{
    public static final int metaRedRock = 0;
    public static final int metaRedCobble = 1;
    public static final int metaRedRockBrick = 2;

    public BlockRedRock(int var1)
    {
        super(var1, 2, Material.STONE);
        this.c(1.5F);
        this.b(2.0F);
        TerrainGenManager.blockMountainRidge = this;
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this, 1, 0));
        var1.add(new ItemStack(this, 1, 1));
        var1.add(new ItemStack(this, 1, 2));
    }

    public boolean canCreatureSpawn(EnumCreatureType var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int getDropData(int var1)
    {
        return var1 == 2 ? 2 : 1;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return var2 == 2 ? 11 : (var2 == 1 ? 12 : super.a(var1, var2));
    }

    /**
     * Returns how much this block can resist explosions from the passed in entity.
     */
    public float a(Entity var1)
    {
        return super.a(var1);
    }

    public float getHardness(int var1)
    {
        return var1 == 1 ? 2.0F : super.getHardness(var1);
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
    }
}
