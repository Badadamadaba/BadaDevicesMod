package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.util.CasedphoneUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemCasedphone extends ItemPhone
{

	public ItemCasedphone(String registryName) 
	{
		super(registryName);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(this.isInCreativeTab(tab))
		{
			for(EnumDyeColor dye : EnumDyeColor.values())
				items.add(CasedphoneUtil.createDye(new ItemStack(this), dye));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + CasedphoneUtil.getRegistryNameFromNBT(stack);
	}
}

