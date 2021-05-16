package exercise.daily;

import org.testng.annotations.Test;

public class MethodParallelTest {
	
	@Test
	public void A() {
		System.out.println("Test: A");
	}
	
	@Test
	public void B() {
		System.out.println("Test: B");
	}
	@Test
	public void C() {
		System.out.println("Test: C");
	}
	
	@Test
	public void D() {
		System.out.println("Test: D");
	}
}
