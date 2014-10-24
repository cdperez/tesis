package preconditions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import terms.LogicalAtom;
import terms.Term;
import terms.Variable;

public class SimplePrecondition extends AtomicPrecondition {

	protected Iterator<LogicalAtom> candidates;
	protected Collection<Variable> toInfer;

	public SimplePrecondition(LogicalAtom logicalAtom) {
		super(logicalAtom);
		this.candidates=null;
		this.toInfer=new LinkedList<>();
	}
	
	public SimplePrecondition(String name, Term... terms){
		super(name, terms);
		this.candidates=null;
		this.toInfer=new LinkedList<>();
	}
	
	public SimplePrecondition(SimplePrecondition clone){
		super(clone);
		this.candidates=null;
		this.toInfer=new LinkedList<>();
	}
	
	public SimplePrecondition(String name, String... terms){
		this(LogicalAtom.asLogicalAtom(name, terms));
	}

	@Override
	public SimplePrecondition clone() {
		return new SimplePrecondition(this);
	}

	public boolean isTrue() {
		
		if (candidates == null){
			toInfer = logicalAtom.uninstanteatedVars();
			candidates = logicalAtom.getCandidates().iterator();
		}
		
		
		if (!candidates.hasNext()){
			this.reset();
			return false;
		}
		
		logicalAtom.bind(candidates.next());
		return true;
	}
	
	public void reset(){
		candidates = null;
		for (Variable v:toInfer)
			v.clear();
		toInfer = new LinkedList<>();
	}
	
	public void inferAll(){
		int count = 0;
		for (LogicalAtom la:logicalAtom.getCandidates()){
			count++;
			System.out.println(la.toString());
		}
		System.out.println("count: "+count);
	}
	
	@Override
	public String toString(){
		return logicalAtom.toString();
	}
}
