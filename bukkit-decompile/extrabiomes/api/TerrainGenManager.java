package extrabiomes.api;

import java.util.Set;
import java.util.TreeSet;
import net.minecraft.server.Block;

public class TerrainGenManager
{
    public static Block blockWasteland = Block.SANDSTONE;
    public static Block blockMountainRidge = Block.STONE;
    public static boolean enableQuickSandGen = false;
    public static boolean enableCattailGen = false;
    public static boolean enableAutumnTreeGen = true;
    public static boolean enableFirGen = true;
    public static boolean enableRedwoodGen = true;
    public static boolean enableAcaciaGen = true;
    public static Block blockBrownAutumnLeaves = Block.LEAVES;
    public static int metaBrownAutumnLeaves = 0;
    public static Block blockBrownAutumnWood = Block.LOG;
    public static int metaBrownAutumnWood = 0;
    public static Block blockOrangeAutumnLeaves = Block.LEAVES;
    public static int metaOrangeAutumnLeaves = 0;
    public static Block blockOrangeAutumnWood = Block.LOG;
    public static int metaOrangeAutumnWood = 0;
    public static Block blockPurpleAutumnLeaves = Block.LEAVES;
    public static int metaPurpleAutumnLeaves = 0;
    public static Block blockPurpleAutumnWood = Block.LOG;
    public static int metaPurpleAutumnWood = 0;
    public static Block blockYellowAutumnLeaves = Block.LEAVES;
    public static int metaYellowAutumnLeaves = 0;
    public static Block blockYellowAutumnWood = Block.LOG;
    public static int metaYellowAutumnWood = 0;
    public static Block blockFirLeaves = Block.LEAVES;
    public static int metaFirLeaves = 1;
    public static Block blockFirWood = Block.LOG;
    public static int metaFirWood = 1;
    public static Block blockRedwoodLeaves = Block.LEAVES;
    public static int metaRedwoodLeaves = 0;
    public static Block blockRedwoodWood = Block.LOG;
    public static int metaRedwoodWood = 1;
    public static Block blockAcaciaLeaves = Block.LEAVES;
    public static int metaAcaciaLeaves = 0;
    public static Block blockAcaciaWood = Block.LOG;
    public static int metaAcaciaWood = 0;
    public static ITreeFactory treeFactory;
    public static Set treesCanGrowOnIDs = new TreeSet();
}
