package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	@Test(dataProvider = "setData")
	public void createLead(String company, String firstName, String lastName, String phoneNumber, String emailId) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailId);	
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider
	public String[][] setData() throws IOException{
		return new DataInputProvider().sendData("CreateLead");
	}
}






