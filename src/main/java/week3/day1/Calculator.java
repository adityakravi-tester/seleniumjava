package week3.day1;

public class Calculator {
	public void add(int a, int b) {
		System.out.println(a + b);
	}

	public void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public void multiply(int a, int b) {
		System.out.println(a * b);
	}

	public void multiply(int a, double b) {
		System.out.println(a * b);
	}

	public void subtract(int a, int b) {
		System.out.println(a - b);
	}

	public void subtract(double a, int b) {
		System.out.println(a - b);
	}

	public void divide(int a, int b) {
		System.out.println(a / b);
	}

	public void divide(double a, int b) {
		System.out.println(a / b);
	}

	public static void main(String[] args) {
		Calculator calculate = new Calculator();
		calculate.add(5, 3);
		calculate.add(5, 3, 9);
		calculate.multiply(5, 3.0);
		calculate.multiply(5, 3);
		calculate.subtract(3.5, 3);
		calculate.subtract(3, 3);
		calculate.divide(5.0, 2);
		calculate.divide(5, 1);
	}
}
