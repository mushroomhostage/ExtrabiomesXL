package extrabiomes;

import extrabiomes.api.ExtrabiomesItem;
import net.minecraft.server.Achievement;
import net.minecraft.server.AchievementList;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ModLoader;

public class AchievementScarecrow
{
    public static Achievement buildScarecrow;

    public static void craftingAchievement(EntityHuman var0, ItemStack var1)
    {
        if (buildScarecrow != null && var1.id == ExtrabiomesItem.scarecrow.id)
        {
            var0.a(buildScarecrow, 1);
        }
    }

    public static void initialize()
    {
        if (ExtrabiomesItem.scarecrow != null)
        {
            buildScarecrow = (new Achievement(3070, "buildScarecrow", -1, 2, new ItemStack(ExtrabiomesItem.scarecrow), AchievementList.h)).c();
            ModLoader.addAchievementDesc(buildScarecrow, "If I Only Had A Brain!", "Use a pumpkin, a melon and sticks to make a scarecrow.");
        }
    }
}
