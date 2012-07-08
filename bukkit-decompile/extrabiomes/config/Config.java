package extrabiomes.config;

import extrabiomes.Proxy;
import forge.Configuration;
import forge.Property;
import java.io.File;

public class Config
{
    public static boolean enableClassicMode = false;
    public static final String CATEGORY_BIOME = "BIOME";
    public static Configuration config;

    public static void addNames()
    {
        ConfigureBlocks.addNames();
        ConfigureItems.addNames();
    }

    public static int getOrCreateBlockIdProperty(String var0, int var1)
    {
        return Integer.parseInt(config.getOrCreateBlockIdProperty(var0, var1).value);
    }

    public static boolean getOrCreateBooleanProperty(String var0, String var1, boolean var2)
    {
        return Boolean.parseBoolean(config.getOrCreateBooleanProperty(var0, var1, var2).value);
    }

    public static int getOrCreateIntProperty(String var0, String var1, int var2)
    {
        return Integer.parseInt(config.getOrCreateIntProperty(var0, var1, var2).value);
    }

    public static Property getProperty(String var0, String var1, String var2)
    {
        return config.getOrCreateProperty(var0, var1, var2);
    }

    public static void load()
    {
        config = new Configuration(new File(Proxy.getExtrabiomesRoot(), "/config/extrabiomes/extrabiomes.cfg"));
        config.load();
        Property var0 = config.getOrCreateBooleanProperty("classicmode.enable", "general", enableClassicMode);
        var0.comment = "set to true to disable all custom blocks";
        enableClassicMode = Boolean.parseBoolean(var0.value);
        ConfigureBlocks.initialize();
        ConfigureBiomeDecorationsManager.initialize();
        ConfigureItems.initialize();
        AchievementManager.initialize();
        ConfigureVanillaBiomes.initialize();
        ConfigureTerrainGen.initialize();
        ConfigureBiomeManager.initialize();
        ConfigureCustomBiomes.initialize();
        ConfigurePlugins.initialize();
        config.save();
    }

    public static void modsLoaded() {}
}
