package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
	
	@BeforeTest
	public void setTestDataFile() {
		excelDataFile = "EditLead";
	}
	
	@Test(dataProvider = "setData", enabled =false )
	public void editLead(String firstName, String companyName) throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElementByXPath("(//input[@name='firstName' and @type='text'])[3]").sendKeys(firstName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement companyNameField = driver.findElement(By.id("updateLeadForm_companyName"));
		companyNameField.clear();
		companyNameField.sendKeys(companyName);
		driver.findElement(By.name("submitButton")).click();
	}
	
//	@DataProvider
//	public String[][] setData(Method method) throws IOException {
//		String name = method.getName();
//		System.out.println("Test Name is: " + name);
//		return new DataInputProvider().sendData("EditLead");
//	}
}






