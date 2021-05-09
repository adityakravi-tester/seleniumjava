package week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void setup(String url, String username, String password) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		
		driver.findElementById("username").sendKeys(username);
		
		driver.findElementById("password").sendKeys(password);
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
