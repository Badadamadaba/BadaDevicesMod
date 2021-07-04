package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.Main;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.BADADEVICESMODTAB);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
