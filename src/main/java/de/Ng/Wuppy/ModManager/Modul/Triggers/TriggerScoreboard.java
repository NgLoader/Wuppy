package de.Ng.Wuppy.ModManager.Modul.Triggers;

import java.util.LinkedList;
import java.util.List;

import de.Ng.Wuppy.ModManager.Mods.Mod;
import de.Ng.Wuppy.ModManager.Modul.Trigger;

public class TriggerScoreboard extends Trigger {
	
	public static List<String> currentObjectiveNames = new LinkedList<>();
	public static long lastUpdate = 0;
	
	private final Mod mod;
	
	private final String objectiveName;
	private final Boolean ignoreCase;
	
	public TriggerScoreboard(Mod mod, String objectiveName, boolean ignoreCase) {
		this.mod = mod;
		this.objectiveName = objectiveName;
		this.ignoreCase = ignoreCase;
	}
	
	@Override
	public boolean isTriggered() {
		if(mod == null || mc == null || mc.world == null || mc.world.getScoreboard() == null)
			return false;
		
		if(lastUpdate > System.currentTimeMillis())
			if(ignoreCase)
				return currentObjectiveNames.stream().anyMatch(objective -> objective.equalsIgnoreCase(objectiveName));
			else
				return currentObjectiveNames.contains(objectiveName);
		lastUpdate = System.currentTimeMillis() + 500;

		currentObjectiveNames.clear();
		
		boolean foundScoreObject = mc.world.getScoreboard().getScoreObjectives().stream().anyMatch(score -> score.getName().contains("MurderMystery"));
		
		mc.world.getScoreboard().getScoreObjectives().forEach(objective -> {
			if(!currentObjectiveNames.contains(objective.getName()))
				currentObjectiveNames.add(objective.getName());
		});
		
		if(ignoreCase)
			return currentObjectiveNames.stream().anyMatch(objective -> objective.equalsIgnoreCase(objectiveName));
		else
			return currentObjectiveNames.contains(objectiveName);
	}

	
	public Mod getMod() {
		return mod;
	}
}