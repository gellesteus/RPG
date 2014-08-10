package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.entity.Character;

public class AddAbility implements Effect {
	private Ability ability;
	public AddAbility(Ability ab){
		this.ability=ab;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
		actor.AddAbility(ability);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub
		actor.RemoveAbility(ability);
	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return false;
	}

}
