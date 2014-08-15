package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.damage.DamageType;
import com.gellesteus.rpg.entity.Character;

public class Damage implements Effect {
	private int amount;
	private Character caster;
	private DamageType dType;
	
	public Damage(Character caster,int amount,DamageType dType){
		this.amount=amount;
		this.caster=caster;
		this.dType=dType;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		
		caster.damage(actor, amount, dType);
	}

	@Override
	public void Remove(Character actor,Character caster) {}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
