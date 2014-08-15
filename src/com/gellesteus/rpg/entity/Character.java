package com.gellesteus.rpg.entity;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.gellesteus.rpg.ai.Routine;
import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.data.ability.CharacterAbility;
import com.gellesteus.rpg.data.ability.Passive;
import com.gellesteus.rpg.data.ability.Passive.Trigger;
import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.data.attribute.CharacterAttribute;
import com.gellesteus.rpg.data.characterclass.CharacterClass;
import com.gellesteus.rpg.data.command.Commands;
import com.gellesteus.rpg.data.container.Container;
import com.gellesteus.rpg.data.damage.DamageType;
import com.gellesteus.rpg.data.effect.CharacterEffect;
import com.gellesteus.rpg.data.effect.Effect;
import com.gellesteus.rpg.data.item.ArmorSlots;
import com.gellesteus.rpg.data.item.Item;
import com.gellesteus.rpg.data.perk.Perk;
import com.gellesteus.rpg.data.race.Race;

public abstract class Character implements Update,Container  {

	private static final float PERK_POINTS_PER_LEVEL = 0.5F;
	private static final float SKILL_POINTS_PER_LEVEL = 1.25F;
	private static final float SPECIALIZATION_POINTS_PER_LEVEL = 0.1F;
	
	
	private ArrayList<Commands> disallowedActions = new ArrayList<Commands>(4);
	private ArrayList<CharacterAbility> abilities = new ArrayList<CharacterAbility>();
	private ArrayList<Passive> passives = new ArrayList<Passive>();
	private ArrayList<CharacterEffect> activeEffects = new ArrayList<CharacterEffect>();
	private HashMap<AttributeType,CharacterAttribute> attributes = new HashMap<AttributeType,CharacterAttribute>();
	private HashMap<Item,Integer> inventory = new HashMap<Item,Integer>();
	private Vector2 position;
	private int level;
	private Race race;
	private CharacterClass cClass;
	private Routine AIPackage;
	private int cgcd;
	private int gcd=1500;
	private float perkPoints;
	private float skillPoints;
	private float specPoints;

	@Override
	public void update(int msPassed) {
		if(cgcd>0){
			cgcd-=msPassed;
		}
		
		for(CharacterAttribute i:attributes.values()){
			i.update(msPassed);
		}
		
		for(CharacterEffect i:activeEffects){
			i.update(msPassed);
		}
		
		for(CharacterAbility i:abilities){
			i.update(msPassed);
		}
	}
	
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
			inventory.put(item, inventory.get(item)+amount);
		}else{
			inventory.put(item, amount);
		}
	}
	
	@Override
	public void removeItem(Item item, int amount) {
		if(inventory.containsKey(item)){
			int current = inventory.get(item);
			current-=amount;
			if(current>0){
				inventory.put(item, current);
			}else{
				inventory.remove(item);
			}
		}
	}
	
	public int heal(Character actor,int amount){
		this.on_event(Trigger.ON_HEAL);
		actor.on_event(Trigger.ON_HEALED);
		actor.modAVC(AttributeType.HEALTH, amount);
		return amount;
		//restores health to the target and triggers effects 
	}
	
	public int healNT(int amount){
		modAVC(AttributeType.HEALTH, amount);
		return amount;
		//heals the character it is called on without triggering any handlers
	}
	
	public int damage(Character actor,int amount,DamageType dType){
		this.on_event(Trigger.ON_DAMAGE);
		actor.on_event(Trigger.ON_DAMAGED);
		actor.modAVC(AttributeType.HEALTH, -amount);
		return amount;
		//damages the target and triggers effects 
	}
	
	public int damageNT(int amount,DamageType dType){
		modAVC(AttributeType.HEALTH, -amount);
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
		if(hasPassive(passive)){
			this.passives.add(passive);
			passive.apply(this);
		}
	}
	
	public void removePassive(Passive passive){
		if(hasPassive(passive)){
			this.passives.add(passive);
			passive.apply(this);
		}
	}
	
	//Duration in seconds
	public void addEffect(Effect effect, float duration){
		activeEffects.add(new CharacterEffect(effect,duration,this));
	}
	
	public void modAV(AttributeType aType,int amount){
		int value = this.attributes.get(aType).getModifier()+amount;
		this.attributes.get(aType).setModifier(value);
	}
	
	public void modAVC(AttributeType aType,int amount){
		int value = this.attributes.get(aType).getModifier()+amount;
		this.attributes.get(aType).setCurrent(value);
	}
	
	public void setAV(AttributeType aType,int amount){
		this.attributes.get(aType).setCurrent(amount);
	}

	public void setAVB(AttributeType aType,int amount){
		this.attributes.get(aType).setBase(amount);
	}
	
	public int getAV(AttributeType aType){
		int value=this.attributes.get(aType).getBase();
		value+=this.attributes.get(aType).getDerived();
		value+=this.attributes.get(aType).getModifier();
		return value;
	}
	
	public int getAVB(AttributeType aType){
		return this.attributes.get(aType).getBase();

	}
	
	public int getAVC(AttributeType aType){
		return this.attributes.get(aType).getCurrent();
	}
	
	public void AddAbility(Ability ab){
		this.abilities.add(new CharacterAbility(ab));
	}
	
	public void RemoveAbility(Ability ab){
		
	}
	
	public boolean hasAbility(Ability ab){
		return false;
	}

	public void dispelAll(){
		for(CharacterEffect i:activeEffects){
			i.dispel();
		}
	}
	
	public boolean hasPassive(Passive passive){
		return passives.contains(passive);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void SetPosition(Vector2 position){
		this.position=position;
	}
	
	public int weaponAttack(Character target){
		this.on_event(Trigger.ON_WEAPON_ATTACK);
		target.on_event(Trigger.ON_WEAPON_ATTACK_RECEIVE);
		return this.damage(target, 10, DamageType.PHYSICAL);
		//TODO: weapon damage+calculations
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
		return this.getAVC(AttributeType.HEALTH)>0;
	}
	
	public void modifyCooldown(Ability ability,float seconds){
		for(CharacterAbility i:abilities){
			if(i.getBaseAbility()==ability){
				i.modCooldown(seconds);
				return;
			}
		}
	}
	
	public abstract void getEquppedItem(ArmorSlots slot);
	
	public float getx(){
		return position.x;
	}
	
	public float gety(){
		return position.y;
	}
	
	public void advanceLevel(){
		skillPoints+=SKILL_POINTS_PER_LEVEL;
		perkPoints+=PERK_POINTS_PER_LEVEL;
		specPoints+=SPECIALIZATION_POINTS_PER_LEVEL;
		level++;
	}
}