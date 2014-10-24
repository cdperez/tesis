package terms;

public class EmptyValue extends Term{

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Term clone() {
		return new EmptyValue();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "EmptyValue";
	}
	
	public boolean isCandidateOf(Term term){
		return true;
	}

}
