/**
 * Copyright (c) Scott Killen and MisterFiber, 2012
 * 
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license
 * located in /MMPL-1.0.txt
 */

package net.minecraft.src;

import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.NetworkMod;
import extrabiomes.Extrabiomes;

public class mod_ExtrabiomesXL extends NetworkMod {

	@Override
	public int addFuel(int id, int damage) {
		return Extrabiomes.addFuel(id, damage);
	}

	@Override
	public void addRenderer(Map map) {
		Extrabiomes.addRenderer(map);
	}

	@Override
	public boolean clientSideRequired() {
		return true;
	}

	@Override
	public void generateSurface(World world, Random random, int chunkX,
			int chunkZ)
	{
		Extrabiomes.generateSurface(world, random, chunkX, chunkZ);
	}

	@Override
	public String getName() {
		return Extrabiomes.getName();
	}

	@Override
	public String getPriorities() {
		return Extrabiomes.getPriorities();
	}

	@Override
	public String getVersion() {
		return Extrabiomes.getVersion();
	}

	@Override
	public void load() {
		Extrabiomes.load();
	}

	@Override
	public void modsLoaded() {
		Extrabiomes.modsLoaded(this);
	}

	@Override
	public boolean onTickInGame(float var1, Minecraft var2) {
		return Extrabiomes.onTickInGame(var1, var2);
	}

	@Override
	public boolean serverSideRequired() {
		return true;
	}

	@Override
	public void takenFromCrafting(EntityPlayer player,
			ItemStack itemstack, IInventory var3)
	{
		Extrabiomes.takenFromCrafting(player, itemstack, var3);
	}

	@Override
	public String toString() {
		return getName() + " " + Extrabiomes.getVersionNumber();
	}
}
