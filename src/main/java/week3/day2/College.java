package week3.day2;

public class College extends University{

	@Override
	public void ug() {
		// TODO Auto-generated method stub
		System.out.println("Undergraduate");
	}
	
	public static void main(String[] args) {
		College college = new College();
		college.ug();
		college.pg();
	}

}
