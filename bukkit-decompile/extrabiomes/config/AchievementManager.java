package extrabiomes.config;

import extrabiomes.AchievementScarecrow;
import forge.AchievementPage;
import net.minecraft.server.Achievement;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemStack;

public class AchievementManager
{
    public static AchievementPage achievePage = new AchievementPage("Extrabiomes XL", new Achievement[0]);

    public static void craftingAchievement(EntityHuman var0, ItemStack var1)
    {
        AchievementScarecrow.craftingAchievement(var0, var1);
    }

    public static void initialize()
    {
        AchievementScarecrow.initialize();
    }

    public static void itemPickup(EntityHuman var0, ItemStack var1) {}
}
