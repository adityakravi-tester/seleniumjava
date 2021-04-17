package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeLoginTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://acme-test.uipath.com/login");
		
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		
		driver.findElementById("password").sendKeys("leaf@12");
		
		driver.findElementByTagName("form").findElement(By.tagName("button")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("Log Out");
		
		driver.close();
	}

}
