package hardcoded;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr.generated.JSHOP2Lexer;
import antlr.generated.JSHOP2Parser;

public class TrucksMain {

	public static void main(String[] args) throws Exception
	  {
		
		JSHOP2Parser problem = getParser("/trucks/problem02");
//		JSHOP2Parser problem = getParser("/trucks/problem20");
		
		long tiempo = System.currentTimeMillis();
		problem.problem();
		tiempo=System.currentTimeMillis()-tiempo;
		System.out.println();
		System.out.println("Tardo "+tiempo+"ms");
	  }
	
	private static JSHOP2Parser getParser(String problemID) throws Exception {
		String domainFile = "./problems/trucks/trucks";
		String problemFile = "./problems"+problemID;
		
	    JSHOP2Lexer domainLexer = new JSHOP2Lexer(new ANTLRFileStream(domainFile));
	    CommonTokenStream domainTokens = new CommonTokenStream(domainLexer);
	    JSHOP2Parser domainParser = new JSHOP2Parser(domainTokens);
	    domainParser.setBuildParseTree(true);
	    domainParser.addParseListener(new TrucksParser());
	    
		
	    JSHOP2Lexer problemLexer = new JSHOP2Lexer(new ANTLRFileStream(problemFile));
	    CommonTokenStream problemTokens = new CommonTokenStream(problemLexer);
	    JSHOP2Parser problemParser = new JSHOP2Parser(problemTokens);
	    problemParser.setBuildParseTree(true);
	    problemParser.addParseListener(new TrucksParser());
	    
	    return problemParser;
	}

}
