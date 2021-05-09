package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	@Test
	public void createLead(String[] args) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Digital Software Inc");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aditya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ravi");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9003746012");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ravi981957632@gmail.com");	
		driver.findElement(By.name("submitButton")).click();
	}
}






