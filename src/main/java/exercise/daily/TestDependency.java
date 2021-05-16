package exercise.daily;

import org.testng.annotations.Test;

public class TestDependency {
	
	@Test
	public void A() {
		System.out.println("A");
	}
	
	@Test(dependsOnMethods = "C")
	public void B() {
		System.out.println("B");
	}
	
	@Test(dependsOnMethods = "A")
	public void C() {
		System.out.println("C");
	}
	
	@Test
	public void D() {
		System.out.println("D");
	}
}
