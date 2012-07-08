package extrabiomes.plugins;

import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.IPlugin;
import java.lang.reflect.Method;
import net.minecraft.server.Block;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ModLoader;

public enum PluginEE implements IPlugin
{
    INSTANCE;
    public static Method setEMC;
    public static Method getEMC;

    public static int getEMC(int var0)
    {
        return getEMC(var0, 0);
    }

    public static int getEMC(int var0, int var1)
    {
        ItemStack var2 = new ItemStack(var0, 1, var1);
        return getEMC(var2);
    }

    public static int getEMC(ItemStack var0)
    {
        Object[] var1 = new Object[] {var0};

        try
        {
            Object var2 = getEMC.invoke((Object)null, var1);
            return ((Integer)var2).intValue();
        }
        catch (Exception var4)
        {
            ModLoader.getLogger().fine("Could not get EMC.");
            return 0;
        }
    }

    public static void setEMC(int var0, int var1)
    {
        setEMC(var0, 0, var1);
    }

    public static void setEMC(int var0, int var1, int var2)
    {
        Object[] var3 = new Object[] {new Integer(var0), new Integer(var1), new Integer(var2)};

        try
        {
            setEMC.invoke((Object)null, var3);
        }
        catch (Exception var5)
        {
            ModLoader.getLogger().fine("Could not set EMC.");
        }
    }

    public static void setEMC(ItemStack var0, int var1)
    {
        setEMC(var0.id, var0.getData(), var1);
    }

    private static void setEMCValues()
    {
        int var0 = getEMC(Block.LEAVES.id);
        int var1 = getEMC(Block.SAND.id);
        int var2 = getEMC(Block.RED_ROSE.id);
        int var3 = getEMC(Block.LONG_GRASS.id);
        int var4 = getEMC(Block.SAND.id);
        int var5 = getEMC(Block.SAPLING.id);
        int var6 = getEMC(new ItemStack(Item.CLAY_BALL));
        int var7 = getEMC(new ItemStack(Item.WATER_BUCKET)) - getEMC(new ItemStack(Item.BUCKET));
        int var8 = var6 * 4 - var7 * 3;

        if (ExtrabiomesBlock.autumnLeaves != null && var0 > 0)
        {
            setEMC(ExtrabiomesBlock.autumnLeaves.id, 0, var0);
            setEMC(ExtrabiomesBlock.autumnLeaves.id, 1, var0);
            setEMC(ExtrabiomesBlock.autumnLeaves.id, 2, var0);
            setEMC(ExtrabiomesBlock.autumnLeaves.id, 3, var0);
        }

        if (ExtrabiomesBlock.greenLeaves != null && var0 > 0)
        {
            setEMC(ExtrabiomesBlock.greenLeaves.id, 0, var0);
            setEMC(ExtrabiomesBlock.greenLeaves.id, 1, var0);
            setEMC(ExtrabiomesBlock.greenLeaves.id, 2, var0);
        }

        if (ExtrabiomesBlock.catTail != null && var3 > 0)
        {
            setEMC(new ItemStack(ExtrabiomesBlock.catTail), var3);
        }

        if (ExtrabiomesBlock.crackedSand != null && var1 > 0)
        {
            setEMC(ExtrabiomesBlock.crackedSand.id, var1);
        }

        if (ExtrabiomesBlock.flower != null && var2 > 0)
        {
            setEMC(ExtrabiomesBlock.flower.id, 0, var0);
            setEMC(ExtrabiomesBlock.flower.id, 1, var0);
            setEMC(ExtrabiomesBlock.flower.id, 2, var0);
            setEMC(ExtrabiomesBlock.flower.id, 3, var0);
            setEMC(ExtrabiomesBlock.flower.id, 5, var0);
            setEMC(ExtrabiomesBlock.flower.id, 4, var0);
            setEMC(ExtrabiomesBlock.flower.id, 6, var0);
            setEMC(ExtrabiomesBlock.flower.id, 7, var0);
        }

        if (ExtrabiomesBlock.grass != null && var3 > 0)
        {
            setEMC(ExtrabiomesBlock.grass.id, 0, var3);
            setEMC(ExtrabiomesBlock.grass.id, 2, var3);
            setEMC(ExtrabiomesBlock.grass.id, 3, var3);
            setEMC(ExtrabiomesBlock.grass.id, 4, var3);
            setEMC(ExtrabiomesBlock.grass.id, 1, var3);
        }

        if (ExtrabiomesBlock.quickSand != null && var4 > 0)
        {
            setEMC(ExtrabiomesBlock.quickSand.id, var4);
        }

        if (ExtrabiomesBlock.redRock != null && var8 > 0)
        {
            setEMC(ExtrabiomesBlock.redRock.id, 1, var8);
            setEMC(ExtrabiomesBlock.redRock.id, 0, var8);
            setEMC(ExtrabiomesBlock.redRock.id, 2, var8 * 4);
        }

        if (ExtrabiomesBlock.sapling != null && var5 > 0)
        {
            setEMC(ExtrabiomesBlock.sapling.id, 0, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 1, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 2, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 3, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 4, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 5, var3);
            setEMC(ExtrabiomesBlock.sapling.id, 6, var3);
        }
    }

    public String getName()
    {
        return "EquivalentExchange";
    }

    public void inject()
    {
        try
        {
            Class var1 = Class.forName("EEProxy");
            Class[] var2 = new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE};
            setEMC = var1.getMethod("setEMC", var2);
            Class[] var3 = new Class[] {ItemStack.class};
            getEMC = var1.getMethod("getEMC", var3);
        }
        catch (Exception var4)
        {
            ModLoader.getLogger().fine("Could not find EE proxy.");
            return;
        }

        setEMCValues();
    }

    public boolean isEnabled()
    {
        return ModLoader.isModLoaded("mod_EE");
    }
}
