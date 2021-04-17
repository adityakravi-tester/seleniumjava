package week1.day2;

public class InputOutput {

	public static void main(String[] args) {
		InputOutput io = new InputOutput();
		int price = io.getPrice(args[0]);
		if (price == 0) {
			System.out.println("Model not recognized");
		} else {
			System.out.println(price);
		}		
	}
	
	private int getPrice(String model) {
		if(model.equals("Hyundai")) {
			return 2000;
		} else if(model.equals("Alto")) {
			return 2500;
		} else
			return 0;
	}
}
