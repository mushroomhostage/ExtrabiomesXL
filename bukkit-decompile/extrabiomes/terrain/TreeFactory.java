package extrabiomes.terrain;

import extrabiomes.api.ITreeFactory;
import extrabiomes.api.TerrainGenManager;
import net.minecraft.server.ItemStack;
import net.minecraft.server.WorldGenerator;

public class TreeFactory implements ITreeFactory
{
    WorldGenerator treeAcacia = null;
    WorldGenerator treeAcaciaNotify = null;
    WorldGenerator treeAutumnBrown = null;
    WorldGenerator treeAutumnBrownBig = null;
    WorldGenerator treeAutumnBrownBigNotify = null;
    WorldGenerator treeAutumnBrownNotify = null;
    WorldGenerator treeAutumnOrange = null;
    WorldGenerator treeAutumnOrangeBig = null;
    WorldGenerator treeAutumnOrangeBigNotify = null;
    WorldGenerator treeAutumnOrangeNotify = null;
    WorldGenerator treeAutumnPurple = null;
    WorldGenerator treeAutumnPurpleBig = null;
    WorldGenerator treeAutumnPurpleBigNotify = null;
    WorldGenerator treeAutumnPurpleNotify = null;
    WorldGenerator treeAutumnYellow = null;
    WorldGenerator treeAutumnYellowBig = null;
    WorldGenerator treeAutumnYellowBigNotify = null;
    WorldGenerator treeAutumnYellowNotify = null;
    WorldGenerator treeFir = null;
    WorldGenerator treeFirBig = null;
    WorldGenerator treeFirBigNotify = null;
    WorldGenerator treeFirNotify = null;
    WorldGenerator treeRedwood = null;
    WorldGenerator treeRedwoodNotify = null;

    private static WorldGenerator makeAutumnTree(boolean var0, TreeFactory.TreeColor var1, boolean var2)
    {
        ItemStack var3 = null;
        ItemStack var4 = null;

        switch (TreeFactory.NamelessClass391182854.$SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor[var1.ordinal()])
        {
            case 1:
                var3 = new ItemStack(TerrainGenManager.blockBrownAutumnLeaves, 1, TerrainGenManager.metaBrownAutumnLeaves);
                var4 = new ItemStack(TerrainGenManager.blockBrownAutumnWood, 1, TerrainGenManager.metaBrownAutumnWood);
                break;

            case 2:
                var3 = new ItemStack(TerrainGenManager.blockOrangeAutumnLeaves, 1, TerrainGenManager.metaOrangeAutumnLeaves);
                var4 = new ItemStack(TerrainGenManager.blockOrangeAutumnWood, 1, TerrainGenManager.metaOrangeAutumnWood);
                break;

            case 3:
                var3 = new ItemStack(TerrainGenManager.blockPurpleAutumnLeaves, 1, TerrainGenManager.metaPurpleAutumnLeaves);
                var4 = new ItemStack(TerrainGenManager.blockPurpleAutumnWood, 1, TerrainGenManager.metaPurpleAutumnWood);
                break;

            case 4:
                var3 = new ItemStack(TerrainGenManager.blockYellowAutumnLeaves, 1, TerrainGenManager.metaYellowAutumnLeaves);
                var4 = new ItemStack(TerrainGenManager.blockYellowAutumnWood, 1, TerrainGenManager.metaYellowAutumnWood);
        }

        return (WorldGenerator)(var2 ? new WorldGenBigAutumnTree(var0, var3, var4) : new WorldGenAutumnTree(var0, var3, var4));
    }

    public WorldGenerator makeTreeGenerator(boolean var1, ITreeFactory.TreeType var2)
    {
        switch (TreeFactory.NamelessClass391182854.$SwitchMap$extrabiomes$api$ITreeFactory$TreeType[var2.ordinal()])
        {
            case 1:
                if (var1)
                {
                    if (this.treeAutumnBrownNotify == null)
                    {
                        this.treeAutumnBrownNotify = makeAutumnTree(var1, TreeFactory.TreeColor.BROWN, false);
                    }

                    return this.treeAutumnBrownNotify;
                }

                if (this.treeAutumnBrown == null)
                {
                    this.treeAutumnBrown = makeAutumnTree(var1, TreeFactory.TreeColor.BROWN, false);
                }

                return this.treeAutumnBrown;

            case 2:
                if (var1)
                {
                    if (this.treeAutumnBrownBigNotify == null)
                    {
                        this.treeAutumnBrownBigNotify = makeAutumnTree(var1, TreeFactory.TreeColor.BROWN, true);
                    }

                    return this.treeAutumnBrownBigNotify;
                }

                if (this.treeAutumnBrownBig == null)
                {
                    this.treeAutumnBrownBig = makeAutumnTree(var1, TreeFactory.TreeColor.BROWN, true);
                }

                return this.treeAutumnBrownBig;

            case 3:
                if (var1)
                {
                    if (this.treeAutumnOrangeNotify == null)
                    {
                        this.treeAutumnOrangeNotify = makeAutumnTree(var1, TreeFactory.TreeColor.ORANGE, false);
                    }

                    return this.treeAutumnOrangeNotify;
                }

                if (this.treeAutumnOrange == null)
                {
                    this.treeAutumnOrange = makeAutumnTree(var1, TreeFactory.TreeColor.ORANGE, false);
                }

                return this.treeAutumnOrange;

            case 4:
                if (var1)
                {
                    if (this.treeAutumnOrangeBigNotify == null)
                    {
                        this.treeAutumnOrangeBigNotify = makeAutumnTree(var1, TreeFactory.TreeColor.ORANGE, true);
                    }

                    return this.treeAutumnOrangeBigNotify;
                }

                if (this.treeAutumnOrangeBig == null)
                {
                    this.treeAutumnOrangeBig = makeAutumnTree(var1, TreeFactory.TreeColor.ORANGE, true);
                }

                return this.treeAutumnOrangeBig;

            case 5:
                if (var1)
                {
                    if (this.treeAutumnPurpleNotify == null)
                    {
                        this.treeAutumnPurpleNotify = makeAutumnTree(var1, TreeFactory.TreeColor.PURPLE, false);
                    }

                    return this.treeAutumnPurpleNotify;
                }

                if (this.treeAutumnPurple == null)
                {
                    this.treeAutumnPurple = makeAutumnTree(var1, TreeFactory.TreeColor.PURPLE, false);
                }

                return this.treeAutumnPurple;

            case 6:
                if (var1)
                {
                    if (this.treeAutumnPurpleBigNotify == null)
                    {
                        this.treeAutumnPurpleBigNotify = makeAutumnTree(var1, TreeFactory.TreeColor.PURPLE, true);
                    }

                    return this.treeAutumnPurpleBigNotify;
                }

                if (this.treeAutumnPurpleBig == null)
                {
                    this.treeAutumnPurpleBig = makeAutumnTree(var1, TreeFactory.TreeColor.PURPLE, true);
                }

                return this.treeAutumnPurpleBig;

            case 7:
                if (var1)
                {
                    if (this.treeAutumnYellowNotify == null)
                    {
                        this.treeAutumnYellowNotify = makeAutumnTree(var1, TreeFactory.TreeColor.YELLOW, false);
                    }

                    return this.treeAutumnYellowNotify;
                }

                if (this.treeAutumnYellow == null)
                {
                    this.treeAutumnYellow = makeAutumnTree(var1, TreeFactory.TreeColor.YELLOW, false);
                }

                return this.treeAutumnYellow;

            case 8:
                if (var1)
                {
                    if (this.treeAutumnYellowBigNotify == null)
                    {
                        this.treeAutumnYellowBigNotify = makeAutumnTree(var1, TreeFactory.TreeColor.YELLOW, true);
                    }

                    return this.treeAutumnYellowBigNotify;
                }

                if (this.treeAutumnYellowBig == null)
                {
                    this.treeAutumnYellowBig = makeAutumnTree(var1, TreeFactory.TreeColor.YELLOW, true);
                }

                return this.treeAutumnYellowBig;

            case 9:
                if (var1)
                {
                    if (this.treeFirNotify == null)
                    {
                        this.treeFirNotify = new WorldGenFirTree(var1);
                    }

                    return this.treeFirNotify;
                }

                if (this.treeFir == null)
                {
                    this.treeFir = new WorldGenFirTree(var1);
                }

                return this.treeFir;

            case 10:
                if (var1)
                {
                    if (this.treeFirBigNotify == null)
                    {
                        this.treeFirBigNotify = new WorldGenFirTree2(var1);
                    }

                    return this.treeFirBigNotify;
                }

                if (this.treeFirBig == null)
                {
                    this.treeFirBig = new WorldGenFirTree2(var1);
                }

                return this.treeFirBig;

            case 11:
                if (var1)
                {
                    if (this.treeRedwoodNotify == null)
                    {
                        this.treeRedwoodNotify = new WorldGenRedwood(var1);
                    }

                    return this.treeRedwoodNotify;
                }

                if (this.treeRedwood == null)
                {
                    this.treeRedwood = new WorldGenRedwood(var1);
                }

                return this.treeRedwood;

            case 12:
                if (var1)
                {
                    if (this.treeAcaciaNotify == null)
                    {
                        this.treeAcaciaNotify = new WorldGenAcacia(var1);
                    }

                    return this.treeAcaciaNotify;
                }

                if (this.treeAcacia == null)
                {
                    this.treeAcacia = new WorldGenAcacia(var1);
                }

                return this.treeAcacia;

            default:
                return null;
        }
    }

    public void registerTreeGen(ITreeFactory.TreeType var1, WorldGenerator var2, boolean var3)
    {
        switch (TreeFactory.NamelessClass391182854.$SwitchMap$extrabiomes$api$ITreeFactory$TreeType[var1.ordinal()])
        {
            case 1:
                if (var3)
                {
                    this.treeAutumnBrownNotify = var2;
                }
                else
                {
                    this.treeAutumnBrown = var2;
                }

                break;

            case 2:
                if (var3)
                {
                    this.treeAutumnBrownBigNotify = var2;
                }
                else
                {
                    this.treeAutumnBrownBig = var2;
                }

                break;

            case 3:
                if (var3)
                {
                    this.treeAutumnOrangeNotify = var2;
                }
                else
                {
                    this.treeAutumnOrange = var2;
                }

                break;

            case 4:
                if (var3)
                {
                    this.treeAutumnOrangeBigNotify = var2;
                }
                else
                {
                    this.treeAutumnOrangeBig = var2;
                }

                break;

            case 5:
                if (var3)
                {
                    this.treeAutumnPurpleNotify = var2;
                }
                else
                {
                    this.treeAutumnPurple = var2;
                }

                break;

            case 6:
                if (var3)
                {
                    this.treeAutumnPurpleBigNotify = var2;
                }
                else
                {
                    this.treeAutumnPurpleBig = var2;
                }

                break;

            case 7:
                if (var3)
                {
                    this.treeAutumnYellowNotify = var2;
                }
                else
                {
                    this.treeAutumnYellow = var2;
                }

                break;

            case 8:
                if (var3)
                {
                    this.treeAutumnYellowBigNotify = var2;
                }
                else
                {
                    this.treeAutumnYellowBig = var2;
                }

                break;

            case 9:
                if (var3)
                {
                    this.treeFirNotify = var2;
                }
                else
                {
                    this.treeFir = var2;
                }

                break;

            case 10:
                if (var3)
                {
                    this.treeFirBigNotify = var2;
                }
                else
                {
                    this.treeFirBig = var2;
                }

                break;

            case 11:
                if (var3)
                {
                    this.treeRedwoodNotify = var2;
                }
                else
                {
                    this.treeRedwood = var2;
                }

                break;

            case 12:
                if (var3)
                {
                    this.treeAcaciaNotify = var2;
                }
                else
                {
                    this.treeAcacia = var2;
                }
        }
    }

    static enum TreeColor
    {
        BROWN("BROWN", 0),
        ORANGE("ORANGE", 1),
        PURPLE("PURPLE", 2),
        YELLOW("YELLOW", 3);

        private static final TreeFactory.TreeColor[] $VALUES = new TreeFactory.TreeColor[]{BROWN, ORANGE, PURPLE, YELLOW};

        private TreeColor(String var1, int var2) {}
    }

    static class NamelessClass391182854
    {
        static final int[] $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor;

        static final int[] $SwitchMap$extrabiomes$api$ITreeFactory$TreeType = new int[ITreeFactory.TreeType.values().length];

        static
        {
            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.BROWN_AUTUMN.ordinal()] = 1;
            }
            catch (NoSuchFieldError var16)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.BROWN_AUTUMN_BIG.ordinal()] = 2;
            }
            catch (NoSuchFieldError var15)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.ORANGE_AUTUMN.ordinal()] = 3;
            }
            catch (NoSuchFieldError var14)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.ORANGE_AUTUMN_BIG.ordinal()] = 4;
            }
            catch (NoSuchFieldError var13)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.PURPLE_AUTUMN.ordinal()] = 5;
            }
            catch (NoSuchFieldError var12)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.PURPLE_AUTUMN_BIG.ordinal()] = 6;
            }
            catch (NoSuchFieldError var11)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.YELLOW_AUTUMN.ordinal()] = 7;
            }
            catch (NoSuchFieldError var10)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.YELLOW_AUTUMN_BIG.ordinal()] = 8;
            }
            catch (NoSuchFieldError var9)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.FIR.ordinal()] = 9;
            }
            catch (NoSuchFieldError var8)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.FIR_HUGE.ordinal()] = 10;
            }
            catch (NoSuchFieldError var7)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.REDWOOD.ordinal()] = 11;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$api$ITreeFactory$TreeType[ITreeFactory.TreeType.ACACIA.ordinal()] = 12;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor = new int[TreeFactory.TreeColor.values().length];

            try
            {
                $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor[TreeFactory.TreeColor.BROWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor[TreeFactory.TreeColor.ORANGE.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor[TreeFactory.TreeColor.PURPLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                $SwitchMap$extrabiomes$terrain$TreeFactory$TreeColor[TreeFactory.TreeColor.YELLOW.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
