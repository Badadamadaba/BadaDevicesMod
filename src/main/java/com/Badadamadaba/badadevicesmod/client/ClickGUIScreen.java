package com.Badadamadaba.badadevicesmod.client;

import net.minecraft.client.gui.GuiScreen;
import java.util.ArrayList;

public class ClickGUIScreen extends GuiScreen {

    public ClickGUIScreen INSTANCE = new ClickGUIScreen();

    ArrayList<FrameForGui> frames;

    public ClickGUIScreen(){
        frames = new ArrayList<>();
        int offeset = 0;
        for(Category category : Category.values()){
            frames.add(new FrameForGui(category, x:10 + offset, y:20));
            offset += 110;
        }
    }

    @java.lang.Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
