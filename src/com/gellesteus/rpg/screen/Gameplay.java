package com.gellesteus.rpg.screen;

import com.badlogic.gdx.Screen;
import com.gellesteus.rpg.scene.Scene;
import com.gellesteus.rpg.entity.Character;

public class Gameplay implements Screen {
	public static Gameplay gameplay = new Gameplay();
	private Scene current;
	private Character activeCharacter;
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		current.Render();
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
		current.Render();
	}
	
	public void showMessgae(String message){
		
	}
	
}
