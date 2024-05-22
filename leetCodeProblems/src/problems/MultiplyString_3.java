package problems;
/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
Constraints:
    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
import java.util.Scanner;
class SolutionMul {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int p : pos) {
            if (!(result.length() == 0 && p == 0)) {
                result.append(p);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}

public class MultiplyString_3{
     public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        String num1 = s.next();

        System.out.println("Enter second number:");
        String num2 = s.next();

        String result =  new SolutionMul().multiply(num1,num2);
        System.out.println("Product of "+num1 + " and "+ num2+ "is: "+result);
        
        s.close();
    }
}
