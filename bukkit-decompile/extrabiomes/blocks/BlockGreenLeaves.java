package extrabiomes.blocks;

import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.TerrainGenManager;
import forge.IShearable;
import forge.ITextureProvider;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.BlockTransparant;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockGreenLeaves extends BlockTransparant implements IShearable, ITextureProvider
{
    private static final int METADATA_BITMASK = 3;
    private static final int METADATA_USERPLACEDBIT = 4;
    private static final int METADATA_DECAYBIT = 8;
    private static final int METADATA_CLEARDECAYBIT = -9;
    public static final int metaFir = 0;
    public static final int metaRedwood = 1;
    public static final int metaAcacia = 2;
    int[] adjacentTreeBlocks;

    private static int clearDecayOnMetadata(int var0)
    {
        return var0 & -9;
    }

    private static boolean isDecaying(int var0)
    {
        return (var0 & 8) != 0;
    }

    private static boolean isUserPlaced(int var0)
    {
        return (var0 & 4) != 0;
    }

    private static int setDecayOnMetadata(int var0)
    {
        return var0 | 8;
    }

    private static int unmarkedMetadata(int var0)
    {
        return var0 & 3;
    }

    public BlockGreenLeaves(int var1)
    {
        super(var1, 80, Material.LEAVES, false);
        this.a(true);
        this.c(0.2F);
        this.f(1);
        this.a(g);
        this.j();
        Block.setBurnProperties(var1, 30, 60);
        TerrainGenManager.blockAcaciaLeaves = this;
        TerrainGenManager.blockRedwoodLeaves = this;
        TerrainGenManager.blockFirLeaves = this;
        TerrainGenManager.metaFirLeaves = 0;
        TerrainGenManager.metaRedwoodLeaves = 1;
        TerrainGenManager.metaAcaciaLeaves = 2;
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this, 1, 0));
        var1.add(new ItemStack(this, 1, 1));
        var1.add(new ItemStack(this, 1, 2));
    }

    public void beginLeavesDecay(World var1, int var2, int var3, int var4)
    {
        var1.setRawData(var2, var3, var4, setDecayOnMetadata(var1.getData(var2, var3, var4)));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int getDropData(int var1)
    {
        return unmarkedMetadata(var1) + 4;
    }

    private void doSaplingDrop(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        int var7 = this.getDropType(var5, var1.random, var6);
        int var8 = this.getDropData(var5);
        this.a(var1, var2, var3, var4, new ItemStack(var7, 1, var8));
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropNaturally(World var1, int var2, int var3, int var4, int var5, float var6, int var7)
    {
        if (!var1.isStatic)
        {
            if (var1.random.nextInt(20) == 0)
            {
                this.doSaplingDrop(var1, var2, var3, var4, var5, var7);
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return this.textureId + unmarkedMetadata(var2) * 2 + (!this.a() ? 0 : 1);
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
        return ExtrabiomesBlock.sapling.id;
    }

    public boolean isLeaves(World var1, int var2, int var3, int var4)
    {
        return true;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean a()
    {
        return Block.LEAVES.a();
    }

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    /**
     * Called whenever the block is removed.
     */
    public void remove(World var1, int var2, int var3, int var4)
    {
        boolean var5 = true;
        boolean var6 = true;

        if (var1.a(var2 - 2, var3 - 2, var4 - 2, var2 + 2, var3 + 2, var4 + 2))
        {
            for (int var7 = -1; var7 <= 1; ++var7)
            {
                for (int var8 = -1; var8 <= 1; ++var8)
                {
                    for (int var9 = -1; var9 <= 1; ++var9)
                    {
                        int var10 = var1.getTypeId(var2 + var7, var3 + var8, var4 + var9);

                        if (Block.byId[var10] != null)
                        {
                            Block.byId[var10].beginLeavesDecay(var1, var2 + var7, var3 + var8, var4 + var9);
                        }
                    }
                }
            }
        }
    }

    /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
    public void b(World var1, int var2, int var3, int var4, Entity var5)
    {
        this.beginLeavesDecay(var1, var2, var3, var4);
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        var7.add(new ItemStack(this, 1, unmarkedMetadata(var2.getData(var3, var4, var5))));
        return var7;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int a(Random var1)
    {
        return var1.nextInt(20) == 0 ? 1 : 0;
    }

    private void removeLeaves(World var1, int var2, int var3, int var4)
    {
        this.b(var1, var2, var3, var4, var1.getData(var2, var3, var4), 0);
        var1.setTypeId(var2, var3, var4, 0);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!var1.isStatic)
        {
            int var6 = var1.getData(var2, var3, var4);

            if (!isUserPlaced(var6) && isDecaying(var6))
            {
                boolean var7 = true;
                boolean var8 = true;
                boolean var9 = true;
                boolean var10 = true;
                boolean var11 = true;

                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[32768];
                }

                if (var1.a(var2 - 5, var3 - 5, var4 - 5, var2 + 5, var3 + 5, var4 + 5))
                {
                    int var12;
                    int var13;
                    int var14;
                    int var15;

                    for (var12 = -4; var12 <= 4; ++var12)
                    {
                        for (var13 = -4; var13 <= 4; ++var13)
                        {
                            for (var14 = -4; var14 <= 4; ++var14)
                            {
                                var15 = var1.getTypeId(var2 + var12, var3 + var13, var4 + var14);
                                Block var16 = Block.byId[var15];

                                if (var16 != null && var16.canSustainLeaves(var1, var2 + var12, var3 + var13, var4 + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = 0;
                                }
                                else if (var16 != null && var16.isLeaves(var1, var2 + var12, var3 + var13, var4 + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -2;
                                }
                                else
                                {
                                    this.adjacentTreeBlocks[(var12 + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -1;
                                }
                            }
                        }
                    }

                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -4; var13 <= 4; ++var13)
                        {
                            for (var14 = -4; var14 <= 4; ++var14)
                            {
                                for (var15 = -4; var15 <= 4; ++var15)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32 + var15 + 16] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32 + var15 + 16] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + (var15 + 16 - 1)] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + (var15 + 16 - 1)] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (this.adjacentTreeBlocks[16912] >= 0)
                {
                    var1.setRawData(var2, var3, var4, clearDecayOnMetadata(var6));
                }
                else
                {
                    this.removeLeaves(var1, var2, var3, var4);
                }
            }
        }
    }
}
