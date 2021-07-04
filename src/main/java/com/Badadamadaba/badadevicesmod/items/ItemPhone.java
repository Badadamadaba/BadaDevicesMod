package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPhone extends ItemBase
{

	public ItemPhone(String registryName) 
	{
		super(registryName);
		setCreativeTab(Main.BADADEVICESMODTAB);
		this.setMaxStackSize(1);
	}

}
