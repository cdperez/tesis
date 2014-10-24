package terms;

public class NilTerm extends Term{

	public NilTerm(){};
	
	@Override
	public boolean equals(Object term) {
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Term clone() {
		return new NilTerm();
	}
	
	@Override
	public String toString() {
		return "NillTerm";
	}

}
