package com.gellesteus.rpg.ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import com.gellesteus.rpg.entity.Character;

public class RandomSelector extends Routine {
	private ArrayList<Routine> selected = new ArrayList<Routine>();
	private int current;
	
	private class Shuffler implements Comparator<Routine>{
		
		private Random random = new Random();
		
		@Override
		public int compare(Routine arg0, Routine arg1) {
			return random.nextInt();
		}
		
	}
	
	public RandomSelector(Routine...routines){
		for(Routine i:routines){
			selected.add(i);
		}
		
		selected.sort(new Shuffler());
		
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
		selected.sort(new Shuffler());
		state=State.RUNNING;
	}
}
