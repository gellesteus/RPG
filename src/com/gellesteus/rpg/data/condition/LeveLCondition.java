package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.entity.Character;

public class LeveLCondition implements Conditional {
	private int amount;
	
	public LeveLCondition(int amount){
		this.amount=amount;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		// TODO Auto-generated method stub
		return actor.getLevel()>=amount;
	}

}
