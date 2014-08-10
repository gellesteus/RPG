package com.gellesteus.rpg.data.item;

import com.gellesteus.rpg.entity.Person;

public abstract class Item {
	private String name;
	private String description;
	private int value;
	private int weight;
	
	public abstract void onEquip(Person actor);
}
