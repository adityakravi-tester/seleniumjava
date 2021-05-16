package exercise.daily;

import org.testng.annotations.Test;

public class GroupsTest {
	
	@Test(groups = "regression", dependsOnGroups = "smoke")
	public void test1() {
		System.out.println("regression: test1");
	}

	@Test(groups = "regression", dependsOnGroups = "smoke")
	public void test2() {
		System.out.println("regression: test2");
	}
	
	@Test(groups = "smoke")
	public void test3() {
		System.out.println("smoke: test3");
	}
	
	@Test(groups = "regression", dependsOnGroups = "smoke")
	public void test4() {
		System.out.println("regression: test4");
	}
	
	@Test(groups = "smoke")
	public void test5() {
		System.out.println("smoke: test5");
	}

	@Test(groups = "smoke")
	public void test6() {
		System.out.println("smoke: test6");
	}

	@Test(groups = "smoke")
	public void test7() {
		System.out.println("smoke: test7");
	}

	@Test(groups = "regression", dependsOnGroups = "smoke")
	public void test8() {
		System.out.println("regression: test8");
	}

	@Test(groups = "smoke")
	public void test9() {
		System.out.println("smoke: test9");
	}

	@Test(groups = "smoke")
	public void test10() {
		System.out.println("smoke: test10");
	}

}
