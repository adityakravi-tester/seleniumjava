package week5.day1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DuplicateLeadUsingTestNG extends BaseClass{

	/*http://leaftaps.com/opentaps/control/main

	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)

	 */
	@Test
	public void duplicateLeadTest() throws InterruptedException {
		
		driver.findElementByXPath("//a[text()='Leads']").click();

		driver.findElementByXPath("//a[text()='Find Leads']").click();

		driver.findElementByXPath("//span[text()='Email']").click();

		driver.findElementByName("emailAddress").sendKeys("ravi98195763@gmail.com");

		//Click on find leads button to search
		driver.findElementByXPath("//button[@class='x-btn-text' and text()='Find Leads']").click();

		Thread.sleep(3000);

		WebElement firstLeadNameElement = driver.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[3]");
		
		//Capture the lead id
		String firstLeadName = firstLeadNameElement.getText();
		
		//Click the first lead id
		firstLeadNameElement.click();
		
		//Click on Duplicate Lead
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		
		//Click on create lead button
		driver.findElementByName("submitButton").click();
		
		String duplicateLeadName = driver.findElementById("viewLead_firstName_sp").getText();
		
		if(duplicateLeadName.equals(firstLeadName)) {
			System.out.println("Duplicate lead name is same as the captured lead name");
		}
	}
}
