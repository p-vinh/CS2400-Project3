// 
//  Name:		Pham, Vinh 
//  Project:	3
//  Due:		21 October 2022 
//  Course:		cs-2400-02-f22 
// 
//  Description: 
//    Using a stack the program will output a postfix expression given an infix.
//    It will also evaluate the postfix expression if given one.
// 

public class ExpressionTest {
	public static void main(String[] args) {
		//String[] expression = { "(", "1", "+", "2", ")", "*", "(", "3", "-", "4", ")", "/", "(", "5", "-", "6", ")" };

		//String[] postfixExpression = Expression.convertToPostfix(args[0].split(" "));

		//for (String str : postfixExpression) {
		//	System.out.print(str + " ");
		//}

		//System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(args[0].split(" "))));
		System.out.println(Expression.evaluatePostfix(new String[] {"3", "5", "+", "4", "/"}));

		// InterfaceStack<String> ex = new LinkedStack<>();
		// for(String str : expression)
		// ex.push(str);

		// String[] postfix = {"1", "10.5", "2", "/", "9", "*", "10.2", "*", "+"};
		// System.out.println(Expression.evaluatePostfix(postfix));
	}
}
