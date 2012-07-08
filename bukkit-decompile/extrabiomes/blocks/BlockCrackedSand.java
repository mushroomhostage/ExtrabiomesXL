package extrabiomes.blocks;

import extrabiomes.api.BiomeManager;
import extrabiomes.api.TerrainGenManager;
import extrabiomes.config.ConfigureBlocks;
import forge.ITextureProvider;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.EnumCreatureType;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCrackedSand extends Block implements ITextureProvider
{
    private static boolean canGrow;
    private static boolean restrictGrowthToBiome;

    public BlockCrackedSand(int var1)
    {
        super(var1, 0, Material.STONE);
        this.c(1.2F);
        this.a(Block.h);

        if (ConfigureBlocks.crackedSandCanGrow)
        {
            this.a(true);
        }

        canGrow = ConfigureBlocks.crackedSandCanGrow;
        restrictGrowthToBiome = ConfigureBlocks.crackedSandGrowthRestrictedToWasteland;
        TerrainGenManager.blockWasteland = this;
    }

    public void addCreativeItems(ArrayList var1)
    {
        var1.add(new ItemStack(this));
    }

    public boolean canCreatureSpawn(EnumCreatureType var1, World var2, int var3, int var4, int var5)
    {
        return true;
    }

    private void changeNeighbor(World var1, int var2, int var3, int var4)
    {
        if (var1.getLightLevel(var2, var3 + 1, var4) >= 9)
        {
            int var5 = var1.getTypeId(var2, var3, var4);

            if (var5 == SAND.id)
            {
                var1.setRawTypeId(var2, var3, var4, this.id);
            }
            else if (var5 == SANDSTONE.id)
            {
                int var6 = var1.getData(var2, var3, var4);

                if (var6 != 0)
                {
                    var1.setData(var2, var3, var4, 0);
                }
                else
                {
                    var1.setTypeId(var2, var3, var4, SAND.id);
                }
            }
            else if (var5 == DIRT.id)
            {
                var1.setRawTypeId(var2, var3, var4, SAND.id);
            }
            else if (var5 == GRASS.id || var5 == SOIL.id)
            {
                var1.setRawTypeId(var2, var3, var4, DIRT.id);
            }
        }
    }

    public String getTextureFile()
    {
        return "/extrabiomes/extrabiomes.png";
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        if (canGrow)
        {
            if (!var1.isStatic)
            {
                if (restrictGrowthToBiome && var1.getBiome(var2, var4) != BiomeManager.wasteland)
                {
                    return;
                }

                if (var1.getLightLevel(var2, var3 + 1, var4) < 15)
                {
                    return;
                }

                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = var2 + var5.nextInt(3) - 1;
                    int var8 = var3 + var5.nextInt(5) - 3;
                    int var9 = var4 + var5.nextInt(3) - 1;

                    if (!restrictGrowthToBiome || var1.getBiome(var7, var9) == BiomeManager.wasteland)
                    {
                        this.changeNeighbor(var1, var7, var8, var9);
                    }
                }
            }
        }
    }
}
