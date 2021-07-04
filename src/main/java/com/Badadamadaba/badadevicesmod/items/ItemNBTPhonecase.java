package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.Main;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.util.PhonecaseUtil;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNBTPhonecase extends Item
{

	public ItemNBTPhonecase ( ) 
	{
		setRegistryName("phonecase");
		setUnlocalizedName("itemphonecase");
		setCreativeTab(Main.BADADEVICESMODTAB);
		setHasSubtypes(false);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(this.isInCreativeTab(tab))
		{
			for(EnumDyeColor dye : EnumDyeColor.values())
				items.add(PhonecaseUtil.createDye(new ItemStack(this), dye));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + PhonecaseUtil.getRegistryNameFromNBT(stack);
	}
}