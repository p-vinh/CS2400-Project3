// 
//  Name:		Pham, Vinh 
//  Project:	3
//  Due:		19 October 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Using a stack the program will output a postfix expression given an infix.
//    It will also evaluate the postfix expression if given one.
// 

import java.util.ArrayList;

public class Expression {

	private Expression() {
	}

	public static String[] convertToPostfix(String[] infixExpression) {
		try {
			ArrayList<String> ret = new ArrayList<>();
			InterfaceStack<String> operatorStack = new LinkedStack<>();
			String topOperator;

			for (String str : infixExpression) {
				if (isNumeric(str))
					ret.add(str);

				switch (str) {
					case "^":
						operatorStack.push(str);
						break;
					case "+":
					case "-":
					case "*":
					case "/":
						while (!operatorStack.isEmpty()
								&& getPrecedence(str) <= getPrecedence(operatorStack.peek())) {
							ret.add(operatorStack.pop());
						}
						operatorStack.push(str);
						break;
					case "(":
						operatorStack.push(str);
						break;
					case ")":
						topOperator = operatorStack.pop();
						while (!topOperator.equals("(")) {
							ret.add(topOperator);
							topOperator = operatorStack.pop();
						}
						break;
					default:
						break; // ignore unexpected characters
				}
			}

			while (!operatorStack.isEmpty()) {
				topOperator = operatorStack.pop();
				if (topOperator.equals("(") || topOperator.equals(")"))
					throw new RuntimeException("Mismatch Parenthesis");
				ret.add(topOperator);
			}

			return ret.toArray(new String[0]);
		} catch (RuntimeException re) {
			throw new RuntimeException("Not a good expression");
		}
	}

	public static double evaluatePostfix(String[] posfixExpression) {
		InterfaceStack<Double> valueStack = new LinkedStack<>();

		for (String str : posfixExpression) {
			if (isNumeric(str))
				valueStack.push(Double.parseDouble(str));
			switch (str) {
				case "+":
				case "-":
				case "*":
				case "/":
				case "^":
					double rhs = valueStack.pop();
					double lhs = valueStack.pop();
					valueStack.push(evaluateOperation(rhs, lhs, str));
					break;
				default:
					break;
			}
		}
		return valueStack.peek();
	}

	private static int getPrecedence(String entry) {
		switch (entry) {
			case "*":
			case "/":
				return 2;
			case "+":
			case "-":
				return 1;
			default:
				return 0;
		}

	}

	private static double evaluateOperation(double rhs, double lhs, String operator) {
		switch (operator) {
			case "^":
				return Math.pow(lhs, rhs);
			case "*":
				return lhs * rhs;
			case "/":
				return lhs / rhs;
			case "+":
				return lhs + rhs;
			case "-":
				return lhs - rhs;
			default:
				return 0.0;
		}
	}

	private static boolean isNumeric(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}