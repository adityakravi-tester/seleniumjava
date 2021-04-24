package week3.day1;

public class MyPhone {

	public static void main(String[] args) {
		
		SmartPhone mySmartPhone = new SmartPhone();
		AndroidPhone myAndroidPhone = new AndroidPhone();
		AndroidPhone myAndroidPhone2 = new SmartPhone();
		/*
		 * mySmartPhone.sendMsg();
		 * 
		 * mySmartPhone.makeCall();
		 * 
		 * mySmartPhone.saveContact();
		 * 
		 * mySmartPhone.takeVideo();
		 * 
		 * mySmartPhone.connectWhatsApp();
		 */
		
		mySmartPhone.takeVideo();
		myAndroidPhone.takeVideo();
		myAndroidPhone2.takeVideo();
	}

}
