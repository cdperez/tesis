package main;

import java.util.LinkedList;

import tasks.Operator;

public class Plan {
	
	protected static LinkedList<Operator> plan = new LinkedList<>();
	
	public static void add(Operator operator){
		plan.add(operator);
	}
	
	public static String toStringg(){
		String ret="";
		int i=1;
		for (Operator operator:plan){
			ret+="["+i++ +"] "+operator.toString()+"\n";
		}
		return ret;
	}

}
