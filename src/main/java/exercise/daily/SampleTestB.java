package exercise.daily;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestB {
	
	@Test
	public void _B() {
		System.out.println("Test: B");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite in B class");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite in B class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method in B class");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method in B class");
	}
	
	@BeforeTest
	public void F() {
		System.out.println("Before Test in B class");
	}
	
	@AfterTest
	public void G() {
		System.out.println("After Test in B class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class in B class");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class in B class");
	}
	
}
