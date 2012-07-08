package extrabiomes.plugins.forestry;

import forestry.api.core.ForestryBlock;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenerator;

public class WorldGenBogEarth extends WorldGenerator
{
    public boolean a(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < 20; ++var6)
        {
            int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);

            if (var1.getTypeId(var7, var4, var9) == Block.SAND.id && (var1.getMaterial(var7 - 1, var4, var9) == Material.WATER || var1.getMaterial(var7 + 1, var4, var9) == Material.WATER || var1.getMaterial(var7, var4, var9 - 1) == Material.WATER || var1.getMaterial(var7, var4, var9 + 1) == Material.WATER))
            {
                var1.setRawTypeIdAndData(var7, var4, var9, ForestryBlock.soil.id, 1);
            }
        }

        return true;
    }
}
