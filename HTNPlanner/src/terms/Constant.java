package terms;


public class Constant extends Term{

	protected String value;
	
	public Constant(String value){
		this.value=value.toLowerCase();
	}
	
	public Constant(Constant clone){
		this.value=clone.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Constant))
			return false;
		Constant other = (Constant) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public Constant clone() {
		return new Constant(this);
	}

	@Override
	public String toString() {
		return value;
	}
	
	public String getValue(){
		return value;
	}

	@Override
	public boolean isCandidateOf(Term term) {
		if (!(term instanceof Constant)) return false;
		
		return this.value.equals(((Constant) term).value);
	}
}
