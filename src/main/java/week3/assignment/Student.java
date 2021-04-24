package week3.assignment;

public class Student {
	
	public Student getStudentInfo(int id) {
		System.out.println("Id: " + id);
		return this;
	}
	
	public Student getStudentInfo(int id, String name) {
		System.out.println("Id: "+ id + " Name: "+ name);
		return this;
	}
	
	public Student getStudentInfo(String email, long phone) {
		System.out.println("Email: " +email+ " phone: " + phone);
		return this;
	}
	
	
	public static void main(String[] args) {
		new Student().getStudentInfo(1).getStudentInfo(1, "Aditya").getStudentInfo("ravi@gmail.com", 981957632);
	
	}
}
