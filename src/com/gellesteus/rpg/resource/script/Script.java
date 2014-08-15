package com.gellesteus.rpg.resource.script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.gellesteus.rpg.data.attribute.AttributeType;
import com.gellesteus.rpg.entity.Character;
import com.gellesteus.rpg.resource.Resource;

public class Script extends Resource {
	private ArrayList<Integer> bytestream = new ArrayList<Integer>();
	private HashMap<Integer,Integer> scriptVars = new HashMap<Integer,Integer>();
	
	private static class Job{
		Script script;
		Character target;
		Character caster;
		
		Job(Script script,Character target,Character caster){
			this.script=script;
			this.target=target;
			this.caster=caster;
		}
	}
	
	
	public void run( Character target, Character caster) throws IOException, ScriptRuntimeException{
		Job job = new Job(this,target,caster);
		//TODO: put these in a queue
		parse(job);
		execute(job,0,bytestream.size());
		
	}
	
	public static void Update(){
		
	}
	
	private void parse(Job job) throws IOException{
		FileReader filereader = new FileReader(job.script.toFile());
		BufferedReader buffer = new BufferedReader(filereader);
		
		String temp = buffer.readLine();
		
		while(temp !=null){
			for(String i:temp.split("//s")){
				bytestream.add(new Integer(Integer.valueOf(i)));
			}
			temp=buffer.readLine();
		}
		buffer.close();
		//Execute loaded instructions
		
	}
	
	private boolean evaluate(Job job,int start,int end){
		Stack<Integer> returnVals = new Stack<Integer>();
		return returnVals.pop()==1;
	}
	
	private void execute(Job job,int start, int end) throws ScriptRuntimeException{
		Stack<Integer> returnVals = new Stack<Integer>();
		
		for(int i = start;i<=end;i++){
			switch(ScriptFunctions.GetFunction(bytestream.get(i))){
				//TODO: write all this crap
				case INST_GETAV:
				{
					Character affected = job.caster;
					AttributeType attEffected = AttributeType.GetAttribute(returnVals.pop());
					returnVals.push(affected.getAV(attEffected));
					break;
				}
				case INST_SETAV:
				{
					Character affected = job.caster;
					AttributeType attEffected = AttributeType.GetAttribute(returnVals.pop());
					int amount = returnVals.pop();
					affected.setAV(attEffected, amount);
					break;
				}
				case INST_MODAV:
				{
					Character affected = job.caster;
					AttributeType attEffected = AttributeType.GetAttribute(returnVals.pop());
					int amount = returnVals.pop();
					affected.modAV(attEffected, amount);
					break;
				}
				case INST_GETTARGET:
					break;	
				case INST_GETCASTER:
					break;
				case INST_ADDITEM:
					break;
				case INST_GETITEMCOUNT:
					break;
				case INST_PLAYSOUND:
					break;
				case INST_SPAWNPARTICLE:
					break;
				case INST_GETDISTANCE:
					break;
				case INST_GETEQUIPPEDITEM:
					break;
				case INST_GETITEMATTRIBUTE:
					break;
				case INST_DAMAGE:
					break;
				case INST_HEAL:
					break;
				case INST_PAY:
					break;
				case INST_APPLYEFFECT:
					break;
				case INST_KILL:
					break;
				case INST_CHARGE:
					break;
				case INST_TELEPORT:
					break;
				case INST_GETX:
					break;
				case INST_GETY:
					break;
				case INST_HASABILITY:
					break;
				case INST_ISFACING:
					break;
				case INST_CANSEE:
					break;
				case INST_PLAYANIM:
					break;
				case INST_ISCRIT:
					break;
				case INST_DISPEL:
					break;
				case INST_LITERAL:
					returnVals.push(bytestream.get(i+1));
					break;
				case INST_ADD:
					returnVals.push(returnVals.pop()+returnVals.pop());
					break;
				case INST_SUBTRACT:
					returnVals.push(returnVals.pop()-returnVals.pop());
					break;
				case INST_MULTIPLY:
					returnVals.push(returnVals.pop()*returnVals.pop());
					break;
				case INST_DIVIDE:
					returnVals.push(returnVals.pop()/returnVals.pop());
					break;
				case INST_EXPONENT:
					returnVals.push((int)(Math.pow(returnVals.pop(), returnVals.pop())));
					break;
				case INST_VARASSIGN:
					{
						int varKey = bytestream.get(i+1);
						int varValue = returnVals.pop();

						scriptVars.put(varKey, varValue);
					}
					break;
				case INST_VARRETREIVE:
					returnVals.push(scriptVars.get(bytestream.get(i+1)));
					break;
				case INST_NOT:
					{
						int j = returnVals.pop();
						if(j==0){
							returnVals.push(1);
						}else{
							returnVals.push(0);
						}
						break;
					}
				case INST_AND:
					{
						int cond1 = returnVals.pop();
						int cond2 = returnVals.pop();
						
						if(cond1 != 0 && cond2 != 0){
							returnVals.push(1);
						}else if(cond1 == 0 && cond2 == 0){
							returnVals.push(1);
						}else{
							returnVals.push(0);
						}
						break;
					}
				case INST_OR:
				{
					int cond1 = returnVals.pop();
					int cond2 = returnVals.pop();
					
					if(cond1 !=0 || cond2 != 0){
						returnVals.push(1);
					}else{
						returnVals.push(0);
					}
					break;
				}
				case INST_XOR:
					{
						int cond1=returnVals.pop();
						int cond2 = returnVals.pop();
						
						if(cond1 == 0 && cond2 != 0){
							returnVals.push(1);
						}else if (cond1!= 0 && cond2 == 0){
							returnVals.push(1);
						}else{
							returnVals.push(0);
						}
					}
				case INST_IF:
					{
						int ifId = bytestream.get(i+1);
						int ifStart = i;
						int condEnd=i;
						int b1End=i;
						int b2End=i;
						for(int j = ifStart;j<=end;j++){
							if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.TAG_IFCONDEND&&bytestream.get(j+1)==ifId){
								condEnd = j;
							}else if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.TAG_IFBLOCK1END&&bytestream.get(j+1)==ifId){
								b1End=j;
							}else if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.TAG_IFBLOCK2END&&bytestream.get(j+1)==ifId){
								b2End=j;
								break;
							}
							if(ScriptFunctions.GetFunction((bytestream.get(j))).valueFollows())
								j++;
						}
						if(evaluate(job,ifStart,condEnd)){
							execute(job,condEnd,b1End);
						}else{
							execute(job,b1End,b2End);
						}
						
						i=b2End+2;
					}
				case INST_DO:
				{
					int doId = bytestream.get(i+1);
					int doStart = i+2;
					int loopStart=i+2;
					int loopEnd=i+2;
					for(int j = doStart;j<=end;j++){
						if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.INST_LITERAL){
							j++;
						}else if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.TAG_DOCONDEND&&bytestream.get(j+1)==doId){
							loopStart = j;
						}else if(ScriptFunctions.GetFunction((bytestream.get(j)))==ScriptFunctions.TAG_DOLOOPEND&&bytestream.get(j+1)==doId){
							loopEnd=j;
							break;
						}
						if(ScriptFunctions.GetFunction((bytestream.get(j))).valueFollows())
							j++;
					}
					while(evaluate(job,doStart,loopStart)){
						execute(job,loopStart,loopEnd);
					}

					i=loopEnd+2;
				}
				case TAG_IFCONDEND:			//ignore all tags. These should never be reached in script under normal circumstances
					break;
				case TAG_IFBLOCK1END:
					break;
				case TAG_IFBLOCK2END:
					break;
				case TAG_DOCONDEND:
					break;
				case TAG_DOLOOPEND:
					break;
				default:
					throw(new ScriptRuntimeException("Function not found in " + job.script.toFile().getName() + " at function "+Integer.toString(i)));
			}
			if(ScriptFunctions.GetFunction((bytestream.get(i))).valueFollows())
				i++;
		}
	}

	@Override
	protected File toFile() {
		//TODO: figure out filepath from archives
		return null;
	}
}