package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.damage.DamageType;
import com.gellesteus.rpg.entity.Character;

public class LifeDrain implements Effect {
	private int amount;
	
	public LifeDrain(int amount){
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		int heal = caster.damage(actor, amount, DamageType.SHADOW);
		caster.healNT(heal);
	}

	@Override
	public void Remove(Character actor,Character caster) {

	}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
