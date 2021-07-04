package com.Badadamadaba.badadevicesmod.recipes;

import com.Badadamadaba.badadevicesmod.items.ItemNBTPhonecase;
import com.Badadamadaba.badadevicesmod.util.PhonecaseUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class PhonecaseDye extends BDMShapedRecipe
{

	public PhonecaseDye(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result) 
	{
		super(group, width, height, ingredients, result);
	}
	
	 public ItemStack getCraftingResult(InventoryCrafting inv)
     {
         ItemStack itemstack = ItemStack.EMPTY;
         ItemStack itemstack1 = ItemStack.EMPTY;

         for (int i = 0; i < inv.getSizeInventory(); ++i)
         {
             ItemStack itemstack2 = inv.getStackInSlot(i);

             if (!itemstack2.isEmpty())
             {
                 if (itemstack2.getItem() instanceof ItemNBTPhonecase)
                 {
                     itemstack = itemstack2;
                 }
                 else if (net.minecraftforge.oredict.DyeUtils.isDye(itemstack2))
                 {
                     itemstack1 = itemstack2;
                 }
             }
         }

         ItemStack itemstack3 = itemstack.copy();

         if (itemstack.hasTagCompound())
         {
             itemstack3.setTagCompound(itemstack.getTagCompound().copy());
         }

         return PhonecaseUtil.createDye(itemstack3, net.minecraftforge.oredict.DyeUtils.colorFromStack(itemstack1).get());
     }
	 
	 @Override
	 public boolean matches(InventoryCrafting inv, World worldIn)
     {
         int i = 0;
         int j = 0;

         for (int k = 0; k < inv.getSizeInventory(); ++k)
         {
             ItemStack itemstack = inv.getStackInSlot(k);

             if (!itemstack.isEmpty())
             {
                 if (itemstack.getItem() instanceof ItemNBTPhonecase && PhonecaseUtil.getRegistryNameFromNBT(itemstack).equals("white"))
                 {
                     ++i;
                 }
                 else
                 {
                     if (!net.minecraftforge.oredict.DyeUtils.isDye(itemstack))
                     {
                         return false;
                     }

                     ++j;
                 }

                 if (j > 1 || i > 1)
                 {
                     return false;
                 }
             }
         }

         return i == 1 && j == 1;
     }
	 
	 @Override
	 public ItemStack getRecipeOutput() 
	 {
		return ItemStack.EMPTY;
	 }
	 
	 public boolean isDynamic()
	 {
		 return true;
	 }
	 
     public boolean canFit(int width, int height)
     {
         return width * height >= 2;
     }
	 
     	public static class Factory extends BDMShapedRecipe.ShapedFactory
	 	{
		@Override
		public IRecipe initRecipe(String var1, int var2, int var3, NonNullList<Ingredient> var4, ItemStack var5) 
		{
			return new PhonecaseDye(var1, var3, var3, var4, var5);
		}
	   }
     	
}
