package com.gellesteus.rpg.ai;

import java.util.ArrayList;

import com.gellesteus.rpg.entity.Character;

public class Selector extends Routine {
	private ArrayList<Routine> selected = new ArrayList<Routine>();
	private int current;
	
	public Selector(Routine...routines){
		for(Routine i:routines){
			selected.add(i);
		}
		current=0;
		state=State.RUNNING;
	}
	
	@Override
	public void execute(Character actor) {
		if(isRunning()){
			Routine todo = selected.get(current);
			todo.execute(actor);
			if(todo.isSuccess()){
				state=State.SUCCESS;
			}else if(todo.isFailure()){
				current++;
			}
			
			if(current>selected.size()){
				state=State.FAILED;
			}
		}
	}

	@Override
	public void reset() {
		current=0;
		state=State.RUNNING;
	}
}
