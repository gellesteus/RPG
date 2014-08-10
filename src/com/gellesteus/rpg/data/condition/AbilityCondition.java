package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.entity.Character;

public class AbilityCondition implements Conditional {
	private Ability ability;
	
	public AbilityCondition(Ability ab){
		this.ability=ab;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		return actor.hasAbility(ability);
	}

}
