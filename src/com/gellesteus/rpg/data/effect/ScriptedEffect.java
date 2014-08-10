package com.gellesteus.rpg.data.effect;

import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.resource.script.Script;

public class ScriptedEffect implements Effect {
	private Script script;
	
	public ScriptedEffect(Script script){
		this.script=script;
	}
	
	
	
	@Override
	public void Apply(Character actor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Remove(Character actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean repeatApplication() {
		// TODO Auto-generated method stub
		return false;
	}

}
