package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;

public class StatCondition implements Conditional {
	private AttributeType aType;
	private int amount;
	
	public StatCondition(AttributeType aType, int amount){
		this.aType=aType;
		this.amount=amount;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		return actor.getAVB(aType)>=amount;
	}

}
