package de.Ng.Wuppy.PlugDj;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;

public class PlugDjManager {
	
	public static PlugDjManager INSTANCE;
	
	public PlugDjManager() {
		INSTANCE = this;
	}
	
	public void play(String url) {
		Media media = new Media(url);
		
		System.out.println("Duration: " + media.getDuration());
		
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		mediaPlayer.play();
	}
}