package com.gellesteus.rpg.data.ability;

import java.util.ArrayList;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.data.condition.Conditional;

public abstract class Ability {
	private int cost;
	private AttributeType costAttr;
	private int cooldown;
	private ArrayList<Conditional> requirements = new ArrayList<Conditional>();
	
	public abstract boolean canCast(Character actor);
	public abstract boolean cast(Character actor);
	
	public boolean canSelect(Character actor){
		for(Conditional i:requirements){
			if(!i.evaluate(actor)) return false;
		}
		return true;
	}
}
