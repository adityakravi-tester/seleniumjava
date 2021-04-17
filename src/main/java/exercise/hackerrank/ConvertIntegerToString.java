package exercise.hackerrank;

import java.util.Scanner;

public class ConvertIntegerToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		String valueOfX = String.valueOf(x);
        
		System.out.println("Value of X in string " + valueOfX);
        
		String valueOfX2 = Integer.toString(x);
        
		String valueOfX3 = String.format("%d", x);
        
		System.out.println("valueOfX2" + valueOfX2);
		
		System.out.println("valueOfX3" + valueOfX3);
		scan.close();
	}

}
