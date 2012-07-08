package extrabiomes.plugins.forestry;

import forestry.api.cultivation.ICropEntity;
import java.util.ArrayList;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class CropSapling implements ICropEntity
{
    private World world;
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int blockid;

    public CropSapling(World var1, int var2, int var3, int var4)
    {
        this.world = var1;
        this.xCoord = var2;
        this.yCoord = var3;
        this.zCoord = var4;
        this.blockid = var1.getTypeId(var2, var3, var4);
    }

    public ArrayList doHarvest()
    {
        ArrayList var1 = Block.byId[this.blockid].getBlockDropped(this.world, this.xCoord, this.yCoord, this.zCoord, 0, 0);
        this.world.setTypeIdAndData(this.xCoord, this.yCoord, this.zCoord, 0, 0);
        return var1;
    }

    public int[] getNextPosition()
    {
        int[] var1 = null;
        int var2 = 1;
        int var3;

        for (var3 = this.world.getTypeId(this.xCoord, this.yCoord + var2, this.zCoord); Block.byId[var3] != null && Block.byId[var3].isWood(this.world, this.xCoord, this.yCoord + var2, this.zCoord); var3 = this.world.getTypeId(this.xCoord, this.yCoord + var2, this.zCoord))
        {
            var1 = new int[] {this.xCoord, this.yCoord + var2, this.zCoord};
            ++var2;
        }

        if (var1 != null)
        {
            return var1;
        }
        else
        {
            var2 = -1;

            for (var3 = this.world.getTypeId(this.xCoord, this.yCoord + var2, this.zCoord); Block.byId[var3] != null && Block.byId[var3].isWood(this.world, this.xCoord, this.yCoord + var2, this.zCoord); var3 = this.world.getTypeId(this.xCoord, this.yCoord + var2, this.zCoord))
            {
                var1 = new int[] {this.xCoord, this.yCoord + var2, this.zCoord};
                --var2;
            }

            return var1;
        }
    }

    public boolean isHarvestable()
    {
        int var1 = this.world.getTypeId(this.xCoord, this.yCoord, this.zCoord);
        return Block.byId[var1] != null && Block.byId[var1].isWood(this.world, this.xCoord, this.yCoord, this.zCoord);
    }
}
