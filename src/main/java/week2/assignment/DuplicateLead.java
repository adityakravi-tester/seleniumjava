package week2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("Demosalesmanager");

		driver.findElementById("password").sendKeys("crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();

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
		
		driver.close();
	}
}
