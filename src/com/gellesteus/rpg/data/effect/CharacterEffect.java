package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.entity.Update;

public class CharacterEffect implements Update{
	private int durationRemaining;
	private Effect effect;
	private int msSinceLastTick;
	private int tickTime;
	private Character target;
	private Character caster;
	
	public CharacterEffect(Effect effect, float duration){
		this.effect=effect;
		this.durationRemaining=(int)(duration*1000);
	}
	
	public CharacterEffect(Effect effect, float duration,Character target){
		this.effect=effect;
		this.durationRemaining=(int)(duration*1000);
		this.target=target;
	}
	
	public CharacterEffect(CharacterEffect effect,float duration, Character target, Character caster){
		this.target=target;
		this.caster=caster;
		this.durationRemaining=(int)(duration*1000);
		this.effect=effect.effect;
		this.durationRemaining=effect.durationRemaining;
		this.tickTime=effect.tickTime;
		this.effect.Apply(target,caster);
	}
	
	public void update(int msPassed){
		durationRemaining -= msPassed;
		msSinceLastTick +=msPassed;
		
		if(durationRemaining<=0){
			remove();
			return;
		}
		
		if(effect.repeatApplication()){
			if(msSinceLastTick>=tickTime){
				effect.Apply(target,caster);
				msSinceLastTick-=tickTime;
			}
		}
	}

	public void dispel(){
		durationRemaining = 0;
	}
	
	private void remove(){
		effect.Remove(target,caster);
	}
}
