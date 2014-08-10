package com.gellesteus.rpg.ai;

import java.util.ArrayList;

import com.gellesteus.rpg.entity.Character;

public class Sequence extends Routine {
	private ArrayList<Routine> sequence = new ArrayList<Routine>();
	private int current;
	
	public Sequence(Routine...routines){
		for(Routine i:routines){
			sequence.add(i);
		}
		current = 0;
		state=State.RUNNING;
	}
	
	@Override
	public void execute(Character actor) {
		if(isRunning()){
			Routine todo =sequence.get(current);
			todo.execute(actor);
			if(todo.isSuccess()){
				current++;
			}else if(todo.isFailure()){
				state=State.FAILED;
			}
			
			if(current>sequence.size()){
				state=State.SUCCESS;
			}
		}
	}

	@Override
	public void reset() {
		current=0;
		state=State.RUNNING;
	}

}
