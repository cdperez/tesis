package tasks;

import java.util.Hashtable;

import terms.Variable;

public class Binder {
	
	protected Hashtable<String,Variable> symbolTable;
	
	public Binder(){
		symbolTable = new Hashtable<String,Variable>();
	}

	public Variable getBind(Variable var){
		if (symbolTable.containsKey(var.getID()))
			return symbolTable.get(var.getID());
		
		symbolTable.put(var.getID(), var);
		return var;
	}

	public void instantiate(Variable var) {
		if (!symbolTable.containsKey(var.getID())) return;
		
		symbolTable.get(var.getID()).bind(var.getValue());
	}
	
	public void instantiate(Variable...variables){
		for (Variable var:variables) instantiate(var);
	}
	
	public String toString(){
		return symbolTable.toString();
	}
	
	public String toStringHashcodes(){
		String ret = "{";
		for (Variable var:symbolTable.values())
			ret+=var.getID()+"="+System.identityHashCode(var)+", ";
		return ret.substring(0,ret.length()-2)+"}";
	}
}
