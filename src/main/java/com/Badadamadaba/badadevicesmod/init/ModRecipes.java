package com.Badadamadaba.badadevicesmod.init;

import com.Badadamadaba.badadevicesmod.util.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes{

	public static void init() 
	{
		GameRegistry.addSmelting(Blocks.BONE_BLOCK, new ItemStack(ModItems.PLASTIC_SHEET, 2), 2.0f);
		ItemStack stack = new ItemStack(ModItems.PHONECASE);
		GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID, "phonecase"), null, new ItemStack(ModItems.PHONECASE), " P ","P P"," P ", 'P', ModItems.PLASTIC_SHEET);
	}
}
