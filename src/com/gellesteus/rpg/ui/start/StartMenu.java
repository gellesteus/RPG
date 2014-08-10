package com.gellesteus.rpg.ui.start;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class StartMenu {
	private static final float topSection = 0.80f;		//Top area of screen occupies 80% of it
	
	
	
	public static void Render(){
		OrthographicCamera cam = new OrthographicCamera(800,600);
		ShapeRenderer debug = new ShapeRenderer();
		
		debug.begin(ShapeType.Line);
		
		debug.setColor(new Color(1,0,0,1));
		debug.rect(0, 600-(600*topSection), 800, 600*topSection);
	
		debug.end();
	}
	
}
