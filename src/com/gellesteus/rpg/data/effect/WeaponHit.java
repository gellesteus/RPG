package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class WeaponHit implements Effect {
	public WeaponHit(){	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		caster.weaponAttack(actor);
	}

	@Override
	public void Remove(Character actor,Character caster) {		
	}

	@Override
	public boolean repeatApplication() {
		return false;
	}

}
