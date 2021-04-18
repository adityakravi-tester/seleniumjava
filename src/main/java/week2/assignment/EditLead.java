package week2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	/*http://leaftaps.com/opentaps/control/main

	 * 1	Launch the browser
	 * 2	Enter the username
	 * 3	Enter the password
	 * 4	Click Login
	 * 5	Click crm/sfa link
	 * 6	Click Leads link
	 * 7	Click Find leads
	 * 8	Enter first name
	 * 9	Click Find leads button
	 * 10 Click on first resulting lead
	 * 11 Verify title of the page
	 * 12 Click Edit
	 * 13 Change the company name
	 * 14 Click Update
	 * 15 Confirm the changed name appears
	 * 16 Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {
		
		String newCompanyName = "Digital";

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
		
		driver.findElementByXPath("(//input[@name='firstName' and @type='text'])[3]").sendKeys("aditya");
		
		driver.findElementByXPath("//button[@class='x-btn-text' and text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		//Click on first resulting lead
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a").click();
		
		//Get title
		System.out.println(driver.getTitle());
		
		//Click on edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		//Change the company name
		WebElement companyNameElement = driver.findElementById("updateLeadForm_companyName");
		companyNameElement.clear();
		companyNameElement.sendKeys(newCompanyName);
		
		//Update
		driver.findElementByXPath("//input[@value='Update']").click();
		
		String updatedCompanyName = driver.findElementById("viewLead_companyName_sp").getText();
		
		if(updatedCompanyName.contains(newCompanyName)) {
			System.out.println("The company name is updated");
		}
	}

}
