package de.Ng.Wuppy.Gui;

import java.io.IOException;

import de.Ng.Wuppy.Gui.Elements.WuppyButton;
import de.Ng.Wuppy.Gui.Elements.WuppyScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiWuppyMods extends WuppyScreen {
	
	private final GuiScreen lastScreen;
	
	public GuiWuppyMods(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
	}
	
	public void initGui() {
        setTitle("Wuppy - Mods");
        
		int j = this.height / 6;
        
        this.buttonList.add(new WuppyButton(1, this.width - 105, this.height - 25, 100, 20, "Back"));
	}
	
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		case 0:
			break;
		case 1:
			this.mc.displayGuiScreen(lastScreen);
			break;
		default:
			break;
		}
	}
}