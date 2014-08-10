package com.gellesteus.rpg.data.effect;

import com.badlogic.gdx.math.Vector2;
import com.gellesteus.rpg.entity.Character;

public class Charge implements Effect {
	private Vector2 target;
	private int speed;
	
	public Charge(Vector2 target,int speed){
		this.target=target;
		this.speed=speed;
	}
	
	public Charge(Character target,int speed){
		this.target=target.getPosition();
		this.speed=speed;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
