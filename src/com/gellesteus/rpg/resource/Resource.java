package com.gellesteus.rpg.resource;

import java.io.File;

import com.gellesteus.rpg.resource.mod.Mod;

public abstract class Resource {
	protected String ID;
	protected Mod parent;
	
	protected abstract File toFile();
}
