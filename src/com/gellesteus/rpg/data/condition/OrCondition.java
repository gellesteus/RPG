package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.entity.Character;

public class OrCondition implements Conditional {
	private Conditional cond1,cond2;
	
	public OrCondition(Conditional cond1,Conditional cond2){
		this.cond1=cond1;
		this.cond2=cond2;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		return (cond1.evaluate(actor)||cond2.evaluate(actor));
	}
}
