package extrabiomes.plugins;

import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.IPlugin;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.biomes.CustomBiomeManager;
import extrabiomes.biomes.ExtrabiomeGenBase;
import extrabiomes.plugins.forestry.CropProviderSapling;
import extrabiomes.plugins.forestry.WorldGenChunkBogEarth;
import extrabiomes.terrain.BiomeDecoration;
import forestry.api.apiculture.FlowerManager;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.core.ForestryBlock;
import forestry.api.core.GlobalManager;
import forestry.api.cultivation.CropProviders;
import forestry.api.storage.BackpackManager;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ModLoader;

public enum PluginForestry implements IPlugin
{
    INSTANCE;
    private static final int DIGGER = 1;
    private static final int FORESTER = 2;
    private static final int ADVENTURER = 4;

    private static void addBackpackItems()
    {
        if (ExtrabiomesBlock.crackedSand != null)
        {
            BackpackManager.backpackItems[1].add(new ItemStack(ExtrabiomesBlock.crackedSand));
        }

        if (ExtrabiomesBlock.redRock != null)
        {
            BackpackManager.backpackItems[1].add(new ItemStack(ExtrabiomesBlock.redRock));
        }

        if (ExtrabiomesBlock.quickSand != null)
        {
            BackpackManager.backpackItems[4].add(new ItemStack(ExtrabiomesBlock.quickSand));
        }

        if (ExtrabiomesBlock.autumnLeaves != null)
        {
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 0));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 1));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 2));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.autumnLeaves, 1, 3));
        }

        if (ExtrabiomesBlock.greenLeaves != null)
        {
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 0));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 1));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.greenLeaves, 1, 2));
        }

        if (ExtrabiomesBlock.sapling != null)
        {
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 0));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 1));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 2));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 3));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 4));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 5));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.sapling, 1, 6));
        }

        if (ExtrabiomesBlock.flower != null)
        {
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 0));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 1));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 2));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 3));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 5));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 4));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 6));
            BackpackManager.backpackItems[2].add(new ItemStack(ExtrabiomesBlock.flower, 1, 7));
        }
    }

    private static void addBasicFlowers()
    {
        if (ExtrabiomesBlock.flower != null)
        {
            FlowerManager.plainFlowers.add(new ItemStack(ExtrabiomesBlock.flower, 1, 1));
            FlowerManager.plainFlowers.add(new ItemStack(ExtrabiomesBlock.flower, 1, 2));
            FlowerManager.plainFlowers.add(new ItemStack(ExtrabiomesBlock.flower, 1, 3));
            FlowerManager.plainFlowers.add(new ItemStack(ExtrabiomesBlock.flower, 1, 7));
        }
    }

    private static void addBogEarthToGreenSwampBiome()
    {
        BiomeDecoration var0 = new BiomeDecoration(1, new WorldGenChunkBogEarth());
        Collection var1 = (Collection)BiomeDecorationsManager.biomeDecorations.get(CustomBiomeManager.greenSwamp);
        var1.add(var0);
    }

    private static void addClimates()
    {
        Iterator var0 = ExtrabiomeGenBase.customBiomeList.iterator();

        while (var0.hasNext())
        {
            BiomeBase var1 = (BiomeBase)var0.next();

            if (var1 != null)
            {
                if (var1.F >= 2.0F)
                {
                    EnumTemperature.hotBiomeIds.add(Integer.valueOf(var1.id));
                }
                else if (var1.F >= 1.2F)
                {
                    EnumTemperature.warmBiomeIds.add(Integer.valueOf(var1.id));
                }
                else if (var1.F >= 0.2F)
                {
                    EnumTemperature.normalBiomeIds.add(Integer.valueOf(var1.id));
                }
                else if (var1.F >= 0.15F)
                {
                    EnumTemperature.coldBiomeIds.add(Integer.valueOf(var1.id));
                }
                else
                {
                    EnumTemperature.icyBiomeIds.add(Integer.valueOf(var1.id));
                }

                if (var1.G >= 0.9F)
                {
                    EnumHumidity.dampBiomeIds.add(Integer.valueOf(var1.id));
                }
                else if (var1.G >= 0.3F)
                {
                    EnumHumidity.normalBiomeIds.add(Integer.valueOf(var1.id));
                }
                else
                {
                    EnumHumidity.aridBiomeIds.add(Integer.valueOf(var1.id));
                }
            }
        }
    }

    private static void addGlobals()
    {
        if (ExtrabiomesBlock.autumnLeaves != null)
        {
            GlobalManager.leafBlockIds.add(Integer.valueOf(ExtrabiomesBlock.autumnLeaves.id));
        }

        if (ExtrabiomesBlock.greenLeaves != null)
        {
            GlobalManager.leafBlockIds.add(Integer.valueOf(ExtrabiomesBlock.greenLeaves.id));
        }
    }

    private static void addSaplings()
    {
        if (ExtrabiomesBlock.sapling != null)
        {
            CropProviders.arborealCrops.add(new CropProviderSapling());
            TerrainGenManager.treesCanGrowOnIDs.add(Integer.valueOf(ForestryBlock.soil.id));
        }
    }

    public String getName()
    {
        return "Forestry";
    }

    public void inject()
    {
        addBogEarthToGreenSwampBiome();
        addSaplings();
        addBasicFlowers();
        addClimates();
        addGlobals();
        addBackpackItems();
    }

    public boolean isEnabled()
    {
        return ModLoader.isModLoaded("mod_Forestry");
    }
}
