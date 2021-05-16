package exercise.daily;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestC {
	@Test
	public void C() {
		System.out.println("Test: C");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite in C class");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite in C class");
	}
	
	@BeforeTest
	public void F() {
		System.out.println("Before Test in C class");
	}
	
	@AfterTest
	public void G() {
		System.out.println("After Test in C class");
	}
}
