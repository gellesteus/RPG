package com.gellesteus.rpg.resource.mod;

import java.io.File;
import java.util.ArrayList;

import com.gellesteus.rpg.ai.Routine;
import com.gellesteus.rpg.data.ability.Ability;
import com.gellesteus.rpg.data.item.Armor;
import com.gellesteus.rpg.data.item.Consumable;
import com.gellesteus.rpg.data.item.Leveled;
import com.gellesteus.rpg.data.item.Misc;
import com.gellesteus.rpg.data.item.Weapon;
import com.gellesteus.rpg.data.perk.Perk;
import com.gellesteus.rpg.entity.Monster;
import com.gellesteus.rpg.entity.Person;
import com.gellesteus.rpg.resource.model.Model;
import com.gellesteus.rpg.resource.script.Script;
import com.gellesteus.rpg.resource.sound.Sound;
import com.gellesteus.rpg.resource.texture.Texture;
import com.gellesteus.rpg.scene.Scene;
import com.thoughtworks.xstream.XStream;

public class Mod {
/* A mod is a collection of models, textures, sounds, scripts, abilties, characters, items and other game data
 * packaged together for quick storage and distribution
 * All game data is loaded out of mod files, with Main.mod being loaded first, and subsequent loadings overwriting it.
 * Mods are given a priority based on when they should be loaded. Lower priorities are loaded earlier
 * Priority 0 should contain content that is independent of all else, such as Main.mod
 * Priority between 1 and 50 should rely on content loaded earlier but either not overwrite it(lower priority)
 * or overwrite little(higher priority).
 * priorities above 50 are used for overwriting content specifically, such as bug fixes, rebalancess or patched.
 * Official patched will have priority 50, increasing by 1 if a patch supersedes a previous patch.
 * A mod that changes content of another mod will have dependency upon it, as indicated in the dependency tags of
 * manifest.
 * 
 * When 2 mods load content with the same name and type, the mod with the higher priority will have their version loaded
 *
 * Types that can be loaded into a mod and the file or folder they go in:
 *
 * TYPE					FOLDER/FILE
 * 
 * mod manifest			manifest.xml		MUST BE PRESENT, OR MOD WILL NOT LOAD
 * 
 * Models				res/model
 * textures				res/texture
 * sound				res/sounds
 * script				res/script
 * ability				data/ability.xml
 * monster				data/monster.xml
 * person				data/NPC.xml
 * scenes				data/scene.xml
 * AI routines			data/AIRoutine.xml
 * consumable			data/consumable.xml
 * armor				data/armor.xml
 * weapon				data/weapon.xml
 * other items			data/miscitem.xml
 * leveled items		data/leveledItems.xml
 * perks				data/perks.xml
 * base classes			data/BaseClass.xml
 * specializations		data/SpecClass.xml
 * dialog				data/dialog.xml
 * condition			data/condition.xml
 * race					data/race.xml
 * attribute			data/attribute.xml
 * 
 * A mod does not need to contain all(or any) of these. All that is requires is a modManifest.xml
 */
	
	private File filePath;
	private String name;
	private String description;
	private String version;
	private String author;
	private int priority;
	private ArrayList<Mod> dependencies = new ArrayList<Mod>();
	
	private boolean ignore;
	
	private static XStream xstream = new XStream();
	
	static{
		xstream.alias("Mod", Mod.class);
		xstream.alias("Monster",Monster.class);
		xstream.alias("NPC",Person.class);
		xstream.alias("Scene",Scene.class);
		xstream.alias("AIRoutine", Routine.class);
		xstream.alias("Consumable",Consumable.class);
		xstream.alias("Armor",Armor.class);
		xstream.alias("Weapon", Weapon.class);
		xstream.alias("MiscItem",Misc.class);
		xstream.alias("LeveledItem",Leveled.class);
		xstream.alias("Perk",Perk.class);
	}
	
	public Mod(File filePath){
		this.filePath=filePath;
	}
	
	public void loadAll(){
		
	}
	
	public ArrayList<Model> loadModels(){
		return null;
	}
	
	public ArrayList<Sound> loadSound(){
		return null;
	}
	
	public ArrayList<Texture> loadTextures(){
		return null;
	}
	
	public ArrayList<Script> loadScript(){
		return null;
	}
	
	public ArrayList<Ability> loadAbility(){
		return null;
	}
	
	public ArrayList<Monster> loadMonster(){
		return null;
	}
	
	public ArrayList<Person> loadNPCs(){
		return null;
	}

	public ArrayList<Scene> loadScenes(){
		return null;
	}

	public ArrayList<Routine> loadRoutines(){
		return null;
	}
}
