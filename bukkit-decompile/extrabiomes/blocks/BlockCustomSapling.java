package extrabiomes.blocks;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import forge.IBonemealHandler;
import forge.ITextureProvider;
import forge.MinecraftForge;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class BlockCustomSapling extends BlockFlower implements IBonemealHandler, ITextureProvider
{
    private static final int METADATA_BITMASK = 7;
    private static final int METADATA_MARKBIT = 8;
    public static final int metaBrown = 0;
    public static final int metaOrange = 1;
    public static final int metaPurple = 2;
    public static final int metaYellow = 3;
    public static final int metaFir = 4;
    public static final int metaRedWood = 5;
    public static final int metaAcacia = 6;

    private static boolean isEnoughLightToGrow(World var0, int var1, int var2, int var3)
    {
        return var0.getLightLevel(var1, var2, var3) >= 9;
    }

    private static boolean isMarkedMetadata(int var0)
    {
        return (var0 & 8) != 0;
    }

    private static int markedMetadata(int var0)
    {
        return var0 | 8;
    }

    private static int unmarkedMetadata(int var0)
    {
        return var0 & 7;
    }

    public BlockCustomSapling(int var1)
    {
        super(var1, 16);
        float var2 = 0.4F;
        this.a(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
        this.c(0.0F);
        this.a(g);
        this.j();
        MinecraftForge.registerBonemealHandler(this);
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
    }

    private void attemptGrowTree(World var1, int var2, int var3, int var4, Random var5)
    {
        if (isEnoughLightToGrow(var1, var2, var3 + 1, var4) && var5.nextInt(7) == 0)
        {
            int var6 = var1.getData(var2, var3, var4);

            if (!isMarkedMetadata(var6))
            {
                var1.setData(var2, var3, var4, markedMetadata(var6));
            }
            else
            {
                this.growTree(var1, var2, var3, var4, var5);
            }
        }
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d(int var1)
    {
        return TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var1));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int getDropData(int var1)
    {
        return unmarkedMetadata(var1);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return super.a(var1) + unmarkedMetadata(var2);
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
    }

    public void growTree(World var1, int var2, int var3, int var4, Random var5)
    {
        int var6 = unmarkedMetadata(var1.getData(var2, var3, var4));
        WorldGenerator var7 = null;
        int var8 = 0;
        int var9 = 0;
        boolean var10 = false;

        if (var6 == 0)
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.BROWN_AUTUMN_BIG);
            }
            else
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.BROWN_AUTUMN);
            }
        }
        else if (var6 == 1)
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.ORANGE_AUTUMN_BIG);
            }
            else
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.ORANGE_AUTUMN);
            }
        }
        else if (var6 == 2)
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.PURPLE_AUTUMN_BIG);
            }
            else
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.PURPLE_AUTUMN);
            }
        }
        else if (var6 == 3)
        {
            if (var5.nextInt(20) == 0)
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.YELLOW_AUTUMN_BIG);
            }
            else
            {
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.YELLOW_AUTUMN);
            }
        }
        else if (var6 == 6)
        {
            var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.ACACIA);
        }
        else
        {
            for (var8 = 0; var8 >= -1; --var8)
            {
                for (var9 = 0; var9 >= -1; --var9)
                {
                    if (this.isSameSapling(var1, var2 + var8, var3, var4 + var9, var6) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9, var6) && this.isSameSapling(var1, var2 + var8, var3, var4 + var9 + 1, var6) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9 + 1, var6))
                    {
                        if (var6 == 4)
                        {
                            var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.FIR_HUGE);
                        }
                        else
                        {
                            var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.REDWOOD);
                        }

                        var10 = true;
                        break;
                    }
                }

                if (var7 != null)
                {
                    break;
                }
            }

            if (var7 == null && var6 == 4)
            {
                var9 = 0;
                var8 = 0;
                var7 = TerrainGenManager.treeFactory.makeTreeGenerator(true, ITreeFactory.TreeType.FIR);
            }
        }

        if (var7 != null)
        {
            if (var10)
            {
                var1.setRawTypeId(var2 + var8, var3, var4 + var9, 0);
                var1.setRawTypeId(var2 + var8 + 1, var3, var4 + var9, 0);
                var1.setRawTypeId(var2 + var8, var3, var4 + var9 + 1, 0);
                var1.setRawTypeId(var2 + var8 + 1, var3, var4 + var9 + 1, 0);
            }
            else
            {
                var1.setRawTypeId(var2, var3, var4, 0);
            }

            int var11 = var10 ? 1 : 0;

            if (!var7.a(var1, var5, var2 + var8 + var11, var3, var4 + var9 + var11))
            {
                if (var10)
                {
                    var1.setRawTypeIdAndData(var2 + var8, var3, var4 + var9, this.id, var6);
                    var1.setRawTypeIdAndData(var2 + var8 + 1, var3, var4 + var9, this.id, var6);
                    var1.setRawTypeIdAndData(var2 + var8, var3, var4 + var9 + 1, this.id, var6);
                    var1.setRawTypeIdAndData(var2 + var8 + 1, var3, var4 + var9 + 1, this.id, var6);
                }
                else
                {
                    var1.setRawTypeIdAndData(var2, var3, var4, this.id, var6);
                }
            }
        }
    }

    public boolean isSameSapling(World var1, int var2, int var3, int var4, int var5)
    {
        return var1.getTypeId(var2, var3, var4) == this.id && unmarkedMetadata(var1.getData(var2, var3, var4)) == var5;
    }

    public boolean onUseBonemeal(World var1, int var2, int var3, int var4, int var5)
    {
        if (var2 == this.id)
        {
            if (!var1.isStatic)
            {
                this.growTree(var1, var3, var4, var5, var1.random);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!var1.isStatic)
        {
            super.a(var1, var2, var3, var4, var5);
            this.attemptGrowTree(var1, var2, var3, var4, var5);
        }
    }
}
