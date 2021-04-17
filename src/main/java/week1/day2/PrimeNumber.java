package week1.day2;

import java.util.Scanner;
public class PrimeNumber {

	/*
	 * Goal: To find whether a number is a Prime number or not
	 * 
	 * input: 13
	 * output: 13 is a Prime Number
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
	 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1)
	 * 2)
	 * 3) 
	 * 
	 */
	public static void main(String[] args) {
		boolean isPrime = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number");
		int i = scan.nextInt();
		for (int j = 2; j <= i/2; j++) {
			if((i % j == 0)) {
				isPrime = true;
				break;
			}
		}
		if(!isPrime) {
			System.out.println(i + " is a prime number");
		} else {
			System.out.println(i + " is not a prime number");
		}
	}
}
