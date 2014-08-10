package com.gellesteus.rpg.scene;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class SceneRenderer {
	private Scene scene;
	private OrthographicCamera cam;

	public SceneRenderer(Scene scene){
		this.scene=scene;
		cam = new OrthographicCamera();
	}
	
	public void render(){
		
	}
}
