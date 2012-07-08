package extrabiomes.terrain;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenNoOp extends WorldGenerator
{
    public WorldGenNoOp()
    {
        super(false);
    }

    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        return false;
    }
}
