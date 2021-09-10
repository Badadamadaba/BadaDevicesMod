package com.Badadamadaba.bdm.init;

import com.Badadamadaba.bdm.items.ItemBase;
import com.Badadamadaba.bdm.items.ItemCasedphone;
import com.Badadamadaba.bdm.items.ItemNBTPhonecase;
import com.Badadamadaba.bdm.items.ItemPhone;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems
{
	//Items
	public static final ItemBase WIRE = new ItemBase("wire");
	public static final ItemBase KEY = new ItemBase("key");
	public static final ItemBase METAL_SHEET = new ItemBase("metal_sheet");
	public static final ItemBase PLASTIC_SHEET= new ItemBase("plastic_sheet");
	
	public static final ItemBase PHONE = new ItemPhone("phone");
	public static ItemCasedphone[] casedPhones = new ItemCasedphone[] {
			new ItemCasedphone("casedphone_red").setColor(EnumDyeColor.RED),
			new ItemCasedphone("casedphone_blue").setColor(EnumDyeColor.BLUE),
			new ItemCasedphone("casedphone_green").setColor(EnumDyeColor.GREEN),
			new ItemCasedphone("casedphone_black").setColor(EnumDyeColor.BLACK),
			new ItemCasedphone("casedphone_brown").setColor(EnumDyeColor.BROWN),
			new ItemCasedphone("casedphone_yellow").setColor(EnumDyeColor.YELLOW),
			new ItemCasedphone("casedphone_orange").setColor(EnumDyeColor.ORANGE),
			new ItemCasedphone("casedphone_magenta").setColor(EnumDyeColor.MAGENTA),
			new ItemCasedphone("casedphone_light_blue").setColor(EnumDyeColor.LIGHT_BLUE),
			new ItemCasedphone("casedphone_lime").setColor(EnumDyeColor.LIME),
			new ItemCasedphone("casedphone_pink").setColor(EnumDyeColor.PINK),
			new ItemCasedphone("casedphone_gray").setColor(EnumDyeColor.GRAY),
			new ItemCasedphone("casedphone_silver").setColor(EnumDyeColor.SILVER),
			new ItemCasedphone("casedphone_cyan").setColor(EnumDyeColor.CYAN),
			new ItemCasedphone("casedphone_purple").setColor(EnumDyeColor.PURPLE)
	};
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
		event.getRegistry().register(PHONECASE.setRegistryName());
		event.getRegistry().register(MONITOR_SCREEN.setRegistryName());
		event.getRegistry().register(KEYBOARD.setRegistryName());
		event.getRegistry().register(MOUSE.setRegistryName());
		//Blocks :pensive:
		event.getRegistry().register(COMPUTER.setRegistryName(ModBlocks.COMPUTER.getRegistryName()));
		event.getRegistry().register(SERVER.setRegistryName(ModBlocks.SERVER.getRegistryName()));

		// TODO figure out if this is supposed to be only clientside
		for (ItemCasedphone casedPhone : casedPhones) {
			event.getRegistry().register(casedPhone.setRegistryName());
		}
	}
}
