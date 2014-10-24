package terms;

import java.util.Collection;
import java.util.Hashtable;

import tasks.Binder;

public abstract class Term {
	
	public abstract boolean equals (Object obj);
	
	public void addToWorld(){};
	
	public void delFromWorld(){};
	
	public abstract int hashCode();
	
	public abstract Term clone();

	public abstract String toString();

	public void addTo(Hashtable<String, Integer> variables, int i) {}

	public void bind(Term term) {}
	
	//public void bind(Binder binder){};
	
	public boolean isCandidateOf(Term term){
		throw new UnsupportedOperationException();
	}

	public Term asConstant() {
		return this;
	}

	public void addIfUninstanteated(Collection<Variable> c) {}

	public void bind(Binder binder) {}
	
	
}
