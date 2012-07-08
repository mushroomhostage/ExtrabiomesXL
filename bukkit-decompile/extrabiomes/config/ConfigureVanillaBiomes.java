package extrabiomes.config;

import extrabiomes.Proxy;
import extrabiomes.api.BiomeManager;
import java.util.Iterator;
import net.minecraft.server.BiomeBase;

public class ConfigureVanillaBiomes
{
    public static void initialize()
    {
        if (Config.getOrCreateBooleanProperty("vanilla.desert.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.DESERT);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.extremehills.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.EXTREME_HILLS);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.forest.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.FOREST);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.jungle.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.JUNGLE);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.plains.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.PLAINS);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.swampland.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.SWAMPLAND);
        }

        if (Config.getOrCreateBooleanProperty("vanilla.taiga.disable", "BIOME", false))
        {
            BiomeManager.disabledVanillaBiomes.add(BiomeBase.TAIGA);
        }
    }

    public static void disableVanillaBiomes()
    {
        Iterator var0 = BiomeManager.disabledVanillaBiomes.iterator();

        while (var0.hasNext())
        {
            BiomeBase var1 = (BiomeBase)var0.next();
            Proxy.removeBiome(var1);
        }

        BiomeManager.disabledVanillaBiomes = null;
    }
}
