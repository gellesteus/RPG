package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.entity.Character;

public class ApplyPassive implements Effect{
	private Passive toApp;
	private boolean alreadyHas=false;
	
	public ApplyPassive(Passive toApp){
		this.toApp=toApp;
	}
	
	@Override
	public void Apply(Character actor,Character caste) {
		if(!actor.hasPassive(toApp)){
			actor.addPassive(toApp);
		}else{
			alreadyHas=true;
		}
	}

	@Override
	public void Remove(Character actor,Character caste) {
		if(!alreadyHas){
			actor.removePassive(toApp);
		}
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
