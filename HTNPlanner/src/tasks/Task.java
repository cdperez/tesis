package tasks;

import java.util.Arrays;

import preconditions.LogicalPrecondition;
import preconditions.NilPrecondition;
import terms.Variable;

public abstract class Task {
	
	protected String name;
	protected Variable[] params;
	protected LogicalPrecondition precondition = new NilPrecondition();
	protected Binder binder;
	
	public Task(String name,Variable... params){
		this.name=name;
		this.params=params;
		binder = new Binder();
		for (Variable var:params)
			var = binder.getBind(var);
	}
	
	public Task(String name,String... params){
		this.name=name;
		this.params=new Variable[params.length];
		for (int i=0;i<params.length;i++)
			this.params[i]=new Variable(params[i]);
		
		binder = new Binder();
		for (Variable var:this.params)
			var = binder.getBind(var);
	}
	
	public Task(Task clone){
		this.name=clone.name;
		
		this.params = new Variable[clone.params.length];
		for (int i=0;i<params.length;i++)
			params[i] = clone.params[i].clone();
		
		binder = new Binder();
		for (Variable var:params)
			var = binder.getBind(var);
		
		setPrecondition(clone.precondition.clone());
	}
	
	public void setPrecondition(LogicalPrecondition precondition){
		this.precondition=precondition;
		this.precondition.bind(binder);
	}
	
	
	public void instantiate(Variable... params){
		for (int i=0;i<params.length;i++)
			this.params[i].bind(params[i].getValue());
	}
	
	
	public boolean invoke(Variable... params){
		instantiate(params);
		
		if (!precondition.isTrue()) return false;
		
		return execute();
	}
	
	public abstract boolean execute();
	
	public abstract Task clone();

	public String getName() {
		return name;
	}
	
	public String toString(){
		return name + " " + Arrays.toString(params);
	}
	
	public String toStringHashcodes(){
		return name + " " + binder.toStringHashcodes();
	}
}
