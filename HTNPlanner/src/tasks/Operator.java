package tasks;

import java.util.LinkedList;
import java.util.List;

import main.Plan;
import terms.LogicalAtom;
import terms.Term;
import terms.Variable;

public class Operator extends Task{
	
	protected List<Term> delList,addList;

	public Operator(String name,Variable... params) {
		super(name,params);
		delList = new LinkedList<>();
		addList = new LinkedList<>();
	}
	
	public Operator(String name,String... params) {
		super(name,params);
		delList = new LinkedList<>();
		addList = new LinkedList<>();
	}
	
	public Operator(Operator clone){
		super(clone);
		delList = new LinkedList<>();
		addList = new LinkedList<>();
		for (Term la:clone.delList) addToDelList(la.clone());
		for (Term la:clone.addList) addToAddList(la.clone());
	}

	@Override
	public boolean execute() {
		//TODO
		System.out.println(this);
		
		for (Term la:delList) la.delFromWorld();
		for (Term la:addList) la.addToWorld();
		
		if (!this.name.contains("protection"))
			Plan.add(this);
		
		return true;
	}
	
	public void addToAddList(Term la){
		if (la instanceof Variable)
			la = binder.getBind((Variable)la);
		if (la instanceof LogicalAtom)
			la.bind(binder);
		
		addList.add(la);
	}
	
	public void addToDelList(Term la){
		if (la instanceof Variable)
			la = binder.getBind((Variable)la);
		if (la instanceof LogicalAtom)
			la.bind(binder);
		
		delList.add(la);
	}

	public void addToAddList(String v) {
		addToAddList(new Variable(v));	
	}
	
	public void addToDelList(String v) {
		addToDelList(new Variable(v));	
	}
	
	@Override
	public Task clone() {
		return new Operator(this);
	}

}
