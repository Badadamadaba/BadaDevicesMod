package com.Badadamadaba.bdm.util.handlers;

import com.Badadamadaba.bdm.init.ModBlocks;
import com.Badadamadaba.bdm.init.ModItems;
import com.Badadamadaba.bdm.util.CasedphoneUtil;
import com.Badadamadaba.bdm.util.PhonecaseUtil;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{

		ModelLoader.setCustomMeshDefinition(ModItems.PHONECASE, new ItemMeshDefinition()
			{
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack)
				{
					System.out.println(stack.getItem().getRegistryName() + "_" + PhonecaseUtil.getRegistryNameFromNBT(stack));
					return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + PhonecaseUtil.getRegistryNameFromNBT(stack), "inventory");
				}
			});
		
		for(EnumDyeColor dye : EnumDyeColor.values())
			ModelBakery.registerItemVariants(ModItems.PHONECASE, new ResourceLocation(ModItems.PHONECASE.getRegistryName().toString() + "_" + dye.getName()));
		
		/*
		ModelLoader.setCustomMeshDefinition(ModItems.CASEDPHONE, new ItemMeshDefinition()
			{
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack)
				{
					System.out.println(stack.getItem().getRegistryName() + "_" + CasedphoneUtil.getRegistryNameFromNBT(stack));
					return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + CasedphoneUtil.getRegistryNameFromNBT(stack), "inventory");
				}
			});
		 */
		
		//and the blocks aren't working
		ModBlocks.COMPUTER.registerModels();
		ModBlocks.SERVER.registerModels();

		ModItems.WIRE.registerModels();
		ModItems.KEY.registerModels();
		ModItems.METAL_SHEET.registerModels();
		ModItems.PLASTIC_SHEET.registerModels();
		ModItems.PHONE.registerModels();
		//What's up with these two?
		//ModItems.CASEDPHONE.registerModels();
		ModItems.PHONECASE.registerModels();
		//I really want to know
		ModItems.MONITOR_SCREEN.registerModels();
		ModItems.KEYBOARD.registerModels();
		ModItems.MOUSE.registerModels();
	}
}