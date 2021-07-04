package com.Badadamadaba.badadevicesmod.util;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CasedphoneUtil 
{
	
	public static ItemStack createDye(ItemStack stack, EnumDyeColor dye)
	{
		NBTTagCompound tag = new NBTTagCompound();
	
		tag.setString("Cased", dye.getName());
		
		stack.setTagCompound(tag);
		
		return stack;
	}
	
	public static String getRegistryNameFromNBT(ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey("Cased"))
			{
				return stack.getTagCompound().getString("Cased");
			}
		}
		return "white";
	}
	
	public static ItemStack copyCasedphone(ItemStack from, ItemStack to)
	{
	  if(!to.hasTagCompound())
	    to.setTagCompound(new NBTTagCompound());
	  if(from.hasTagCompound() && from.getTagCompound().hasKey("Cased"))
	    to.getTagCompound().setString("Cased", to.getTagCompound().getString("Cased"));
	  return to;
	}
}