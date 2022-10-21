import java.util.EmptyStackException;

// 
//  Name:		Pham, Vinh 
//  Project:	3
//  Due:		21 October 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Expression Test is testing all the methods in Expression.java
//    to check if it works and if it outputs the correct answer.
// 

public class ExpressionTest {
	public static void main(String[] args) {
		// String[] expression = { "(", "1", "+", "2", ")", "*", "(", "3", "-", "4",
		// ")", "/", "(", "5", "-", "6", ")" };

		// String[] postfixExpression = Expression.convertToPostfix(args[0].split(" "));

		// for (String str : postfixExpression) {
		// System.out.print(str + " ");
		// }

		// System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(args[0].split("
		// "))));
		
		System.out.println(Expression.evaluatePostfix(new String[] { "3", "5", "+", "4", "/" }));

		String[] postfixExpression = Expression.convertToPostfix(args[0].split(" "));
		System.out.print("Postfix Expression: ");
		for (String str : postfixExpression) {
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.print("Postfix Evaluation: ");
		System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(args[0].split(" "))));

		System.out.println();

		String testExpression = "3 * ( 7 + 8 )";
		System.out.println("Test 1: Precedence of Operator");
		System.out.println("Infix Expression : " + testExpression);
		System.out.print("Postfix Expression: ");
		for (String str : Expression.convertToPostfix(testExpression.split(" ")))
			System.out.print(str + " ");
		System.out.println();
		System.out.println("Output should be: 45");
		System.out.println("Postfix Evaluation: "
				+ Expression.evaluatePostfix(Expression.convertToPostfix(testExpression.split(" "))));
		if (Expression.evaluatePostfix(Expression.convertToPostfix(testExpression.split(" "))) == 45)
			System.out.println("Evaluation is equal to Test");


		testExpression = "( 3 + 4 ( / 2";
		try {
			System.out.println("Infix Expression : " + testExpression);
			System.out.print("Postfix Expression: ");
			Expression.convertToPostfix(testExpression.split(" "))
			
		} catch (EmptyStackException ese) {
			System.out.println("Empty Stack Exception. Mismatch Parenthesis");
		}
		
	}
}
