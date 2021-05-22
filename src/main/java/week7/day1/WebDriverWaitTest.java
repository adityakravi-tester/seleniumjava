package week7.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitTest {

  public static void main(String[] args) {

  WebDriverManager.chromedriver().setup();

  ChromeDriver driver = new ChromeDriver();

  driver.manage().window().maximize();

  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  driver.get("http://leafground.com/pages/disapper.html");
  
  WebElement eleToDisappear = driver.findElement(By.xpath("//*[contains(text(),'Keep looking at me!!')]"));
  
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
  
  wait.until(ExpectedConditions.invisibilityOf(eleToDisappear));
  
  String text = driver.findElement(By.tagName("strong")).getText();
  
  System.out.println(text);
  
  driver.close();
  }

}
