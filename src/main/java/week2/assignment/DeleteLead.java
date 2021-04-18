package week2.assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		driver.findElementByXPath("//a[text()='Leads']").click();
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Click on phone tab
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		//Enter phone number
		driver.findElementByName("phoneNumber").sendKeys("9003746012");
		
		//Click on find leads button'
		driver.findElementByXPath("//button[@class='x-btn-text' and text()='Find Leads']").click();
		
		//Capture first search
		Thread.sleep(3000);
		
		WebElement firstLeadIdElement = driver.findElementByXPath("//table[@class='x-grid3-row-table']//a");
		
		String firstLeadId = firstLeadIdElement.getText();
		
		//Click on the lead id
		firstLeadIdElement.click();
		
		//Click on delete
		driver.findElementByClassName("subMenuButtonDangerous").click();
		
		//Click on find leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Enter the lead id in the search box
		driver.findElementByName("id").sendKeys(firstLeadId);
		
		//Click on find leads button'
		driver.findElementByXPath("//button[@class='x-btn-text' and text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		//Check the no records message
		System.out.println(driver.findElementByXPath("//div[text()='No records to display']").getText());
		
		driver.close();
		
	}

}
