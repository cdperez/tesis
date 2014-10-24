package hardcoded;

import java.io.IOException;

import main.Domain;
import main.Plan;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import preconditions.LogicalPrecondition;
import preconditions.PreconditionAnd;
import preconditions.PreconditionDifferent;
import preconditions.PreconditionSame;
import preconditions.SimplePrecondition;
import tasks.Method;
import tasks.Operator;
import terms.LogicalAtom;
import terms.Variable;
import antlr.Parser;
import antlr.generated.JSHOP2Lexer;
import antlr.generated.JSHOP2Parser;

public class Logistics_classes {
	
	public static void main(String[] args){
		loadDomain();
		try{
			loadProblem();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		long tiempo = System.currentTimeMillis();
		
		System.out.println(Domain.invoke("obj-at", new Variable("obj","package1"), new Variable("loc-goal","loc8-1")));
		System.out.println(Domain.invoke("obj-at", new Variable("obj","package2"), new Variable("loc-goal","loc2-1")));
		System.out.println(Domain.invoke("obj-at", new Variable("obj","package3"), new Variable("loc-goal","loc2-3")));
		System.out.println(Domain.invoke("obj-at", new Variable("obj","package4"), new Variable("loc-goal","loc6-2")));
		System.out.println(Domain.invoke("obj-at", new Variable("obj","package5"), new Variable("loc-goal","loc1-1")));
		
		tiempo=System.currentTimeMillis()-tiempo;
		
		
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package6"), new Variable("loc-goal","loc6-2")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package7"), new Variable("loc-goal","loc6-3")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package8"), new Variable("loc-goal","loc1-1")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package9"), new Variable("loc-goal","loc4-2")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package10"), new Variable("loc-goal","loc8-3")));
		
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package11"), new Variable("loc-goal","loc3-2")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package12"), new Variable("loc-goal","loc3-3")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package13"), new Variable("loc-goal","loc3-2")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package14"), new Variable("loc-goal","loc6-3")));
		//System.out.println(Domain.invoke("obj-at", new Variable("obj","package15"), new Variable("loc-goal","loc5-1")));
		
		System.out.println(Plan.toStringg());
		
		System.out.println();
		System.out.println("Tardó "+tiempo+"ms");
	}
	
	private static void loadDomain(){
		Domain.put(_load_truck());
		Domain.put(_unload_truck());
		Domain.put(_load_airplane());
		Domain.put(_unload_airplane());
		Domain.put(_drive_truck());
		Domain.put(_fly_airplane());
		Domain.put(_add_protection());
		Domain.put(_delete_protection());
		
		Domain.put(obj_at1());
		Domain.put(obj_at2());
		Domain.put(in_city_delivery1());
		Domain.put(in_city_delivery2());
		Domain.put(truck_at1());
		Domain.put(truck_at2());
		Domain.put(air_deliver_obj1());
		Domain.put(air_deliver_obj2());
		Domain.put(fly_airplane1());
		Domain.put(fly_airplane2());
	}
	
	private static void loadProblem() throws IOException{
		String problemFile = "./problems/logistics/problem";
	    
	    JSHOP2Lexer problemLexer = new JSHOP2Lexer(new ANTLRFileStream(problemFile));
	    CommonTokenStream problemTokens = new CommonTokenStream(problemLexer);
	    JSHOP2Parser problemParser = new JSHOP2Parser(problemTokens);
	    problemParser.setBuildParseTree(true);
	    problemParser.addParseListener(new Parser());
	    problemParser.problem();
	}
	
	private static Operator _load_truck(){
		Operator operator = new Operator("!load-truck","obj","truck","loc");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("obj-at","obj","loc"));
		operator.addToDelList(LogicalAtom.asProtectionCondition("truck-at","truck","loc"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("in-truck","obj","truck"));
		
		return operator;
	}
	
	private static Operator _unload_truck(){
		Operator operator = new Operator("!unload-truck","obj","truck","loc");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("in-truck","obj","truck"));
		operator.addToDelList(LogicalAtom.asProtectionCondition("truck-at","truck","loc"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("in-truck","obj","truck"));
		
		return operator;
	}
	
	private static Operator _load_airplane(){
		Operator operator = new Operator("!load-airplane","obj","airplane","loc");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("obj-at","obj","loc"));
		operator.addToDelList(LogicalAtom.asProtectionCondition("airplane-at","airplane","loc"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("in-airplane","obj","airplane"));
		
		return operator;
	}
	
	private static Operator _unload_airplane(){
		Operator operator = new Operator("!unload-airplane","obj","airplane","loc");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("in-airplane","obj","airplane"));
		operator.addToDelList(LogicalAtom.asProtectionCondition("airplane-at","airplane","loc"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("obj-at","obj","loc"));
		
		return operator;
	}
	
	private static Operator _drive_truck(){
		Operator operator = new Operator("!drive-truck","truck","loc-from","loc-to");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("truck-at","truck","loc-from"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("truck-at","truck","loc-to"));
		operator.addToAddList(LogicalAtom.asProtectionCondition("truck-at","truck","loc-to"));
		
		return operator;
	}
	
	private static Operator _fly_airplane(){
		Operator operator = new Operator("!fly-airplane","airplane","airport-from","airport-to");
		
		operator.addToDelList(LogicalAtom.asLogicalAtom("airplane-at","airplane","airport-from"));
		
		operator.addToAddList(LogicalAtom.asLogicalAtom("airplane-at","airplane","airport-to"));
		operator.addToAddList(LogicalAtom.asProtectionCondition("airplane-at","airplane","airport-to"));
		
		return operator;
	}
	
	private static Operator _add_protection(){
		Operator operator = new Operator("!add-protection","g");
		
		operator.addToAddList("g");
		
		return operator;
	}
	
	private static Operator _delete_protection(){
		Operator operator = new Operator("!delete-protection","g");
		
		operator.addToDelList("g");
		
		return operator;
	}
	
	private static Method obj_at1(){
		Method method = new Method("obj-at","obj","loc-goal");
		
		PreconditionAnd precondition = new PreconditionAnd(
				new SimplePrecondition("in-city","loc-goal","city-goal"),
				new SimplePrecondition("obj-at","obj","loc-now"),
				new SimplePrecondition("in-city","loc-now","city-goal"),
				new SimplePrecondition("truck","truck","city-goal")
				);
		
		method.setPrecondition(precondition);
		method.addTask("in-city-delivery","truck","obj","loc-now","loc-goal");
		
		return method;
	}
	
	private static Method obj_at2(){
		Method method = new Method("obj-at","obj","loc-goal");
		
		PreconditionAnd precondition = new PreconditionAnd(
				new SimplePrecondition("in-city","loc-goal","city-goal"),
				new SimplePrecondition("obj-at","obj","loc-now"),
				new SimplePrecondition("in-city","loc-now","city-now"),
				new PreconditionDifferent("city-goal","city-now"),
				new SimplePrecondition("truck","truck-now" ,"city-now"),
				new SimplePrecondition("truck","truck-goal","city-goal"),
				new SimplePrecondition("airport","airport-now"),
				new SimplePrecondition("in-city","airport-now","city-now"),
				new SimplePrecondition("airport","airport-goal"),
				new SimplePrecondition("in-city","airport-goal","city-goal")
				);
		
		method.setPrecondition(precondition);
		method.addTask("in-city-delivery","truck-now","obj","loc-now","airport-now");
        method.addTask("air-deliver-obj","obj","airport-now","airport-goal");
        method.addTask("in-city-delivery","truck-goal","obj","airport-goal","loc-goal");

		return method;
	}
	
	private static Method in_city_delivery1(){
		Method method = new Method("in-city-delivery","truck","obj","loc-from","loc-to");
		
		LogicalPrecondition precondition = new PreconditionSame("loc-from","loc-to");
		
		method.setPrecondition(precondition);
		
		return method;
	}
	
	private static Method in_city_delivery2(){
		Method method = new Method("in-city-delivery","truck","obj","loc-from","loc-to");
		
		LogicalPrecondition precondition = new PreconditionAnd(
				new SimplePrecondition("in-city","loc-from","city"),
				new SimplePrecondition("truck","truck","city")
				);
		
		method.setPrecondition(precondition);
		
		method.addTask("truck-at","truck","loc-from");
		method.addTask("!load-truck","obj","truck","loc-from");
		method.addTask("truck-at","truck","loc-to");
		method.addTask("!unload-truck","obj","truck","loc-to");
		
		return method;
	}
	
	private static Method truck_at1(){
		Method method = new Method("truck-at","truck","loc-to");
		
		LogicalPrecondition precondition = new PreconditionAnd(
				new SimplePrecondition("truck-at","truck","loc-from"),
				new PreconditionDifferent("loc-from","loc-to")
				);
		
		method.setPrecondition(precondition);
		
		method.addTask("!drive-truck","truck","loc-from","loc-to");
		
		return method;
	}
	
	private static Method truck_at2(){
		Method method = new Method("truck-at","truck","loc-to");
		
		LogicalPrecondition precondition = new PreconditionAnd(
				new SimplePrecondition("truck-at","truck","loc-from"),
				new PreconditionSame("loc-from","loc-to")
				);
		
		method.setPrecondition(precondition);
		
		Variable la = new Variable("la");
		la.bind(LogicalAtom.asProtectionCondition("truck-at","truck","loc-to"));
		
		method.addTask("!add-protection",la);
		
		return method;
	}
	
	private static Method air_deliver_obj1(){
		Method method = new Method("air-deliver-obj","obj","airport-from","airport-to");
		
		LogicalPrecondition precondition = new SimplePrecondition("airplane-at","airplane","airport-from");
		
		method.setPrecondition(precondition);
		
		Variable la = new Variable("la");
		la.bind(LogicalAtom.asProtectionCondition("airplane-at","airplane","airport-from"));
		
		method.addTask("!add-protection",la);
		method.addTask("!load-airplane","obj","airplane","airport-from");
		method.addTask("fly-airplane","airplane","airport-to");
		method.addTask("!unload-airplane","obj","airplane","airport-to");
		
		return method;
	}
	
	private static Method air_deliver_obj2(){
		Method method = new Method("air-deliver-obj","obj","airport-from","airport-to");
		
		LogicalPrecondition precondition = new SimplePrecondition("airplane-at","airplane","any-airport");
		
		method.setPrecondition(precondition);
		
		method.addTask("!fly-airplane","airplane","any-airport","airport-from");
		method.addTask("!load-airplane","obj","airplane","airport-from");
		method.addTask("fly-airplane","airplane","airport-to");
		method.addTask("!unload-airplane","obj","airplane","airport-to");
		
		return method;
	}
	
	private static Method fly_airplane1(){
		Method method = new Method("fly-airplane","airplane","airport-to");
		
		LogicalPrecondition precondition = new SimplePrecondition("airplane-at","airplane","airport-to");
		
		method.setPrecondition(precondition);
		
		Variable la = new Variable("la");
		la.bind(LogicalAtom.asProtectionCondition("airplane","airplane","airport-to"));
		
		method.addTask("!add-protection",la);
		
		return method;
	}
	
	private static Method fly_airplane2(){
		Method method = new Method("fly-airplane","airplane","airport-to");
		
		LogicalPrecondition precondition = new SimplePrecondition("airplane-at","airplane","airport-from");
		
		method.setPrecondition(precondition);
		
		method.addTask("!fly-airplane","airplane","airport-from","airport-to");
		
		return method;
	}
}
