grammar JSHOP2;

@header
{
package antlr.generated;
	
import java.util.Collection;
import preconditions.*;
import terms.*;
import tasks.*;
}

program : domain | problem;


/*
* DOMAIN PARSER
*/

domain 			: '(' ('defdomain'|'Defdomain') name '(' (item)+ ')' ')';

item 			: (operator | method | axiom);

method returns [Method _method]: '(' ':method'
                compound_task_atom
                (name? (logical_precondition) (task_list))+
                ')';

operator returns [Operator _operator]: '(' ':operator'
		primitive_task_atom    
		logical_precondition
		deleteList=term_list
		addList=term_list
		cost=term?
		')';

protection_condition: '(' ':protection' (logical_atom | variable) ')';

compound_task_atom	: '(' compound_task terms ')';
primitive_task_atom	: '(' primitive_task terms ')'; //internal or common task

task_list returns [Collection<TaskInvoker> _tasksPointers]:
    NIL                                 #task_list_A
    |task_atom                          #task_list_B
    |'(' ':unordered'? task_atom*')'	#task_list_C
    ;

task_atom returns [TaskInvoker _taskPointer]: '(' ':immediate'? task terms ')';

task			: (primitive_task | compound_task);

axiom returns [LogicalPrecondition _axiom]: '(' ':-' logical_atom (name|) (logical_precondition (name|))+ ')';

logical_precondition returns [LogicalPrecondition _precondition]:
    NIL                     #logical_precondition_A
    |logical_expression     #logical_precondition_B
    |first_satisfier_pre    #logical_precondition_C
    |sorted_pre             #logical_precondition_D;

first_satisfier_pre	: '(' ':first' logical_expression ')';
sorted_pre		: '(' ':sort-by' variable (java_class|shop2_comparator) logical_expression ')';

logical_expression returns [LogicalPrecondition _precondition]:
	expA=logical_expression 'and'? expB=logical_expression					#expAnd
	| expA=logical_expression 'and'? '(' 'not' expB=logical_expression ')'	#expAndNot
	| '(' logical_expression? ')'											#expVoid			
	| logical_atom															#expAtom
	| task_atom																#expTaskAtom
	;

//simple_expression: logical_atom | task_atom;

logical_atom returns [LogicalAtom _logicalAtom]: '(' predicate terms ')';

terms returns [Collection<Term> _terms]: term*;

term_list returns [List<Term> _termList]: '(' terms ')';

list_head: '(' head=variable '.' list=variable ')';

term returns [Term _term] :
    NIL             #termA
    | NUMBER        #termB
    | SYMBOL        #termC
    | variable      #termD
    | call_term     #termE
    | logical_atom  #termF
    | list_head     #termG
    | term_list     #termH;

call_term : '(' 'call' (shop2_function | java_function) term+ ')';

variable returns [Variable _variable] : '?' SYMBOL;
primitive_task	: '!'? '!' SYMBOL;
predicate		: SYMBOL;
compound_task	: SYMBOL;
java_function 	: SYMBOL;
java_class		: SYMBOL;
name			: SYMBOL;
shop2_function 	: ('+' | '-' | '=' | '>' | '<' | '!=' | '<=' | '>=' | '^' | '*' | '/');
shop2_comparator: ('<' | '>');

/*
* PROBLEM PARSER
*/

problem: '(' ('defproblem' | 'Defproblem') problemName=name domainName=name (initial_state goals)+ ')';

initial_state: '(' logical_atom* ')';

//goal: task_list;

goals: '(' ':unordered'? compound_task_atom*')';


/*
* LEXER
*/

COMMENT     :   (';' .*? ('\r' | '\n')) -> skip;
WS     : [ \t\n\r]+ -> skip ;
NIL     : 'nil';

SYMBOL	: ('a'..'z' | '_' | 'A'..'Z') ('a'..'z' | '_' | '-' | 'A'..'Z' | '0'..'9')* ;
NUMBER  : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;