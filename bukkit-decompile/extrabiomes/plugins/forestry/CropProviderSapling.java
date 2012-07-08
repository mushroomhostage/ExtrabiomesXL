package extrabiomes.plugins.forestry;

import extrabiomes.api.ExtrabiomesBlock;
import forestry.api.core.ForestryAPI;
import forestry.api.core.ForestryBlock;
import forestry.api.cultivation.ICropEntity;
import forestry.api.cultivation.ICropProvider;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.Block;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class CropProviderSapling implements ICropProvider
{
    public boolean doPlant(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        int var6 = var2.getTypeId(var3, var4, var5);

        if (var6 != 0)
        {
            return false;
        }
        else
        {
            int var7 = var2.getTypeId(var3, var4 - 1, var5);
            int var8 = var2.getData(var3, var4 - 1, var5);

            if (var7 == ForestryBlock.soil.id && (var8 & 3) == 0)
            {
                var2.setTypeIdAndData(var3, var4, var5, ExtrabiomesBlock.sapling.id, 0);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public ICropEntity getCrop(World var1, int var2, int var3, int var4)
    {
        return new CropSapling(var1, var2, var3, var4);
    }

    public ItemStack[] getWindfall()
    {
        ArrayList var1 = new ArrayList();
        var1.add(new ItemStack(ExtrabiomesBlock.sapling));
        Iterator var2 = ForestryAPI.loggerWindfall.iterator();

        while (var2.hasNext())
        {
            ItemStack var3 = (ItemStack)var2.next();
            var1.add(var3);
        }

        return (ItemStack[])((ItemStack[])var1.toArray(new ItemStack[0]));
    }

    public boolean isCrop(World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getTypeId(var2, var3, var4);
        var1.getData(var2, var3, var4);
        return var5 == ExtrabiomesBlock.sapling.id || Block.byId[var5] != null && Block.byId[var5].isWood(var1, var2, var3, var4);
    }

    public boolean isGermling(ItemStack var1)
    {
        return var1.id == ExtrabiomesBlock.sapling.id;
    }
}
