package week1.day2;

public class ArmstrongNumber {
	
	public static void main(String[] args) {
		int checkNum = 153;
		System.out.println("Is number " + checkNum + " an armstrong number ???  -> " + isArmstrongNumber(checkNum));
	}
	
	private static boolean isArmstrongNumber(int checkNum) {
		int temp;
		int sum = 0;
		int originalNum = checkNum;
		while (checkNum > 0) {
			temp = checkNum % 10;
			sum = sum + temp * temp * temp;
			System.out.println(sum);
			checkNum = checkNum /10 ;
		}
		if (sum == originalNum) {
			return true;
		} else {
			return false;
		}
	}
}
