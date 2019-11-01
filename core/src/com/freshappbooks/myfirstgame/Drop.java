package com.freshappbooks.myfirstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends ApplicationAdapter {
	SpriteBatch batch; //coordinates for rectangle, red rectangle
	Texture dropImage; // decode and load img file to p
	Texture bucketImage;
	Sound dropSound;
	Music rainMusic;

	@Override
	public void create () {
		batch = new SpriteBatch();
		dropImage = new Texture("drop.png");
		bucketImage = new Texture("bucket.png");

		dropSound = Gdx.audio.newSound(Gdx.files.internal("knock.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);
		rainMusic.play();
	}

	@Override
	public void render () {  //when need to draw something
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
