package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;

public class IncreaseAttribute implements Effect {
	private AttributeType aType;
	private int amount;
	
	public IncreaseAttribute(AttributeType aType, int amount){
		this.aType=aType;
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		// TODO Auto-generated method stub
		actor.modAV(aType, amount);
	}

	@Override
	public void Remove(Character actor,Character caster) {
		// TODO Auto-generated method stub	
		actor.modAV(aType, -amount);
	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return false;
	}

}
