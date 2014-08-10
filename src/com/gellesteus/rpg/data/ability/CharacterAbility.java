package com.gellesteus.rpg.data.ability;

import com.gellesteus.rpg.entity.Update;

public class CharacterAbility implements Update{
	private int cooldown;
	private Ability ability;
	@Override
	public void update(int msPassed) {
		if(cooldown>0){
			cooldown-=msPassed;
		}
		
		if(cooldown<0){
			cooldown=0;
		}
	}

}
