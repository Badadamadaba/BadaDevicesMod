package com.Badadamadaba.badadevicesmod.inventory;

import com.Badadamadaba.badadevicesmod.BadaDevicesMod;
import com.Badadamadaba.badadevicesmod.client.GuiPhone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

//I have no idea what the fuck I'm doing
//Code Stolen From: Actually Additions
public class GuiHandler implements IGuiHandler {

	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(BadaDevicesMod.instance, new GuiHandler());
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Sunglasses dot mp4" + ID);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Is this thing on?" + ID);
		TileEntity tile = null;
		if (GuiDevice.values()[ID].checkTileEntity) {
			tile = (TileEntity) world.getTileEntity(new BlockPos(x, y, z));
		}
		switch (GuiDevice.values()[ID]){
			//Deez nuts
			case PHONE:
				return new GuiPhone();
			default:
				return null;
		}
	}

	public enum GuiDevice {
		PHONE (false);
		public final boolean checkTileEntity;

		GuiDevice() {
			this(true);
		}

		GuiDevice(boolean checkTileEntity) {
			this.checkTileEntity = checkTileEntity;
		}
	}
}
