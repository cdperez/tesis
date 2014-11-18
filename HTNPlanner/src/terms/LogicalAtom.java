package terms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import main.Problem;
import tasks.Binder;

public class LogicalAtom extends Term implements Iterable<Term>{
	
	protected String name;
	protected List<Term> terms;
	
	public LogicalAtom(String name){
		this.name = name.toLowerCase();
		terms = new LinkedList<Term>();
	}
	
	public LogicalAtom(LogicalAtom clone){
		this.name=clone.name;
		terms = new LinkedList<Term>();
		for (Term term:clone.terms)
			terms.add(term.clone());
	}

	@Override
	public void addToWorld() {
		Problem.addState(this);
	}
	
	public void delFromWorld() {
		Problem.delState(this);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		for (Term term:terms)
			result = prime * result + ((term == null) ? 0 : term.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LogicalAtom))
			return false;
		LogicalAtom other = (LogicalAtom) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (terms == null)
			if (other.terms != null)
				return false;
		
		for (int i=0;i<terms.size();i++)
			if (!(terms.get(i).equals(other.terms.get(i)))) return false;
		
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isTrue(){
		return Problem.isTrue(this);
	}
	
	public Collection<LogicalAtom> getCandidates(){
		return Problem.getCandidates(this);
	}

	public boolean isCandidateOf(Term term) {
		/*
		 * _la deberia ser siempre un predicado del estado,
		 * con todos sus terminos instanciados.
		 */
		
		if (!(term instanceof LogicalAtom)) return false;
		
		LogicalAtom other = (LogicalAtom) term;
		
		if (!this.getName().equals(other.getName())) return false;
		if (!(this.terms.size() == other.terms.size())) return false;
		
		for (int i=0;i<terms.size();i++)
			if (!terms.get(i).isCandidateOf(other.terms.get(i))) return false;
		
		return true;
	}

	@Override
	public LogicalAtom clone() {
		return new LogicalAtom(this);
	}

	public void addTerm(Term term) {
		terms.add(term);
	}
	
	public String toString(){
		String debug = "("+name+" ";
		for (Term term:terms)
			debug+=term.toString()+" ";
		return debug.substring(0, debug.length()-1)+")";
	}
	
	public String toStringHashcodes(){
		String debug = "("+name+" ";
		for (Term term:terms)
			debug+=term.toString()+"="+System.identityHashCode(term)+", ";
		return debug.substring(0, debug.length()-2)+")";
	}
	
	public Iterator<Term> iterator(){
		return terms.iterator();
	}
	
	public Term getTerm(int index){
		try{
			return terms.get(index);
		} catch (Exception e){
			e.printStackTrace();
			return new NilTerm();
		}
		
	}
	
	public int size(){
		return terms.size();
	}

	public Collection<Variable> getVariables() {
		Collection<Variable> variables = new LinkedList<>();
		for (Term term:terms)
			if (term instanceof Variable) variables.add((Variable) term);
		return variables;
	}

	public void bind(LogicalAtom other) {
		for (int i=0;i<terms.size();i++)
			terms.get(i).bind(other.getTerm(i));
	}

	public LogicalAtom asConstant() {
		LogicalAtom constant = new LogicalAtom(this.name);
		for (Term term:terms){
			constant.addTerm(term.asConstant());
		}
		
		return constant;
	}

	public Collection<Variable> uninstanteatedVars() {
		Collection<Variable> c = new LinkedList<>();
		for (Term term:terms)
			term.addIfUninstanteated(c);
		return c;
	}
	
	public static LogicalAtom asLogicalAtom(String name, Term... terms){
		LogicalAtom la=new LogicalAtom(name);
		la.terms=Arrays.asList(terms);
		return la;
	}
	
	public static LogicalAtom asLogicalAtom(String name, String... terms){
		LogicalAtom la=new LogicalAtom(name);
		for (String term:terms)
			la.addTerm(new Variable(term));
		return la;
	}
	
	public static ProtectionCondition asProtectionCondition(String name, Term... terms){
		return new ProtectionCondition(LogicalAtom.asLogicalAtom(name, terms)); 
	}
	
	public static ProtectionCondition asProtectionCondition(String name, String... terms){
		return new ProtectionCondition(LogicalAtom.asLogicalAtom(name, terms)); 
	}

	public void bind(Binder binder) {
		ListIterator<Term> it=terms.listIterator();
		while (it.hasNext()){
			Variable b = binder.getBind((Variable)it.next());
			it.set(b);
		}
	}
	
	public int getBenefit(){
		int acumBenefit=benefit;
		for (Term term:terms)
			acumBenefit+=term.getBenefit();
		return acumBenefit;
	}
	
}
