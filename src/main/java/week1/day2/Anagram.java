package week1.day2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {
	
	/*
	 * Pseudo Code
	  
	 *Declare a String 
		String text1 = "stops";
	 *Declare another String
		String text2 = "potss"; 
	 * a) Check length of the strings are same then (Use A Condition)
	 * b) Convert both Strings in to characters
	 * c) Sort Both the arrays
	 * d) Check both the arrays has same value
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Anagram().checkAnagram("stops", "potss");
	}
	
	private void checkAnagram(String str, String str2) {
		// TODO Auto-generated method stub
		if (str.length() == str2.length()) {
			char [] charArray1 = str.toCharArray();
			char [] charArray2 = str2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			boolean equals = Arrays.equals(charArray1, charArray2);
			System.out.println(equals);
		}
	}
}
