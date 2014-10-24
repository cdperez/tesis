package tasks;

import java.util.LinkedList;
import java.util.List;

import terms.Variable;

public class Method extends Task{
	
	List<TaskInvoker> tasks;

	public Method(String name, Variable... params) {
		super(name, params);
		tasks = new LinkedList<>();
	}
	
	public Method(String name, String... params) {
		super(name, params);
		tasks = new LinkedList<>();
	}
	
	public Method(Method clone){
		super(clone);
		tasks = new LinkedList<>();
		for (TaskInvoker task:clone.tasks)
			addTask(task.clone());
	}
	
	public void addTask(TaskInvoker task){
		task.bind(binder);
		tasks.add(task);
	}
	
	public void addTask(String name, String... terms){
		this.addTask(new TaskInvoker(name,terms));
	}
	
	public void addTask(String name, Variable... terms){
		this.addTask(new TaskInvoker(name,terms));
	}

	@Override
	public boolean execute() {
		//TODO
		System.out.println(this);
		
		for (TaskInvoker task:tasks)
			if (!task.invoke()) return false;
		
		return true;
	}

	@Override
	public Task clone() {
		return new Method(this);
	}

}
