import java.util.ArrayList;

public class Expression {
	public static String[] convertToPostfix (String[] infixExpression) {
		ArrayList<String> ret = new ArrayList<>();
		InterfaceStack<String> operatorStack = new LinkedStack<>();
		String postFix = "";
		int index = 0;

		while (index < infixExpression.length) {
			
			index++;
		}





		return ret.toArray(new String[0]);
	}

	public static double evaluatePostfix (String[] posfixExpression) {


		return 0.0;
	}
}