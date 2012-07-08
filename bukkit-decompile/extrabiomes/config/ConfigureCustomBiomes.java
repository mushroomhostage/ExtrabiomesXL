package extrabiomes.config;

import extrabiomes.Proxy;
import extrabiomes.api.BiomeManager;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.WorldGenVillage;

public class ConfigureCustomBiomes
{
    private static void configureCustomBiome(String var0, BiomeBase var1)
    {
        if (Config.getOrCreateBooleanProperty(var0 + ".enable", "BIOME", true))
        {
            BiomeManager.enabledCustomBiomes.add(var1);

            if (Config.getOrCreateBooleanProperty(var0 + ".allow.village", "BIOME", true))
            {
                BiomeManager.villageSpawnBiomes.add(var1);
            }
        }
    }

    public static void enableCustomBiomes()
    {
        Iterator var0 = BiomeManager.enabledCustomBiomes.iterator();

        while (var0.hasNext())
        {
            BiomeBase var1 = (BiomeBase)var0.next();
            Proxy.addBiome(var1);
        }

        ArrayList var2 = new ArrayList();
        var2.addAll(WorldGenVillage.a);
        var2.addAll(BiomeManager.villageSpawnBiomes);
        WorldGenVillage.a = var2;
        BiomeManager.villageSpawnBiomes = null;
    }

    public static void initialize()
    {
        configureCustomBiome("alpine", BiomeManager.alpine);
        configureCustomBiome("autumnwoods", BiomeManager.autumnwoods);
        configureCustomBiome("birchforest", BiomeManager.birchforest);
        configureCustomBiome("extremejungle", BiomeManager.extremejungle);
        configureCustomBiome("forestedhills", BiomeManager.forestedhills);
        configureCustomBiome("forestedisland", BiomeManager.forestedisland);
        configureCustomBiome("glacier", BiomeManager.glacier);
        configureCustomBiome("greenhills", BiomeManager.greenhills);
        configureCustomBiome("greenswamp", BiomeManager.greenswamp);
        configureCustomBiome("icewasteland", BiomeManager.icewasteland);
        configureCustomBiome("marsh", BiomeManager.marsh);
        configureCustomBiome("meadow", BiomeManager.meadow);
        configureCustomBiome("minijungle", BiomeManager.minijungle);
        configureCustomBiome("mountaindesert", BiomeManager.mountaindesert);
        configureCustomBiome("mountainridge", BiomeManager.mountainridge);
        configureCustomBiome("mountaintaiga", BiomeManager.mountaintaiga);
        configureCustomBiome("pineforest", BiomeManager.pineforest);
        configureCustomBiome("rainforest", BiomeManager.rainforest);
        configureCustomBiome("redwoodforest", BiomeManager.redwoodforest);
        configureCustomBiome("redwoodlush", BiomeManager.redwoodlush);
        configureCustomBiome("savanna", BiomeManager.savanna);
        configureCustomBiome("shrubland", BiomeManager.shrubland);
        configureCustomBiome("snowforest", BiomeManager.snowforest);
        configureCustomBiome("snowyrainforest", BiomeManager.snowyrainforest);
        configureCustomBiome("temporaterainforest", BiomeManager.temperaterainforest);
        configureCustomBiome("tundra", BiomeManager.tundra);
        configureCustomBiome("wasteland", BiomeManager.wasteland);
        configureCustomBiome("woodlands", BiomeManager.woodlands);
    }
}
