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

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getDerived() {
		return derived;
	}

	public void setDerived(int derived) {
		this.derived = derived;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
