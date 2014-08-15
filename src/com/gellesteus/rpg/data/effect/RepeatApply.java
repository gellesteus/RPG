package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public class RepeatApply implements Effect {
	//Every tick, will add a new instance of the effect with the duration equal to the remaining duration of the effect
	private Effect effect;
	
	public RepeatApply(Effect effect){
		this.effect=effect;
	}
	
	@Override
	public void Apply(Character actor,Character caster) {
		actor.addEffect(effect, 5.0f);
		//TODO: find duration
	}

	@Override
	public void Remove(Character actor,Character caster) {
	}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
