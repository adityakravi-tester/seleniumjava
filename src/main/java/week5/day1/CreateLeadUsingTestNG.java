package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateLeadUsingTestNG extends BaseClass{
	@Test
	public void createLeadTest() {
		
		driver.findElementByXPath("//a[text()='Contacts']").click();
		
		driver.findElementByXPath("//a[text()='Create Contact']").click();
		
		driver.findElementById("firstNameField").sendKeys("aditya");
		
		driver.findElementById("lastNameField").sendKeys("ravi");
		
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("aditya");
		
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("ravi");
		
		driver.findElementById("createContactForm_departmentName").sendKeys("Testing");
		
		driver.findElementById("createContactForm_description").sendKeys("This is a test description");
		
		WebElement phoneNumber = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("createLeadForm_primaryPhoneNumber"))));
		
		phoneNumber.click();
		phoneNumber.sendKeys("9003746012");
		
		driver.findElementById("createContactForm_primaryEmail").sendKeys("ravi981957632@gmail.com");
		
		new Select(driver.findElementById("createContactForm_generalStateProvinceGeoId")).selectByVisibleText("New York");
		
		driver.findElementByName("submitButton").click();
		
		driver.findElementByXPath("//a[@class='subMenuButton' and text()='Edit']").click();
		
		driver.findElementById("updateContactForm_description").clear();
		
		driver.findElementById("updateContactForm_importantNote").sendKeys("Test Notice");
		
		driver.findElementByXPath("//input[@class='smallSubmit' and @value='Update']").click();
		
		System.out.println("Title after update: " + driver.getTitle());
		
		
	}
}
