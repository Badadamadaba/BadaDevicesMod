package com.Badadamadaba.badadevicesmod.init;

import java.util.ArrayList;
import java.util.List;

import com.Badadamadaba.badadevicesmod.items.ItemBase;
import com.Badadamadaba.badadevicesmod.items.ItemCasedphone;
import com.Badadamadaba.badadevicesmod.items.ItemNBTPhonecase;
import com.Badadamadaba.badadevicesmod.items.ItemPhone;
import com.Badadamadaba.badadevicesmod.util.Reference;

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
	public static final Item CASEDPHONE = new ItemCasedphone("casedphone");
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
