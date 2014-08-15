package com.gellesteus.rpg.data.effect;

import java.io.IOException;

import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.resource.script.Script;
import com.gellesteus.rpg.resource.script.ScriptRuntimeException;

public class ScriptedEffect implements Effect {
	private Script script;
	private Character caster;
	
	public ScriptedEffect(Script script,Character caster){
		this.script=script;
	}
	
	
	
	@Override
	public void Apply(Character actor,Character caster) {
		try {
			script.run(actor, caster);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ScriptRuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Remove(Character actor,Character caster) {}

	@Override
	public boolean repeatApplication() {
		return true;
	}

}
