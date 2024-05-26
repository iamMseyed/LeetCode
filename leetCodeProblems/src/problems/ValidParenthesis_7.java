/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 
Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


 */
package problems;
import java.util.Scanner;
class SolutionParn{
	public boolean isValid(String s) {
		if(s==null || s.length()==0)
			return false;
		
		char[] strAsChar = new char[s.length()];
		
		int top = -1;
		for(char c:s.toCharArray()) {
			if(c=='(' || c=='{' || c=='[' ) //check if opening bracket is there
				strAsChar[++top]=c; //if it is, put into char array, ++top as top =-1 initially
			else {
                if (top == -1) {
                    return false; 
                }//to check if there are opening brackets, if not, return false at that instant
                char topChar = strAsChar[top--]; 
                if ((c == ')' && topChar != '(') //check if matching
                	|| (c == ']' && topChar != '[') 
                	|| (c == '}' && topChar != '{')) {
                    return false; 
                }
            }
		}
		return top == -1; //if top == -1 means every elements are a match, and will return true, if not will return false
	}
}
public class ValidParenthesis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter parenthesis in any order: Acceptable : (,),{,},[,] ");
		String parn = s.next();
		
		for(int i=0;i<parn.length();i++) {
			if( !(parn.charAt(i)==('(') || parn.charAt(i)==(')') || parn.charAt(i)==('{')
					|| parn.charAt(i)==('}') ||parn.charAt(i)==('[') || parn.charAt(i)==(']') )) {
				System.err.println("Enter acceptable characters only!");
				System.exit(0);
			}
		}
		boolean check = new SolutionParn().isValid(parn);
		System.out.println(check);

		s.close();
	}
}
