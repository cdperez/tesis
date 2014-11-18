package preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import terms.LogicalAtom;
import terms.Term;

public class PreferencesManager {

	protected List<LogicalAtom> sortedCandidates;
	protected Comparator<Term> preference;	
	
	public PreferencesManager(){
		sortedCandidates = new ArrayList<LogicalAtom>();
		preference = new TrivialPreference();
	}
	
	public List<LogicalAtom> sort(List<LogicalAtom> candidates){
		Collections.sort(candidates,preference);
		return candidates;
	}
	
}
