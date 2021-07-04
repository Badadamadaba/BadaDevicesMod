package com.Badadamadaba.badadevicesmod.util;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PhonecaseUtil 
{
	
	public static ItemStack createDye(ItemStack stack, EnumDyeColor dye)
	{
		NBTTagCompound tag = new NBTTagCompound();
	
		tag.setString("Case", dye.getName());
		
		stack.setTagCompound(tag);
		
		return stack;
	}
	
	public static String getRegistryNameFromNBT(ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey("Case"))
			{
				return stack.getTagCompound().getString("Case");
			}
		}
		return "white";
	}
	
	public static ItemStack copyPhonecase(ItemStack from, ItemStack to)
	{
	  if(!to.hasTagCompound())
	    to.setTagCompound(new NBTTagCompound());
	  if(from.hasTagCompound() && from.getTagCompound().hasKey("Case"))
	    to.getTagCompound().setString("Case", to.getTagCompound().getString("Case"));
	  return to;
	}
}
