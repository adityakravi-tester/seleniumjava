package week1.day2;

import java.util.Scanner;

public class ChangeOddIndexToUpperCase {
	/*
	 Pseudo Code
	 
	 * Declare String Input as Follow
	  
	 * String test = "changeme";
	 
	 * a) Convert the String to character array
	 
	 * b) Traverse through each character (using loop)
	 
	 * c)find the odd index within the loop (use mod operator)
	 
	 * d)within the loop, change the character to uppercase, if the index is odd else don't change
	  
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String test ;
		System.out.print("Enter the string: ");
		test  = scan.next();
		System.out.println("The changed string is: " + new ChangeOddIndexToUpperCase().changeOddIndexToUpperCase(test));
		System.out.println("The changed string is: " + new ChangeOddIndexToUpperCase().changeOddIndextToUpperCase2(test));
		scan.close();
	}
	
	private String changeOddIndexToUpperCase(String test) {
		String changedString = "";
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i % 2 == 0) {
				changedString = changedString + Character.toUpperCase(test.charAt(i));
			} else {
				changedString = changedString + test.charAt(i);
			}	
		}
		return changedString;
	}
	
	public String changeOddIndextToUpperCase2(String str){
		StringBuilder strbuild = new StringBuilder(str);
		for(int i = 0; i<str.length(); i+=2) {
			strbuild.setCharAt(i, Character.toUpperCase(str.charAt(i)));
		
			System.out.println(str.replace(str.charAt(i), Character.toUpperCase(str.charAt(i))));
		}
		return strbuild.toString();
	}

}
