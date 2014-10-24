package main;


import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import tasks.Task;
import terms.Variable;

public class Domain {
	
	protected static String name = "";
	protected static Hashtable<String,List<Task>> tasks = new Hashtable<>();
	
	public static void put (Task task){
		String name = task.getName();
		
		if (!tasks.containsKey((name)))
			tasks.put(name, new LinkedList<Task>());

		tasks.get(name).add(task);
	}
	
	public static List<Task> get (String name){
		if (!tasks.containsKey(name)) return new LinkedList<Task>();
		return tasks.get(name);
	}
	
	public String toString(){
		String ret ="";
		
		for (String head:tasks.keySet())
			ret+=tasks.get(head)+"\n";
		
		return ret;
	}
	
	public static boolean invoke(String name, Variable... params) {
		if (!tasks.containsKey(name))
			return false;
		
		for (Task task:tasks.get(name))
			if (task.clone().invoke(params)) return true;
		
		return false;
	}

}
