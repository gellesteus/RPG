package com.gellesteus.rpg.entity;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.data.ability.CharacterAbility;
import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.data.ability.Passive.Trigger;
import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.data.characterclass.CharacterClass;
import com.gellesteus.rpg.data.command.Commands;
import com.gellesteus.rpg.data.container.Container;
import com.gellesteus.rpg.data.damage.DamageType;
import com.gellesteus.rpg.data.effect.CharacterEffect;
import com.gellesteus.rpg.data.effect.Effect;
import com.gellesteus.rpg.data.item.Item;
import com.gellesteus.rpg.data.perk.Perk;
import com.gellesteus.rpg.data.race.Race;

public abstract class Character implements Update,Container  {
	
	private ArrayList<Commands> disallowedActions = new ArrayList<Commands>(4);
	private ArrayList<CharacterAbility> abilities = new ArrayList<CharacterAbility>();
	private ArrayList<Passive> passives = new ArrayList<Passive>();
	private ArrayList<CharacterEffect> activeEffects = new ArrayList<CharacterEffect>();
	private Vector2 position;
	private int level;
	private Race race;
	private CharacterClass cClass;
	@Override
	public void update(int msPassed) {
		// TODO Auto-generated method stub
		for(CharacterEffect i:activeEffects){
			i.update(msPassed);
		}
		for(CharacterAbility i:abilities){
			i.update(msPassed);
		}
	}

	@Override
	public int getItemCount(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItem(Item item, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Item item, int amount) {
		// TODO Auto-generated method stub
		
	}
	
	public int heal(Character actor,int amount){
		this.on_event(Trigger.ON_HEAL);
		actor.on_event(Trigger.ON_HEALED);
		return amount;
		//restores health to the target and triggers effects 
	}
	
	public int healNT(int amount){
		return amount;
		//heals the character it is called on without triggering any handlers
	}
	
	public int damage(Character actor,int amount,DamageType dType){
		this.on_event(Trigger.ON_DAMAGE);
		actor.on_event(Trigger.ON_DAMAGED);
		return amount;
		//damages the target and triggers effects 
	}
	
	public int damageNT(int amount,DamageType dType){
		return amount;
		//damages the character it is called on without triggering any handlers
	}

	public void disallowAction(Commands Action){
		//Prevents a character from performing the action given
		disallowedActions.add(Action);
	}
	
	public void allowAction(Commands action){
		disallowedActions.remove(action);
	}
	
	public void addPassive(Passive passive){
		
	}
	
	public void removePassive(Passive passive){
		
	}
	
	//Duration in seconds
	public void addEffect(Effect effect, float duration){
		activeEffects.add(new CharacterEffect(effect,duration,this));
	}
	
	public void modAV(AttributeType aType,int amount){
		
	}
	
	public void setAV(AttributeType aType,int amount){
		
	}

	public void setAVB(AttributeType aType,int amount){
		
	}
	
	public int getAV(AttributeType aType){
		return 0;
	}
	
	public int getAVB(AttributeType aType){
		return 0;
	}
	
	public int getAVC(AttributeType aType){
		return 0;
	}
	
	public void AddAbility(Ability ab){
		
	}
	
	public void RemoveAbility(Ability ab){
		
	}
	
	public boolean hasAbility(Ability ab){
		return false;
	}

	public void dispelAll(){
		
	}
	
	public boolean hasPassive(Passive passive){
		return false;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void SetPosition(Vector2 position){
		this.position=position;
	}
	
	public int weaponAttack(Character target){
		return 0;
	}
	
	private void on_event(Passive.Trigger event){
		for(Passive i:passives){
			
		}
	}
	
	public int getLevel(){
		return level;
	}
	
	public boolean hasPerk(Perk perk){
		return false;
	}
	
	public void addPerk(Perk perk){
		
	}

	public void removePerk(Perk perk){
		
	}
	
	public Race getRace(){
		return race;
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void advanceLevel(){
		level++;
	}
}