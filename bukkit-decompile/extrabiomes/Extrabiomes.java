package extrabiomes;

import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.ExtrabiomesItem;
import extrabiomes.api.IPlugin;
import extrabiomes.api.PluginManager;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.biomes.CustomBiomeManager;
import extrabiomes.config.AchievementManager;
import extrabiomes.config.Config;
import extrabiomes.config.ConfigureCustomBiomes;
import extrabiomes.config.ConfigureRecipes;
import extrabiomes.config.ConfigureVanillaBiomes;
import extrabiomes.terrain.TerrainGenerator;
import forge.NetworkMod;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.IInventory;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class Extrabiomes
{
    private static final String NAME = "ExtraBiomes XL";
    private static final String PRIORITIES = "";
    private static final String VERSION = "2.2.6";

    public static int addFuel(int var0, int var1)
    {
        return ExtrabiomesBlock.sapling != null && var0 == ExtrabiomesBlock.sapling.id ? 100 : 0;
    }

    public static boolean clientSideRequired()
    {
        return ExtrabiomesBlock.autumnLeaves != null || ExtrabiomesBlock.catTail != null || ExtrabiomesBlock.crackedSand != null || ExtrabiomesBlock.flower != null || ExtrabiomesBlock.grass != null || ExtrabiomesBlock.greenLeaves != null || ExtrabiomesBlock.leafPile != null || ExtrabiomesBlock.quickSand != null || ExtrabiomesBlock.redRock != null || ExtrabiomesBlock.sapling != null;
    }

    public static void generateSurface(World var0, Random var1, int var2, int var3)
    {
        TerrainGenerator.generateSurface(var0, var1, var2, var3);
    }

    public static String getName()
    {
        return "ExtraBiomes XL";
    }

    public static String getPriorities()
    {
        return "";
    }

    public static String getVersion()
    {
        return getVersionNumber() + " Server";
    }

    public static String getVersionNumber()
    {
        return "2.2.6";
    }

    private static void injectPlugins()
    {
        Iterator var0 = PluginManager.plugins.iterator();

        while (var0.hasNext())
        {
            IPlugin var1 = (IPlugin)var0.next();

            if (var1 != null && var1.isEnabled())
            {
                Log.write("Injecting the " + var1.getName() + " plugin into ExtrabiomesXL.");
                var1.inject();
            }
        }
    }

    public static void load()
    {
        Config.load();
    }

    public static void modsLoaded(NetworkMod var0)
    {
        Config.modsLoaded();
        ConfigureRecipes.initialize();
        Config.addNames();

        if (ExtrabiomesItem.scarecrow != null)
        {
            ExtrabiomesEntity.scarecrow = 127;
            Proxy.registerEntityID(EntityScarecrow.class, "scarecrow", ExtrabiomesEntity.scarecrow);
            Proxy.registerEntity(EntityScarecrow.class, var0, ExtrabiomesEntity.scarecrow);
        }

        ConfigureVanillaBiomes.disableVanillaBiomes();

        if (TerrainGenManager.blockWasteland != null)
        {
            CustomBiomeManager.wasteland.A = CustomBiomeManager.wasteland.B = (byte)TerrainGenManager.blockWasteland.id;
        }

        if (TerrainGenManager.blockWasteland != null)
        {
            CustomBiomeManager.mountainRidge.A = CustomBiomeManager.mountainRidge.B = (byte)TerrainGenManager.blockMountainRidge.id;
        }

        ConfigureCustomBiomes.enableCustomBiomes();
        injectPlugins();
    }

    public static void takenFromCrafting(EntityHuman var0, ItemStack var1, IInventory var2)
    {
        AchievementManager.craftingAchievement(var0, var1);
    }
}
