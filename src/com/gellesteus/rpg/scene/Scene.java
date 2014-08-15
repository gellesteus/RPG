package com.gellesteus.rpg.scene;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.gellesteus.rpg.data.statics.Static;
import com.gellesteus.rpg.entity.Character;

public class Scene {
	private ArrayList<Waypoint> major = new ArrayList<Waypoint>();
	private ArrayList<Waypoint> minor = new ArrayList<Waypoint>();
	private ArrayList<Static> statics = new ArrayList<Static>();
	private ArrayList<Character> spawners = new ArrayList<Character>();
	private Tileset tileset;
	private OrthographicCamera cam = new OrthographicCamera();
	
	public Vector2 nextStepTo(Character actor, Vector2 location){
		return null;
	}

	public void Render(){
		
	}
}
