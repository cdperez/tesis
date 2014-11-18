package terms;

import java.util.Collection;
import java.util.Hashtable;

import tasks.Binder;

public class Variable extends Term{
	
	protected String id;
	protected Term value;
	
	public Variable(String id){
		this.id=id;
		this.value = new EmptyValue();
	}
	
	public Variable (String id, String value){
		this.id=id;
		this.value = new Constant(value);
	}
	
	public Variable(Variable clone){
		this.id=clone.id;
		value = clone.getValue().clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public Variable clone() {
		return new Variable(this);
	}
	
	@Override
	public String toString() {
		return id+"="+value.toString();
	}
	
	public String getID(){
		return id;
	}
	
	public void addTo(Hashtable<String, Integer> variables, int i) {
		variables.put(id, i);
	}
	
	public Term getValue(){
		return value;
	}
	
	public void bind(Term term) {
		this.value = term;
	}
	
	public void bind(Variable v){
		this.value=v.value;
	}
	
	public void bind(String string){
		this.value=new Constant(string);
	}

	@Override
	public boolean isCandidateOf(Term term) {
		return this.value.isCandidateOf(term);
	}
	
	public void clear(){
		this.value=new EmptyValue();
	}
	
	public Term asConstant() {
		return value;
	}
	
	public void addIfUninstanteated(Collection<Variable> c) {
		if (value instanceof EmptyValue)
			c.add(this);
	}
	
	@Override
	public void addToWorld() {
		value.addToWorld();
	}

	@Override
	public void delFromWorld() {
		value.delFromWorld();
	}

	public void bind(Binder binder) {
		value.bind(binder);
	}
	
	public int getBenefit(){
		//TODO ver
		return value.getBenefit();
	}
}
