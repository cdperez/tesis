package preconditions;

import tasks.Binder;
import terms.Constant;
import terms.Term;
import terms.Variable;

public class PreconditionSame extends RawPrecondition{
	/*
	 * Se usa para implementar los axiomas "Same"
	 */
	
	Variable a,b;

	public PreconditionSame(Variable a, Variable b){
		super();
		this.a=a;
		this.b=b;
	}
	
	public PreconditionSame(String a, String b){
		this(new Variable(a), new Variable(b));
	}
	
	public PreconditionSame(PreconditionSame clone){
		super();
		this.a=clone.a.clone();
		this.b=clone.b.clone();
	}
	
	public String getValue(Term t){
		return ((Constant)t.asConstant()).getValue();
	}

	@Override
	public PreconditionSame clone() {
		return new PreconditionSame(this);
	}

	@Override
	public String toString() {
		return "Same("+a.toString()+","+b.toString()+")";
	}

	@Override
	protected boolean logicalValue() {
		return getValue(a).equals(getValue(b));
	}
	
	@Override
	public void bind(Binder binder) {
		a = binder.getBind(a);
		b = binder.getBind(b);
	}

	@Override
	public String toStringHashcodes() {
		return "PreconditionSameOrDiff ("+a+"="+System.identityHashCode(a)+", "+b+"="+System.identityHashCode(b)+")";
	}
}
