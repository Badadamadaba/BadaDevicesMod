package com.Badadamadaba.bdm.items;

import com.Badadamadaba.bdm.BadaDevicesMod;
import com.Badadamadaba.bdm.util.PhonecaseUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;

public class ItemNBTPhonecase extends Item
{

	public ItemNBTPhonecase ( ) 
	{
		setRegistryName("phonecase");
		setUnlocalizedName("itemphonecase");
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
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
