package com.gellesteus.rpg.data.item;

import java.util.Arrays;
import java.util.Set;
import java.util.HashMap;

import com.gellesteus.rpg.entity.Person;

public class Leveled extends Item {
	//When a npc tries to equip a leveled item they will be given a level appropriate item instead.
	//A leveled item can point to other leveled item,or a random item to create variation between
	//similar groups of humanoids.
	
	private HashMap<Integer,Item> items = new HashMap<Integer,Item>();
	
	@Override
	public void onEquip(Person actor) {
		int level =actor.getLevel();
		
		if(items.containsKey(level)){
			actor.addItem(items.get(level));
		}else{
			
			Integer[] keys =(Integer[])items.keySet().toArray();
			Arrays.sort(keys);
			
			if(level> keys[keys.length]){
				actor.addItem(items.get(keys[keys.length]));
			}else{
				for(int i = 0;i<keys.length-1;i++){
					if(keys[i] <=level && keys[i+1]>=level){
						 actor.addItem(items.get(keys[i]));
					}
				}
			}
		}
		
		actor.removeItem(this, 1);
	}

}
