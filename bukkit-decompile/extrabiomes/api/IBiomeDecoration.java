package extrabiomes.api;

import java.util.Random;
import net.minecraft.server.World;

public interface IBiomeDecoration
{
    void decorate(World var1, Random var2, int var3, int var4);
}
