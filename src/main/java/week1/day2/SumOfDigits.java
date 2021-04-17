package week1.day2;

import java.util.Scanner;

public class SumOfDigits {


	/*
	 * Goal: Find the sum of digits of a given number
	 * 
	 * input: 123
	 * output: 1+2+3 = 6
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'while' loop: type 'while', followed by ctrl + space + enter
	 *   
	 * What are my learnings from this code?
	 * 1)
	 * 2)
	 * 3) 
	 * 
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int number;
		System.out.print("Enter the number: ");
		number = scan.nextInt();
		
		SumOfDigits sum = new SumOfDigits();
		System.out.println(sum.addDigits(number));

	}
	
	public int addDigits(int number) {
		int sum = 0;
		while (number > 0) {
			int remainder = number % 10;
			sum = sum + remainder;
			number = number / 10;
		}
		return sum;
	}
}
