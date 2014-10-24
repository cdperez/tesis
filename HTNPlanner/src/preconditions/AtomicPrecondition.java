package preconditions;

import tasks.Binder;
import terms.LogicalAtom;
import terms.Term;

public class AtomicPrecondition extends LogicalPrecondition{

	protected LogicalAtom logicalAtom;

	public AtomicPrecondition(LogicalAtom logicalAtom) {
		super();
		this.logicalAtom=logicalAtom;
	}
	
	public AtomicPrecondition(String name, Term... terms){
		super();
		this.logicalAtom = LogicalAtom.asLogicalAtom(name, terms);
	}
	
	public AtomicPrecondition(AtomicPrecondition clone){
		super();
		this.logicalAtom=clone.logicalAtom.clone();
	}

	public boolean isTrue() {
		return logicalAtom.isTrue();
	}

	@Override
	public AtomicPrecondition clone() {
		return new AtomicPrecondition(this);
	}

	@Override
	public String toString() {
		return logicalAtom.toString();
	}
	
	@Override
	public void bind(Binder binder) {
		logicalAtom.bind(binder);
	}

	@Override
	public String toStringHashcodes() {
		return logicalAtom.toStringHashcodes();
	}
}
