package com.Badadamadaba.badadevicesmod.blocks;

import com.Badadamadaba.badadevicesmod.BadaDevicesMod;
import com.Badadamadaba.badadevicesmod.init.ModBlocks;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.util.IHasModel;

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
