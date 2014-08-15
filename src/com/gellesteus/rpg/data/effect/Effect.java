package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public interface Effect {
	public abstract void Apply(Character target,Character caster);
	public abstract void Remove(Character actor,Character caster);
	public abstract boolean repeatApplication();
	
}
