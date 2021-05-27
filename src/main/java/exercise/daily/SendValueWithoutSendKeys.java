package exercise.daily;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendValueWithoutSendKeys {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();

    ChromeDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.google.com/");
    
    WebElement search = driver.findElement(By.name("q"));
    
    search.sendKeys("Google");
    
    String searchKey = "Google";
    
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    js.executeScript("arguments[0].vlaue='"+searchKey+"';", search);
  }

}
