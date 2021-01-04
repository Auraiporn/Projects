/** 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
import java.util.Stack;

public class Valid_Parentheses {
    public static boolean valid_parentheses (String s){
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray() ){
            if ( (c == '(') || (c == '[') || (c == '{') ){
                stack.push(c);
            } else if ( c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            }  else if ( c == ']' && !stack.empty() && stack.peek() == '[')   {
                stack.pop();
            } else if (c == '}' && !stack.empty() && stack.peek() == '{' ) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main (String args[]){
        boolean is_valid = valid_parentheses("()[]{}");
        System.out.println("Is valid parentheses: " + is_valid);


    }
}
