package extrabiomes.plugins;

import extrabiomes.Log;
import extrabiomes.Proxy;
import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.IBiomeDecoration;
import extrabiomes.api.IPlugin;
import extrabiomes.plugins.redpower.BiomeDecorationPlants;
import extrabiomes.plugins.redpower.BiomeDecorationRubberTrees;
import forge.Configuration;
import forge.Property;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.ModLoader;
import net.minecraft.server.WorldGenerator;

public enum PluginRedPower implements IPlugin
{
    INSTANCE;
    public static int idPlants = 0;
    public static Class worldGenRubberTree = null;
    public static Field fldPlants = null;
    public static final String CATEGORY_PLUGIN = "PLUGINS";

    private static void addBiomeDecoration(BiomeBase var0, IBiomeDecoration var1)
    {
        if (var1 != null)
        {
            Collection var2 = (Collection)BiomeDecorationsManager.biomeDecorations.get(var0);
            var2.add(var1);
        }
    }

    public static WorldGenerator newWorldGenRubberTree()
    {
        if (worldGenRubberTree != null)
        {
            try
            {
                return (WorldGenerator)worldGenRubberTree.newInstance();
            }
            catch (Exception var1)
            {
                Log.write("Could not create RedPower\'s rubber tree generator.");
            }
        }

        return null;
    }

    public String getName()
    {
        return "RedPower";
    }

    public void inject()
    {
        try
        {
            worldGenRubberTree = Class.forName("eloraam.world.WorldGenRubberTree");
        }
        catch (Exception var6)
        {
            Log.write("Could not find RedPower classes. Terrain generation features disabled.");
        }

        Configuration var1 = new Configuration(new File(Proxy.getExtrabiomesRoot(), "/config/extrabiomes/extrabiomes.cfg"));
        var1.load();
        Property var2 = var1.getOrCreateIntProperty("redpower.plants.id", "PLUGINS", idPlants);
        idPlants = Integer.parseInt(var2.value);

        if (idPlants == 0)
        {
            var2.comment = "Set this to the same value as plants.id in the world section of redpower/redpower.cfg";
        }

        var1.save();
        BiomeDecorationPlants var3 = idPlants != 0 ? new BiomeDecorationPlants() : null;
        BiomeDecorationPlants var4 = idPlants != 0 ? new BiomeDecorationPlants(4) : null;
        BiomeDecorationRubberTrees var5 = new BiomeDecorationRubberTrees();
        addBiomeDecoration(BiomeManager.extremejungle, var3);
        addBiomeDecoration(BiomeManager.extremejungle, var5);
        addBiomeDecoration(BiomeManager.minijungle, var3);
        addBiomeDecoration(BiomeManager.minijungle, var5);
        addBiomeDecoration(BiomeManager.birchforest, var3);
        addBiomeDecoration(BiomeManager.forestedhills, var3);
        addBiomeDecoration(BiomeManager.forestedisland, var3);
        addBiomeDecoration(BiomeManager.pineforest, var3);
        addBiomeDecoration(BiomeManager.rainforest, var3);
        addBiomeDecoration(BiomeManager.redwoodforest, var3);
        addBiomeDecoration(BiomeManager.temperaterainforest, var3);
        addBiomeDecoration(BiomeManager.woodlands, var3);
        addBiomeDecoration(BiomeManager.meadow, var4);
        addBiomeDecoration(BiomeManager.savanna, var4);
        addBiomeDecoration(BiomeManager.shrubland, var4);
    }

    public boolean isEnabled()
    {
        return ModLoader.isModLoaded("mod_RedPowerWorld");
    }

    public static void initBlockId()
    {
        Block var0 = null;

        try
        {
            var0 = (Block)fldPlants.get((Object)null);
        }
        catch (Exception var2)
        {
            Log.write("could not find RedPower plant block id. Disabling plant generation.");
        }

        if (var0 != null)
        {
            idPlants = var0.id;
        }
    }
}
