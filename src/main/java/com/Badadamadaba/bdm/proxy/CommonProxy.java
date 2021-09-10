package com.Badadamadaba.bdm.proxy;

import com.Badadamadaba.bdm.init.ModItems;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
	public void preInit(){
		MinecraftForge.EVENT_BUS.register(ModItems.class);
	}
}
