package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class EffectOnEnd implements Effect {
	private Effect effect;
	private float duration;
	
	public EffectOnEnd(Effect effect,float duration){
		this.effect=effect;
		this.duration=duration;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {

	}

	@Override
	public void Remove(Character actor,Character caster) {
		actor.addEffect(effect, duration);
	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return false;
	}

}
