package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class Heal implements Effect {
	private int amount;
	
	public Heal(int amount){
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		// TODO Auto-generated method stub
		caster.heal(actor,amount);
	}

	@Override
	public void Remove(Character actor,Character caster) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
