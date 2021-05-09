package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
1. Create BaseClass with ChromeDriver declared globally
2. Create preCondition and move the common code into this method
3. Apply @BeforeMethod for the preCondition()
4. Create postCondition() and move driver.close() to this method
5. Apply @AfterMethod for postCondition()
6. All the testcases class should extends BaseClass
*/
public class BaseClass {
	
	ChromeDriver driver;
	
	
	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
