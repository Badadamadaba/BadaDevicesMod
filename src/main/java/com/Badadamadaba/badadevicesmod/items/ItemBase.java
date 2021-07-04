package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.BadaDevicesMod;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		BadaDevicesMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
