package extrabiomes;

import forge.MinecraftForge;
import forge.NetworkMod;
import java.io.File;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ModLoader;

public class Proxy
{
    public static void addBiome(BiomeBase var0)
    {
        if (var0 != null)
        {
            ModLoader.addBiome(var0);
        }
    }

    public static void addName(Object var0, String var1)
    {
        if (var0 != null)
        {
            ModLoader.addName(var0, var1);
        }
    }

    public static void addRecipe(ItemStack var0, Object[] var1)
    {
        ModLoader.addRecipe(var0, var1);
    }

    public static void addShapelessRecipe(ItemStack var0, Object[] var1)
    {
        ModLoader.addShapelessRecipe(var0, var1);
    }

    public static File getExtrabiomesRoot()
    {
        return new File("./");
    }

    public static int getUniqueEntityId()
    {
        return ModLoader.getUniqueEntityId();
    }

    public static void registerBlock(Block var0)
    {
        if (var0 != null)
        {
            ModLoader.registerBlock(var0);
        }
    }

    public static void registerBlock(Block var0, Class var1)
    {
        if (var0 != null)
        {
            ModLoader.registerBlock(var0, var1);
        }
    }

    public static void registerEntity(Class var0, NetworkMod var1, int var2)
    {
        MinecraftForge.registerEntity(var0, var1, var2, 300, 2, true);
    }

    public static void registerEntityID(Class var0, String var1, int var2)
    {
        ModLoader.registerEntityID(var0, var1, var2);
    }

    public static void removeBiome(BiomeBase var0)
    {
        if (var0 != null)
        {
            ModLoader.removeBiome(var0);
        }
    }
}
