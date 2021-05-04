package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.snapdeal.com/");
		WebElement mensFashonLink = driver.findElement(By.xpath("//span[@class='catText' and text()=\"Men's Fashion\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashonLink)
		       .click(driver.findElement(By.xpath("(//span[@class='linkTest' and text()='Shirts'])[2]")))
		       .perform();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@id='products']//div[@class='product-tuple-image '])[1]")))
			   .click(driver.findElement(By.xpath("(//div[@id='products']//div[@class='product-tuple-image '])[1]//div[normalize-space()='Quick View']")))
			   .perform();
		driver.quit();
		
	}

}
