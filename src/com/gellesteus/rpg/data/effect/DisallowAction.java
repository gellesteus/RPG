package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.command.Commands;
import com.gellesteus.rpg.entity.Character;

public class DisallowAction implements Effect {
	private Commands action;
	
	public DisallowAction(Commands action){
		this.action=action;
	}
	@Override
	public void Apply(Character actor,Character caster) {
		actor.disallowAction(action);
	}

	@Override
	public void Remove(Character actor,Character caster) {
		// TODO fix effect overwriting
		actor.allowAction(action);
	}
	
	@Override
	public boolean repeatApplication() {
		return false;
	}

}
