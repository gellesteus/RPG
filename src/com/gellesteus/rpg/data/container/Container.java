package com.gellesteus.rpg.data.container;

import com.gellesteus.rpg.data.item.Item;

public interface Container {
	
	public abstract int getItemCount(Item item);
	public abstract void addItem(Item item);
	public abstract void addItem(Item item, int amount);
	public abstract void removeItem(Item item,int amount);
}
