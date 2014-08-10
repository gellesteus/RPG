package com.gellesteus.rpg;

import com.badlogic.gdx.Game;

public class RPG extends Game{
	@Override
	public void create() {
		//Put it into menu state
		setScreen(new com.gellesteus.rpg.screen.StartMenu());
	}
}
