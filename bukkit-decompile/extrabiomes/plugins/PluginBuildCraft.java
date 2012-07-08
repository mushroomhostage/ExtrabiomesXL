package extrabiomes.plugins;

import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.IPlugin;
import extrabiomes.plugins.buildcraft.OilPopulateMediumLargeDeposits;
import extrabiomes.plugins.buildcraft.OilPopulateSmallDepositDesert;
import extrabiomes.plugins.buildcraft.OilPopulateSmallDepositWasteland;
import java.lang.reflect.Field;
import java.util.Collection;
import net.minecraft.server.Block;
import net.minecraft.server.ModLoader;

public enum PluginBuildCraft implements IPlugin
{
    INSTANCE;
    public static boolean modifyWorld = false;
    public static Block oilStill = null;
    public static Block oilMoving = null;

    public String getName()
    {
        return "Buildcraft";
    }

    public void inject()
    {
        try
        {
            Class var1 = Class.forName("BuildCraftCore");
            Field var2 = var1.getField("modifyWorld");
            modifyWorld = var2.getBoolean((Object)null);
            var1 = Class.forName("BuildCraftEnergy");
            var2 = var1.getField("oilStill");
            oilStill = (Block)var2.get((Object)null);
            var2 = var1.getField("oilMoving");
            oilMoving = (Block)var2.get((Object)null);
        }
        catch (Exception var3)
        {
            ModLoader.getLogger().fine("Could not find Buildcraft classes.");
            return;
        }

        Collection var4 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.mountaindesert);
        var4.add(new OilPopulateSmallDepositDesert());
        var4 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.wasteland);
        var4.add(new OilPopulateSmallDepositWasteland());
        BiomeDecorationsManager.commonDecorations.add(new OilPopulateMediumLargeDeposits());
    }

    public boolean isEnabled()
    {
        return ModLoader.isModLoaded("mod_BuildCraftEnergy");
    }
}
