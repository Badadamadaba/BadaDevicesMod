package com.Badadamadaba.bdm.items;

import com.Badadamadaba.bdm.BadaDevicesMod;
import com.Badadamadaba.bdm.init.ModItems;
import com.Badadamadaba.bdm.util.IHasModel;

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
