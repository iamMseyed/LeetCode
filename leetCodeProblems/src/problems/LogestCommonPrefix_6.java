/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.

 */

package problems;
import java.util.Scanner;
class SolutionLCF {
public String longestCommonPrefix(String[] strArr) {
    if (strArr == null || strArr.length == 0) {
        return "";
    }

    int size = strArr.length;
		int[] stringLenArr= new int[size];
		for(int i = 0;i<strArr.length;i++) {
			stringLenArr[i]=strArr[i].length();
		}
    int minLen=stringLenArr[0];
		for(int i=0;i<stringLenArr.length;i++)
		{
			if(stringLenArr[i]<minLen)
				minLen=stringLenArr[i];
		}

    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < minLen; i++) {
        char currentChar = strArr[0].charAt(i);
        for (int j = 1; j < strArr.length; j++) {
            if (strArr[j].charAt(i) != currentChar) {
		        return prefix.toString();
		    }
         }
        prefix.append(currentChar);
	}
    return prefix.toString();
	}

}
public class LogestCommonPrefix {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of string array");
		int size = s.nextInt();
		
		String[] strArr = new String[size];
		
		for(int i=0;i<strArr.length;i++) {
			
			strArr[i]=s.next().toLowerCase();
		} 
		String ans = new SolutionLCF().longestCommonPrefix(strArr);
		
		s.close();
	}
}
