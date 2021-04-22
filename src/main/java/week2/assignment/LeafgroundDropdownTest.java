package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundDropdownTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		System.out.println("Select training program using index: " );
		
		new Select(driver.findElementById("dropdown1")).selectByIndex(1);
		
		System.out.println("Select training program using Text");
		
		new Select(driver.findElementByName("dropdown2")).selectByVisibleText("Selenium");
		
		System.out.println("Select training program using Value");
		
		new Select(driver.findElementById("dropdown3")).selectByValue("1");
		
		System.out.println("Number of dropdown options : " + new Select(driver.findElementByClassName("dropdown")).getOptions().size());
		
		System.out.println("Using sendKeys to select");
		
		driver.findElementsByClassName("example").get(4).findElement(By.tagName("Select")).sendKeys("Selenium");
		
		new Select(driver.findElementsByClassName("example").get(5).findElement(By.tagName("Select"))).selectByVisibleText("Selenium");
		
		driver.close();
		
	}

}
