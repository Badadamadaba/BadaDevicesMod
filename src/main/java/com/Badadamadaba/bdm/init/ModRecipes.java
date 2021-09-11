package com.Badadamadaba.bdm.init;

import com.Badadamadaba.bdm.util.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
