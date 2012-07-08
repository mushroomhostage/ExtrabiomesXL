package extrabiomes.config;

import extrabiomes.Proxy;
import extrabiomes.api.ExtrabiomesBlock;
import extrabiomes.api.ExtrabiomesItem;
import net.minecraft.server.Block;
import net.minecraft.server.FurnaceRecipes;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class ConfigureRecipes
{
    public static void initialize()
    {
        if (ExtrabiomesItem.scarecrow != null)
        {
            Proxy.addRecipe(new ItemStack(ExtrabiomesItem.scarecrow), new Object[] {" a ", "cbc", " c ", 'a', Block.PUMPKIN, 'b', Block.MELON, 'c', Item.STICK});
        }

        if (ExtrabiomesBlock.redRock != null)
        {
            Proxy.addShapelessRecipe(new ItemStack(Item.CLAY_BALL, 4), new Object[] {new ItemStack(ExtrabiomesBlock.redRock, 1, 1), new ItemStack(Item.WATER_BUCKET), new ItemStack(Item.WATER_BUCKET), new ItemStack(Item.WATER_BUCKET)});
            Proxy.addRecipe(new ItemStack(ExtrabiomesBlock.redRock, 1, 2), new Object[] {"##", "##", '#', new ItemStack(ExtrabiomesBlock.redRock, 1, 0)});
            FurnaceRecipes.getInstance().addSmelting(ExtrabiomesBlock.redRock.id, 1, new ItemStack(ExtrabiomesBlock.redRock.id, 1, 0));
        }

        if (ExtrabiomesBlock.crackedSand != null)
        {
            Proxy.addShapelessRecipe(new ItemStack(Block.SAND), new Object[] {new ItemStack(ExtrabiomesBlock.crackedSand), new ItemStack(Item.WATER_BUCKET)});
        }

        if (ExtrabiomesBlock.flower != null)
        {
            Proxy.addShapelessRecipe(new ItemStack(Item.INK_SACK, 1, 12), new Object[] {new ItemStack(ExtrabiomesBlock.flower, 1, 1)});
            Proxy.addShapelessRecipe(new ItemStack(Item.INK_SACK, 1, 14), new Object[] {new ItemStack(ExtrabiomesBlock.flower, 1, 2)});
            Proxy.addShapelessRecipe(new ItemStack(Item.INK_SACK, 1, 13), new Object[] {new ItemStack(ExtrabiomesBlock.flower, 1, 3)});
            Proxy.addShapelessRecipe(new ItemStack(Item.INK_SACK, 1, 7), new Object[] {new ItemStack(ExtrabiomesBlock.flower, 1, 7)});
            Proxy.addShapelessRecipe(new ItemStack(Item.MUSHROOM_SOUP), new Object[] {Block.BROWN_MUSHROOM, new ItemStack(ExtrabiomesBlock.flower, 1, 6), new ItemStack(ExtrabiomesBlock.flower, 1, 6), Item.BOWL});
            Proxy.addShapelessRecipe(new ItemStack(Item.MUSHROOM_SOUP), new Object[] {Block.RED_MUSHROOM, new ItemStack(ExtrabiomesBlock.flower, 1, 6), new ItemStack(ExtrabiomesBlock.flower, 1, 6), Item.BOWL});
        }

        if (ExtrabiomesBlock.leafPile != null)
        {
            Proxy.addRecipe(new ItemStack(Block.LEAVES), new Object[] {"###", "###", "###", '#', new ItemStack(ExtrabiomesBlock.leafPile)});
        }
    }
}
