package com.gellesteus.rpg.ai;

import com.gellesteus.rpg.entity.Character;

public abstract class Routine {
	protected State state;
	
	public abstract void execute(Character actor);
	public abstract void reset();
	
	public boolean isFailure() {
		return state==State.FAILED;
	}

	public boolean isSuccess() {
		return state==State.SUCCESS;
	}

	public boolean isRunning() {
		return state==State.RUNNING;
	}
	
	protected State getState(){return state;}
}
