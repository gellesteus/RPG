package com.gellesteus.rpg.data.perk;

import java.util.ArrayList;

import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.data.condition.Conditional;
import com.gellesteus.rpg.entity.Character;

public class Perk {
	public static ArrayList<Perk> perkList = new ArrayList<Perk>();
	
	private Passive effect;
	private ArrayList<Conditional> conditions =new ArrayList<Conditional>();

	public boolean qualifies(Character actor){
		for(Conditional i:conditions){
			if(!i.evaluate(actor)){
				return false;
			}
		}
		return true;
	}
}
