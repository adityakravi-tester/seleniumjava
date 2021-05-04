package week4.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowCreateIncident {

	public static void main(String[] args) {
		
		//Setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://dev111627.service-now.com/");
		
		driver.switchTo().frame(0);
		
		driver.findElementById("user_name").sendKeys("admin");
		
		driver.findElementById("user_password").sendKeys("India@123");
		
		driver.findElementById("sysverb_login").click();
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='All'])[2]").click();
		
		driver.switchTo().frame(0);
		
		driver.findElementByXPath("//button[@type='submit' and text()='New']").click(); //Click on New
		
		driver.findElementById("lookup.incident.caller_id").click();  //Click on caller search button
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(windows.get(1));
		
		driver.findElementByClassName("glide_ref_item_link").click();
		
		driver.switchTo().window(windows.get(0));
		
		driver.switchTo().frame(0);
		
		driver.findElementById("incident.short_description").sendKeys("Image issue");
		
		String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
		
		System.out.println("Created incident with ID: "+ incidentNumber);
		
		driver.findElementByXPath("//button[@value='sysverb_insert']").click();
		
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(incidentNumber + Keys.ENTER);
		
		String searchedId = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		
		System.out.println("Searched result: "+searchedId);
		
		if(searchedId.equals(incidentNumber)) {
			System.out.println("Found correct incident");
		} else {
			System.out.println("Incident not created");
		}
	}
}
