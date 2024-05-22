package problems;

import java.util.Scanner;

public class StringToLower_1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter any String value");
		String orgStr = s.nextLine();
		if(containsDigits(orgStr)) {
			System.err.println("Please type String values (character) only not any numeric value !");
			System.exit(0);
		}
		while(true) {
			System.out.println("""
					
					====Choose the way to get the solution===
					1: Built in method
					2: With char array
					3: With StringBuilder
					4: With charAt() 
					5: To Exit from the program
					Enter your choice:
					""");
			
			int choice = s.nextInt();
			switch(choice) {
				case 1:
					String lwr = orgStr.toLowerCase();
					if(!orgStr.equals(lwr))
						System.out.println("String in lower case is: "+lwr);
					else
						System.out.println("No changes made to given string: "+orgStr);
				break;
				
				case 2:
					char[] strChar = orgStr.toCharArray(); //break string into char array
					for(int i = 0; i <strChar.length;i++) { //strChar is array, thus using length (not method)
						if(strChar[i]>=65  && strChar[i]<=90) {
							strChar[i] = (char) (strChar[i]+32);  
							/*32 because ascii value of A is 65....Z is 90. Of a is 97, thus gap of 6, 
							  also total alphabets are 26 so, 26+6 = 32. Thus if we have say N, now to 
							  convert this to lower case we use 6+26 which will be n
							*/  
						}
					}
					String toLow2 = String.valueOf(strChar); //covert char back to string
					System.out.println("String to lower case via char Array is : "+toLow2);
				break;
				
				case 3:
					StringBuilder sb = new StringBuilder();
					for(char c:orgStr.toCharArray()) {
						if(c>=65 && c<=90) {
							c = (char) (c+32);
						}
						sb.append(c);
					}
					System.out.println("String in lower case via StringBuilder method is: "+sb.toString());
				break;
				
				case 4:
					String toLow3="";
					for(int i = 0; i<orgStr.length();i++) { //orgStr is String, thus using length()
						if('A' <=orgStr.charAt(i) && orgStr.charAt(i)<='Z') {
							toLow3+=(char)(orgStr.charAt(i)+32);
						}else
							toLow3+=(char)(orgStr.charAt(i));
					}
					System.out.println("String in lower case via charAt() is: "+toLow3);
				break;
				
				case 5:
					System.out.println("Closing....");
					System.exit(0);
				
				default:
					System.err.println("Enter a valid choice!");
			}
		}
	}
	private static boolean containsDigits(String input) {
        for (char c:input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
