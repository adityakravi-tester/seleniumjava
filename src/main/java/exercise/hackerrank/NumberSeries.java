package exercise.hackerrank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-loops/problem
public class NumberSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of q: ");
		int t = in.nextInt();
		int[] varA = new int[t];
		int[] varB = new int[t];
		int[] varN = new int[t];
		int [] sum = new int[t];
		for (int i = 0; i < t; i++) {
			System.out.println("Enter the value of a: ");
			int a = in.nextInt();
			varA[i] = a;
			System.out.println("Enter the value of b: ");
			int b = in.nextInt();
			varB[i] = b;
			System.out.println("Enter the value of n: ");
			int n = in.nextInt();
			varN[i] = n;
		}

		/*
		 * System.out.println("The values for all the variables are :"); for (int i = 0;
		 * i < t; i++) { // System.out.print("varA: "+varA[i] + " varB: " + varB[i] +
		 * " varN: " + varN[i] // + "\n"); System.out.printf("%6s%6s%6s%n", "varA",
		 * "varB", "varN"); System.out.printf("%6d%6d%6d%n", varA[i], varB[i], varN[i]);
		 * }
		 */

		for (int i = 0; i < t; i++) {
			sum[i] = sum[i] + varA[i];
			for (int j = 0; j < varN[i]; j++) {
				sum[i] = sum[i] + ((int) Math.pow(2, j) * varB[i]);
				System.out.print(sum[i] + " ");
			}
			System.out.println("\n");
		}

		in.close();
	}
}
