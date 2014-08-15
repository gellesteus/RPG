package com.gellesteus.rpg.resource.script;

import java.util.EnumSet;

public enum ScriptFunctions{
	INST_GETAV(0X01,false),
	INST_SETAV(0X02,false),
	INST_MODAV(0X03,false),
	INST_LITERAL(0X04,true),
	INST_GETTARGET(0X05,false),
	INST_GETCASTER(0X06,false),
	INST_ADDITEM(0X07,false),
	INST_GETITEMCOUNT(0X08,false),
	INST_PLAYSOUND(0X09,false),
	INST_SPAWNPARTICLE(0X0A,false),
	INST_GETDISTANCE(0X0B,false),
	INST_ADD(0X0C,false),
	INST_SUBTRACT(0X0D,false),
	INST_MULTIPLY(0X0E,false),
	INST_DIVIDE(0X0F,false),
	INST_EXPONENT(0X10,false),
	INST_GETEQUIPPEDITEM(0X11,false),
	INST_GETITEMATTRIBUTE(0X28,false),
	INST_DAMAGE(0X13,false),
	INST_HEAL(0X14,false),
	INST_PAY(0X15,false),
	INST_APPLYEFFECT(0X16,false),
	INST_KILL(0X17,false),
	INST_CHARGE(0X19,false),
	INST_TELEPORT(0X1A,false),
	INST_GETX(0X1B,false),
	INST_GETY(0X1C,false),
	INST_HASABILITY(0X1D,false),
	INST_ISFACING(0X1E,false),
	INST_CANSEE(0X1F,false),
	INST_PLAYANIM(0X20,false),
	INST_ISCRIT(0X21,false),
	INST_DISPEL(0X22,false),
	INST_VARASSIGN(0X23,true),
	INST_VARRETREIVE(0X24,true),
	INST_IF(0X25,true),
	TAG_IFCONDEND(0X26,true),
	TAG_IFBLOCK1END(0X27,true),
	TAG_IFBLOCK2END(0X28,true),
	INST_DO(0X29,true),
	TAG_DOCONDEND(0X2A,true),
	TAG_DOLOOPEND(0X2B,true),
	INST_SENDEVENT(0X2C,true),
	INST_AND(0X2D,false),
	INST_OR(0X2E,false),
	INST_XOR(0X2F,false),
	INST_NOT(0X30,false),
	INST_ADDABILITY(0X31,false),
	INST_REMOVEABILITY(0x32,false),
	INST_ISITEMEQUIPPED(0X33,false),
	INST_ISHOSTILE(0x34,false),
	INST_ISSELFCAST(0X35,false),
	INST_SETITEMATTR(0X36,false),
	INST_EQUALS(0X37,false),
	INST_GREATERTHAN(0X38,false),
	INST_LESSTHAN(0X39,false),
	INST_GREATERTHANEQUAL(0X3A,false),
	INST_LESSTHANEQUAL(0X3B,false),
	INST_NOTEQUAL(0X3C,false),
	INST_MODIFYCD(0X3D,false),
	INST_MODIFYGCD(0XEC,false),
	INST_SPAWNPROJECTILE(0X3F,false);
	
	private boolean valueFollows;
	private int value;

	int getValue(){return value;}
	boolean valueFollows(){return valueFollows;}
	
	ScriptFunctions(int reference, boolean valF){
		value = reference;
		valueFollows=valF;
	}
	
	static ScriptFunctions GetFunction(int reference){
		for(ScriptFunctions i : EnumSet.allOf(ScriptFunctions.class)){
			if(i.getValue()==reference){
				return i;
			}
		}
		return null;
	}
}