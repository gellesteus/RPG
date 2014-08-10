package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class Heal implements Effect {
	private Character caster;
	private int amount;
	
	public Heal(Character caster,int amount){
		this.caster=caster;
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
		caster.heal(actor,amount);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
