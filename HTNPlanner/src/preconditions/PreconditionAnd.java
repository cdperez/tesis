package preconditions;

import tasks.Binder;

public class PreconditionAnd extends LogicalPrecondition{

	LogicalPrecondition[] preconditions;
	int iterator = 0;
	
	public PreconditionAnd (LogicalPrecondition... preconditions){
		this.preconditions=preconditions;
	}
	
	public PreconditionAnd (PreconditionAnd clone){
		preconditions = new LogicalPrecondition[clone.preconditions.length];
		for (int j=0;j<preconditions.length;j++)
			preconditions[j] = clone.preconditions[j].clone();
	}
	
	@Override
	public boolean isTrue() {
		if (iterator<0) return false;
		if (iterator>=preconditions.length){
			iterator = preconditions.length-1;
			return true;
		}
		
		if (preconditions[iterator].isTrue())
			iterator++;
		else
			iterator--;
		
		return this.isTrue();
	}

	@Override
	public PreconditionAnd clone() {
		return new PreconditionAnd(this);
	}

	@Override
	public String toString() {
		String ret = "PreconditionAnd:\n";
		for (LogicalPrecondition precondition:preconditions)
			ret+=precondition.toString()+"\n";
		return ret;
	}
	
	@Override
	public void bind(Binder binder) {
		for (LogicalPrecondition precondition:preconditions)
			precondition.bind(binder);
	}

	@Override
	public String toStringHashcodes() {
		String ret="";
		
		for (LogicalPrecondition prec:preconditions){
			ret+=prec.toStringHashcodes()+", ";
		}
		
		return ret.substring(0,ret.length()-1);
	}
}
