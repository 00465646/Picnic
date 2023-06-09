package com.mygdx.game;

import static com.mygdx.game.Picnic.SCR_HEIGHT;
import static com.mygdx.game.Picnic.SCR_WIDTH;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.Picnic;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode((int) SCR_WIDTH, (int) SCR_HEIGHT);
		config.setTitle("Picnic");
		new Lwjgl3Application(new Picnic(), config);
	}
}
