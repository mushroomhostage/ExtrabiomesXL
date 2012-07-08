package forestry.api.core;

import java.util.ArrayList;

public enum EnumTemperature
{
    NONE("None", 0),
    ICY("Icy", 8),
    COLD("Cold", 6),
    NORMAL("Normal", 1),
    WARM("Warm", 4),
    HOT("Hot", 2),
    HELLISH("Hellish", 10);
    public static ArrayList icyBiomeIds = new ArrayList();
    public static ArrayList coldBiomeIds = new ArrayList();
    public static ArrayList normalBiomeIds = new ArrayList();
    public static ArrayList warmBiomeIds = new ArrayList();
    public static ArrayList hotBiomeIds = new ArrayList();
    public static ArrayList hellishBiomeIds = new ArrayList();
    public final String name;
    public final int iconIndex;

    private EnumTemperature(String var3, int var4)
    {
        this.name = var3;
        this.iconIndex = var4;
    }

    public String getName()
    {
        return this.name;
    }

    public int getIconIndex()
    {
        return this.iconIndex;
    }

    public static ArrayList getBiomeIds(EnumTemperature var0)
    {
        switch (EnumTemperature.NamelessClass1427774925.$SwitchMap$forestry$api$core$EnumTemperature[var0.ordinal()])
        {
            case 1:
                return icyBiomeIds;

            case 2:
                return coldBiomeIds;

            case 3:
                return warmBiomeIds;

            case 4:
                return hotBiomeIds;

            case 5:
                return hellishBiomeIds;

            case 6:
            default:
                return normalBiomeIds;
        }
    }

    static class NamelessClass1427774925 {
        static final int[] $SwitchMap$forestry$api$core$EnumTemperature = new int[EnumTemperature.values().length];

        static {
            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.ICY.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.COLD.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.WARM.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.HOT.ordinal()] = 4;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.HELLISH.ordinal()] = 5;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try {
                $SwitchMap$forestry$api$core$EnumTemperature[EnumTemperature.NORMAL.ordinal()] = 6;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
