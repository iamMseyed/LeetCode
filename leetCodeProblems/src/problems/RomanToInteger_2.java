package problems;
/*
13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:
    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
import java.util.Scanner;

class SolutionRomToInt {
    public int romanToInt(String rStr) {
        int integerTotal = 0;
        for (int i = 0; i < rStr.length() - 1; i++) {
            int valF = convertToValue(rStr.charAt(i));
            int valL = convertToValue(rStr.charAt(i + 1));
//            MCMXCIV
            if (valF < valL) {
                integerTotal -= valF;
            } else {
                integerTotal += valF;
            }
            System.err.println("valF:"+rStr.charAt(i));
            System.err.println("valL:"+rStr.charAt(i+1));
            System.err.println("intTot:"+integerTotal);
        }

        integerTotal += convertToValue(rStr.charAt(rStr.length() - 1));

        return integerTotal;
    }

    private int convertToValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

public class RomanToInteger_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter any roman value to find its integer equivalent: ");
        String roman = s.next().toUpperCase();
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            if (!(c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'D' || c == 'M')) {
                System.err.println("""
                        Acceptable values (combination or single value from any of the below):
                        I
                        V
                        X
                        L
                        C
                        D
                        M
                        """
                );
                System.exit(0);
            }
        }
        int ans = new SolutionRomToInt().romanToInt(roman);
        System.out.println(roman + " value in int is: " + ans);
        s.close();
    }
}
