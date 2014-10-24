package preconditions;

import tasks.Binder;

public abstract class LogicalPrecondition {
	
	protected String name;	
	private static int id=1;
	
	public LogicalPrecondition(){
		name = "precondition "+id++;
	}
	
	public abstract boolean isTrue();
	
	public abstract LogicalPrecondition clone();
	
	@Override
	public abstract String toString();

	public void bind(Binder binder) {}
	
	public abstract String toStringHashcodes();
}
