package exercise.daily;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestD {
	
	@Test
	public void A() {
		System.out.println("Test: D");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite in D class");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite in D class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class in D class");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class in D class");
	}
}
