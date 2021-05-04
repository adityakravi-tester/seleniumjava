package week4.assignment;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		1) Open https://www.myntra.com/
		2) Mouse over on WOMEN 
		3) Click Jackets & Coats
		4) Find the total count of item 
		5) Validate the sum of categories count matches
		6) Check Coats
		7) Click + More option under BRAND	
		8) Type MANGO and click checkbox
		9) Close the pop-up x
		10) Confirm all the Coats are of brand MANGO
		11) Sort by Better Discount
		12) Find the price of first displayed item
		13) Mouse over on size of the first item
		14) Click on WishList Now
		15) Close Browser
		*/
		Actions builder = new Actions(driver);
		
		driver.get("https://www.myntra.com/");
		
		builder.moveToElement(driver.findElementByXPath("//a[@data-group='women']")).pause(Duration.ofSeconds(3)).moveToElement(driver.findElementByXPath("//a[text()='Jackets & Coats']")).click().perform();
		
		String itemCount = driver.findElementByClassName("title-count").getText().replaceAll("[^0-9]", "");
		
		System.out.println("Count of items : " + itemCount);
		
		List<WebElement> categoryCountElements = driver.findElementsByClassName("categories-num");
		
		int sumOfCategories = 0;
		for (WebElement categoryCount : categoryCountElements) {
			sumOfCategories = sumOfCategories + Integer.parseInt(categoryCount.getText().replaceAll("[^0-9]", ""));
		}
		
		if(Integer.parseInt(itemCount) == sumOfCategories) {
			System.out.println("Sum of category matches the total number of matched items");			
		}
		
		JavascriptExecutor executeScript = (JavascriptExecutor) driver;  // Using JSExecutor for clicks specially for checkboxes, since they are getting clicked and throws ElementNotInteractableException
		
		//Click on coats category
		WebElement coats = driver.findElementByXPath("//input[@value='Coats']");
		executeScript.executeScript("arguments[0].click();", coats);
		
		//Click on More brands
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
		//Search for Mango
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Mango");
		
		//Select Mango
		WebElement brandMango = driver.findElementByXPath("//ul[@class='FilterDirectory-list']//input[@type='checkbox' and @value='MANGO']");
		executeScript.executeScript("arguments[0].click();", brandMango);
		
		//Close the brands popup
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		Thread.sleep(3000);
		
		List<WebElement> productBrandsList = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		System.out.println("Search result size: "+productBrandsList.size());
		boolean isBrandMango = true;
		for (WebElement productBrand : productBrandsList) {
			if(!(productBrand.getText().equalsIgnoreCase("Mango"))) {
				isBrandMango = false;
				break;
			} 
		}
		
		if(isBrandMango) {
			System.out.println("All coats are of Mango brand");
		} else {
			System.out.println("All coats are not of Mango brand");
		}
		
		driver.findElementByClassName("sort-sortBy").click();
		
		driver.findElementByXPath("//input[@value='discount']/parent::label").click();
		
		System.out.println("Price of first coat is: " +  driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText());
		
		builder.moveToElement(driver.findElement(By.xpath("//img"))).perform();
		
		WebElement wishListNow = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//div[@class='product-actions '])[1]")));
		
		wishListNow.click();
		
		//Close the browser
		driver.close();
	}
}
