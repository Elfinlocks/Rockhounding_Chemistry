package com.globbypotato.rockhounding_chemistry.machines.recipe;

import net.minecraft.item.ItemStack;

public class SaltSeasonerRecipe {

	private ItemStack input;
	private ItemStack output;

	public SaltSeasonerRecipe(ItemStack input, ItemStack output){
		this.input = input;
		this.output = output;
	}

	public ItemStack getInput(){
		return this.input.copy();
	}

	public ItemStack getOutput() {
		return this.output.copy();
	}

}