package extrabiomes.terrain;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeDecorator;

public class CustomBiomeDecorator extends BiomeDecorator
{
    private CustomBiomeDecorator()
    {
        super((BiomeBase)null);
    }

    private CustomBiomeDecorator(CustomBiomeDecorator.Builder var1)
    {
        super(var1.biome);
        this.y = var1.waterlilyPerChunk;
        this.z = var1.treesPerChunk;
        this.A = var1.flowersPerChunk;
        this.B = var1.grassPerChunk;
        this.C = var1.deadBushPerChunk;
        this.D = var1.mushroomsPerChunk;
        this.E = var1.reedsPerChunk;
        this.F = var1.cactiPerChunk;
        this.G = var1.sandPerChunk;
        this.H = var1.sandPerChunk2;
        this.I = var1.clayPerChunk;
        this.J = var1.bigMushroomsPerChunk;
    }

    CustomBiomeDecorator(CustomBiomeDecorator.Builder var1, CustomBiomeDecorator.NamelessClass1348497515 var2)
    {
        this(var1);
    }

    public static class Builder
    {
        private final BiomeBase biome;
        private int waterlilyPerChunk;
        private int treesPerChunk;
        private int flowersPerChunk;
        private int grassPerChunk;
        private int deadBushPerChunk;
        private int mushroomsPerChunk;
        private int reedsPerChunk;
        private int cactiPerChunk;
        private int sandPerChunk;
        private int sandPerChunk2;
        private int clayPerChunk;
        private int bigMushroomsPerChunk;

        private Builder()
        {
            this((BiomeBase)null);
        }

        public CustomBiomeDecorator build()
        {
            return new CustomBiomeDecorator(this, (CustomBiomeDecorator.NamelessClass1348497515)null);
        }

        public Builder(BiomeBase var1)
        {
            this.waterlilyPerChunk = 0;
            this.treesPerChunk = 0;
            this.flowersPerChunk = 2;
            this.grassPerChunk = 1;
            this.deadBushPerChunk = 0;
            this.mushroomsPerChunk = 0;
            this.reedsPerChunk = 0;
            this.cactiPerChunk = 0;
            this.sandPerChunk = 1;
            this.sandPerChunk2 = 3;
            this.clayPerChunk = 1;
            this.bigMushroomsPerChunk = 0;
            this.biome = var1;
        }

        public CustomBiomeDecorator.Builder bigMushroomsPerChunk(int var1)
        {
            this.bigMushroomsPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder cactiPerChunk(int var1)
        {
            this.cactiPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder clayPerChunk(int var1)
        {
            this.clayPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder deadBushPerChunk(int var1)
        {
            this.deadBushPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder flowersPerChunk(int var1)
        {
            this.flowersPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder grassPerChunk(int var1)
        {
            this.grassPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder mushroomsPerChunk(int var1)
        {
            this.mushroomsPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder reedsPerChunk(int var1)
        {
            this.reedsPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder sandPerChunk(int var1, int var2)
        {
            this.sandPerChunk = var1;
            this.sandPerChunk2 = var2;
            return this;
        }

        public CustomBiomeDecorator.Builder treesPerChunk(int var1)
        {
            this.treesPerChunk = var1;
            return this;
        }

        public CustomBiomeDecorator.Builder waterlilyPerChunk(int var1)
        {
            this.waterlilyPerChunk = var1;
            return this;
        }
    }

    static class NamelessClass1348497515
    {
    }
}
