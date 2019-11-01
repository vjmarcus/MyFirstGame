package com.freshappbooks.myfirstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.awt.Rectangle;

public class Drop extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch; //coordinates for rectangle, red rectangle
	Texture dropImage; // decode and load img file to p
	Texture bucketImage;
	Sound dropSound;
	Music rainMusic;
	Rectangle bucket;
	Vector3 touchPos;
	Array<Rectangle> airdrops;
	long lastDropTime;

	@Override
	public void create () {

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		touchPos = new Vector3();
		dropImage = new Texture("drop.png");
		bucketImage = new Texture("bucket.png");

		dropSound = Gdx.audio.newSound(Gdx.files.internal("knock.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		rainMusic.setLooping(true);
		rainMusic.play();

		bucket = new Rectangle();
		bucket.x = 800 / 2  - 64 / 2;
		bucket.y = 20;
		bucket.height = 64;
		bucket.width = 64;
	}

	@Override
	public void render () {  //when need to draw something
		Gdx.gl.glClearColor(0, 0, 2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		batch.setTransformMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.end();

		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = (int) (touchPos.x - 64 / 2);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

		if (bucket.x < 0) bucket.x = 0;
		if (bucket.x > 800 - 64) bucket.x = 800 - 64;

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
