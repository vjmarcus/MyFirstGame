package com.freshappbooks.myfirstgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.freshappbooks.myfirstgame.Drop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "drop";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Drop(), config);
	}
}
