package week1.day2;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Addition Result: " + Calculator.add(99, 66) + "\n"
							+ "Subtraction Result: " + Calculator.sub(88, 35) + "\n"
							+ "Multiplication Result: " + Calculator.mul(2.99, 45.2) + "\n"
							+ "Division Result: " + Calculator.divide(9897, 16));
	}
	
	public static int add(int num1, int num2) {
		return num1+num2;
	}
	
	public static double sub(double num1, double num2) {
		return num1-num2;
	}
	
	public static double mul(double num1, double num2) {
		return num1 * num2;
	}
	
	public static double divide(int num1, int num2) {
		return num1/num2;
	}

}
