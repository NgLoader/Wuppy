package de.Ng.Wuppy.ModManager;

import de.Ng.Wuppy.ModManager.Mods.Mod;
import de.Ng.Wuppy.ModManager.Mods.Hypixel.MurderMystery;

public class ModList {
	
	public static Mod MURDERMYSTERY;
	
	public static void registerAllMods() {
		ModManager modManager = ModManager.INSTANCE;
		
		MURDERMYSTERY = new MurderMystery(modManager);
	}
}