package hardcoded;

import main.Problem;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import preconditions.PreconditionAnd;
import preconditions.PreconditionDifferent;
import preconditions.SimplePrecondition;
import terms.Variable;
import antlr.Parser;
import antlr.generated.JSHOP2Lexer;
import antlr.generated.JSHOP2Parser;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public class LogisticsMain {

	public static void main(String[] args) throws Exception
	  {
		
		JSHOP2Parser problem = getParser("ipc2002/probLOGISTICS-30-1/problem");
		
		
		long tiempo = System.currentTimeMillis();
	    problem.problem();
	    tiempo=System.currentTimeMillis()-tiempo;
		System.out.println();
		System.out.println("Tardo "+tiempo+"ms");
		}
	
	private static JSHOP2Parser getParser(String problemID) throws Exception {
		String domainFile = "./problems/logistics/logistics";
		String problemFile = "./problems/logistics/"+problemID;
		
	    JSHOP2Lexer domainLexer = new JSHOP2Lexer(new ANTLRFileStream(domainFile));
	    CommonTokenStream domainTokens = new CommonTokenStream(domainLexer);
	    JSHOP2Parser domainParser = new JSHOP2Parser(domainTokens);
	    domainParser.setBuildParseTree(true);
	    domainParser.addParseListener(new LogisticsParser());
	    
		
	    JSHOP2Lexer problemLexer = new JSHOP2Lexer(new ANTLRFileStream(problemFile));
	    CommonTokenStream problemTokens = new CommonTokenStream(problemLexer);
	    JSHOP2Parser problemParser = new JSHOP2Parser(problemTokens);
	    problemParser.setBuildParseTree(true);
	    problemParser.addParseListener(new LogisticsParser());
	    
	    return problemParser;
	}

	private static void problemTest(){
		System.out.println(Problem.debug());
		
		/*
		LogicalAtom airport = new LogicalAtom("airport"); airport.addTerm(new Constant("loc7-1"));
		Problem.addProtection(airport);
		Problem.addProtection(airport);
		Problem.delProtection(airport);
		Problem.delProtection(airport);
		Problem.delState(airport);
		
		System.out.println(Problem.debug());
		*/
	}
	
	private static void multimapTests(){
		Multimap<String,String> table = LinkedListMultimap.create();
		table.put("x", "t01");
		table.put("x", "t02");
		table.put("x", "t01");
		table.put("x", "t03");
		table.put("x", "t01");
		table.put("y", "t03");
		table.put("h", "t04");
		
		Multimap<String,String> table2 = LinkedListMultimap.create();
		table2.put("x", "t01");
		table2.put("x", "t05");
		table2.put("y", "t03");
		table2.put("h", "t04");
		
		
		System.out.println(table);
		System.out.println(table2);
	}
	
	private static void PreconditionsTest2(){
		Variable airport_now = new Variable("airport-now");
		Variable airport_goal = new Variable("airport-goal");
		Variable city_now = new Variable("city-now");
		Variable city_goal = new Variable("city-goal");
		Variable truck_now = new Variable("truck-now");
		Variable truck_goal = new Variable("truck-now");
		Variable loc_now = new Variable("loc-now");
		Variable loc_goal = new Variable("loc-now");
		Variable obj = new Variable("obj");

		PreconditionAnd precondition1 = new PreconditionAnd(
				new SimplePrecondition("in-city",loc_goal,city_goal),
				new SimplePrecondition("obj-at",obj,loc_now),
				new SimplePrecondition("in-city",loc_now,city_now),
				new PreconditionDifferent(city_goal,city_now),
				new SimplePrecondition("truck",truck_now ,city_now),
				new SimplePrecondition("truck",truck_goal,city_goal),
				new SimplePrecondition("airport",airport_now),
				new SimplePrecondition("in-city",airport_now,city_now),
				new SimplePrecondition("airport",airport_goal),
				new SimplePrecondition("in-city",airport_goal,city_goal)
				);
		
		int count=0;
		while (precondition1.isTrue()){
			count++;
			System.out.println(precondition1);
		}
		System.out.println("count: "+count);
	}
	
	private static void logisticsTestOriginal(){
		System.out.println(Problem.debug());
		
		Logistics domain = new Logistics();
		
		long tiempo = System.currentTimeMillis();
		
		/*
		 * (obj-at package1 loc8-1)
  			(obj-at package2 loc2-1)
  			(obj-at package3 loc2-3)
  			(obj-at package4 loc6-2)
  			(obj-at package5 loc1-1)
  			*/
//		System.out.println("(obj-at package1 loc8-1) is " + domain.obj_at("package1","loc8-1") +"\n");
//		System.out.println("(obj-at package2 loc2-1) is " + domain.obj_at("package2","loc2-1") +"\n");
//		System.out.println("(obj-at package3 loc2-3) is " + domain.obj_at("package3","loc2-3") +"\n");
//		System.out.println("(obj-at package4 loc6-2) is " + domain.obj_at("package4","loc6-2") +"\n");
//		System.out.println("(obj-at package5 loc1-1) is " + domain.obj_at("package5","loc1-1") +"\n");
//		
//		/*
//  			(obj-at package6 loc6-2)
//  			(obj-at package7 loc6-3)
//  			(obj-at package8 loc1-1)
//  			(obj-at package9 loc4-2)
//  			(obj-at package10 loc8-3)
//  		*/
//		System.out.println("(obj-at package6 loc6-2) is " + domain.obj_at("package6","loc6-2") +"\n");
//		System.out.println("(obj-at package7 loc6-3) is " + domain.obj_at("package7","loc6-3") +"\n");
//		System.out.println("(obj-at package8 loc1-1) is " + domain.obj_at("package8","loc1-1") +"\n");
//		System.out.println("(obj-at package9 loc4-2) is " + domain.obj_at("package9","loc4-2") +"\n");
//		System.out.println("(obj-at package10 loc8-3) is " + domain.obj_at("package10","loc8-3") +"\n");
//  		
//		/*(obj-at package11 loc3-2)
//  			(obj-at package12 loc3-3)
//  			(obj-at package13 loc3-2)
//  			(obj-at package14 loc6-3)
//  			(obj-at package15 loc5-1)
//		 */
//		System.out.println("(obj-at package11 loc3-2) is " + domain.obj_at("package11","loc3-2") +"\n");
//		System.out.println("(obj-at package12 loc3-3) is " + domain.obj_at("package12","loc3-3") +"\n");
//		System.out.println("(obj-at package13 loc3-2) is " + domain.obj_at("package13","loc3-2") +"\n");
//		System.out.println("(obj-at package14 loc6-3) is " + domain.obj_at("package14","loc6-3") +"\n");
//		System.out.println("(obj-at package15 loc5-1) is " + domain.obj_at("package15","loc5-1") +"\n");
//		
//		tiempo=System.currentTimeMillis()-tiempo;
//		System.out.println();
//		System.out.println("Tard� "+tiempo+"ms");
//		System.out.println();
//		System.out.println("Plan: ");
//		System.out.println(domain);
//		System.out.println();
//		//System.out.println(Problem.debug());
	}

}
