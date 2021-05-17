package week6.day2;

import org.testng.annotations.Test;
import java.util.NoSuchElementException;

public class SampleTest {

  @Test
  public void testA() {
    System.out.println("Test: A");
    throw new NoSuchElementException();
  }

  @Test
  public void B() {
    System.out.println("Test: B");
  }

  @Test(retryAnalyzer = RetryTestsAnalyzer.class)
  public void C() {
    System.out.println("Test: C");
    throw new NoSuchElementException();
  }
}
