package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.entity.Character;

public interface Conditional {
	public abstract boolean evaluate(Character actor);
}
