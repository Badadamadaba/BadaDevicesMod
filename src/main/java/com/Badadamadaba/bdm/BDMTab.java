package com.Badadamadaba.bdm;

import com.Badadamadaba.bdm.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BDMTab extends CreativeTabs
{
	public BDMTab (String label)
	{
		super("bdmtab");
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.PHONE);
	}
}
