package com.Badadamadaba.bdm.items;

import com.Badadamadaba.bdm.BadaDevicesMod;
import com.Badadamadaba.bdm.proxy.ClientProxy;

import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
	}

	public Item setRegistryName(){
		return setRegistryName(getUnlocalizedName().substring(5));
	}

	public void registerModels() 
	{
		ClientProxy.registerItemRenderer(this, 0, "inventory");
	}

}
