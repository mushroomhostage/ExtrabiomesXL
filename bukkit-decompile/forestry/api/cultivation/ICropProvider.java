package forestry.api.cultivation;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public interface ICropProvider
{
    boolean isGermling(ItemStack var1);

    boolean isCrop(World var1, int var2, int var3, int var4);

    ItemStack[] getWindfall();

    boolean doPlant(ItemStack var1, World var2, int var3, int var4, int var5);

    ICropEntity getCrop(World var1, int var2, int var3, int var4);
}
