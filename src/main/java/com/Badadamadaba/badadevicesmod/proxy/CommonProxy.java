package com.Badadamadaba.badadevicesmod.proxy;

import com.Badadamadaba.badadevicesmod.init.ModItems;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
	public void preInit(){
		MinecraftForge.EVENT_BUS.register(ModItems.class);
	}
}
