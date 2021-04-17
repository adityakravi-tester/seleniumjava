package week1.day1;

public class Mobile {
	
	String mobileModel = "Samsung";
	int mobileWeight = 150;
	boolean isCharged = false;
	double mobilePrice = 10000.00;
	
	public void makeCall() {
		System.out.println("Calling anonymous user");
	}
	
	public void sendMsg() {
		System.out.println("Happy Birthday");
	}
	
	public static void main(String[] args) {
		Mobile samsung = new Mobile();
		samsung.makeCall();
		samsung.sendMsg();
		System.out.println("\n" + "Mobile Model: "+ samsung.mobileModel + "\n" + "Mobile Weight: "+ samsung.mobileWeight + " gms" 
				+ "\n" + "Mobile Charged ? : "+ samsung.isCharged + "\n" + "Mobile price: "+ samsung.mobilePrice );
		System.out.println();
		
	}
}

