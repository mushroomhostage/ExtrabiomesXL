package extrabiomes.config;

import extrabiomes.api.BiomeDecorationsManager;
import extrabiomes.terrain.BiomeDecorationsMap;
import java.util.ArrayList;

public class ConfigureBiomeDecorationsManager
{
    public static void initialize()
    {
        BiomeDecorationsManager.biomeDecorations = BiomeDecorationsMap.newInstance();
        BiomeDecorationsManager.commonDecorations = new ArrayList();
    }
}
