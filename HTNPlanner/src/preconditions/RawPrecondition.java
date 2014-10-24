package preconditions;

public abstract class RawPrecondition extends LogicalPrecondition{

	boolean called = false;
	
	@Override
	public boolean isTrue(){
		if (called){
			called = false;
			return false;
		}
		
		called = true;
		return this.logicalValue();
	}

	protected abstract boolean logicalValue();
}
