package extrabiomes.config;

import extrabiomes.ItemScarecrow;
import extrabiomes.Proxy;
import extrabiomes.api.ExtrabiomesItem;

public class ConfigureItems
{
    public static void addNames()
    {
        if (ExtrabiomesItem.scarecrow != null)
        {
            Proxy.addName(ExtrabiomesItem.scarecrow, "Scarecrow");
        }
    }

    public static void initialize()
    {
        int var0 = Config.getOrCreateIntProperty("scarecrow.id", "item", 2870);

        if (var0 != 0)
        {
            ExtrabiomesItem.scarecrow = (new ItemScarecrow(var0)).a("scarecrow").d(96);
        }
    }
}
