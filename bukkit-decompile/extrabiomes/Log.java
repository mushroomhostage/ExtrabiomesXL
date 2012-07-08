package extrabiomes;

import net.minecraft.server.ModLoader;

public final class Log
{
    public static void write(String var0)
    {
        ModLoader.getLogger().finer(var0);
        System.out.println("Extrabiomes XL: " + var0);
    }
}
