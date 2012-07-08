package extrabiomes.biomes;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashSet;
import net.minecraft.server.BiomeBase;

public class ExtrabiomeGenBase extends BiomeBase
{
    public static Collection customBiomeList = new LinkedHashSet();

    protected ExtrabiomeGenBase(int var1)
    {
        super(var1);
        customBiomeList.add(this);
    }

    protected void disableRain()
    {
        try
        {
            Field var1 = BiomeBase.class.getDeclaredField("S");
            var1.setAccessible(true);
            var1.setBoolean(this, false);
        }
        catch (Throwable var3)
        {
            ;
        }
    }
}
