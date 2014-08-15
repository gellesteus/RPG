package com.gellesteus.rpg.data.attribute;

public enum AttributeType {
	HEALTH,
	//Class specific resources
	STAMINA,
	MANA,
	COMBO_POSITION,
	RUNE_1,
	RUNE_2,
	RUNE_3,
	RUNE_4,
	//Base stats
	STRENGTH,
	INTELLIGENCE,
	DEXTERITY,
	WISDOM,
	ENDURANCE,
	//Resistances
	ARMOR,
	MAGIC_RESISTANCE,
	AIR_RESISTANCE,
	EARTH_REISTANCE,
	FIRE_RESISTANCE,
	WATER_RESISTANCE,
	POISON_RESISTANCE,
	SHOCK_RESISTANCE,
	HOLY_RESISTANCE,
	SHADOW_RESISTANCE,
	TENACITY,
	//Resistance penetration
	ARMOR_PENETRATION,
	MAGIC_PENETRATION,
	//Damage stats
	ATTACK_POWER,
	SPELL_POWER,
	//Resource regen
	HEALTH_REGEN,
	MANA_REGEN,
	STAMINA_REGEN,
	RUNE_REGEN,
	//Difficulty modifiers
	PERCENT_DAMAGE_TAKEN,
	PERCENT_DAMAGE_DEALT,
	PERCENT_HEALING_TAKEN,
	PERCENT_HEALING_GIVEN,;

	public static AttributeType GetAttribute(Integer pop) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
