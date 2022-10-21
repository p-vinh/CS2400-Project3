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

		String testExpression = "2 ^ 2 ^ 2";
		System.out.println("Test 1: Normal Expression");
		System.out.println("Infix Expression : " + testExpression);
		System.out.print("Postfix Expression: ");
		for (String str : Expression.convertToPostfix(testExpression.split(" ")))
			System.out.print(str + " ");
		System.out.println();
		System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(testExpression.split(" "))));
		System.out.println();

		testExpression = "3 * ( 7 + 8 )";
		System.out.println("Test 2: Precedence of Operator");
		System.out.println("Infix Expression : " + testExpression);
		System.out.print("Postfix Expression: ");
		for (String str : Expression.convertToPostfix(testExpression.split(" ")))
			System.out.print(str + " ");
		System.out.println();
		System.out.println();

		System.out.println("Test 3: Testing Output. Answer should be: 45");
		System.out.println("Postfix Evaluation (3 7 8 + *): "
				+ Expression.evaluatePostfix(Expression.convertToPostfix(testExpression.split(" "))));
		if (Expression.evaluatePostfix(Expression.convertToPostfix(testExpression.split(" "))) == 45)
			System.out.println("Evaluation is equal to Test");
		System.out.println();

		try {

			testExpression = "( 3 + 4 ( / 2";
			System.out.println("Test 4: Unbalanced Equation");
			System.out.println("Infix Expression : " + testExpression);
			System.out.print("Postfix Expression: ");
			Expression.convertToPostfix(testExpression.split(" "));
			System.out.println();

		} catch (RuntimeException re) {
			System.out.println("Invalid Expression");
		}

		try {
			testExpression = "3 3 2 +";
			System.out.println();
			System.out.println("Test 5: Missing an Operand in Postfix");
			System.out.println("Expression: " + testExpression);
			System.out.println("Evaluating Postfix Expression: " + Expression.evaluatePostfix(testExpression.split(" ")));
			System.out.println();
			
		} catch (RuntimeException re) {
			System.out.println("Missing an Operand");
		}
	}
}
