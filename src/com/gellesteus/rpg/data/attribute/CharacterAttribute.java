package com.gellesteus.rpg.data.attribute;

import com.gellesteus.rpg.entity.Update;

public class CharacterAttribute implements Update{
	private Attribute attribute;
	private int  base;
	private int derived;
	private int modifier;
	private int current;
	
	@Override
	public void update(int msPassed) {
		// TODO Auto-generated method stub
		
	}
}
