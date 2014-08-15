package com.gellesteus.rpg.data.ability;

import com.gellesteus.rpg.entity.Update;

public class CharacterAbility implements Update{
	private int cooldown;
	private Ability ability;
	
	public CharacterAbility(Ability ab) {
		this.ability=ab;
	}

	@Override
	public void update(int msPassed) {
		if(cooldown>0){
			cooldown-=msPassed;
		}
		
		if(cooldown<0){
			cooldown=0;
		}
	}
	
	public Ability getBaseAbility(){return ability;}
	
	public void setCooldown(float seconds){
		this.cooldown=(int)(seconds*1000);
	}
	
	public void modCooldown(float seconds){
		this.cooldown+=(int)(seconds*1000);
	}
}
