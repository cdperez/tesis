package main;


import java.util.Collection;
import java.util.Hashtable;

import terms.Term;

public class SymbolTable {
	
	protected static Hashtable<String,Term> value = new Hashtable<String,Term>();
	protected static Hashtable<String,Collection<Term>> state = new Hashtable<String,Collection<Term>>();
	
	public static boolean contains(String id){
		return value.containsKey(id);
	}
	
	public static void putValue(String id, Term v){
		value.put(id,v);
	}
	
	public static Term getValue(String id){
		return value.get(id);
	}

}
