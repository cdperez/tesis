package main;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import tasks.TaskInvoker;
import terms.LogicalAtom;
import terms.Term;

import com.google.common.collect.HashMultimap;


public class Problem {
	
	protected static String name = "";
	//protected static HashMap<String, HashSet<LogicalAtom>> state = new HashMap<String, HashSet<LogicalAtom>>();
	protected static HashMultimap<String,LogicalAtom> state = HashMultimap.create();
	protected static List<TaskInvoker> goals = new LinkedList<>();
	
	protected static HashMap<LogicalAtom,Integer> protections = new HashMap<>();
	
	public static void addState(LogicalAtom atom){
		LogicalAtom la = atom.asConstant();
		state.put(la.getName(), la);
		protections.put(la, 0);
	}
	
	public static void delState(LogicalAtom atom){
		LogicalAtom la = atom.asConstant();
		
		if (!isProtected(la))
			state.remove(la.getName(), la);
	}
	
	public static void addState(String name, Term... terms){
		Problem.addState(LogicalAtom.asLogicalAtom(name, terms));
	}
	
	public static void delState(String name, Term... terms){
		Problem.delState(LogicalAtom.asLogicalAtom(name, terms));
	} 
	
	public static void addProtection(LogicalAtom atom){
		LogicalAtom la = atom.asConstant();
		
		if (!protections.containsKey(la))
			protections.put(la, 0);
		
		protections.put(la, protections.get(la)+1);
	}
	
	public static void delProtection(LogicalAtom atom){
		LogicalAtom la = atom.asConstant();
		if (!isProtected(la)) return;
		
		protections.put(la, protections.get(la)-1);
	}
	
	public static void addProtection(String name, Term... terms){
		Problem.addProtection(LogicalAtom.asLogicalAtom(name, terms));
	}
	
	public static void delProtection(String name, Term... terms){
		Problem.delProtection(LogicalAtom.asLogicalAtom(name, terms));
	}
	
	private static boolean isProtected(LogicalAtom la){
		if (!protections.containsKey(la)) return false;
		if (protections.get(la) <= 0) return false;
		
		return true;
	}
	
	public static boolean isTrue(LogicalAtom la){
		return state.containsEntry(la.getName(), la.asConstant());
	}
	
	public static LinkedList<LogicalAtom> getCandidates(LogicalAtom la){
		LinkedList<LogicalAtom> result = new LinkedList<>();
		
		if (!state.containsKey(la.getName())) return result;
		
		for (LogicalAtom _la:state.get(la.getName()))
			if (la.isCandidateOf(_la)) result.add(_la);
				
		return result;
	}
	
	public static void addGoal(TaskInvoker task){
		//goals.add(task);
	}
	
	public static void setName(String name){
		Problem.name=name;
	}

	public static String debug() {
		String debug="Problem "+name+"\n";
		
		debug+="State: \n";
		for (String key:state.keySet()){
			//debug+="\n"+key+": ";
			for (LogicalAtom la:state.get(key)){
				debug+=la.toString()+"\n";
			}
		}
		
		debug+="\n Goal: \n";
		for (TaskInvoker task:goals)
			debug+=task.toString()+"\n";
		
		return debug;
	}

	public static int getCount(String string) {
		if (!state.containsKey(string)) return 0;
		return state.get(string).size();
	}

}
