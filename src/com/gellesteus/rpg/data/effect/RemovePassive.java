package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.entity.Character;

public class RemovePassive implements Effect {
	private Passive passive;
	private boolean hadPassive;
	
	public RemovePassive(Passive passive){
		this.passive=passive;
	}
	
	@Override
	public void Apply(Character actor) {
		hadPassive=actor.hasPassive(passive);
		if(hadPassive){
			actor.removePassive(passive);
		}
	}

	@Override
	public void Remove(Character actor) {
		if(hadPassive){
			actor.addPassive(passive);
		}
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
