package exercise.daily;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class IgnoreTest {
	@Test
	public void A() {
		System.out.println("Test: A");
		throw new SkipException("The test is skipped");
	}
	
	@Test(enabled = false)
	public void B() {
		System.out.println("Test: B");
	}
	
	@Test(groups = {"smoke"})
	public void C() {
		System.out.println("Test: C");
	}
	
	@Test
	public void D() {
		System.out.println("Test: D");
	}
}
