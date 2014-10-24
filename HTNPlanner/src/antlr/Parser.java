package antlr;


import hardcoded.Logistics;

import java.util.ArrayList;
import java.util.Collection;

import main.Problem;
import preconditions.SimplePrecondition;
import terms.Constant;
import terms.LogicalAtom;
import terms.NilTerm;
import terms.Term;
import terms.Variable;
import antlr.generated.JSHOP2BaseListener;
import antlr.generated.JSHOP2Parser;
import antlr.generated.JSHOP2Parser.AxiomContext;
import antlr.generated.JSHOP2Parser.Compound_task_atomContext;
import antlr.generated.JSHOP2Parser.ExpAndContext;
import antlr.generated.JSHOP2Parser.ExpAndNotContext;
import antlr.generated.JSHOP2Parser.ExpAtomContext;
import antlr.generated.JSHOP2Parser.ExpTaskAtomContext;
import antlr.generated.JSHOP2Parser.GoalsContext;
import antlr.generated.JSHOP2Parser.Initial_stateContext;
import antlr.generated.JSHOP2Parser.List_headContext;
import antlr.generated.JSHOP2Parser.Logical_atomContext;
import antlr.generated.JSHOP2Parser.Logical_precondition_AContext;
import antlr.generated.JSHOP2Parser.Logical_precondition_BContext;
import antlr.generated.JSHOP2Parser.Logical_precondition_CContext;
import antlr.generated.JSHOP2Parser.Logical_precondition_DContext;
import antlr.generated.JSHOP2Parser.MethodContext;
import antlr.generated.JSHOP2Parser.OperatorContext;
import antlr.generated.JSHOP2Parser.ProblemContext;
import antlr.generated.JSHOP2Parser.Task_atomContext;
import antlr.generated.JSHOP2Parser.Task_list_AContext;
import antlr.generated.JSHOP2Parser.Task_list_BContext;
import antlr.generated.JSHOP2Parser.Task_list_CContext;
import antlr.generated.JSHOP2Parser.TermContext;
import antlr.generated.JSHOP2Parser.TermFContext;
import antlr.generated.JSHOP2Parser.TermGContext;
import antlr.generated.JSHOP2Parser.TermHContext;
import antlr.generated.JSHOP2Parser.Term_listContext;
import antlr.generated.JSHOP2Parser.TermsContext;
import antlr.generated.JSHOP2Parser.VariableContext;

public class Parser extends JSHOP2BaseListener {

	/*
	 * Terms
	 */
	
	@Override
	public void exitVariable(VariableContext ctx) {
		ctx._variable = new Variable(ctx.getText());
	}
	
	public void exitTermA(JSHOP2Parser.TermAContext ctx) {
		//NIL term
		ctx._term = new NilTerm();
	}

	@Override
	public void exitTermB(JSHOP2Parser.TermBContext ctx) {
		//Number term. Por ahora los trato como constantes
		ctx._term = new Constant(ctx.getText());
	}

	@Override
	public void exitTermC(JSHOP2Parser.TermCContext ctx) {
		//Constant term
		ctx._term = new Constant(ctx.getText());
	}
	
	@Override
	public void exitTermD(JSHOP2Parser.TermDContext ctx) {
		//Variable term
		ctx._term = ctx.variable()._variable;
	}
	
	@Override
	public void exitTermE(JSHOP2Parser.TermEContext ctx) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void exitTermF(TermFContext ctx) {
		//LogicalAtom term
		ctx._term = ctx.logical_atom()._logicalAtom;
	}
	
	@Override
	public void exitTermG(TermGContext ctx) {
		//ListHead term
		//ctx._term = ctx.list_head()._listHeadPointer;
	}
	
	@Override
	public void exitTermH(TermHContext ctx) {
		//TermList term
		//ctx._term = ctx.term_list()._termList;
	}
	
	@Override
	public void exitTerms(TermsContext ctx) {
		Collection<Term> terms= new ArrayList<Term>();
		for (TermContext tc:ctx.term())
			//TODO no esta de mas esto?
			if (!(tc._term instanceof NilTerm)) terms.add(tc._term);
		
		ctx._terms = terms;
	}

	public void exitLogical_atom(JSHOP2Parser.Logical_atomContext ctx) {
		LogicalAtom la = new LogicalAtom(ctx.predicate().getText());
		for (Term term:ctx.terms()._terms)
			la.addTerm(term);
		
		ctx._logicalAtom = la;
	}
	
	
	@Override
	public void exitList_head(List_headContext ctx) {
		//ctx._listHeadPointer = new ListHeadPointer(ctx.head._variable,ctx.list._variable);
	}
	
	@Override
	public void exitTerm_list(Term_listContext ctx) {
		//ctx._termList = new TermList();
		//for (Term term:ctx.terms()._terms)
			//ctx._termList.addTerm(term);
	}
	
	/*
	 * Logical_Expression
	 */

	@Override
	public void exitExpAnd(ExpAndContext ctx) {
		//ctx._precondition = new PreconditionAnd(ctx.expA._precondition,ctx.expB._precondition);
	}

	@Override
	public void exitExpAndNot(ExpAndNotContext ctx) {
		//ctx._precondition = new PreconditionAndNot(ctx.expA._precondition,ctx.expB._precondition);
	}
	
	@Override
	public void exitExpAtom(ExpAtomContext ctx) {
		ctx._precondition = new SimplePrecondition(ctx.logical_atom()._logicalAtom);
	}

	@Override
	public void exitExpTaskAtom(ExpTaskAtomContext ctx) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * 
	 */
	
	/*
	 * Logical Precondition
	 */
	
	@Override
	public void exitLogical_precondition_A(Logical_precondition_AContext ctx) {
		//NIL Precondition
		//ctx._precondition = new NilPrecondition();
	}

	@Override
	public void exitLogical_precondition_B(Logical_precondition_BContext ctx) {
		//LogicalExpression Precondition
		ctx._precondition = ctx.logical_expression()._precondition;
	}

	@Override
	public void exitLogical_precondition_C(Logical_precondition_CContext ctx) {
		//FirstSatisfier Precondition
		throw new UnsupportedOperationException();
	}

	@Override
	public void exitLogical_precondition_D(Logical_precondition_DContext ctx) {
		//Sorted Precondition
		throw new UnsupportedOperationException();
	}
	
	/*
	 * 
	 */
	
	/*
	 * Axiom
	 */
	
	@Override
	public void exitAxiom(AxiomContext ctx) {
		/*
		PreconditionOr precondition = new PreconditionOr();
		for (Logical_preconditionContext c:ctx.logical_precondition())
			precondition.add(c._precondition);
		
		ctx._axiom = new Axiom(ctx.logical_atom()._logicalAtom);
		ctx._axiom.setPrecondition(precondition);
		*/
	}
	
	/*
	 * 
	 */
	
	/*
	 * Tasks
	 */
	
	@Override
	public void exitOperator(OperatorContext ctx) {
		/*
		Operator operator = new Operator (ctx.primitive_task_atom().primitive_task().getText());
		
		if (ctx.primitive_task_atom().terms()._terms != null)
			for (Term term:ctx.primitive_task_atom().terms()._terms)
				operator.addVariable((Variable)term);
		
		operator.setPrecondition(ctx.logical_precondition()._precondition);
		
		for (Term p:ctx.deleteList._termList)
			operator.addDeleteElemen(p);
		for (Term p:ctx.addList._termList)
			operator.addAddElemen(p);
		
		//operator.buildReferenceTree();
		Domain.put(operator);
		*/
	}
	
	@Override
	public void exitTask_atom(Task_atomContext ctx) {
		/*
		ctx._taskPointer = new TaskPointer(ctx.task().getText());
		
		for (Term term:ctx.terms()._terms)
			ctx._taskPointer.addTerm(term);
			*/
	}

	@Override
	public void exitTask_list_A(Task_list_AContext ctx) {
		//NIL tasks list
		//ctx._tasksPointers = new ArrayList<TaskPointer>();
	}

	@Override
	public void exitTask_list_B(Task_list_BContext ctx) {
		//Single task atom
		//ctx._tasksPointers = new ArrayList<TaskPointer>();
		//ctx._tasksPointers.add(ctx.task_atom()._taskPointer);
	}
	
	@Override
	public void exitTask_list_C(Task_list_CContext ctx) {
		//ctx._tasksPointers = new ArrayList<TaskPointer>();
		//for (Task_atomContext c:ctx.task_atom())
			//ctx._tasksPointers.add(c._taskPointer);
	}

	@Override
	public void exitMethod(MethodContext ctx) {
/*
		for (int i=0; i<ctx.logical_precondition().size(); i++){
			Method method = new Method (ctx.compound_task_atom().compound_task().getText());
			
			for (Term term:ctx.compound_task_atom().terms()._terms)
				method.addVariable((Variable)term);
			
			method.setPrecondition(ctx.logical_precondition(i)._precondition);
			
			for (TaskPointer task:ctx.task_list(i)._tasksPointers)
				method.addTask(task);
			
			//method.buildReferenceTree();
			Domain.put(method);
		}
	*/	
	}
	
	/*
	 * 
	 */
	
	public void exitDomain(JSHOP2Parser.DomainContext ctx) {
		/*
		for (ParseTree r:ctx.children){
			System.out.println(r.getText());
		}
		*/
	}
	
	@Override
	public void exitProblem(ProblemContext ctx) {
		Problem.setName(ctx.problemName.getText());
	}
	
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
	
	@Override
	public void exitInitial_state(Initial_stateContext ctx) {
		for (Logical_atomContext logicalAtom:ctx.logical_atom())
			Problem.addState(logicalAtom._logicalAtom);
	}
}
