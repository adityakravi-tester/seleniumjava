package week2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		driver.findElementByXPath("//a[text()='Contacts']").click();
		
		driver.findElementByXPath("//a[text()='Create Contact']").click();
		
		driver.findElementById("firstNameField").sendKeys("Aditya");
		
		driver.findElementById("lastNameField").sendKeys("Ravi");
		
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("aditya");
		
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("ravi");
		
		driver.findElementById("createContactForm_departmentName").sendKeys("Testing");
		
		driver.findElementById("createContactForm_description").sendKeys("This is a test description");
		
		driver.findElementById("createContactForm_primaryEmail").sendKeys("ravi@gmail.com");
		
		new Select(driver.findElementById("createContactForm_generalStateProvinceGeoId")).selectByVisibleText("New York");
		
		driver.findElementByName("submitButton").click();
		
		driver.findElementByXPath("//a[@class='subMenuButton' and text()='Edit']").click();
		
		driver.findElementById("updateContactForm_description").clear();
		
		driver.findElementById("updateContactForm_importantNote").sendKeys("Test Notice");
		
		driver.findElementByXPath("//input[@class='smallSubmit' and @value='Update']").click();
		
		System.out.println("Title after update: " + driver.getTitle());
	}
}
