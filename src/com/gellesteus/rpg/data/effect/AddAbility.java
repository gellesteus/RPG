package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.entity.Character;

public class AddAbility implements Effect {
	private Ability ability;
	private boolean hasAbility=false;
	public AddAbility(Ability ab){
		this.ability=ab;
	}
	
	@Override
	public void Apply(Character actor,Character caste) {
		if(actor.hasAbility(ability)){	
			hasAbility=true;
			actor.AddAbility(ability);
		}
	}

	@Override
	public void Remove(Character actor,Character caster) {
		if(hasAbility){
			actor.RemoveAbility(ability);
			}
		}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
