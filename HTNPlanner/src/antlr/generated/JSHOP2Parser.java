// Generated from JSHOP2.g4 by ANTLR 4.2.2

package antlr.generated;
	
import java.util.Collection;
import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import preconditions.LogicalPrecondition;
import tasks.Method;
import tasks.Operator;
import tasks.TaskInvoker;
import terms.LogicalAtom;
import terms.Term;
import terms.Variable;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSHOP2Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__30=1, T__29=2, T__28=3, T__27=4, T__26=5, T__25=6, T__24=7, T__23=8, 
		T__22=9, T__21=10, T__20=11, T__19=12, T__18=13, T__17=14, T__16=15, T__15=16, 
		T__14=17, T__13=18, T__12=19, T__11=20, T__10=21, T__9=22, T__8=23, T__7=24, 
		T__6=25, T__5=26, T__4=27, T__3=28, T__2=29, T__1=30, T__0=31, COMMENT=32, 
		WS=33, NIL=34, SYMBOL=35, NUMBER=36;
	public static final String[] tokenNames = {
		"<INVALID>", "'Defdomain'", "':sort-by'", "'Defproblem'", "'-'", "'*'", 
		"'not'", "'('", "'<'", "':method'", "'!='", "':unordered'", "':operator'", 
		"':first'", "'<='", "'?'", "'defproblem'", "'and'", "'^'", "'.'", "')'", 
		"':-'", "'+'", "'='", "'defdomain'", "':protection'", "'>'", "'call'", 
		"':immediate'", "'/'", "'>='", "'!'", "COMMENT", "WS", "'nil'", "SYMBOL", 
		"NUMBER"
	};
	public static final int
		RULE_program = 0, RULE_domain = 1, RULE_item = 2, RULE_method = 3, RULE_operator = 4, 
		RULE_protection_condition = 5, RULE_compound_task_atom = 6, RULE_primitive_task_atom = 7, 
		RULE_task_list = 8, RULE_task_atom = 9, RULE_task = 10, RULE_axiom = 11, 
		RULE_logical_precondition = 12, RULE_first_satisfier_pre = 13, RULE_sorted_pre = 14, 
		RULE_logical_expression = 15, RULE_logical_atom = 16, RULE_terms = 17, 
		RULE_term_list = 18, RULE_list_head = 19, RULE_term = 20, RULE_call_term = 21, 
		RULE_variable = 22, RULE_primitive_task = 23, RULE_predicate = 24, RULE_compound_task = 25, 
		RULE_java_function = 26, RULE_java_class = 27, RULE_name = 28, RULE_shop2_function = 29, 
		RULE_shop2_comparator = 30, RULE_problem = 31, RULE_initial_state = 32, 
		RULE_goals = 33;
	public static final String[] ruleNames = {
		"program", "domain", "item", "method", "operator", "protection_condition", 
		"compound_task_atom", "primitive_task_atom", "task_list", "task_atom", 
		"task", "axiom", "logical_precondition", "first_satisfier_pre", "sorted_pre", 
		"logical_expression", "logical_atom", "terms", "term_list", "list_head", 
		"term", "call_term", "variable", "primitive_task", "predicate", "compound_task", 
		"java_function", "java_class", "name", "shop2_function", "shop2_comparator", 
		"problem", "initial_state", "goals"
	};

	@Override
	public String getGrammarFileName() { return "JSHOP2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSHOP2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DomainContext domain() {
			return getRuleContext(DomainContext.class,0);
		}
		public ProblemContext problem() {
			return getRuleContext(ProblemContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); domain();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); problem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DomainContext extends ParserRuleContext {
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public DomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDomain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDomain(this);
		}
	}

	public final DomainContext domain() throws RecognitionException {
		DomainContext _localctx = new DomainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_domain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(7);
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==24) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(74); name();
			setState(75); match(7);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76); item();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==7 );
			setState(81); match(20);
			setState(82); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public AxiomContext axiom() {
			return getRuleContext(AxiomContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(84); operator();
				}
				break;

			case 2:
				{
				setState(85); method();
				}
				break;

			case 3:
				{
				setState(86); axiom();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public Method _method;
		public Task_listContext task_list(int i) {
			return getRuleContext(Task_listContext.class,i);
		}
		public Logical_preconditionContext logical_precondition(int i) {
			return getRuleContext(Logical_preconditionContext.class,i);
		}
		public Compound_task_atomContext compound_task_atom() {
			return getRuleContext(Compound_task_atomContext.class,0);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<Logical_preconditionContext> logical_precondition() {
			return getRuleContexts(Logical_preconditionContext.class);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public List<Task_listContext> task_list() {
			return getRuleContexts(Task_listContext.class);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(7);
			setState(90); match(9);
			setState(91); compound_task_atom();
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				_la = _input.LA(1);
				if (_la==SYMBOL) {
					{
					setState(92); name();
					}
				}

				{
				setState(95); logical_precondition();
				}
				{
				setState(96); task_list();
				}
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << NIL) | (1L << SYMBOL))) != 0) );
			setState(102); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public Operator _operator;
		public Term_listContext deleteList;
		public Term_listContext addList;
		public TermContext cost;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Term_listContext term_list(int i) {
			return getRuleContext(Term_listContext.class,i);
		}
		public Primitive_task_atomContext primitive_task_atom() {
			return getRuleContext(Primitive_task_atomContext.class,0);
		}
		public Logical_preconditionContext logical_precondition() {
			return getRuleContext(Logical_preconditionContext.class,0);
		}
		public List<Term_listContext> term_list() {
			return getRuleContexts(Term_listContext.class);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(7);
			setState(105); match(12);
			setState(106); primitive_task_atom();
			setState(107); logical_precondition();
			setState(108); ((OperatorContext)_localctx).deleteList = term_list();
			setState(109); ((OperatorContext)_localctx).addList = term_list();
			setState(111);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 15) | (1L << NIL) | (1L << SYMBOL) | (1L << NUMBER))) != 0)) {
				{
				setState(110); ((OperatorContext)_localctx).cost = term();
				}
			}

			setState(113); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Protection_conditionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Logical_atomContext logical_atom() {
			return getRuleContext(Logical_atomContext.class,0);
		}
		public Protection_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protection_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterProtection_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitProtection_condition(this);
		}
	}

	public final Protection_conditionContext protection_condition() throws RecognitionException {
		Protection_conditionContext _localctx = new Protection_conditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_protection_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(7);
			setState(116); match(25);
			setState(119);
			switch (_input.LA(1)) {
			case 7:
				{
				setState(117); logical_atom();
				}
				break;
			case 15:
				{
				setState(118); variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(121); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_task_atomContext extends ParserRuleContext {
		public Compound_taskContext compound_task() {
			return getRuleContext(Compound_taskContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public Compound_task_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_task_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterCompound_task_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitCompound_task_atom(this);
		}
	}

	public final Compound_task_atomContext compound_task_atom() throws RecognitionException {
		Compound_task_atomContext _localctx = new Compound_task_atomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_task_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(7);
			setState(124); compound_task();
			setState(125); terms();
			setState(126); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_task_atomContext extends ParserRuleContext {
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public Primitive_taskContext primitive_task() {
			return getRuleContext(Primitive_taskContext.class,0);
		}
		public Primitive_task_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_task_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPrimitive_task_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPrimitive_task_atom(this);
		}
	}

	public final Primitive_task_atomContext primitive_task_atom() throws RecognitionException {
		Primitive_task_atomContext _localctx = new Primitive_task_atomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitive_task_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(7);
			setState(129); primitive_task();
			setState(130); terms();
			setState(131); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Task_listContext extends ParserRuleContext {
		public Collection<TaskInvoker> _tasksPointers;
		public Task_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task_list; }
	 
		public Task_listContext() { }
		public void copyFrom(Task_listContext ctx) {
			super.copyFrom(ctx);
			this._tasksPointers = ctx._tasksPointers;
		}
	}
	public static class Task_list_CContext extends Task_listContext {
		public Task_atomContext task_atom(int i) {
			return getRuleContext(Task_atomContext.class,i);
		}
		public List<Task_atomContext> task_atom() {
			return getRuleContexts(Task_atomContext.class);
		}
		public Task_list_CContext(Task_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTask_list_C(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTask_list_C(this);
		}
	}
	public static class Task_list_AContext extends Task_listContext {
		public TerminalNode NIL() { return getToken(JSHOP2Parser.NIL, 0); }
		public Task_list_AContext(Task_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTask_list_A(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTask_list_A(this);
		}
	}
	public static class Task_list_BContext extends Task_listContext {
		public Task_atomContext task_atom() {
			return getRuleContext(Task_atomContext.class,0);
		}
		public Task_list_BContext(Task_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTask_list_B(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTask_list_B(this);
		}
	}

	public final Task_listContext task_list() throws RecognitionException {
		Task_listContext _localctx = new Task_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_task_list);
		int _la;
		try {
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new Task_list_AContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(NIL);
				}
				break;

			case 2:
				_localctx = new Task_list_BContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134); task_atom();
				}
				break;

			case 3:
				_localctx = new Task_list_CContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135); match(7);
				setState(137);
				_la = _input.LA(1);
				if (_la==11) {
					{
					setState(136); match(11);
					}
				}

				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==7) {
					{
					{
					setState(139); task_atom();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145); match(20);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Task_atomContext extends ParserRuleContext {
		public TaskInvoker _taskPointer;
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TaskContext task() {
			return getRuleContext(TaskContext.class,0);
		}
		public Task_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTask_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTask_atom(this);
		}
	}

	public final Task_atomContext task_atom() throws RecognitionException {
		Task_atomContext _localctx = new Task_atomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_task_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(7);
			setState(150);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(149); match(28);
				}
			}

			setState(152); task();
			setState(153); terms();
			setState(154); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TaskContext extends ParserRuleContext {
		public Compound_taskContext compound_task() {
			return getRuleContext(Compound_taskContext.class,0);
		}
		public Primitive_taskContext primitive_task() {
			return getRuleContext(Primitive_taskContext.class,0);
		}
		public TaskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTask(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTask(this);
		}
	}

	public final TaskContext task() throws RecognitionException {
		TaskContext _localctx = new TaskContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_task);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			switch (_input.LA(1)) {
			case 31:
				{
				setState(156); primitive_task();
				}
				break;
			case SYMBOL:
				{
				setState(157); compound_task();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AxiomContext extends ParserRuleContext {
		public LogicalPrecondition _axiom;
		public Logical_preconditionContext logical_precondition(int i) {
			return getRuleContext(Logical_preconditionContext.class,i);
		}
		public List<Logical_preconditionContext> logical_precondition() {
			return getRuleContexts(Logical_preconditionContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public Logical_atomContext logical_atom() {
			return getRuleContext(Logical_atomContext.class,0);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public AxiomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axiom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAxiom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAxiom(this);
		}
	}

	public final AxiomContext axiom() throws RecognitionException {
		AxiomContext _localctx = new AxiomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_axiom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(7);
			setState(161); match(21);
			setState(162); logical_atom();
			setState(165);
			switch (_input.LA(1)) {
			case SYMBOL:
				{
				setState(163); name();
				}
				break;
			case 7:
			case NIL:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167); logical_precondition();
				setState(170);
				switch (_input.LA(1)) {
				case SYMBOL:
					{
					setState(168); name();
					}
					break;
				case 7:
				case 20:
				case NIL:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==7 || _la==NIL );
			setState(176); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_preconditionContext extends ParserRuleContext {
		public LogicalPrecondition _precondition;
		public Logical_preconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_precondition; }
	 
		public Logical_preconditionContext() { }
		public void copyFrom(Logical_preconditionContext ctx) {
			super.copyFrom(ctx);
			this._precondition = ctx._precondition;
		}
	}
	public static class Logical_precondition_AContext extends Logical_preconditionContext {
		public TerminalNode NIL() { return getToken(JSHOP2Parser.NIL, 0); }
		public Logical_precondition_AContext(Logical_preconditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterLogical_precondition_A(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitLogical_precondition_A(this);
		}
	}
	public static class Logical_precondition_BContext extends Logical_preconditionContext {
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public Logical_precondition_BContext(Logical_preconditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterLogical_precondition_B(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitLogical_precondition_B(this);
		}
	}
	public static class Logical_precondition_CContext extends Logical_preconditionContext {
		public First_satisfier_preContext first_satisfier_pre() {
			return getRuleContext(First_satisfier_preContext.class,0);
		}
		public Logical_precondition_CContext(Logical_preconditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterLogical_precondition_C(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitLogical_precondition_C(this);
		}
	}
	public static class Logical_precondition_DContext extends Logical_preconditionContext {
		public Sorted_preContext sorted_pre() {
			return getRuleContext(Sorted_preContext.class,0);
		}
		public Logical_precondition_DContext(Logical_preconditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterLogical_precondition_D(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitLogical_precondition_D(this);
		}
	}

	public final Logical_preconditionContext logical_precondition() throws RecognitionException {
		Logical_preconditionContext _localctx = new Logical_preconditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logical_precondition);
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Logical_precondition_AContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178); match(NIL);
				}
				break;

			case 2:
				_localctx = new Logical_precondition_BContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179); logical_expression(0);
				}
				break;

			case 3:
				_localctx = new Logical_precondition_CContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(180); first_satisfier_pre();
				}
				break;

			case 4:
				_localctx = new Logical_precondition_DContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(181); sorted_pre();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class First_satisfier_preContext extends ParserRuleContext {
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public First_satisfier_preContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_satisfier_pre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterFirst_satisfier_pre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitFirst_satisfier_pre(this);
		}
	}

	public final First_satisfier_preContext first_satisfier_pre() throws RecognitionException {
		First_satisfier_preContext _localctx = new First_satisfier_preContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_first_satisfier_pre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(7);
			setState(185); match(13);
			setState(186); logical_expression(0);
			setState(187); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sorted_preContext extends ParserRuleContext {
		public Shop2_comparatorContext shop2_comparator() {
			return getRuleContext(Shop2_comparatorContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public Java_classContext java_class() {
			return getRuleContext(Java_classContext.class,0);
		}
		public Sorted_preContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sorted_pre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterSorted_pre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitSorted_pre(this);
		}
	}

	public final Sorted_preContext sorted_pre() throws RecognitionException {
		Sorted_preContext _localctx = new Sorted_preContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sorted_pre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(7);
			setState(190); match(2);
			setState(191); variable();
			setState(194);
			switch (_input.LA(1)) {
			case SYMBOL:
				{
				setState(192); java_class();
				}
				break;
			case 8:
			case 26:
				{
				setState(193); shop2_comparator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(196); logical_expression(0);
			setState(197); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_expressionContext extends ParserRuleContext {
		public LogicalPrecondition _precondition;
		public Logical_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expression; }
	 
		public Logical_expressionContext() { }
		public void copyFrom(Logical_expressionContext ctx) {
			super.copyFrom(ctx);
			this._precondition = ctx._precondition;
		}
	}
	public static class ExpVoidContext extends Logical_expressionContext {
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public ExpVoidContext(Logical_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExpVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExpVoid(this);
		}
	}
	public static class ExpAtomContext extends Logical_expressionContext {
		public Logical_atomContext logical_atom() {
			return getRuleContext(Logical_atomContext.class,0);
		}
		public ExpAtomContext(Logical_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExpAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExpAtom(this);
		}
	}
	public static class ExpAndNotContext extends Logical_expressionContext {
		public Logical_expressionContext expA;
		public Logical_expressionContext expB;
		public List<Logical_expressionContext> logical_expression() {
			return getRuleContexts(Logical_expressionContext.class);
		}
		public Logical_expressionContext logical_expression(int i) {
			return getRuleContext(Logical_expressionContext.class,i);
		}
		public ExpAndNotContext(Logical_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExpAndNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExpAndNot(this);
		}
	}
	public static class ExpAndContext extends Logical_expressionContext {
		public Logical_expressionContext expA;
		public Logical_expressionContext expB;
		public List<Logical_expressionContext> logical_expression() {
			return getRuleContexts(Logical_expressionContext.class);
		}
		public Logical_expressionContext logical_expression(int i) {
			return getRuleContext(Logical_expressionContext.class,i);
		}
		public ExpAndContext(Logical_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExpAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExpAnd(this);
		}
	}
	public static class ExpTaskAtomContext extends Logical_expressionContext {
		public Task_atomContext task_atom() {
			return getRuleContext(Task_atomContext.class,0);
		}
		public ExpTaskAtomContext(Logical_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExpTaskAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExpTaskAtom(this);
		}
	}

	public final Logical_expressionContext logical_expression() throws RecognitionException {
		return logical_expression(0);
	}

	private Logical_expressionContext logical_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_expressionContext _localctx = new Logical_expressionContext(_ctx, _parentState);
		Logical_expressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_logical_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new ExpVoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(200); match(7);
				setState(202);
				_la = _input.LA(1);
				if (_la==7) {
					{
					setState(201); logical_expression(0);
					}
				}

				setState(204); match(20);
				}
				break;

			case 2:
				{
				_localctx = new ExpAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205); logical_atom();
				}
				break;

			case 3:
				{
				_localctx = new ExpTaskAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206); task_atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpAndContext(new Logical_expressionContext(_parentctx, _parentState));
						((ExpAndContext)_localctx).expA = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expression);
						setState(209);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(211);
						_la = _input.LA(1);
						if (_la==17) {
							{
							setState(210); match(17);
							}
						}

						setState(213); ((ExpAndContext)_localctx).expB = logical_expression(6);
						}
						break;

					case 2:
						{
						_localctx = new ExpAndNotContext(new Logical_expressionContext(_parentctx, _parentState));
						((ExpAndNotContext)_localctx).expA = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expression);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(216);
						_la = _input.LA(1);
						if (_la==17) {
							{
							setState(215); match(17);
							}
						}

						setState(218); match(7);
						setState(219); match(6);
						setState(220); ((ExpAndNotContext)_localctx).expB = logical_expression(0);
						setState(221); match(20);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Logical_atomContext extends ParserRuleContext {
		public LogicalAtom _logicalAtom;
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Logical_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterLogical_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitLogical_atom(this);
		}
	}

	public final Logical_atomContext logical_atom() throws RecognitionException {
		Logical_atomContext _localctx = new Logical_atomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logical_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(7);
			setState(229); predicate();
			setState(230); terms();
			setState(231); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermsContext extends ParserRuleContext {
		public Collection<Term> _terms;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerms(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 15) | (1L << NIL) | (1L << SYMBOL) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(233); term();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Term_listContext extends ParserRuleContext {
		public List<Term> _termList;
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public Term_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_list(this);
		}
	}

	public final Term_listContext term_list() throws RecognitionException {
		Term_listContext _localctx = new Term_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_term_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(7);
			setState(240); terms();
			setState(241); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_headContext extends ParserRuleContext {
		public VariableContext head;
		public VariableContext list;
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List_headContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterList_head(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitList_head(this);
		}
	}

	public final List_headContext list_head() throws RecognitionException {
		List_headContext _localctx = new List_headContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(7);
			setState(244); ((List_headContext)_localctx).head = variable();
			setState(245); match(19);
			setState(246); ((List_headContext)_localctx).list = variable();
			setState(247); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Term _term;
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
			this._term = ctx._term;
		}
	}
	public static class TermHContext extends TermContext {
		public Term_listContext term_list() {
			return getRuleContext(Term_listContext.class,0);
		}
		public TermHContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermH(this);
		}
	}
	public static class TermDContext extends TermContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TermDContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermD(this);
		}
	}
	public static class TermEContext extends TermContext {
		public Call_termContext call_term() {
			return getRuleContext(Call_termContext.class,0);
		}
		public TermEContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermE(this);
		}
	}
	public static class TermFContext extends TermContext {
		public Logical_atomContext logical_atom() {
			return getRuleContext(Logical_atomContext.class,0);
		}
		public TermFContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermF(this);
		}
	}
	public static class TermGContext extends TermContext {
		public List_headContext list_head() {
			return getRuleContext(List_headContext.class,0);
		}
		public TermGContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermG(this);
		}
	}
	public static class TermAContext extends TermContext {
		public TerminalNode NIL() { return getToken(JSHOP2Parser.NIL, 0); }
		public TermAContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermA(this);
		}
	}
	public static class TermBContext extends TermContext {
		public TerminalNode NUMBER() { return getToken(JSHOP2Parser.NUMBER, 0); }
		public TermBContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermB(this);
		}
	}
	public static class TermCContext extends TermContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public TermCContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTermC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTermC(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		try {
			setState(257);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new TermAContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249); match(NIL);
				}
				break;

			case 2:
				_localctx = new TermBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(250); match(NUMBER);
				}
				break;

			case 3:
				_localctx = new TermCContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(251); match(SYMBOL);
				}
				break;

			case 4:
				_localctx = new TermDContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252); variable();
				}
				break;

			case 5:
				_localctx = new TermEContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(253); call_term();
				}
				break;

			case 6:
				_localctx = new TermFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(254); logical_atom();
				}
				break;

			case 7:
				_localctx = new TermGContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(255); list_head();
				}
				break;

			case 8:
				_localctx = new TermHContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(256); term_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_termContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public Java_functionContext java_function() {
			return getRuleContext(Java_functionContext.class,0);
		}
		public Shop2_functionContext shop2_function() {
			return getRuleContext(Shop2_functionContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Call_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterCall_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitCall_term(this);
		}
	}

	public final Call_termContext call_term() throws RecognitionException {
		Call_termContext _localctx = new Call_termContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_call_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(7);
			setState(260); match(27);
			setState(263);
			switch (_input.LA(1)) {
			case 4:
			case 5:
			case 8:
			case 10:
			case 14:
			case 18:
			case 22:
			case 23:
			case 26:
			case 29:
			case 30:
				{
				setState(261); shop2_function();
				}
				break;
			case SYMBOL:
				{
				setState(262); java_function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(266); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(265); term();
				}
				}
				setState(268); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 15) | (1L << NIL) | (1L << SYMBOL) | (1L << NUMBER))) != 0) );
			setState(270); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Variable _variable;
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(15);
			setState(273); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_taskContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public Primitive_taskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_task; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPrimitive_task(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPrimitive_task(this);
		}
	}

	public final Primitive_taskContext primitive_task() throws RecognitionException {
		Primitive_taskContext _localctx = new Primitive_taskContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primitive_task);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(275); match(31);
				}
				break;
			}
			setState(278); match(31);
			setState(279); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_taskContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public Compound_taskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_task; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterCompound_task(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitCompound_task(this);
		}
	}

	public final Compound_taskContext compound_task() throws RecognitionException {
		Compound_taskContext _localctx = new Compound_taskContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_compound_task);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Java_functionContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public Java_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_java_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterJava_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitJava_function(this);
		}
	}

	public final Java_functionContext java_function() throws RecognitionException {
		Java_functionContext _localctx = new Java_functionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_java_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Java_classContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public Java_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_java_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterJava_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitJava_class(this);
		}
	}

	public final Java_classContext java_class() throws RecognitionException {
		Java_classContext _localctx = new Java_classContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_java_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(JSHOP2Parser.SYMBOL, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shop2_functionContext extends ParserRuleContext {
		public Shop2_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shop2_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterShop2_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitShop2_function(this);
		}
	}

	public final Shop2_functionContext shop2_function() throws RecognitionException {
		Shop2_functionContext _localctx = new Shop2_functionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_shop2_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 5) | (1L << 8) | (1L << 10) | (1L << 14) | (1L << 18) | (1L << 22) | (1L << 23) | (1L << 26) | (1L << 29) | (1L << 30))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shop2_comparatorContext extends ParserRuleContext {
		public Shop2_comparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shop2_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterShop2_comparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitShop2_comparator(this);
		}
	}

	public final Shop2_comparatorContext shop2_comparator() throws RecognitionException {
		Shop2_comparatorContext _localctx = new Shop2_comparatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_shop2_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==26) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProblemContext extends ParserRuleContext {
		public NameContext problemName;
		public NameContext domainName;
		public Initial_stateContext initial_state(int i) {
			return getRuleContext(Initial_stateContext.class,i);
		}
		public List<GoalsContext> goals() {
			return getRuleContexts(GoalsContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public GoalsContext goals(int i) {
			return getRuleContext(GoalsContext.class,i);
		}
		public List<Initial_stateContext> initial_state() {
			return getRuleContexts(Initial_stateContext.class);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public ProblemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_problem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterProblem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitProblem(this);
		}
	}

	public final ProblemContext problem() throws RecognitionException {
		ProblemContext _localctx = new ProblemContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_problem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); match(7);
			setState(296);
			_la = _input.LA(1);
			if ( !(_la==3 || _la==16) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(297); ((ProblemContext)_localctx).problemName = name();
			setState(298); ((ProblemContext)_localctx).domainName = name();
			setState(302); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(299); initial_state();
				setState(300); goals();
				}
				}
				setState(304); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==7 );
			setState(306); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initial_stateContext extends ParserRuleContext {
		public Logical_atomContext logical_atom(int i) {
			return getRuleContext(Logical_atomContext.class,i);
		}
		public List<Logical_atomContext> logical_atom() {
			return getRuleContexts(Logical_atomContext.class);
		}
		public Initial_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterInitial_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitInitial_state(this);
		}
	}

	public final Initial_stateContext initial_state() throws RecognitionException {
		Initial_stateContext _localctx = new Initial_stateContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_initial_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(7);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==7) {
				{
				{
				setState(309); logical_atom();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GoalsContext extends ParserRuleContext {
		public List<Compound_task_atomContext> compound_task_atom() {
			return getRuleContexts(Compound_task_atomContext.class);
		}
		public Compound_task_atomContext compound_task_atom(int i) {
			return getRuleContext(Compound_task_atomContext.class,i);
		}
		public GoalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterGoals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitGoals(this);
		}
	}

	public final GoalsContext goals() throws RecognitionException {
		GoalsContext _localctx = new GoalsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_goals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(7);
			setState(319);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(318); match(11);
				}
			}

			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==7) {
				{
				{
				setState(321); compound_task_atom();
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(327); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15: return logical_expression_sempred((Logical_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_expression_sempred(Logical_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 5);

		case 1: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u014c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\5\2I\n\2\3\3\3\3\3\3\3\3\3\3\6\3P\n\3\r\3\16"+
		"\3Q\3\3\3\3\3\3\3\4\3\4\3\4\5\4Z\n\4\3\5\3\5\3\5\3\5\5\5`\n\5\3\5\3\5"+
		"\3\5\6\5e\n\5\r\5\16\5f\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6r\n\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\5\7z\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\7\n\u008f\n\n\f\n\16\n\u0092"+
		"\13\n\3\n\5\n\u0095\n\n\3\13\3\13\5\13\u0099\n\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\r\3\r\3\r\5"+
		"\r\u00ad\n\r\6\r\u00af\n\r\r\r\16\r\u00b0\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\5\16\u00b9\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00c5\n\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u00cd\n\21\3\21\3\21\3"+
		"\21\5\21\u00d2\n\21\3\21\3\21\5\21\u00d6\n\21\3\21\3\21\3\21\5\21\u00db"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u00e2\n\21\f\21\16\21\u00e5\13\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\7\23\u00ed\n\23\f\23\16\23\u00f0\13\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0104\n\26\3\27\3\27\3\27\3\27\5\27\u010a\n"+
		"\27\3\27\6\27\u010d\n\27\r\27\16\27\u010e\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\5\31\u0117\n\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\6!\u0131\n!\r!\16!\u0132"+
		"\3!\3!\3\"\3\"\7\"\u0139\n\"\f\"\16\"\u013c\13\"\3\"\3\"\3#\3#\5#\u0142"+
		"\n#\3#\7#\u0145\n#\f#\16#\u0148\13#\3#\3#\3#\2\3 $\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\6\4\2\3\3\32\32\n\2\6"+
		"\7\n\n\f\f\20\20\24\24\30\31\34\34\37 \4\2\n\n\34\34\4\2\5\5\22\22\u0154"+
		"\2H\3\2\2\2\4J\3\2\2\2\6Y\3\2\2\2\b[\3\2\2\2\nj\3\2\2\2\fu\3\2\2\2\16"+
		"}\3\2\2\2\20\u0082\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u00a0"+
		"\3\2\2\2\30\u00a2\3\2\2\2\32\u00b8\3\2\2\2\34\u00ba\3\2\2\2\36\u00bf\3"+
		"\2\2\2 \u00d1\3\2\2\2\"\u00e6\3\2\2\2$\u00ee\3\2\2\2&\u00f1\3\2\2\2(\u00f5"+
		"\3\2\2\2*\u0103\3\2\2\2,\u0105\3\2\2\2.\u0112\3\2\2\2\60\u0116\3\2\2\2"+
		"\62\u011b\3\2\2\2\64\u011d\3\2\2\2\66\u011f\3\2\2\28\u0121\3\2\2\2:\u0123"+
		"\3\2\2\2<\u0125\3\2\2\2>\u0127\3\2\2\2@\u0129\3\2\2\2B\u0136\3\2\2\2D"+
		"\u013f\3\2\2\2FI\5\4\3\2GI\5@!\2HF\3\2\2\2HG\3\2\2\2I\3\3\2\2\2JK\7\t"+
		"\2\2KL\t\2\2\2LM\5:\36\2MO\7\t\2\2NP\5\6\4\2ON\3\2\2\2PQ\3\2\2\2QO\3\2"+
		"\2\2QR\3\2\2\2RS\3\2\2\2ST\7\26\2\2TU\7\26\2\2U\5\3\2\2\2VZ\5\n\6\2WZ"+
		"\5\b\5\2XZ\5\30\r\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\7\3\2\2\2[\\\7\t\2"+
		"\2\\]\7\13\2\2]d\5\16\b\2^`\5:\36\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5"+
		"\32\16\2bc\5\22\n\2ce\3\2\2\2d_\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hi\7\26\2\2i\t\3\2\2\2jk\7\t\2\2kl\7\16\2\2lm\5\20\t\2mn\5\32"+
		"\16\2no\5&\24\2oq\5&\24\2pr\5*\26\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7"+
		"\26\2\2t\13\3\2\2\2uv\7\t\2\2vy\7\33\2\2wz\5\"\22\2xz\5.\30\2yw\3\2\2"+
		"\2yx\3\2\2\2z{\3\2\2\2{|\7\26\2\2|\r\3\2\2\2}~\7\t\2\2~\177\5\64\33\2"+
		"\177\u0080\5$\23\2\u0080\u0081\7\26\2\2\u0081\17\3\2\2\2\u0082\u0083\7"+
		"\t\2\2\u0083\u0084\5\60\31\2\u0084\u0085\5$\23\2\u0085\u0086\7\26\2\2"+
		"\u0086\21\3\2\2\2\u0087\u0095\7$\2\2\u0088\u0095\5\24\13\2\u0089\u008b"+
		"\7\t\2\2\u008a\u008c\7\r\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u0090\3\2\2\2\u008d\u008f\5\24\13\2\u008e\u008d\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0095\7\26\2\2\u0094\u0087\3\2\2\2\u0094\u0088\3"+
		"\2\2\2\u0094\u0089\3\2\2\2\u0095\23\3\2\2\2\u0096\u0098\7\t\2\2\u0097"+
		"\u0099\7\36\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u009b\5\26\f\2\u009b\u009c\5$\23\2\u009c\u009d\7\26\2\2\u009d"+
		"\25\3\2\2\2\u009e\u00a1\5\60\31\2\u009f\u00a1\5\64\33\2\u00a0\u009e\3"+
		"\2\2\2\u00a0\u009f\3\2\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\7\t\2\2\u00a3"+
		"\u00a4\7\27\2\2\u00a4\u00a7\5\"\22\2\u00a5\u00a8\5:\36\2\u00a6\u00a8\3"+
		"\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ae\3\2\2\2\u00a9"+
		"\u00ac\5\32\16\2\u00aa\u00ad\5:\36\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\7\26\2\2\u00b3\31\3\2\2\2\u00b4\u00b9\7$\2\2\u00b5\u00b9"+
		"\5 \21\2\u00b6\u00b9\5\34\17\2\u00b7\u00b9\5\36\20\2\u00b8\u00b4\3\2\2"+
		"\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\33"+
		"\3\2\2\2\u00ba\u00bb\7\t\2\2\u00bb\u00bc\7\17\2\2\u00bc\u00bd\5 \21\2"+
		"\u00bd\u00be\7\26\2\2\u00be\35\3\2\2\2\u00bf\u00c0\7\t\2\2\u00c0\u00c1"+
		"\7\4\2\2\u00c1\u00c4\5.\30\2\u00c2\u00c5\58\35\2\u00c3\u00c5\5> \2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\5 "+
		"\21\2\u00c7\u00c8\7\26\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\b\21\1\2\u00ca"+
		"\u00cc\7\t\2\2\u00cb\u00cd\5 \21\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d2\7\26\2\2\u00cf\u00d2\5\"\22\2\u00d0"+
		"\u00d2\5\24\13\2\u00d1\u00c9\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3"+
		"\2\2\2\u00d2\u00e3\3\2\2\2\u00d3\u00d5\f\7\2\2\u00d4\u00d6\7\23\2\2\u00d5"+
		"\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e2\5 "+
		"\21\b\u00d8\u00da\f\6\2\2\u00d9\u00db\7\23\2\2\u00da\u00d9\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\t\2\2\u00dd\u00de\7\b"+
		"\2\2\u00de\u00df\5 \21\2\u00df\u00e0\7\26\2\2\u00e0\u00e2\3\2\2\2\u00e1"+
		"\u00d3\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4!\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7"+
		"\7\t\2\2\u00e7\u00e8\5\62\32\2\u00e8\u00e9\5$\23\2\u00e9\u00ea\7\26\2"+
		"\2\u00ea#\3\2\2\2\u00eb\u00ed\5*\26\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef%\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f2\7\t\2\2\u00f2\u00f3\5$\23\2\u00f3\u00f4\7\26"+
		"\2\2\u00f4\'\3\2\2\2\u00f5\u00f6\7\t\2\2\u00f6\u00f7\5.\30\2\u00f7\u00f8"+
		"\7\25\2\2\u00f8\u00f9\5.\30\2\u00f9\u00fa\7\26\2\2\u00fa)\3\2\2\2\u00fb"+
		"\u0104\7$\2\2\u00fc\u0104\7&\2\2\u00fd\u0104\7%\2\2\u00fe\u0104\5.\30"+
		"\2\u00ff\u0104\5,\27\2\u0100\u0104\5\"\22\2\u0101\u0104\5(\25\2\u0102"+
		"\u0104\5&\24\2\u0103\u00fb\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u00fd\3\2"+
		"\2\2\u0103\u00fe\3\2\2\2\u0103\u00ff\3\2\2\2\u0103\u0100\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104+\3\2\2\2\u0105\u0106\7\t\2\2"+
		"\u0106\u0109\7\35\2\2\u0107\u010a\5<\37\2\u0108\u010a\5\66\34\2\u0109"+
		"\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u010d\5*"+
		"\26\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\26\2\2\u0111-\3\2\2\2"+
		"\u0112\u0113\7\21\2\2\u0113\u0114\7%\2\2\u0114/\3\2\2\2\u0115\u0117\7"+
		"!\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\7!\2\2\u0119\u011a\7%\2\2\u011a\61\3\2\2\2\u011b\u011c\7%\2\2\u011c"+
		"\63\3\2\2\2\u011d\u011e\7%\2\2\u011e\65\3\2\2\2\u011f\u0120\7%\2\2\u0120"+
		"\67\3\2\2\2\u0121\u0122\7%\2\2\u01229\3\2\2\2\u0123\u0124\7%\2\2\u0124"+
		";\3\2\2\2\u0125\u0126\t\3\2\2\u0126=\3\2\2\2\u0127\u0128\t\4\2\2\u0128"+
		"?\3\2\2\2\u0129\u012a\7\t\2\2\u012a\u012b\t\5\2\2\u012b\u012c\5:\36\2"+
		"\u012c\u0130\5:\36\2\u012d\u012e\5B\"\2\u012e\u012f\5D#\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012d\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\7\26\2\2\u0135A\3\2\2\2"+
		"\u0136\u013a\7\t\2\2\u0137\u0139\5\"\22\2\u0138\u0137\3\2\2\2\u0139\u013c"+
		"\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u013e\7\26\2\2\u013eC\3\2\2\2\u013f\u0141\7\t\2\2"+
		"\u0140\u0142\7\r\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0146"+
		"\3\2\2\2\u0143\u0145\5\16\b\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2"+
		"\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0149\u014a\7\26\2\2\u014aE\3\2\2\2\"HQY_fqy\u008b\u0090\u0094"+
		"\u0098\u00a0\u00a7\u00ac\u00b0\u00b8\u00c4\u00cc\u00d1\u00d5\u00da\u00e1"+
		"\u00e3\u00ee\u0103\u0109\u010e\u0116\u0132\u013a\u0141\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}