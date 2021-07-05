package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.BadaDevicesMod;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.proxy.ClientProxy;
import com.Badadamadaba.badadevicesmod.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
	}

	public Item setRegistryName(){
		return setRegistryName(getUnlocalizedName().substring(5));
	}
	
	@Override
	public void registerModels() 
	{
		ClientProxy.registerItemRenderer(this, 0, "inventory");
	}

}
