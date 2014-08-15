package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class Dispel implements Effect {

	@Override
	public void Apply(Character actor,Character caster) {
		actor.dispelAll();
	}

	@Override
	public void Remove(Character actor,Character caster) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return true;
	}

}
