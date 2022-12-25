package de.Ng.Wuppy.ModManager.Modul;

import de.Ng.Wuppy.ModManager.Mods.Mod;
import net.minecraft.client.Minecraft;

public abstract class Trigger {
	
	protected Minecraft mc = Minecraft.getMinecraft();
	
	public abstract boolean isTriggered();
	public abstract Mod getMod();
}