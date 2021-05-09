package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadUsingXpath {
	
	@Test
	public void createLeadTest() {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//input[@id='username']").sendKeys("Demosalesmanager");
		
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
				
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		driver.findElementByXPath("//a[text()='Leads']").click();
		
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		
		driver.findElementByXPath("//input[@name='companyName' and @id='createLeadForm_companyName']").sendKeys("Digital Software Inc");
		
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Aditya");
		
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Kumar");
		
		driver.findElementByXPath("//input[@name='submitButton']").click();
	}

}
