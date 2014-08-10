package com.gellesteus.rpg.data.condition;

import com.gellesteus.rpg.data.race.Race;
import com.gellesteus.rpg.entity.Character;

public class RaceCondition implements Conditional {
	private Race race;
	
	public RaceCondition(Race race){
		this.race=race;
	}
	
	@Override
	public boolean evaluate(Character actor) {
		return actor.getRace()==race;
	}

}
