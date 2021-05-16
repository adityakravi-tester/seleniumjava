package week5.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ChromeDriver driver;
	public String excelDataFile;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void setup(String url, String username, String password, ITestContext context) {

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
	
	@DataProvider(indices = {0})
	public String[][] setData(ITestContext context) throws IOException {
		String name = this.getClass().getSimpleName();
		System.out.println("Test Name is: " + name);
		return new DataInputProvider().sendData(excelDataFile);
	}
	
	@AfterTest()
	public void afterTest() {
		try {
			System.out.println("Kill chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
