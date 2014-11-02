package hardcoded;

import java.util.LinkedList;
import java.util.List;

import main.Problem;
import preconditions.PreconditionAnd;
import preconditions.SimplePrecondition;
import terms.Variable;

public class Trucks {
	
	private List<String> plan = new LinkedList<>();

	public List<String> getPlan(){
		return plan;
	}
	
	public String toString(){
		String result="";
		for (int i=0;i<plan.size();i++)
			result+="["+(i+1)+"] "+plan.get(i)+"\n";
		return result;
	}
	
	private String formatTask(String name, Variable... vars){
		String result=name+"(";
		for (Variable var:vars)
			result+=var.getValue().toString()+",";
		
		return result.substring(0,result.length()-1)+")";
	}
	
	protected boolean _load (Variable p, Variable t, Variable a1, Variable l){
		plan.add(formatTask("!load",p,t,a1,l));
		
		Problem.delState("at",p,l);
		Problem.delState("free",a1,t);
		
		Problem.addState("in",p,t,a1);
		
		return true;
	}
	
	protected boolean _unload (Variable p, Variable t, Variable a1, Variable l){
		plan.add(formatTask("!unload",p,t,a1,l));
		
		Problem.delState("in",p,t,a1);
		
		Problem.addState("free",a1,t);
		Problem.addState("at",p,l);
				
		return true;
	}
	
	protected boolean _drive (Variable t, Variable from, Variable to, Variable t1, Variable t2){
		plan.add(formatTask("!drive",t,from,to,t1,t2));
		
		Problem.delState("at",t,from);
		Problem.delState("time-now",t1);
		
		Problem.addState("time-now",t2);
		Problem.addState("at",t,to);
		
		return true;
	}
	
	protected boolean _deliver (Variable p, Variable l, Variable t1, Variable t2){
		plan.add(formatTask("!deliver",p,l,t1,t2));
		
		Problem.delState("at",p,l);
		
		Problem.addState("delivered",p,l,t2);
		Problem.addState("at-destination",p,l);
		
		return true;
	}
	
	public boolean at_destination(String p, String l){
		boolean result = at_destination(new Variable("p",p), new Variable("l",l));
		Debugger.println(result);
		return result;
		//return at_destination(new Variable("p",p), new Variable("l",l));
	}
	
	protected boolean at_destination (Variable p, Variable l){
		
		if ((new SimplePrecondition("at-destination",p,l)).isTrue())
			return true;
		
		if ((new SimplePrecondition("at",p,l)).isTrue())
			return deliver(p,l);
		
		Variable from = new Variable("from");
		if ((new SimplePrecondition("at",p,from)).isTrue())
			return transport_package(p,from,l) && at_destination(p,l);
		
		return false;
	}

	private boolean transport_package(Variable p, Variable from, Variable to) {
		
		/*
		 * Caso 1: el paquete ya esta en 'to'
		 */
		if ((new SimplePrecondition("at",p,to)).isTrue()) return true;
		
		/*
		 * Caso 2: el paquete no esta en 'to', y hay un camion en 'from'
		 */
		Variable t = new Variable("t");
		Variable a1 = new Variable("a1");
		PreconditionAnd precondition2 = new PreconditionAnd(
				new SimplePrecondition("at",p,from),
				new SimplePrecondition("at",t ,from),
				new SimplePrecondition("free",a1 ,t)
				);
		
		if (precondition2.isTrue())
			return (_load(p,t,a1,from) && drive(t,from,to) && _unload(p,t,a1,to));
		
		/*
		 * Caso 3: el paquete no esta en 'to', y no hay un camion en 'from'
		 */
		t = new Variable("t");
		Variable loc = new Variable("loc");
		a1 = new Variable("a1");
		PreconditionAnd precondition3 = new PreconditionAnd(
				new SimplePrecondition("at",p,from),
				new SimplePrecondition("at",t ,loc),
				new SimplePrecondition("free",a1 ,t)
				);
		
		if (precondition3.isTrue())
			return (drive (t,loc,from) && transport_package(p,from,to));
		
		
		return false;
	}

	private boolean drive(Variable t, Variable from, Variable to) {
		
		if ((new SimplePrecondition("at",t,to)).isTrue()) return true;
		
		Variable t1 = new Variable("t1");
		Variable t2 = new Variable("t2");
		PreconditionAnd precondition2 = new PreconditionAnd(
				new SimplePrecondition("at",t,from),
				new SimplePrecondition("connected",from ,to),
				new SimplePrecondition("time-now",t1),
				new SimplePrecondition("next",t1,t2)
				);
		
		if (precondition2.isTrue())
			return (_drive(t,from,to,t1,t2));
		
		return false;
	}

	private boolean deliver(Variable p, Variable l) {
		
		Variable t1 = new Variable("t1");
		Variable t2 = new Variable("t2");
		PreconditionAnd precondition1 = new PreconditionAnd(
				new SimplePrecondition("at",p,l),
				new SimplePrecondition("time-now",t1),
				new SimplePrecondition("next",t1,t2) //TODO no es next, es le. pero para ver si funciona asi...
				);
		
		if (precondition1.isTrue())
			return _deliver(p,l,t1,t2);
		
		return false;
	}

}
