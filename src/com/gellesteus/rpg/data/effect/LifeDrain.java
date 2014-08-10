package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.data.damage.DamageType;
import com.gellesteus.rpg.entity.Character;

public class LifeDrain implements Effect {
	private Character caster;
	private int amount;
	
	public LifeDrain(Character caster, int amount){
		this.caster=caster;
		this.amount=amount;
	}
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
		int heal = caster.damage(actor, amount, DamageType.SHADOW);
		caster.healNT(heal);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return true;
	}

}
