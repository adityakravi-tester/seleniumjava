package week4.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		//Setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElementById("username").sendKeys("Demosalesmanager");

		driver.findElementById("password").sendKeys("crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByLinkText("Contacts").click();

		//Click on Merge contact
		driver.findElementByXPath("//ul[@class='shortcuts']/li[last()]").click();
		
		//Click on Widget of From Contact
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();

		driver.switchTo().window(windows.get(0));
		windows.removeAll(windows);
		
		//Click on Widget of To Contact
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();

		windows = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(windows.get(1));
		
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody)[2]//a")).click();

		driver.switchTo().window(windows.get(0));
		
		//Click on Merge button using Xpath Locator
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		
		//Accept the Alert
		driver.switchTo().alert().accept();
		
		//Verify page title
		System.out.println("The title of the page is: " + driver.getTitle());
	}
}
