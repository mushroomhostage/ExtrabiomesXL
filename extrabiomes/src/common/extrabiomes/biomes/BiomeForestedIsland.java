package extrabiomes.biomes;

import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;
import extrabiomes.terrain.CustomBiomeDecorator;

public class BiomeForestedIsland extends ExtrabiomeGenBase {

	public BiomeForestedIsland(int id) {
		super(id);

		setColor(0x62BF6C);
		setBiomeName("Forested Island");
		temperature = BiomeGenBase.forest.temperature + 0.1F;
		rainfall = BiomeGenBase.forest.rainfall;
		minHeight = -0.8F;
		maxHeight = 0.8F;

		spawnableCreatureList
				.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
	}

	@Override
	protected BiomeDecorator createBiomeDecorator() {
		return new CustomBiomeDecorator.Builder(this).treesPerChunk(7)
				.grassPerChunk(3).build();
	}

}
