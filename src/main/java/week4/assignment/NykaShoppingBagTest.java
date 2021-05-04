/**
 * Assignment 4:
=============
1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Mouseover on Popular
3) Click L'Oreal Paris
4) Go to the newly opened window and check the title contains L'Oreal Paris
5) Click sort By and select customer top rated
6) Click Category and click Shampoo
7) check whether the Filter is applied with Shampoo
8) Click on L'Oreal Paris Colour Protect Shampoo
9) GO to the new window and select size as 175ml
10) Print the MRP of the product
11) Click on ADD to BAG
12) Go to Shopping Bag 
13) Print the Grand Total amount
14) Click Proceed
15) Click on Continue as Guest
16) Check if this grand total is the same in step 13
17) Close all windows
 */

package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaShoppingBagTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://www.nykaa.com/");

		Actions builder = new Actions(driver);

		builder.moveToElement(driver.findElementByXPath("//a[text()='brands']")).
		pause(Duration.ofSeconds(2)).
		moveToElement(driver.findElementByXPath("//a[text()='Popular']")).
		click(driver.findElementByXPath("//img[contains(@src,'lorealparis')]")).
		perform();

		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

		if(driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("The title is L'Oreal Paris");
		} else {
			System.out.println("The title is not L'Oreal Paris");
		}

		//Click on sort by and select customer top rated
		driver.findElementByXPath("//span[@title='POPULARITY']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(3000);

		//Select category and shampoo
		builder.click(driver.findElementByXPath("//div[@class='filter-sidebar__filter-title pull-left' and text()='Category']")).
		pause(Duration.ofSeconds(4)).
		click(driver.findElementByXPath("//span[@class='category-title-text' and text()='Hair']")). perform();

		driver.findElementByXPath("//span[@class='category-title-text' and text()='Hair Care']").click();
		driver.findElementByXPath("//span[text()='Shampoo']").click();

		//Verify shampoo filter applied
		boolean isFilterApplied = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']//li").getText().contains("Shampoo");
		System.out.println("Shampoo filter applied: "+isFilterApplied);

		//Select L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("//div[@class='m-content__product-list__title']//span[text()=\"L'Oreal Paris Colour Protect Shampoo\"]").click();

		windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(2));

		//Select size as 175ml
		new Select(driver.findElementByXPath("//div[@class='select-style shade-select']/select")).selectByVisibleText("175ml");

		System.out.println("MRP: " + driver.findElementByXPath("//div//span[@class='post-card__content-price-offer']").getText());

		//Add to bag
		driver.findElement(By.xpath("//div[@class='main-cta-wrap-inner']//button")).click();

		//Click on bag
		driver.findElement(By.className("AddBagIcon")).click();
		
		//Get the grand total amount
		String grandTotal = driver.findElementByXPath("//div[@class='sticky-bottom proceed-cart-btn']//div[@class='value']").getText();
		System.out.println("The grand total is: "+ grandTotal);

		driver.switchTo().frame(6);
		driver.findElement(By.xpath("//div[@class='close']")).click();
      	driver.switchTo().defaultContent();
		 
		//Click on proceed
		Thread.sleep(3000);
		WebElement proceedButton = driver.findElement(By.xpath("//div[@class='sticky-bottom proceed-cart-btn']//button/span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", proceedButton);
		
		//Click on continue as guest
		driver.findElementByXPath("//button[@class='btn full big']").click();
		
		//Verify grand total
		String grandTotalCheck = driver.findElement(By.xpath("//div[@class='name' and text()='Grand Total']//following-sibling::div")).getText();
		if(grandTotal.replaceAll("[^0-9]", "").equals(grandTotalCheck.replaceAll("[^0-9]",""))) {
			System.out.println("The amounts are equal");
		} else {
			System.out.println("The amounts are not equal");
		}
		
		//Close all windows
		//driver.quit();
	}
}
