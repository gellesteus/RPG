package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;

public interface Effect {
	public abstract void Apply(Character actor);
	public abstract void Remove(Character actor);
	public abstract boolean repeatApplication();
	
}
