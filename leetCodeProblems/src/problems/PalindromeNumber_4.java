/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:
    -231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?
*/

package problems;
import java.util.Scanner;

class SolutionPal{
	public boolean isPalindrome(int x) {
		if(x<0)
			return false; 
		
		//get length of the number
		int length=0;
		int num = x;
		while(x>0) { 
			x= x/10; 
			length++; 
		}
		
		//use array and store reversed num to it
		int revNum[] = new int[length];
		for(int i = 0; i<length;i++) {  
			revNum[i]= num%10; 
			num/=10; 
		}
		
		//use loop from end till 0 and get number as in array
		int curNum[] = new int[length];
		int j=0;
		for(int i =length-1;i>=0;i-- ) { 
			curNum[i]=revNum[j];
			j++; 
		}
		
		//check if num and rev num are equal, if equal return true, else false
		int fLen= length-1;
		int flag=0;
		int i=0;
		while(0<=fLen) { 
			if(curNum[i]!=revNum[i]) {
				flag = 1;
				break;
			}
			i++;
			fLen--;
		}
		if(flag==0)
			return true;
		return false;

	}
}
public class PalindromeNumber_4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter any number from -231 to 231 to check palindrome");
		int num = s.nextInt();
		
		if(num>-231 && num<232) {
			if(num<0) {
				new SolutionPal().isPalindrome(num);
			}
			boolean check = new SolutionPal().isPalindrome(num);
			if(check)
				System.out.println("Palindrome!");
			else 
				System.out.println("Not a palindrome!");
		}
		else 
			System.err.println("please enter number within the range!");
		s.close();
	}
}
