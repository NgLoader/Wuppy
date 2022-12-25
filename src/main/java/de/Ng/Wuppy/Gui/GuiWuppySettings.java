package de.Ng.Wuppy.Gui;

import java.io.IOException;

import de.Ng.Wuppy.Gui.Elements.WuppyButton;
import de.Ng.Wuppy.Gui.Elements.WuppyScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiWuppySettings extends WuppyScreen {
	
	private final GuiScreen lastScreen;
	
	public GuiWuppySettings(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
	}
	
	public void initGui() {
        setTitle("Wuppy - Settings");
        
        int j = this.height / 6;
        
        this.buttonList.add(new WuppyButton(0, this.width / 24, j, 100, 20, "Mods"));
        this.buttonList.add(new WuppyButton(1, this.width - 105, this.height - 25, 100, 20, "Back"));
	}
	
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		case 0:
			this.mc.displayGuiScreen(new GuiWuppyMods(this));
			break;
		case 1:
			this.mc.displayGuiScreen(lastScreen);
			break;
		default:
			break;
		}
	}
}