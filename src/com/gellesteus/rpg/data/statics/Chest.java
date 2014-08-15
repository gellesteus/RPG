package com.gellesteus.rpg.data.statics;

import java.util.HashMap;

import com.gellesteus.rpg.data.container.Container;
import com.gellesteus.rpg.data.item.Item;
import com.gellesteus.rpg.entity.Character;

public class Chest extends Static implements Container {
	private HashMap<Item,Integer> inventory = new HashMap<Item,Integer>();
	
	@Override
	public int getItemCount(Item item) {
		if(inventory.containsKey(item)){
			return inventory.get(item);
		}
		return 0;
	}

	@Override
	public void addItem(Item item) {
		addItem(item,1);
	}

	@Override
	public void addItem(Item item, int amount) {
		if(inventory.containsKey(item)){
			inventory.put(item,inventory.get(item)+amount);
		}else{
			inventory.put(item,amount);
		}
	}

	@Override
	public void removeItem(Item item, int amount) {
		if(inventory.containsKey(item)){
			if(inventory.get(item)>amount){
				inventory.put(item,inventory.get(item)-amount);
			}else{
				inventory.remove(item);
			}
		}
	}

	@Override
	public void onActivate(Character activator) {
		//TODO: display item selection screen
	}

}
