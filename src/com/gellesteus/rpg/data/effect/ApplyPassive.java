package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.entity.Character;

public class ApplyPassive implements Effect{
	private Passive toApp;
	
	public ApplyPassive(Passive toApp){
		this.toApp=toApp;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
		actor.addPassive(toApp);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub
		actor.removePassive(toApp);
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
