package com.gellesteus.rpg.entity.AbilityUsage;

import com.gellesteus.rpg.data.ability.Ability;

public interface Cast {	//Determines how targetting selection works.
	public abstract void cast(Ability ab);
}

