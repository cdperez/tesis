package hardcoded;

import java.util.LinkedList;
import java.util.List;

import main.Problem;
import preconditions.PreconditionAnd;
import preconditions.PreconditionDifferent;
import preconditions.PreconditionSame;
import preconditions.SimplePrecondition;
import terms.LogicalAtom;
import terms.Variable;

public class Logistics {
	
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
	
	protected boolean load_truck (Variable obj, Variable truck, Variable loc){
		/*
		 * (:operator (!load-truck ?obj ?truck ?loc)
               ()
               ((obj-at ?obj ?loc) (:protection (truck-at ?truck ?loc)))
               ((in-truck ?obj ?truck)))
		 */
		System.out.println(formatTask("!load_truck",obj,truck,loc));
		plan.add(formatTask("!load_truck",obj,truck,loc));
		
		Problem.delState("obj-at",obj,loc);
		Problem.delProtection("truck-at",truck,loc);
		
		Problem.addState("in-truck",obj,truck);
		
		return true;
	}
	
	protected boolean unload_truck (Variable obj, Variable truck, Variable loc){
		/*
		 * (:operator (!unload-truck ?obj ?truck ?loc)
               ()
               ((in-truck ?obj ?truck) (:protection (truck-at ?truck ?loc)))
               ((obj-at ?obj ?loc)))
		 */
		System.out.println(formatTask("!unload_truck",obj,truck,loc));
		plan.add(formatTask("!unload_truck",obj,truck,loc));
		
		Problem.delState("in-truck",obj,truck);
		Problem.delProtection("truck-at",truck,loc);
		
		Problem.addState("obj-at",obj,loc);
		
		return true;
	}
	
	protected boolean load_airplane (Variable obj, Variable airplane, Variable loc){
		/*
		 * (:operator (!load-airplane ?obj ?airplane ?loc)
               ()
               ((obj-at ?obj ?loc) (:protection (airplane-at ?airplane ?loc)))
               ((in-airplane ?obj ?airplane)))
		 */
		
		System.out.println(formatTask("!load-airplane",obj,airplane,loc));
		plan.add(formatTask("!load-airplane",obj,airplane,loc));
		
		Problem.delState("obj-at",obj,loc);
		Problem.delProtection("airplane-at",airplane,loc);
		
		Problem.addState("in-airplane",obj,airplane);
		
		return true;
	}
	
	protected boolean unload_airplane (Variable obj, Variable airplane, Variable loc){
		/*
		 * (:operator (!unload-airplane ?obj ?airplane ?loc)
               ()
               ((in-airplane ?obj ?airplane) (:protection (airplane-at ?airplane ?loc)))
               ((obj-at ?obj ?loc)))
		 */
		
		System.out.println(formatTask("!unload-airplane",obj,airplane,loc));
		plan.add(formatTask("!unload-airplane",obj,airplane,loc));
		
		Problem.delState("in-airplane",obj,airplane);
		Problem.delProtection("airplane-at",airplane,loc);
		
		Problem.addState("obj-at",obj,loc);
		
		return true;
	}
	
	protected boolean drive_truck(Variable truck, Variable loc_from, Variable loc_to){
		/*
		 * (:operator (!drive-truck ?truck ?loc-from ?loc-to)
               ()
               ((truck-at ?truck ?loc-from))
               ((truck-at ?truck ?loc-to) (:protection (truck-at ?truck ?loc-to))))
		 */
		
		System.out.println(formatTask("!drive-truck",truck,loc_from,loc_to));
		plan.add(formatTask("!drive-truck",truck,loc_from,loc_to));
				
		Problem.delState("truck-at",truck,loc_from);
		
		Problem.addState("truck-at",truck,loc_to);
		Problem.addProtection("truck-at",truck,loc_to);
		
		return true;
	}
	
	protected boolean fly_airplane (Variable airplane, Variable airport_from, Variable airport_to){
		/*
		 * (:operator (!fly-airplane ?airplane ?airport-from ?airport-to)
               ()
               ((airplane-at ?airplane ?airport-from))
               ((airplane-at ?airplane ?airport-to) (:protection (airplane-at ?airplane ?airport-to))))
		 */
		
		System.out.println(formatTask("!fly-airplane",airplane,airport_from,airport_to));
		plan.add(formatTask("!fly-airplane",airplane,airport_from,airport_to));
		
		Problem.delState("airplane-at",airplane,airport_from);
		
		Problem.addState("airplane-at",airplane,airport_to);
		Problem.addProtection("airplane-at",airplane,airport_to);
		
		return true;
	}
	
	protected boolean add_protection (LogicalAtom g){
		/*
		 * (:operator (!add-protection ?g)
               ()
               ()
               ((:protection ?g))
               )
		 */
		
		System.out.println("!add-protection("+g.toString()+")");
//		plan.add("!add-protection("+g.toString()+")");
		
		Problem.addProtection(g);
		return true;
	}
	
	protected boolean delete_protection (LogicalAtom g){
		/*
		 * (:operator (!delete-protection ?g)
               ()
               ((:protection ?g))
               ()
               )
		 */
		
		System.out.println("!delete-protection("+g.toString()+")");
//		plan.add("!delete-protection("+g.toString()+")");
		
		Problem.delProtection(g);
		return true;
	}
	
	public boolean obj_at (String obj, String loc_goal){
		return obj_at(new Variable("obj",obj), new Variable("loc-goal",loc_goal));
	}
	
	public boolean obj_at (Variable obj, Variable loc_goal){
		/*
		 * (:method (obj-at ?obj ?loc-goal)
             ((in-city ?loc-goal ?city-goal)
              (obj-at ?obj ?loc-now)
              (in-city ?loc-now ?city-goal)
              (truck ?truck ?city-goal)
              )
      ((in-city-delivery ?truck ?obj ?loc-now ?loc-goal))
      */
		
		System.out.println(":method obj-at");
		
		Variable city_goal = new Variable ("city-goal");
		Variable loc_now = new Variable ("loc-now");
		Variable truck = new Variable ("truck");
		PreconditionAnd precondition1 = new PreconditionAnd(
				new SimplePrecondition("in-city",loc_goal,city_goal),
				new SimplePrecondition("obj-at",obj,loc_now),
				new SimplePrecondition("in-city",loc_now,city_goal),
				new SimplePrecondition("truck",truck,city_goal)
				);
		
		if (precondition1.isTrue())
			return (in_city_delivery(truck,obj,loc_now,loc_goal));
		
		/*
      ((in-city ?loc-goal ?city-goal)
       (obj-at ?obj ?loc-now)
       (in-city ?loc-now ?city-now)
       (different ?city-goal ?city-now)
       (truck ?truck-now ?city-now)
       (truck ?truck-goal ?city-goal)
       (airport ?airport-now) (in-city ?airport-now ?city-now)
       (airport ?airport-goal) (in-city ?airport-goal ?city-goal))
       
      ((in-city-delivery ?truck-now ?obj ?loc-now ?airport-now)
                (air-deliver-obj ?obj ?airport-now ?airport-goal)
                (in-city-delivery ?truck-goal ?obj ?airport-goal ?loc-goal)))
		 */
		
		city_goal.clear();
		loc_now.clear();
		truck.clear();
		Variable city_now = new Variable ("city-now");
		Variable truck_now = new Variable ("truck-now");
		Variable truck_goal = new Variable ("truck-goal");
		Variable airport_now = new Variable ("airport-now");
		Variable airport_goal = new Variable ("airport-goal");
		PreconditionAnd precondition2 = new PreconditionAnd(
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
		
		if (precondition2.isTrue())
			return (in_city_delivery(truck_now,obj,loc_now,airport_now) &&
	                air_deliver_obj(obj,airport_now,airport_goal) &&
	                in_city_delivery(truck_goal,obj,airport_goal,loc_goal));
		
		return false;
	}
	

	public boolean in_city_delivery(Variable truck, Variable obj, Variable loc_from, Variable loc_to) {
		/*
		 * (:method (in-city-delivery ?truck ?obj ?loc-from ?loc-to)
             ((same ?loc-from ?loc-to))
             ()
             */
		
		System.out.println(":method in-city-delivery");
		
		if (new PreconditionSame(loc_from,loc_to).isTrue()) return true;
		
		/*
             ((in-city ?loc-from ?city)
              (truck ?truck ?city))
             ((truck-at ?truck ?loc-from)
                       (:immediate !load-truck ?obj ?truck ?loc-from)
                       (truck-at ?truck ?loc-to)
                       (:immediate !unload-truck ?obj ?truck ?loc-to)))
		 */
		
		Variable city = new Variable ("city");
		PreconditionAnd precondition = new PreconditionAnd(
				new SimplePrecondition("in-city",loc_from,city),
				new SimplePrecondition("truck",truck,city)
				);
		
		if (precondition.isTrue())
			return (truck_at(truck,loc_from) && load_truck(obj,truck,loc_from) &&
					truck_at(truck,loc_to) && unload_truck(obj,truck,loc_to));
		
		
		return false;
	}
	
	public boolean truck_at(Variable truck, Variable loc_to) {
		/*
		 * (:method (truck-at ?truck ?loc-to)

             ((truck-at ?truck ?loc-from)
              (different ?loc-from ?loc-to))
             ((:immediate !drive-truck ?truck ?loc-from ?loc-to)) */
		
		System.out.println(":method truck-at");
		
		Variable loc_from = new Variable ("loc-from");
		PreconditionAnd precondition1 = new PreconditionAnd(
				new SimplePrecondition("truck-at",truck,loc_from),
				new PreconditionDifferent(loc_from,loc_to)
				);
		
		if (precondition1.isTrue()) return drive_truck(truck,loc_from,loc_to);
		
		/*
        ((truck-at ?truck ?loc-from)
         (same ?loc-from ?loc-to))
        ((:immediate !add-protection (truck-at ?truck ?loc-to))))
		 */
		
		loc_from.clear();
		PreconditionAnd precondition2 = new PreconditionAnd(
				new SimplePrecondition("truck-at",truck,loc_from),
				new PreconditionSame(loc_from,loc_to)
				);
		
		if (precondition2.isTrue()) return add_protection(LogicalAtom.asLogicalAtom("truck-at",truck,loc_to));
		
		return false;
	}

	public boolean air_deliver_obj(Variable obj, Variable airport_from, Variable airport_to) {
		/*
		 * (:method (air-deliver-obj ?obj ?airport-from ?airport-to)
             airplane-at-the-current-airport
             ((airplane-at ?airplane ?airport-from))
             ((:immediate !add-protection (airplane-at ?airplane ?airport-from))
                       (!load-airplane ?obj ?airplane ?airport-from)
                       (fly-airplane ?airplane ?airport-to)
                       (!unload-airplane ?obj ?airplane ?airport-to))*/
		
		System.out.println(":method air-deliver-obj");
		
		Variable airplane = new Variable ("airplane");
		if (new SimplePrecondition("airplane-at",airplane,airport_from).isTrue())
			return (add_protection(LogicalAtom.asLogicalAtom("airplane-at",airplane,airport_from)) &&
					load_airplane(obj,airplane,airport_from) &&
					fly_airplane(airplane,airport_to) &&
					unload_airplane(obj,airplane,airport_to));
		
		/*
             ((airplane-at ?airplane ?any-airport))
             ((:immediate !fly-airplane ?airplane ?any-airport ?airport-from)
                       (!load-airplane ?obj ?airplane ?airport-from)
                       (fly-airplane ?airplane ?airport-to)
                       (!unload-airplane ?obj ?airplane ?airport-to)))
		 */
		
		airplane.clear();
		Variable any_airport = new Variable("any-airport");
		if (new SimplePrecondition("airplane-at",airplane,any_airport).isTrue())
			return (fly_airplane(airplane,any_airport,airport_from) &&
					load_airplane(obj,airplane,airport_from) &&
					fly_airplane(airplane,airport_to) &&
					unload_airplane(obj,airplane,airport_to));
		
		return false;
	}

	public boolean fly_airplane(Variable airplane, Variable airport_to) {
		/*
		 * (:method (fly-airplane ?airplane ?airport-to)
             airplane-already-there
             ((airplane-at ?airplane ?airport-to))
             ((:immediate !add-protection (airplane-at ?airplane ?airport-to)))*/

		System.out.println(":method fly-airplane");
		
		if (new SimplePrecondition("airplane-at",airplane,airport_to).isTrue())
			return (add_protection(LogicalAtom.asLogicalAtom("airplane",airplane,airport_to)));
		
           /*  fly-airplane-in
             ((airplane-at ?airplane ?airport-from))
             ((:immediate !fly-airplane ?airplane ?airport-from ?airport-to)))
		 */
		
		Variable airport_from = new Variable("airport-from");
		if (new SimplePrecondition("airplane-at",airplane,airport_from).isTrue())
			return (fly_airplane(airplane,airport_from,airport_to));
		
		return false;
	}
	
	private String formatTask(String name, Variable... vars){
		String result=name+"(";
		for (Variable var:vars)
			result+=var.getValue().toString()+",";
		
		return result.substring(0,result.length()-1)+")";
	}
	
}
