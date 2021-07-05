package com.Badadamadaba.badadevicesmod.init;

import com.Badadamadaba.badadevicesmod.blocks.BlockBase;
import com.Badadamadaba.badadevicesmod.blocks.computer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks
{
	public static final BlockBase COMPUTER = new computer("computer", Material.IRON);
	public static final BlockBase SERVER = new BlockBase("server", Material.IRON);

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(COMPUTER.setRegistryName());
		event.getRegistry().register(SERVER.setRegistryName());
	}
}
