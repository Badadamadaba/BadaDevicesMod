package com.Badadamadaba.badadevicesmod;

import com.Badadamadaba.badadevicesmod.init.ModRecipes;
import com.Badadamadaba.badadevicesmod.inventory.GuiHandler;
import com.Badadamadaba.badadevicesmod.proxy.CommonProxy;
import com.Badadamadaba.badadevicesmod.tabs.BDMTab;
import com.Badadamadaba.badadevicesmod.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class BadaDevicesMod {
	
	@Instance
	public static BadaDevicesMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs BADADEVICESMODTAB = new BDMTab("BadaDeviceTab");
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		
	}
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		GuiHandler.init();
		ModRecipes.init();
	}
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}

}
