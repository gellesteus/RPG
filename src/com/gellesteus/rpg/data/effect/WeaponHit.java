package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class WeaponHit implements Effect {
	private Character caster;
	
	public WeaponHit(Character caster){
		this.caster=caster;
	}
	
	@Override
	public void Apply(Character actor) {
		caster.weaponAttack(actor);
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
