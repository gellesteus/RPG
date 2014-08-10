package com.gellesteus.rpg.ai;

import com.gellesteus.rpg.entity.Character;

public class Conditional extends Routine {
	private com.gellesteus.rpg.data.condition.Conditional condition;
	private Routine routine;
	
	public Conditional(com.gellesteus.rpg.data.condition.Conditional condition,Routine todo){
		this.condition=condition;
		this.routine=todo;
		state=State.RUNNING;
	}
	
	@Override
	public void execute(Character actor) {
		if(isRunning()){
			if(condition.evaluate(actor)){
				routine.execute(actor);
				state=routine.getState();
			}else{
				state=State.FAILED;
			}
		}
	}

	@Override
	public void reset() {
		state=State.RUNNING;
	}

}
