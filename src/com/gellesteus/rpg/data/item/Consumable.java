package com.gellesteus.rpg.data.item;

import com.gellesteus.rpg.data.effect.Effect;
import com.gellesteus.rpg.entity.Person;

public class Consumable extends Item{
	private Effect effect;
	private float duration;
	
	public Consumable(int value, int weight, Effect effect, float duration){
		
	}
	
	@Override
	public void onEquip(Person actor) {
		actor.removeItem(this,1);
		actor.addEffect(effect, duration);
	}

}
