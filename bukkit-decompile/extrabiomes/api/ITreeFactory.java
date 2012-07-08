package extrabiomes.api;

import net.minecraft.server.WorldGenerator;

public interface ITreeFactory
{
    WorldGenerator makeTreeGenerator(boolean var1, ITreeFactory.TreeType var2);

    void registerTreeGen(ITreeFactory.TreeType var1, WorldGenerator var2, boolean var3);

    public static enum TreeType
    {
        BROWN_AUTUMN("BROWN_AUTUMN", 0),
        BROWN_AUTUMN_BIG("BROWN_AUTUMN_BIG", 1),
        ORANGE_AUTUMN("ORANGE_AUTUMN", 2),
        ORANGE_AUTUMN_BIG("ORANGE_AUTUMN_BIG", 3),
        PURPLE_AUTUMN("PURPLE_AUTUMN", 4),
        PURPLE_AUTUMN_BIG("PURPLE_AUTUMN_BIG", 5),
        YELLOW_AUTUMN("YELLOW_AUTUMN", 6),
        YELLOW_AUTUMN_BIG("YELLOW_AUTUMN_BIG", 7),
        FIR("FIR", 8),
        FIR_HUGE("FIR_HUGE", 9),
        REDWOOD("REDWOOD", 10),
        ACACIA("ACACIA", 11);

        private static final ITreeFactory.TreeType[] $VALUES = new ITreeFactory.TreeType[]{BROWN_AUTUMN, BROWN_AUTUMN_BIG, ORANGE_AUTUMN, ORANGE_AUTUMN_BIG, PURPLE_AUTUMN, PURPLE_AUTUMN_BIG, YELLOW_AUTUMN, YELLOW_AUTUMN_BIG, FIR, FIR_HUGE, REDWOOD, ACACIA};

        private TreeType(String var1, int var2) {}
    }
}
