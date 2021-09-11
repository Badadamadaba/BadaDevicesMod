package com.Badadamadaba.bdm.init;

import java.util.ArrayList;
import java.util.List;

import com.Badadamadaba.bdm.blocks.BlockBase;
import com.Badadamadaba.bdm.blocks.computer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block COMPUTER = new computer("computer", Material.IRON);
	public static final Block SERVER = new BlockBase("server", Material.IRON);

}
