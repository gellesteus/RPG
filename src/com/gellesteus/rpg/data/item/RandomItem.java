package com.gellesteus.rpg.data.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import com.gellesteus.rpg.entity.Person;

public class RandomItem extends Item{
	
	private ArrayList<Item> itemList = new ArrayList<Item>();

	private class Shuffler implements Comparator<Item>{
		Random random =new Random();
		
		@Override
		public int compare(Item arg0, Item arg1) {
			return random.nextInt();
		}
	}
	
	
	public RandomItem(Item...items){
		for(Item i:items){
			itemList.add(i);
		}
		itemList.sort(new Shuffler());
	}


	@Override
	public void onEquip(Person actor) {
		actor.addItem(itemList.get(0));
	}
	
}
