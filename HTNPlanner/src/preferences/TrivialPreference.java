package preferences;

import java.util.Comparator;

import terms.Term;

public class TrivialPreference implements Comparator<Term>{

	@Override
	public int compare(Term t1, Term t2) {
		return new Integer(t1.getBenefit()).compareTo(new Integer(t2.getBenefit()));
	}
}
