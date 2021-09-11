package com.Badadamadaba.bdm.init;

import java.util.ArrayList;
import java.util.List;

import com.Badadamadaba.bdm.items.ItemBase;
import com.Badadamadaba.bdm.items.ItemCasedphone;
import com.Badadamadaba.bdm.items.ItemNBTPhonecase;
import com.Badadamadaba.bdm.items.ItemPhone;
import com.Badadamadaba.bdm.util.Reference;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Items
	public static final Item WIRE = new ItemBase("wire");
	public static final Item KEY = new ItemBase("key");
	public static final Item METAL_SHEET = new ItemBase("metal_sheet");
	public static final Item PLASTIC_SHEET= new ItemBase("plastic_sheet");
	
	public static final Item PHONE = new ItemPhone("phone");
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
			new ItemCasedphone("casedphone_white").setColor(EnumDyeColor.WHITE),
			new ItemCasedphone("casedphone_purple").setColor(EnumDyeColor.PURPLE)
	};
	public static final Item PHONECASE = new ItemNBTPhonecase();
	
	public static final Item MONITOR_SCREEN = new ItemBase("monitor_screen");
	public static final Item KEYBOARD = new ItemBase("keyboard");
	public static final Item MOUSE = new ItemBase("mouse");
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class ItemRegistration
	{
		public static final NonNullList<Item> ITEMS = NonNullList.<Item>create();
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().register(PHONECASE);
		}
	}
}
