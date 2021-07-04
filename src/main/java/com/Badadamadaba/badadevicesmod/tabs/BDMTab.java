package com.Badadamadaba.badadevicesmod.tabs;

import com.Badadamadaba.badadevicesmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BDMTab extends CreativeTabs
{
	public BDMTab (String label)
	{
		super("badadevicesmodtab");
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.PHONE);
	}
}
