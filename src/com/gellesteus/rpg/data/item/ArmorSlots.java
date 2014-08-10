package com.gellesteus.rpg.data.item;

public enum ArmorSlots {
	HELMET(1),
	NECK(1),
	CHEST(1),
	HANDS(1),
	RINGS(2),
	LEGS(1),
	FEET(1),
	BACK(1);
	
	private int max_count;
	
	private ArmorSlots(int max_count){
		this.max_count=max_count;
	}
	
	public int getMax(){return max_count;}
}
