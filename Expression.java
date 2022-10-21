// 
//  Name:		Pham, Vinh 
//  Project:	3
//  Due:		19 October 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Expression.java is the implementation of convertToPostfix
//    and evaluatePostfix using the stack implentation.
// 

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Expression {

	private Expression() {
	}

	public static String[] convertToPostfix(String[] infixExpression) {
		try {
			ArrayList<String> ret = new ArrayList<>();
			StackInterface<String> opStack = new LinkedStack<>();
			String topOperator;

			for (String str : infixExpression) {
				if (isNumber(str))
					ret.add(str);

				switch (str) {
					case "^":
						opStack.push(str);
						break;
					case "+":
					case "-":
					case "*":
					case "/":
						while (!opStack.isEmpty()
								&& getPrecedence(str) <= getPrecedence(opStack.peek())) {
							ret.add(opStack.pop());
						}
						opStack.push(str);
						break;
					case "(":
						opStack.push(str);
						break;
					case ")":
						topOperator = opStack.pop();
						while (!topOperator.equals("(")) {
							ret.add(topOperator);
							topOperator = opStack.pop();
						}
						break;
					default:
						break; // ignore unexpected characters
				}
			}

			while (!opStack.isEmpty()) {
				topOperator = opStack.pop();
				if (topOperator.equals("("))
					throw new EmptyStackException();
				ret.add(topOperator);
			}

			return ret.toArray(new String[0]);
		} catch (RuntimeException re) {
			throw new RuntimeException("Invalid Infix Expression");
		}
	}

	public static double evaluatePostfix(String[] posfixExpression) {
		try {
			StackInterface<Double> evalStack = new LinkedStack<>();

			for (String str : posfixExpression) {
				if (isNumber(str))
					evalStack.push(Double.parseDouble(str));
				switch (str) {
					case "*":
					case "/":
					case "^":
					case "+":
					case "-":
						double rhs = evalStack.pop();
						double lhs = evalStack.pop();
						evalStack.push(evaluateOperation(rhs, lhs, str));
						break;
					default:
						break;
				}
			}
			double ret = evalStack.pop();
			if (!evalStack.isEmpty())
				throw new RuntimeException("Invalid Postfix Expression");
			return ret;
		} catch (RuntimeException re) {
			throw new RuntimeException("Invalid Postfix Expression");
		}
	}

	private static int getPrecedence(String operator) {
		switch (operator) {
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

	private static boolean isNumber(String num) {
		try {
			double d = Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}