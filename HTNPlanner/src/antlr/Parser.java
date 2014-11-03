package antlr;


import java.util.ArrayList;
import java.util.List;

import main.Domain;
import main.Problem;
import preconditions.NilPrecondition;
import preconditions.PreconditionAnd;
import preconditions.SimplePrecondition;
import tasks.Method;
import tasks.Operator;
import tasks.TaskInvoker;
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
import antlr.generated.JSHOP2Parser.ExpSubContext;
import antlr.generated.JSHOP2Parser.ExpTaskAtomContext;
import antlr.generated.JSHOP2Parser.ExpVoidContext;
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
		//Number term
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
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void exitTermH(TermHContext ctx) {
		//TermList term
		//ctx._term = ctx.term_list()._termList;
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void exitTerms(TermsContext ctx) {
		List<Term> terms= new ArrayList<Term>();
		for (TermContext tc:ctx.term())
			if (!(tc._term instanceof NilTerm)) terms.add(tc._term);
		
		ctx._terms = terms;
	}
	
	@Override
	public void exitLogical_atom(Logical_atomContext ctx) {
		/*
		 * Pensar como hacer las protection condition para que puedan tener un logical atom
		 * o una variable.
		 * si es una variable se tendria que obtener su valor en runtime.
		 * acomodar las reglas en la gramatica respectivas a esto.
		 */
		
		
		LogicalAtom la = new LogicalAtom(ctx.predicate().getText());
		for (Term term:ctx.terms()._terms)
			la.addTerm(term);
		
		ctx._logicalAtom = la;
	}

	@Override
	public void exitList_head(List_headContext ctx) {
		//ctx._listHeadPointer = new ListHeadPointer(ctx.head._variable,ctx.list._variable);
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void exitTerm_list(Term_listContext ctx) {
		ctx._termList = ctx.terms()._terms;
	}
	
	/*
	 * Logical_Expression
	 */

	@Override
	public void exitExpAnd(ExpAndContext ctx) {
		ctx._precondition = new PreconditionAnd(ctx.expA._precondition,ctx.expB._precondition);
	}

	@Override
	public void exitExpAndNot(ExpAndNotContext ctx) {
		//ctx._precondition = new PreconditionAndNot(ctx.expA._precondition,ctx.expB._precondition);
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void exitExpVoid(ExpVoidContext ctx) {
		ctx._precondition = new NilPrecondition();
	}
	
	@Override
	public void exitExpSub(ExpSubContext ctx) {
		ctx._precondition = ctx.logical_expression()._precondition;
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
		ctx._precondition = new NilPrecondition();
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
		throw new UnsupportedOperationException();
	}
	
	/*
	 * 
	 */
	
	/*
	 * Tasks
	 */
	
	@Override
	public void exitOperator(OperatorContext ctx) {
		Variable[] variables = new Variable[ctx.primitive_task_atom().terms()._terms.size()];
		for (int i=0;i<variables.length;i++)
			variables[i] = (Variable) ctx.primitive_task_atom().terms()._terms.get(i);
		
		Operator operator = new Operator (ctx.primitive_task_atom().primitive_task().getText(), variables);
		
		operator.setPrecondition(ctx.logical_precondition()._precondition);
		
		for (Term p:ctx.deleteList._termList)
			operator.addToDelList(p);
		for (Term p:ctx.addList._termList)
			operator.addToAddList(p);
		
		Domain.put(operator);
	}
	
	@Override
	public void exitTask_atom(Task_atomContext ctx) {
		Variable[] variables = new Variable[ctx.terms()._terms.size()];
		for (int i=0;i<variables.length;i++)
			variables[i] = (Variable) ctx.terms()._terms.get(i);
		
		ctx._taskInvoker = new TaskInvoker(ctx.task().getText(), variables);
	}

	@Override
	public void exitTask_list_A(Task_list_AContext ctx) {
		//NIL tasks list
		ctx._tasksInvokers = new ArrayList<TaskInvoker>();
	}

	@Override
	public void exitTask_list_B(Task_list_BContext ctx) {
		//Single task atom
		ctx._tasksInvokers = new ArrayList<TaskInvoker>();
		ctx._tasksInvokers.add(ctx.task_atom()._taskInvoker);
	}
	
	@Override
	public void exitTask_list_C(Task_list_CContext ctx) {
		ctx._tasksInvokers = new ArrayList<TaskInvoker>();
		for (Task_atomContext c:ctx.task_atom())
			ctx._tasksInvokers.add(c._taskInvoker);
	}

	@Override
	public void exitMethod(MethodContext ctx) {
		for (int i=0; i<ctx.logical_precondition().size(); i++){
			Variable[] variables = new Variable[ctx.compound_task_atom().terms()._terms.size()];
			for (int j=0;j<variables.length;j++)
				variables[j] = (Variable) ctx.compound_task_atom().terms()._terms.get(j);
			
			Method method = new Method(ctx.compound_task_atom().compound_task().getText(), variables);

			method.setPrecondition(ctx.logical_precondition(i)._precondition);
			
			for (TaskInvoker task:ctx.task_list(i)._tasksInvokers)
				method.addTask(task);
			
			Domain.put(method);
		}
	}
	
	/*
	 * 
	 */
	
	public void exitDomain(JSHOP2Parser.DomainContext ctx) {
	}
	
	@Override
	public void exitProblem(ProblemContext ctx) {
		Problem.setName(ctx.problemName.getText());
	}
	
	@Override
	public void exitGoals(GoalsContext ctx) {		
		for (Compound_task_atomContext task:ctx.compound_task_atom()){
			ArrayList<Term> list = new ArrayList<>(task.terms()._terms);
			String[] params = new String[list.size()];
			for (int i=0;i<params.length;i++)
				params[i]=list.get(i).toString();
			
			Domain.invoke(task.compound_task().getText(), params);
		}
	}
	
	@Override
	public void exitInitial_state(Initial_stateContext ctx) {
		for (Logical_atomContext logicalAtom:ctx.logical_atom())
			Problem.addState(logicalAtom._logicalAtom);
	}
}
