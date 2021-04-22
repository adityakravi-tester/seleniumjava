package week2.assignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcDropdownTest {

	public static void main(String [] args) {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElementById("username").sendKeys("Demosalesmanager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		/*
		 * Select select = new
		 * Select(driver.findElement(By.id("createLeadForm_generalCountryGeoId")));
		 * 
		 * for (int i = 0; i < select.getOptions().size(); i++) {
		 * if(select.getOptions().get(i).getText().startsWith("A")) {
		 * select.selectByIndex(i+1); break; } }
		 */
		
		driver.findElementById("createLeadForm_generalCountryGeoId").click();
		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='generalCountryGeoId']/option"));
		for (int i = 0; i < countries.size(); i++) {
			if(countries.get(i).getText().contains("A")) {
				countries.get(i+1).click();
				break;
			}
		}
		
		
	}
}
