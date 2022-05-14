package com.Badadamadaba.bdm.client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPhone extends GuiScreen {

	public static final ResourceLocation guiBackground = new ResourceLocation("bdm", "textures/gui/phone_gui.png");
	public static final int guiWidth = 256, guiHeight = 256;

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.getTextureManager().bindTexture(guiBackground);
		int xOffset = (width - guiWidth) / 2;
		int yOffset = (height - guiHeight) / 2;
		this.drawTexturedModalRect(xOffset, yOffset, 0, 0, guiWidth, guiHeight);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public GuiPhone() {

	}
}