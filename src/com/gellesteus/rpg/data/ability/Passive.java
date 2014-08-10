package com.gellesteus.rpg.data.ability;


import java.util.HashMap;

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
		ON_COMBAT_END;
	}
	
	private HashMap<Effect,Trigger> abEffects = new HashMap<Effect,Trigger>();
	
	public void addEffect(Effect abEffect,Trigger trigger){
		abEffects.put(abEffect, trigger);
	}
	
	public void getEffects(){
		
	}
}
