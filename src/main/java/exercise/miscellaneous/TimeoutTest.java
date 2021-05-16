package exercise.miscellaneous;

import org.testng.annotations.Test;

public class TimeoutTest {
	
	@Test(invocationCount = 2, timeOut = 3000)
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("This test should run 2 times");
	}
	
	@Test
	public void test2() {
		System.out.println("This test should run 1 times");
	}
	
	@Test
	public void test3() {
		System.out.println("This test should run 1 times");
	}
	
}
