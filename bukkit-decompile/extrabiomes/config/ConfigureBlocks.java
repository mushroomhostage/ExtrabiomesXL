package extrabiomes.config;

import extrabiomes.ItemCatTail;
import extrabiomes.ItemCustomLeaves;
import extrabiomes.MultiItemBlock;
import extrabiomes.Proxy;
import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.blocks.BlockAutumnLeaves;
import extrabiomes.blocks.BlockCatTail;
import extrabiomes.blocks.BlockCrackedSand;
import extrabiomes.blocks.BlockCustomFlower;
import extrabiomes.blocks.BlockCustomSapling;
import extrabiomes.blocks.BlockCustomTallGrass;
import extrabiomes.blocks.BlockGreenLeaves;
import extrabiomes.blocks.BlockLeafPile;
import extrabiomes.blocks.BlockQuickSand;
import extrabiomes.blocks.BlockRedRock;
import forge.MinecraftForge;
import forge.Property;
import net.minecraft.server.ItemStack;

public class ConfigureBlocks
{
    public static boolean crackedSandCanGrow = true;
    public static boolean crackedSandGrowthRestrictedToWasteland = false;

    public static void addNames()
    {
        Proxy.addName(ExtrabiomesBlock.catTail, "Cat Tail");
        Proxy.addName(ExtrabiomesBlock.crackedSand, "Cracked Sand");
        Proxy.addName(ExtrabiomesBlock.leafPile, "Leaf Pile");
        Proxy.addName(ExtrabiomesBlock.quickSand, "Quick Sand");

        if (ExtrabiomesBlock.redRock != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.redRock, 1, 0), "Red Rock");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.redRock, 1, 1), "Red Cobblestone");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.redRock, 1, 2), "Red Rock Brick");
        }

        if (ExtrabiomesBlock.autumnLeaves != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 0), "Brown Autumn Leaves");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 1), "Orange Autumn Leaves");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 2), "Purple Autumn Leaves");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 3), "Yellow Autumn Leaves");
        }

        if (ExtrabiomesBlock.flower != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 0), "Autumn Shrub");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 1), "Hydrangea");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 2), "Orange Flower");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 3), "Purple Flower");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 4), "Tiny Cactus");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 5), "Root");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 6), "Toad Stool");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.flower, 1, 7), "White Flower");
        }

        if (ExtrabiomesBlock.grass != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.grass, 1, 0), "Brown Grass");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.grass, 1, 1), "Short Brown Grass");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.grass, 1, 2), "Dead Grass");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.grass, 1, 3), "Tall Dead Grass");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.grass, 1, 4), "Yellow Dead Grass");
        }

        if (ExtrabiomesBlock.greenLeaves != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 0), "Fir Leaves");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 1), "Redwood Leaves");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 2), "Acacia Leaves");
        }

        if (ExtrabiomesBlock.sapling != null)
        {
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 0), "Brown Autumn Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 1), "Orange Autumn Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 2), "Purple Autumn Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 3), "Yellow Autumn Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 4), "Fir Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 5), "Redwood Sapling");
            Proxy.addName(new ItemStack(ExtrabiomesBlock.sapling, 1, 6), "Acacia Sapling");
        }
    }

    public static void initialize()
    {
        if (!Config.enableClassicMode)
        {
            int var0 = Config.getOrCreateIntProperty("crackedsand.id", "block", 150) & 255;

            if (var0 != 0)
            {
                crackedSandCanGrow = Config.getOrCreateBooleanProperty("wasteland.enable.growth", "BIOME", crackedSandCanGrow);
                crackedSandGrowthRestrictedToWasteland = Config.getOrCreateBooleanProperty("wasteland.restrict.growth.to.biome", "BIOME", crackedSandGrowthRestrictedToWasteland);
                ExtrabiomesBlock.crackedSand = (new BlockCrackedSand(var0)).a("crackedsand");
                MinecraftForge.setBlockHarvestLevel(ExtrabiomesBlock.crackedSand, "pickaxe", 0);
            }

            Property var1 = Config.getProperty("crackedsand.id", "block", String.valueOf(var0));
            var1.value = String.valueOf(var0);
            var1.comment = "Due to a hole in the 4096 patch crackedsand.id must be set to a value less than 256.";
            int var2 = Config.getOrCreateIntProperty("redrock.id", "block", 151) & 255;

            if (var2 != 0)
            {
                ExtrabiomesBlock.redRock = (new BlockRedRock(var2)).a("redrock");
                MinecraftForge.setBlockHarvestLevel(ExtrabiomesBlock.redRock, "pickaxe", 0);
            }

            Property var3 = Config.getProperty("redrock.id", "block", String.valueOf(var2));
            var3.value = String.valueOf(var2);
            var3.comment = "Due to a hole in the 4096 patch redrock.id must be set to a value less than 256.";
            int var4 = Config.getOrCreateBlockIdProperty("quicksand.id", 152);

            if (var4 != 0)
            {
                ExtrabiomesBlock.quickSand = (new BlockQuickSand(var4)).a("quicksand");
                MinecraftForge.setBlockHarvestLevel(ExtrabiomesBlock.quickSand, "shovel", 0);
            }

            int var5 = Config.getOrCreateBlockIdProperty("autumnleaves.id", 153);

            if (var5 != 0)
            {
                ExtrabiomesBlock.autumnLeaves = (new BlockAutumnLeaves(var5)).a("autumnleaves");
            }

            int var6 = Config.getOrCreateBlockIdProperty("greenleaves.id", 154);

            if (var6 != 0)
            {
                ExtrabiomesBlock.greenLeaves = (new BlockGreenLeaves(var6)).a("greenleaves");
            }

            int var7 = Config.getOrCreateBlockIdProperty("flower.id", 155);

            if (var7 != 0)
            {
                ExtrabiomesBlock.flower = (new BlockCustomFlower(var7)).a("flower");
            }

            int var8 = Config.getOrCreateBlockIdProperty("grass.id", 156);

            if (var8 != 0)
            {
                ExtrabiomesBlock.grass = (new BlockCustomTallGrass(var8)).a("grass");
            }

            int var9 = Config.getOrCreateBlockIdProperty("sapling.id", 156);

            if (var9 != 0)
            {
                ExtrabiomesBlock.sapling = (new BlockCustomSapling(var9)).a("sapling");
            }

            int var10 = Config.getOrCreateBlockIdProperty("cattail.id", 156);

            if (var10 != 0)
            {
                ExtrabiomesBlock.catTail = (new BlockCatTail(var10)).a("cattail");
            }

            int var11 = Config.getOrCreateBlockIdProperty("leafpile.id", 156);

            if (var11 != 0)
            {
                ExtrabiomesBlock.leafPile = (new BlockLeafPile(var11)).a("leafpile");
            }

            Proxy.registerBlock(ExtrabiomesBlock.crackedSand);
            Proxy.registerBlock(ExtrabiomesBlock.leafPile);
            Proxy.registerBlock(ExtrabiomesBlock.quickSand);
            Proxy.registerBlock(ExtrabiomesBlock.redRock, MultiItemBlock.class);
            Proxy.registerBlock(ExtrabiomesBlock.autumnLeaves, ItemCustomLeaves.class);
            Proxy.registerBlock(ExtrabiomesBlock.catTail, ItemCatTail.class);
            Proxy.registerBlock(ExtrabiomesBlock.flower, MultiItemBlock.class);
            Proxy.registerBlock(ExtrabiomesBlock.grass, MultiItemBlock.class);
            Proxy.registerBlock(ExtrabiomesBlock.greenLeaves, ItemCustomLeaves.class);
            Proxy.registerBlock(ExtrabiomesBlock.sapling, MultiItemBlock.class);
        }
    }
}
