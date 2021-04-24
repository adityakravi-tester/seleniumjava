package week3.day1;

public class Mobile {
	public void sendMsg() {
		System.out.println("Message sent");
	}
	
	public void makeCall() {
		System.out.println("Call made");
	}
	
	public void saveContact() {
		System.out.println("Contact saved");
	}
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.connectWhatsApp();
	}
}
