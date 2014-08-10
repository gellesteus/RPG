package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;

public class DecreaseAttribute implements Effect {
	private AttributeType aType;
	private int amount;
	
	public DecreaseAttribute(AttributeType aType, int amount){
		this.aType=aType;
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
		actor.modAV(aType, -amount);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub	
		actor.modAV(aType, amount);
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
