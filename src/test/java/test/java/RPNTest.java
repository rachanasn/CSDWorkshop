package test.java;

import junit.framework.TestCase;
import main.java.RPNCalculator;

import org.junit.Ignore;

public class RPNTest extends TestCase{
	
	public void test1(){
		String expr = "2,3,+";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("5", rpnCalculator.calculate(expr));
	}
	
	public void test2(){
		String expr = "3,3,+";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("6", rpnCalculator.calculate(expr));
	}
	
	public void test3(){
		String expr = "2";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("Length should be equal to 2 or more than 2", rpnCalculator.calculate(expr));
	}
	
	@Ignore
	public void test4(){
		String expr = "+,2,2";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("First two values should be digits", rpnCalculator.calculate(expr));
	}
	
	@Ignore
	public void test5(){
		String expr = "2,+,2";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("First two values should be digits", rpnCalculator.calculate(expr));
	}
	
	public void test6(){
		String expr = "-2,2,+";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("0", rpnCalculator.calculate(expr));
	}
	
	
	@Ignore
	public void test7(){
		String expr = "2.00,4.50,+";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("Not a valid input", rpnCalculator.calculate(expr));
	}
	
	@Ignore
	public void test8(){
		String expr = "3,+,+";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("First two values should be digits", rpnCalculator.calculate(expr));
	}
	
	
	public void test9(){
		String expr = "2,3,-";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("-1", rpnCalculator.calculate(expr));
	}
	
	
	public void test10(){
		String expr = "1,2,3,+,-";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("-4", rpnCalculator.calculate(expr));
	}
	
	public void test11(){
		String expr = "3,3,*,2";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("Bad expression", rpnCalculator.calculate(expr));
	}
	
	public void test12(){
		String expr = "3,3,<";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("Not a valid input", rpnCalculator.calculate(expr));
	}
	
	public void test13(){
		String expr = "3,3,a";
		RPNCalculator rpnCalculator = new RPNCalculator();		
		assertEquals("Not a valid input", rpnCalculator.calculate(expr));
	}



}
