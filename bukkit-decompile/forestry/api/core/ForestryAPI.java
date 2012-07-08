package forestry.api.core;

import forge.NetworkMod;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.ItemStack;

public class ForestryAPI
{
    public static NetworkMod instance;
    public static ArrayList loggerWindfall = new ArrayList();
    private static ArrayList wrenchs = new ArrayList();

    public static boolean registerWrench(ItemStack var0)
    {
        ItemStack var1 = new ItemStack(var0.id, 0, var0.getData());
        Iterator var2 = wrenchs.iterator();
        ItemStack var3;

        do
        {
            if (!var2.hasNext())
            {
                wrenchs.add(var1);
                return true;
            }

            var3 = (ItemStack)var2.next();
        }
        while (!var3.doMaterialsMatch(var0));

        return false;
    }

    public static boolean isWrench(ItemStack var0)
    {
        Iterator var1 = wrenchs.iterator();
        ItemStack var2;

        do
        {
            if (!var1.hasNext())
            {
                return false;
            }

            var2 = (ItemStack)var1.next();
        }
        while (!var2.doMaterialsMatch(var0));

        return true;
    }
}
