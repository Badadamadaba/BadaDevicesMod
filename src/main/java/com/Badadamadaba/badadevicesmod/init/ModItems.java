package com.Badadamadaba.badadevicesmod.init;

import java.util.ArrayList;
import java.util.List;

import com.Badadamadaba.badadevicesmod.items.ItemBase;
import com.Badadamadaba.badadevicesmod.items.ItemCasedphone;
import com.Badadamadaba.badadevicesmod.items.ItemNBTPhonecase;
import com.Badadamadaba.badadevicesmod.items.ItemPhone;
import com.Badadamadaba.badadevicesmod.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems
{
	//Items
	public static final ItemBase WIRE = new ItemBase("wire");
	public static final ItemBase KEY = new ItemBase("key");
	public static final ItemBase METAL_SHEET = new ItemBase("metal_sheet");
	public static final ItemBase PLASTIC_SHEET= new ItemBase("plastic_sheet");
	
	public static final ItemBase PHONE = new ItemPhone("phone");
	public static final ItemBase CASEDPHONE = new ItemCasedphone("casedphone");
	public static final ItemBase PHONECASE = new ItemNBTPhonecase();
	
	public static final ItemBase MONITOR_SCREEN = new ItemBase("monitor_screen");
	public static final ItemBase KEYBOARD = new ItemBase("keyboard");
	public static final ItemBase MOUSE = new ItemBase("mouse");

	public static final Item COMPUTER = new ItemBlock(ModBlocks.COMPUTER);
	public static final Item SERVER = new ItemBlock(ModBlocks.SERVER);

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		//Items :sunglasso:
		event.getRegistry().register(WIRE.setRegistryName());
		event.getRegistry().register(KEY.setRegistryName());
		event.getRegistry().register(METAL_SHEET.setRegistryName());
		event.getRegistry().register(PLASTIC_SHEET.setRegistryName());
		event.getRegistry().register(PHONE.setRegistryName());
		event.getRegistry().register(CASEDPHONE.setRegistryName());
		event.getRegistry().register(PHONECASE.setRegistryName());
		event.getRegistry().register(MONITOR_SCREEN.setRegistryName());
		event.getRegistry().register(KEYBOARD.setRegistryName());
		event.getRegistry().register(MOUSE.setRegistryName());
		//Blocks :pensive:
		event.getRegistry().register(COMPUTER.setRegistryName(ModBlocks.COMPUTER.getRegistryName()));
		event.getRegistry().register(SERVER.setRegistryName(ModBlocks.SERVER.getRegistryName()));
	}
}
