package com.Badadamadaba.badadevicesmod.items;

import com.Badadamadaba.badadevicesmod.BadaDevicesMod;

import com.Badadamadaba.badadevicesmod.client.ClickGUIScreen;
import com.Badadamadaba.badadevicesmod.inventory.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPhone extends ItemBase
{
	//ItemCasedPhone extends ItemPhone which means both activate the gui I'm so fucking happy. Now to figure out how to make the gui.
	public ItemPhone(String registryName)
	{
		super(registryName);
		setCreativeTab(BadaDevicesMod.BADADEVICESMODTAB);
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!world.isRemote){
			player.openGui(BadaDevicesMod.instance, GuiHandler.GuiDevice.PHONE.ordinal(), world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
}