package extrabiomes.terrain;

import extrabiomes.api.TerrainGenManager;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MathHelper;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenBigAutumnTree extends WorldGenerator
{
    static final byte[] otherCoordPairs = new byte[] {(byte)2, (byte)0, (byte)0, (byte)1, (byte)2, (byte)1};
    Random rand = new Random();
    World worldObj;
    int[] basePos = new int[] {0, 0, 0};
    int heightLimit = 0;
    int height;
    double heightAttenuation = 0.618D;
    double branchDensity = 1.0D;
    double branchSlope = 0.381D;
    double scaleWidth = 1.0D;
    double leafDensity = 1.0D;
    int trunkSize = 1;
    int heightLimitLimit = 12;
    int leafDistanceLimit = 4;
    int[][] leafNodes;
    private final ItemStack leaf;
    private final ItemStack wood;

    public WorldGenBigAutumnTree(boolean var1, ItemStack var2, ItemStack var3)
    {
        super(var1);
        this.leaf = var2;
        this.wood = var3;
    }

    int checkBlockLine(int[] var1, int[] var2)
    {
        int[] var3 = new int[] {0, 0, 0};
        byte var4 = 0;
        byte var5;

        for (var5 = 0; var4 < 3; ++var4)
        {
            var3[var4] = var2[var4] - var1[var4];

            if (Math.abs(var3[var4]) > Math.abs(var3[var5]))
            {
                var5 = var4;
            }
        }

        if (var3[var5] == 0)
        {
            return -1;
        }
        else
        {
            byte var6 = otherCoordPairs[var5];
            byte var7 = otherCoordPairs[var5 + 3];
            byte var8;

            if (var3[var5] > 0)
            {
                var8 = 1;
            }
            else
            {
                var8 = -1;
            }

            double var9 = (double)var3[var6] / (double)var3[var5];
            double var11 = (double)var3[var7] / (double)var3[var5];
            int[] var13 = new int[] {0, 0, 0};
            int var14 = 0;
            int var15;

            for (var15 = var3[var5] + var8; var14 != var15; var14 += var8)
            {
                var13[var5] = var1[var5] + var14;
                var13[var6] = MathHelper.floor((double)var1[var6] + (double)var14 * var9);
                var13[var7] = MathHelper.floor((double)var1[var7] + (double)var14 * var11);
                int var16 = this.worldObj.getTypeId(var13[0], var13[1], var13[2]);

                if (Block.byId[var16] != null && !Block.byId[var16].isLeaves(this.worldObj, var13[0], var13[1], var13[2]))
                {
                    break;
                }
            }

            return var14 == var15 ? -1 : Math.abs(var14);
        }
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        this.worldObj = var1;
        long var6 = var2.nextLong();
        this.rand.setSeed(var6);
        this.basePos[0] = var3;
        this.basePos[1] = var4;
        this.basePos[2] = var5;

        if (this.heightLimit == 0)
        {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }

        if (!this.validTreeLocation())
        {
            return false;
        }
        else
        {
            this.generateLeafNodeList();
            this.generateLeaves();
            this.generateTrunk();
            this.generateLeafNodeBases();
            return true;
        }
    }

    void generateLeafNode(int var1, int var2, int var3)
    {
        int var4 = var2;

        for (int var6 = var2 + this.leafDistanceLimit; var4 < var6; ++var4)
        {
            float var5 = this.leafSize(var4 - var2);
            this.genTreeLayer(var1, var4, var3, var5);
        }
    }

    void generateLeafNodeBases()
    {
        int var1 = 0;
        int var2 = this.leafNodes.length;

        for (int[] var3 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]}; var1 < var2; ++var1)
        {
            int[] var4 = this.leafNodes[var1];
            int[] var5 = new int[] {var4[0], var4[1], var4[2]};
            var3[1] = var4[3];
            int var6 = var3[1] - this.basePos[1];

            if (this.leafNodeNeedsBase(var6))
            {
                this.placeBlockLine(var3, var5);
            }
        }
    }

    void generateLeafNodeList()
    {
        this.height = (int)((double)this.heightLimit * this.heightAttenuation);

        if (this.height >= this.heightLimit)
        {
            this.height = this.heightLimit - 1;
        }

        int var1 = (int)(1.382D + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0D, 2.0D));

        if (var1 < 1)
        {
            var1 = 1;
        }

        int[][] var2 = new int[var1 * this.heightLimit][4];
        int var3 = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
        int var4 = 1;
        int var5 = this.basePos[1] + this.height;
        int var6 = var3 - this.basePos[1];
        var2[0][0] = this.basePos[0];
        var2[0][1] = var3;
        var2[0][2] = this.basePos[2];
        var2[0][3] = var5;
        --var3;

        while (var6 >= 0)
        {
            int var7 = 0;
            float var8 = this.layerSize(var6);

            if (var8 < 0.0F)
            {
                --var3;
                --var6;
            }
            else
            {
                for (double var9 = 0.5D; var7 < var1; ++var7)
                {
                    double var11 = this.scaleWidth * (double)var8 * ((double)this.rand.nextFloat() + 0.328D);
                    double var13 = (double)this.rand.nextFloat() * 2.0D * Math.PI;
                    int var15 = MathHelper.floor(var11 * Math.sin(var13) + (double)this.basePos[0] + var9);
                    int var16 = MathHelper.floor(var11 * Math.cos(var13) + (double)this.basePos[2] + var9);
                    int[] var17 = new int[] {var15, var3, var16};
                    int[] var18 = new int[] {var15, var3 + this.leafDistanceLimit, var16};

                    if (this.checkBlockLine(var17, var18) == -1)
                    {
                        int[] var19 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
                        double var20 = Math.sqrt(Math.pow((double)Math.abs(this.basePos[0] - var17[0]), 2.0D) + Math.pow((double)Math.abs(this.basePos[2] - var17[2]), 2.0D));
                        double var22 = var20 * this.branchSlope;

                        if ((double)var17[1] - var22 > (double)var5)
                        {
                            var19[1] = var5;
                        }
                        else
                        {
                            var19[1] = (int)((double)var17[1] - var22);
                        }

                        if (this.checkBlockLine(var19, var17) == -1)
                        {
                            var2[var4][0] = var15;
                            var2[var4][1] = var3;
                            var2[var4][2] = var16;
                            var2[var4][3] = var19[1];
                            ++var4;
                        }
                    }
                }

                --var3;
                --var6;
            }
        }

        this.leafNodes = new int[var4][4];
        System.arraycopy(var2, 0, this.leafNodes, 0, var4);
    }

    void generateLeaves()
    {
        int var1 = 0;

        for (int var2 = this.leafNodes.length; var1 < var2; ++var1)
        {
            this.generateLeafNode(this.leafNodes[var1][0], this.leafNodes[var1][1], this.leafNodes[var1][2]);
        }
    }

    void generateTrunk()
    {
        int var1 = this.basePos[0];
        int var2 = this.basePos[1];
        int var3 = this.basePos[1] + this.height;
        int var4 = this.basePos[2];
        int[] var5 = new int[] {var1, var2, var4};
        int[] var6 = new int[] {var1, var3, var4};
        this.placeBlockLine(var5, var6);

        if (this.trunkSize == 2)
        {
            ++var5[0];
            ++var6[0];
            this.placeBlockLine(var5, var6);
            ++var5[2];
            ++var6[2];
            this.placeBlockLine(var5, var6);
            var5[0] += -1;
            var6[0] += -1;
            this.placeBlockLine(var5, var6);
        }
    }

    void genTreeLayer(int var1, int var2, int var3, float var4)
    {
        int var5 = (int)((double)var4 + 0.618D);
        byte var6 = otherCoordPairs[1];
        byte var7 = otherCoordPairs[4];
        int[] var8 = new int[] {var1, var2, var3};
        int[] var9 = new int[] {0, 0, 0};
        int var10 = -var5;
        int var11 = -var5;

        for (var9[1] = var8[1]; var10 <= var5; ++var10)
        {
            var9[var6] = var8[var6] + var10;
            var11 = -var5;

            while (var11 <= var5)
            {
                double var12 = Math.sqrt(Math.pow((double)Math.abs(var10) + 0.5D, 2.0D) + Math.pow((double)Math.abs(var11) + 0.5D, 2.0D));

                if (var12 > (double)var4)
                {
                    ++var11;
                }
                else
                {
                    var9[var7] = var8[var7] + var11;
                    int var14 = this.worldObj.getTypeId(var9[0], var9[1], var9[2]);

                    if (Block.byId[var14] != null && !Block.byId[var14].isLeaves(this.worldObj, var9[0], var9[1], var9[2]))
                    {
                        ++var11;
                    }
                    else
                    {
                        this.setTypeAndData((org.bukkit.BlockChangeDelegate)this.worldObj, var9[0], var9[1], var9[2], this.leaf.getItem().id, this.leaf.getData());
                        ++var11;
                    }
                }
            }
        }
    }

    float layerSize(int var1)
    {
        if ((double)var1 < (double)this.heightLimit * 0.3D)
        {
            return -1.618F;
        }
        else
        {
            float var2 = (float)this.heightLimit / 2.0F;
            float var3 = (float)this.heightLimit / 2.0F - (float)var1;
            float var4;

            if (var3 == 0.0F)
            {
                var4 = var2;
            }
            else if (Math.abs(var3) >= var2)
            {
                var4 = 0.0F;
            }
            else
            {
                var4 = (float)Math.sqrt(Math.pow((double)Math.abs(var2), 2.0D) - Math.pow((double)Math.abs(var3), 2.0D));
            }

            var4 *= 0.5F;
            return var4;
        }
    }

    boolean leafNodeNeedsBase(int var1)
    {
        return (double)var1 >= (double)this.heightLimit * 0.2D;
    }

    float leafSize(int var1)
    {
        return var1 >= 0 && var1 < this.leafDistanceLimit ? (var1 != 0 && var1 != this.leafDistanceLimit - 1 ? 3.0F : 2.0F) : -1.0F;
    }

    void placeBlockLine(int[] var1, int[] var2)
    {
        int[] var3 = new int[] {0, 0, 0};
        byte var4 = 0;
        byte var5;

        for (var5 = 0; var4 < 3; ++var4)
        {
            var3[var4] = var2[var4] - var1[var4];

            if (Math.abs(var3[var4]) > Math.abs(var3[var5]))
            {
                var5 = var4;
            }
        }

        if (var3[var5] != 0)
        {
            byte var6 = otherCoordPairs[var5];
            byte var7 = otherCoordPairs[var5 + 3];
            byte var8;

            if (var3[var5] > 0)
            {
                var8 = 1;
            }
            else
            {
                var8 = -1;
            }

            double var9 = (double)var3[var6] / (double)var3[var5];
            double var11 = (double)var3[var7] / (double)var3[var5];
            int[] var13 = new int[] {0, 0, 0};
            int var14 = 0;

            for (int var15 = var3[var5] + var8; var14 != var15; var14 += var8)
            {
                var13[var5] = MathHelper.floor((double)(var1[var5] + var14) + 0.5D);
                var13[var6] = MathHelper.floor((double)var1[var6] + (double)var14 * var9 + 0.5D);
                var13[var7] = MathHelper.floor((double)var1[var7] + (double)var14 * var11 + 0.5D);
                Block var16 = Block.byId[this.worldObj.getTypeId(var13[0], var13[1], var13[2])];

                if (var16 == null || var16.isLeaves(this.worldObj, var13[0], var13[1], var13[2]))
                {
                    this.setTypeAndData((org.bukkit.BlockChangeDelegate)this.worldObj, var13[0], var13[1], var13[2], this.wood.getItem().id, this.wood.getData());
                }
            }
        }
    }

    /**
     * Rescales the generator settings, only used in WorldGenBigTree
     */
    public void a(double var1, double var3, double var5)
    {
        this.heightLimitLimit = (int)(var1 * 12.0D);

        if (var1 > 0.5D)
        {
            this.leafDistanceLimit = 5;
        }

        this.scaleWidth = var3;
        this.leafDensity = var5;
    }

    boolean validTreeLocation()
    {
        int[] var1 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
        int[] var2 = new int[] {this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2]};
        int var3 = this.worldObj.getTypeId(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);

        if (!TerrainGenManager.treesCanGrowOnIDs.contains(Integer.valueOf(var3)))
        {
            return false;
        }
        else
        {
            int var4 = this.checkBlockLine(var1, var2);

            if (var4 == -1)
            {
                return true;
            }
            else if (var4 < 6)
            {
                return false;
            }
            else
            {
                this.heightLimit = var4;
                return true;
            }
        }
    }
}
