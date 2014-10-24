package tasks;

import main.Domain;
import terms.Variable;

public class TaskInvoker {
	
	protected String name;
	protected Variable[] params;
	
	public TaskInvoker(String name,Variable... params){
		this.name=name;
		this.params=params;
	}
	
	public TaskInvoker(String name,String... params){
		this.name=name;
		this.params=new Variable[params.length];
		for (int i=0;i<params.length;i++){
			this.params[i]=new Variable(params[i]);
		}
	}
	
	public TaskInvoker(TaskInvoker clone){
		this.name=clone.name;
		this.params=new Variable[clone.params.length];
		for (int i=0;i<params.length;i++){
			params[i]=clone.params[i].clone();
		}
	}
	
	public boolean invoke(){
		return Domain.invoke(name,params);
	}

	public Object getName() {
		return name;
	}

	public Variable[] getParams() {
		return params;
	}

	public void bind(Binder binder) {
		for (int i=0;i<params.length;i++){
			params[i] = binder.getBind(params[i]);
			params[i].bind(binder);
		}
	}
	
	public TaskInvoker clone(){
		return new TaskInvoker(this);
	}
	
	public String toString(){
		String ret = "taskInvoker "+name+" {";
		for (Variable var:params)
			ret+=var.toString()+", ";
		return ret.substring(0,ret.length()-2)+"}";
	}
	
	public String toStringHashcodes(){
		String ret = "taskInvoker "+name+" {";
		for (Variable var:params)
			ret+=var.getID()+"="+System.identityHashCode(var)+", ";
		return ret.substring(0,ret.length()-2)+"}";
	}

}
