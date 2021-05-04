package week4.day1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectUsingActionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		Actions builder = new Actions(driver);
		
		builder.keyDown(Keys.CONTROL)
			   .click(driver.findElement(By.xpath("//select[@multiple]/option[@value='1']")))
			   .click(driver.findElement(By.xpath("//select[@multiple]/option[@value='2']")))
			   .click(driver.findElement(By.xpath("//select[@multiple]/option[@value='3']")))
			   .keyUp(Keys.CONTROL)
			   .perform();

	}

}
