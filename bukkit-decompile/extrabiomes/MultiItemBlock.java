package extrabiomes;

import net.minecraft.server.Block;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.ItemStack;

public class MultiItemBlock extends ItemBlock
{
    public MultiItemBlock(int var1)
    {
        super(var1);
        this.setMaxDurability(0);
        this.a(true);
    }

    Block getBlock()
    {
        return Block.byId[this.a()];
    }

    public String a(ItemStack var1)
    {
        return "tile." + Block.byId[this.a()].q() + "." + var1.getData();
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int filterData(int var1)
    {
        return var1;
    }
}
