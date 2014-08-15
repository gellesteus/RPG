package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.data.perk.Perk;
import com.gellesteus.rpg.entity.Character;

public class PerkCondition implements Conditional {
	private Perk perk;
	
	public PerkCondition(Perk perk){
		this.perk=perk;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		return actor.hasPerk(perk);
	}

}
