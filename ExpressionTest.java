// 
//  Name:   Pham, Vinh 
//  Project:  3
//  Due:        19 October 2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    A brief description of the project. 
// 
public class ExpressionTest {
    public static void main(String[] args) {
        String[] expression = {"1", "+", "10.5", "/", "2", "*", "9", "*", "10.2"};

        System.out.println();
        String[] test = Expression.convertToPostfix(args);

        for(int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }

        // InterfaceStack<String> ex = new LinkedStack<>();
        // for(String str : expression)
        //     ex.push(str);
        
        // String[] postfix = {"1", "10.5", "2", "/", "9", "*", "10.2", "*", "+"};
        // System.out.println(Expression.evaluatePostfix(postfix));
    }
}
