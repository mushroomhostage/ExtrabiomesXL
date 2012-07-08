package net.minecraft.server;

import extrabiomes.Extrabiomes;
import forge.NetworkMod;
import java.util.Random;

public class mod_ExtrabiomesXL extends NetworkMod
{
    public int addFuel(int var1, int var2)
    {
        return Extrabiomes.addFuel(var1, var2);
    }

    public boolean clientSideRequired()
    {
        return Extrabiomes.clientSideRequired();
    }

    public void generateSurface(World var1, Random var2, int var3, int var4)
    {
        Extrabiomes.generateSurface(var1, var2, var3, var4);
    }

    public String getName()
    {
        return Extrabiomes.getName();
    }

    public String getPriorities()
    {
        return Extrabiomes.getPriorities();
    }

    public String getVersion()
    {
        return Extrabiomes.getVersion();
    }

    public void load()
    {
        Extrabiomes.load();
    }

    public void modsLoaded()
    {
        Extrabiomes.modsLoaded(this);
    }

    public void takenFromCrafting(EntityHuman var1, ItemStack var2, IInventory var3)
    {
        Extrabiomes.takenFromCrafting(var1, var2, var3);
    }

    public String toString()
    {
        return this.getName() + " " + Extrabiomes.getVersionNumber();
    }
}
