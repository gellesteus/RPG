package com.gellesteus.rpg.data.ability;


import java.util.HashMap;
import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.data.effect.Effect;

public class Passive {
	public enum Trigger{
		ON_APPLY,
		ON_DAMAGED,
		ON_DAMAGE,
		ON_DEATH,
		ON_HEAL,
		ON_HEALED,
		ON_CRITICAL,
		ON_CRITICAL_RECEIVE,
		ON_KILL,
		ON_UPDATE,
		ON_COMBAT_START,
		ON_COMBAT_END,
		ON_WEAPON_ATTACK,
		ON_WEAPON_ATTACK_RECEIVE;
	}
	
	private HashMap<Effect,Trigger> abEffects = new HashMap<Effect,Trigger>();
	
	public void addEffect(Effect abEffect,Trigger trigger){
		abEffects.put(abEffect, trigger);
	}
	
	public void apply(Character actor){
		for(Effect i:abEffects.keySet()){
			if(abEffects.get(i)==Trigger.ON_APPLY){
				actor.addEffect(i, -1);
			}
		}
	}
	
	public void getEffects(){
		
	}
}
