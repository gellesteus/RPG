package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.entity.Character;

public class FlagCondition implements Conditional {
	//load a story flag from a save file and check it
	private String flag;
	
	public FlagCondition(String flag){
		this.flag=flag; 
	}
	
	@Override
	public boolean evaluate(Character actor) {
		// TODO Auto-generated method stub
		return false;
	}

}
