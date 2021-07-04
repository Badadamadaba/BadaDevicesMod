package com.Badadamadaba.badadevicesmod.util.handlers;

import com.Badadamadaba.badadevicesmod.init.ModBlocks;
import com.Badadamadaba.badadevicesmod.init.ModItems;
import com.Badadamadaba.badadevicesmod.util.CasedphoneUtil;
import com.Badadamadaba.badadevicesmod.util.IHasModel;
import com.Badadamadaba.badadevicesmod.util.PhonecaseUtil;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		ModelLoader.setCustomMeshDefinition(ModItems.PHONECASE, new ItemMeshDefinition()
				{
					@Override
					public ModelResourceLocation getModelLocation(ItemStack stack)
					{
						return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + PhonecaseUtil.getRegistryNameFromNBT(stack), "inventory");
					}
				});
		
		for(EnumDyeColor dye : EnumDyeColor.values())
			ModelBakery.registerItemVariants(ModItems.PHONECASE, new ResourceLocation(ModItems.PHONECASE.getRegistryName().toString() + "_" + dye.getName()));
		
		ModelLoader.setCustomMeshDefinition(ModItems.CASEDPHONE, new ItemMeshDefinition()
			{
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack)
				{
					return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + CasedphoneUtil.getRegistryNameFromNBT(stack), "inventory");
				}
			});
		
		for(EnumDyeColor dye : EnumDyeColor.values())
			ModelBakery.registerItemVariants(ModItems.CASEDPHONE, new ResourceLocation(ModItems.CASEDPHONE.getRegistryName().toString() + "_" + dye.getName()));
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
}
