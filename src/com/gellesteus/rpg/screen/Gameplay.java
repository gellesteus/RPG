package com.gellesteus.rpg.screen;

import com.badlogic.gdx.Screen;
import com.gellesteus.rpg.scene.Scene;
import com.gellesteus.rpg.scene.SceneRenderer;

public class Gameplay implements Screen {
	public static Gameplay gameplay = new Gameplay();
	private Scene current;
	private SceneRenderer sRender;
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		sRender.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void changeScene(Scene newScene){
		current=newScene;
		sRender=new SceneRenderer(current);
	}
	
	public void showMessgae(String message){
		
	}
	
}
