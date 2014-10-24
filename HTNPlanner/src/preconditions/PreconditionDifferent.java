package preconditions;

import terms.Variable;

public class PreconditionDifferent extends PreconditionSame{
	/*
	 * Se usa para los axiomas "Different"
	 */

	public PreconditionDifferent(Variable a, Variable b) {
		super(a, b);
	}
	
	public PreconditionDifferent(String a, String b){
		super(a,b);
	}
	
	@Override
	public String toString() {
		return "Different("+a.toString()+","+b.toString()+")";
	}
	
	@Override
	public PreconditionDifferent clone() {
		return new PreconditionDifferent(a.clone(),b.clone());
	}

	@Override
	protected boolean logicalValue() {
		return !super.logicalValue();
	}
	
	

}
