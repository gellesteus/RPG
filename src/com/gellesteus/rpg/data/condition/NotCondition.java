package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.entity.Character;

public class NotCondition implements Conditional {
	private Conditional condition;
	
	public NotCondition(Conditional condition){
		this.condition=condition;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		// TODO Auto-generated method stub
		return !(condition.evaluate(actor));
	}

}
