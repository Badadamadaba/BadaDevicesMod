package com.Badadamadaba.bdm.blocks;

import com.Badadamadaba.bdm.BadaDevicesMod;
import com.Badadamadaba.bdm.init.ModBlocks;
import com.Badadamadaba.bdm.init.ModItems;
import com.Badadamadaba.bdm.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		BadaDevicesMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
