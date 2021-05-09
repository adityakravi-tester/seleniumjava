package week5.day1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteLeadUsingTestNG extends BaseClass{
	
	@Test
	public void deleteLeadTest() throws InterruptedException {

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

	}
}
