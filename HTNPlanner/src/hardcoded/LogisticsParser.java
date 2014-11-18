package hardcoded;

import java.util.ArrayList;

import terms.Term;
import antlr.Parser;
import antlr.generated.JSHOP2Parser.Compound_task_atomContext;
import antlr.generated.JSHOP2Parser.GoalsContext;

public class LogisticsParser extends Parser{

	@Override
	public void exitGoals(GoalsContext ctx) {
		Logistics domain = new Logistics();
		for (Compound_task_atomContext task:ctx.compound_task_atom()){
			ArrayList<Term> list = new ArrayList<>(task.terms()._terms);
			domain.obj_at(list.get(0).toString(),list.get(1).toString());
		}
		
		System.out.println();
		System.out.println(domain);
	}
	
}
