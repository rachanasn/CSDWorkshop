package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPNCalculator {

	public String calculate1(String[] arr) {
		if (arr.length < 3) {
			return "Length should be more than 3";
		}

		List<Integer> arrValInInt = new ArrayList<Integer>();
		Integer sum = 0;

		for (int i = 0; i < arr.length; i++) {
			int prevRes = 0;
			int j = 0;
			if (!arr[i].equals("+") && !arr[i].equals("-")) {
				Integer parsedArrInt = 0;
				try {
					parsedArrInt = Integer.parseInt(arr[i]);
				} catch (NumberFormatException e) {
					return "Only integers allowed";
				}
				arrValInInt.add(parsedArrInt);
				j++;

			} else if (arr[i].equals("+") || arr[i].equals("-")) {
				if (i == 0 || i == 1) {
					return "First two values should be digits";
				}
				if (arr[i].equals("+")) {
					System.out.println(arrValInInt.size());
					sum = sum + arrValInInt.get(arrValInInt.size() - 1)
							+ arrValInInt.get(arrValInInt.size() - 2);
					arrValInInt.remove(arrValInInt.size());
					arrValInInt.remove(arrValInInt.size());
					arrValInInt.add(sum);
					prevRes = sum;
				} else if (arr[i].equals("-")) {
					sum = sum + arrValInInt.get(i - 2) - arrValInInt.get(i - 1);

				}

			}

		}

		return sum.toString();
	}

	public String calculate(String expr) {
		String[] arr = expr.split(",");
		String validationMessage = validateExpression(arr);
		if(validationMessage == null) {
			Stack<String> rpnStack = new Stack<String>();
			for (int i = 0; i < arr.length; i++) {				
				if (arr[i].equals("+")) {
					Integer x2 = Integer.parseInt(rpnStack.pop());
					Integer x1 = Integer.parseInt(rpnStack.pop());
					Integer sum = x1 + x2;
					rpnStack.push(String.valueOf(sum));
					
				} 	else if (arr[i].equals("-")) {
					Integer x2 = Integer.parseInt(rpnStack.pop());
					Integer x1 = Integer.parseInt(rpnStack.pop());
					Integer difference = x1 - x2;
					rpnStack.push(String.valueOf(difference));
				
				}
				
				else if (arr[i].equals("*")) {
					Integer x2 = Integer.parseInt(rpnStack.pop());
					Integer x1 = Integer.parseInt(rpnStack.pop());
					Integer product = x1 * x2;
					rpnStack.push(String.valueOf(product));
				
				}
				
				else if (arr[i].equals("/")) {
					Integer x2 = Integer.parseInt(rpnStack.pop());
					Integer x1 = Integer.parseInt(rpnStack.pop());
					Integer quotient = x1 / x2;
					rpnStack.push(String.valueOf(quotient));					
				}
				
				
				else if (arr[i].equals("%")) {
					Integer modulus = Integer.parseInt(rpnStack.pop()) / 100;
					rpnStack.push(String.valueOf(modulus));					
				}
				
				else {
					rpnStack.push(arr[i]);
				}
			}
			
			if(rpnStack.size() > 1) {
				return "Bad expression";
			} else {
				return rpnStack.pop();
			}
			
		}
		
		else {
			return validationMessage;
		}
		
	}
	
	private String validateExpression(String[] arr) {
		String message = null;

		if (arr.length == 0) {
			message = "Expression is empty";
		}

		if (arr.length > 0 && arr.length < 2) {
			message = "Length should be equal to 2 or more than 2";
		}

		for (int i = 0; i < arr.length; i++) {
			try {
				Integer.parseInt(arr[i]);

			} catch (NumberFormatException e) {
				if (!isValidOperator(arr[i])) {
					message = "Not a valid input";
				}

			}
		}
		return message;
	}

	private boolean isValidOperator(String arrEle) {
		boolean valid = true;
		List<String> validOperatorList = new ArrayList<String>();
		validOperatorList.add("+");
		validOperatorList.add("-");
		validOperatorList.add("*");
		validOperatorList.add("/");
		validOperatorList.add("%");
		validOperatorList.add("!");
		validOperatorList.add("^");

		if (!validOperatorList.contains(arrEle))
			valid = false;

		return valid;

	}


}
