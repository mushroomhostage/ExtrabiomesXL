package extrabiomes.plugins;

import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.api.BiomeManager;
import extrabiomes.api.IPlugin;
import extrabiomes.plugins.pamsmods.PamGen;
import java.lang.reflect.Field;
import java.util.Collection;
import net.minecraft.server.ModLoader;

public enum PluginHarvestcraft implements IPlugin
{
    INSTANCE;

    public String getName()
    {
        return "Pam\'s HarvestCraft";
    }

    public void inject()
    {
        try
        {
            Class var1 = Class.forName("mod_Pamfood");
            Field var2 = var1.getField("treeRarity");
            PamGen.TREES.setRarity(var2.getInt((Object)null));
            var2 = var1.getField("bushRarity");
            PamGen.BUSHES.setRarity(var2.getInt((Object)null));
            var2 = var1.getField("treewarmRarity");
            PamGen.WARM_TREES.setRarity(var2.getInt((Object)null));
            var2 = var1.getField("bushwarmRarity");
            PamGen.WARM_BUSHES.setRarity(var2.getInt((Object)null));
            var1 = Class.forName("WorldGenPamTrees");
            Class[] var3 = new Class[] {Integer.TYPE};
            PamGen.TREES.setConstructor(var1.getConstructor(var3));
            var1 = Class.forName("WorldGenPamBushes");
            PamGen.BUSHES.setConstructor(var1.getConstructor(var3));
            var1 = Class.forName("WorldGenPamTreesWarm");
            PamGen.WARM_TREES.setConstructor(var1.getConstructor(var3));
            var1 = Class.forName("WorldGenPamBushesWarm");
            PamGen.WARM_BUSHES.setConstructor(var1.getConstructor(var3));
        }
        catch (Exception var4)
        {
            ModLoader.getLogger().fine("Could not find HarvestCraft fields.");
            return;
        }

        this.setBiomeDecorations();
    }

    public boolean isEnabled()
    {
        return ModLoader.isModLoaded("mod_Pamfood");
    }

    private void setBiomeDecorations()
    {
        Collection var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.autumnwoods);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.birchforest);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.extremejungle);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.forestedhills);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.forestedisland);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.greenhills);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.greenswamp);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.meadow);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.minijungle);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.mountaindesert);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.mountainridge);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.pineforest);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.rainforest);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.redwoodforest);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.redwoodlush);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.savanna);
        var1.add(PamGen.WARM_TREES);
        var1.add(PamGen.WARM_BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.shrubland);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.temperaterainforest);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
        var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(BiomeManager.woodlands);
        var1.add(PamGen.TREES);
        var1.add(PamGen.BUSHES);
    }
}
