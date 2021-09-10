package com.Badadamadaba.bdm.items;

import com.Badadamadaba.bdm.util.CasedphoneUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.client.renderer.color.IItemColor;

public class ItemCasedphone extends ItemPhone
{
	public ItemCasedphone setColor(EnumDyeColor color) {
		this.color = color;
		return this;
	}
	public EnumDyeColor color = null;
	public ItemCasedphone(String registryName)
	{
		super(registryName);
	}
	//How do I do NBT color variants????
	/*@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(this.isInCreativeTab(tab))
		{
			for(EnumDyeColor dye : EnumDyeColor.values())
				items.add(CasedphoneUtil.createDye(new ItemStack(this), dye));
		}
	}*/
	public EnumDyeColor getColor() {return color;}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + CasedphoneUtil.getRegistryNameFromNBT(stack);
	}

	public static class phoneColorHandler implements IItemColor {
		@Override
		public int colorMultiplier(ItemStack stack, int tintIndex) {
			if (tintIndex != 1 | ((ItemCasedphone) stack.getItem()).getColor() == null)
				return -1;

			int meta = stack.getMetadata();
			return ((ItemCasedphone) stack.getItem()).getColor().getColorValue();
		}
	}
}

