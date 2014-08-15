package com.gellesteus.rpg.ui.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class Overlay{
	private Stage stage;
	
	public Overlay(){
		stage = new Stage();
	    Gdx.input.setInputProcessor(stage);

	    Table table = new Table();
	    table.setFillParent(true);
	    stage.addActor(table);
	    
	    table.add(new Button());
	}
	
	public void draw(){
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}
