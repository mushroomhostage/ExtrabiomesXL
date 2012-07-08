package extrabiomes;

import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityTypes;
import net.minecraft.server.Facing;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class ItemScarecrow extends Item
{
    public static boolean spawnCreature(World var0, double var1, double var3, double var5)
    {
        Entity var7 = EntityTypes.createEntityByName("scarecrow", var0);

        if (var7 != null)
        {
            var7.setPositionRotation(var1, var3, var5, var0.random.nextFloat() * 360.0F, 0.0F);
            var0.addEntity(var7);
        }

        return var7 != null;
    }

    public ItemScarecrow(int var1)
    {
        super(var1);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, int var4, int var5, int var6, int var7)
    {
        if (var3.isStatic)
        {
            return true;
        }
        else
        {
            int var8 = var3.getTypeId(var4, var5, var6);
            var4 += Facing.b[var7];
            var5 += Facing.c[var7];
            var6 += Facing.d[var7];
            double var9 = 0.0D;

            if (var7 == 1 && var8 == Block.FENCE.id || var8 == Block.NETHER_FENCE.id)
            {
                var9 = 0.5D;
            }

            if (spawnCreature(var3, (double)var4 + 0.5D, (double)var5 + var9, (double)var6 + 0.5D) && !var2.abilities.canInstantlyBuild)
            {
                --var1.count;
            }

            return true;
        }
    }
}
