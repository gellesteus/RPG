package com.gellesteus.rpg.data.statics;

import com.badlogic.gdx.graphics.g3d.Model;
import com.gellesteus.rpg.entity.Character;

public abstract class Static {
	private Model model;
	private float width,height;
	public abstract void onActivate(Character activator);
	
}
