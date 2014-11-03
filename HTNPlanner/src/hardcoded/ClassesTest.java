package hardcoded;

import preconditions.PreconditionAnd;
import preconditions.SimplePrecondition;
import tasks.Binder;
import tasks.Method;
import tasks.Operator;
import terms.LogicalAtom;
import terms.Variable;

public class ClassesTest {
	
	public static void main(String[] args){
//		operatorTest();
		methodTest();
//		binderTest();
	}
	
	public static void operatorTest(){
		Operator operator = new Operator("!load-truck","obj","truck","loc");
		operator.addToDelList(LogicalAtom.asLogicalAtom("obj-at","obj","loc"));
		operator.addToDelList(LogicalAtom.asProtectionCondition("truck-at","truck","loc"));
		operator.addToAddList(LogicalAtom.asLogicalAtom("in-truck","obj","truck"));
		
		System.out.println(operator);
		
		operator.instantiate(new Variable("obj","o"),
				new Variable("truck","t"),
				new Variable("loc","l")
		);
		
		System.out.println(operator);
	}
	
	public static void methodTest(){
		Method method = new Method("obj-at","obj","loc-goal");
		
		PreconditionAnd precondition = new PreconditionAnd(
				new SimplePrecondition("in-city","loc-goal","city-goal"),
				new SimplePrecondition("obj-at","obj","loc-now"),
				new SimplePrecondition("in-city","loc-now","city-goal"),
				new SimplePrecondition("truck","truck","city-goal")
				);
		
		method.setPrecondition(precondition);
		method.addTask("in-city-delivery","truck","obj","loc-now","loc-goal");
		
		System.out.println(method);
		
		method.instantiate(new Variable("obj","o"),
				new Variable("loc-goal","lg")
		);
		
		System.out.println(method);
	}
	
	public static void binderTest(){
		Binder binder = new Binder();
		Variable a = binder.getBind(new Variable("a"));
		binder.getBind(new Variable("b"));
		binder.getBind(new Variable("c"));
		System.out.println(binder);
		
//		Variable a = new Variable ("a");
		a.bind("a1");
		System.out.println(a);
		System.out.println(binder);
		a = binder.getBind(new Variable("a"));
		//a.bind("a1");
		System.out.println(a);
		System.out.println(binder);
	}

}
