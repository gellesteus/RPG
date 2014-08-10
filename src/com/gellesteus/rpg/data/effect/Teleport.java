package com.gellesteus.rpg.data.effect;

import com.badlogic.gdx.math.Vector2;
import com.gellesteus.rpg.entity.Character;

public class Teleport implements Effect {
	private Vector2 target;
	
	public Teleport(Vector2 target){
		this.target=target;
	}
	
	@Override
	public void Apply(Character actor) {
		actor.SetPosition(target);
	}

	@Override
	public void Remove(Character actor) {

	}

	@Override
	public boolean repeatApplication() {
		return false;
	}
}
