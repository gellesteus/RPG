package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;

public class SetAttribute implements Effect {
	private AttributeType aType;
	private int origValue;
	private int newValue;
	
	public SetAttribute(AttributeType aType,int amount){
		this.aType=aType;
	}
	
	@Override
	public void Apply(Character actor) {
		origValue=actor.getAVB(aType);
		actor.setAVB(aType, newValue);
	}

	@Override
	public void Remove(Character actor) {
		//fix overwrite problem
		actor.setAVB(aType, origValue);
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}
}
