package de.Ng.Wuppy.ModManager.addons;

import java.util.List;

import me.ichun.mods.pictureinpicture.common.PiP;
import scala.actors.threadpool.Arrays;

public class AddonPictureInPicture {
	
	public static boolean isAvavible() {
		try {
			return Class.forName("me.ichun.mods.pictureinpicture.common.PiP") != null;
		} catch(ClassNotFoundException ex) { }
		return false;
	}
	
	
	public static void addPlayer(String name) {
		if(!isAvavible())
			return;
		
		List<String> players = Arrays.asList(PiP.config.playerCam.split(","));
		
		if(!players.contains(name))
			players.add(name);
		
		PiP.config.playerCam = String.join(",", players);
	}
	
	public static void removePlayer(String name) {
		if(!isAvavible())
			return;
		
		List<String> players = Arrays.asList(PiP.config.playerCam.split(","));
		players.remove(name);
		PiP.config.playerCam = String.join(",", players);
	}
	
	public static void resetPlayers() {
		if(!isAvavible())
			return;
		
		PiP.config.playerCam = "";
	}
}