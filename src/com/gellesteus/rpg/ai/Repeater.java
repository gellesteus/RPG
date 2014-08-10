package com.gellesteus.rpg.ai;

import com.gellesteus.rpg.entity.Character;

public class Repeater extends Routine {
	private Routine toRepeat;
	private int timesToRepeat;
	private int originalTTR;
		
	public Repeater(Routine toRepeat, int timesToRepeat){
		this.toRepeat=toRepeat;
		this.timesToRepeat=timesToRepeat;
		this.originalTTR=timesToRepeat;
	}
	
	@Override
	public void execute(Character actor) {
		if(isRunning()){
			if(!actor.isDead()){
				toRepeat.execute(actor);
				timesToRepeat--;
			}else{
				state=State.FAILED;
			}
			
			if(timesToRepeat==0){
				state=State.SUCCESS;
			}
		}
	}


	@Override
	public void reset() {
		timesToRepeat=originalTTR;
		state=State.RUNNING;
	}

}
