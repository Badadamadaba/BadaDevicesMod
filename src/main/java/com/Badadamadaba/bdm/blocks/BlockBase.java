package com.Badadamadaba.bdm.blocks;

import com.Badadamadaba.bdm.BadaDevicesMod;
import com.Badadamadaba.bdm.proxy.ClientProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
	}

	public Block setRegistryName(){
		return setRegistryName(getUnlocalizedName().substring(5));
	}


	public void registerModels() 
	{
		ClientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
