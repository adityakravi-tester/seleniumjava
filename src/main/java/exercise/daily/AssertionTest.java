package exercise.daily;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class AssertionTest {
	
	@Test(priority = 1)
	public void A() {
		System.out.println("Test: A");
		Assert.assertEquals(true, false);
		System.out.println("Continue execution");
	}
	
	@Test(priority = 2)
	public void B() {
		System.out.println("Test: B");
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(true, false);
		System.out.println("Continue execution");
		asserts.assertAll();
	}
	
	@Test(priority = 3)
	public void C() {
		System.out.println("Test: C");
		
	}
}
