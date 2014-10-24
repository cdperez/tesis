package preconditions;

public class NilPrecondition extends LogicalPrecondition{

	@Override
	public boolean isTrue() {
		return true;
	}

	@Override
	public NilPrecondition clone() {
		return new NilPrecondition();
	}

	@Override
	public String toString() {
		return "NilPrecondition";
	}

	@Override
	public String toStringHashcodes() {
		return "NilPrecondition";
	}

}
