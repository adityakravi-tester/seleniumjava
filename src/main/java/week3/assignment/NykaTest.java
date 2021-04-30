package week3.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaTest {

	public static void main(String[] args) {
		
		Random rand = new Random();

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to("https://www.nykaa.com/");

		driver.findElement(By.name("search-suggestions-nykaa")).sendKeys("Perfumes" + Keys.ENTER);

		List<WebElement> perfumes = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']//span"));

		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
		
		List<String> expectedItemsInBag = new ArrayList<String>();

		System.out.printf("\n%-60s%7s","Perfume","Price");
		System.out.println("\n====================================================================");

		for (int i = 0; i < perfumes.size(); i++) {
			System.out.printf("\n%-60s%7s",perfumes.get(i).getText(), prices.get(i).getText());
		}

		int randomNumber = rand.nextInt(perfumes.size());
		WebElement aRandomPerfume = perfumes.get(randomNumber);
		System.out.println("\n\nSelecting perfume: "+aRandomPerfume.getText());
		expectedItemsInBag.add(aRandomPerfume.getText());
		aRandomPerfume.click();

		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));

		//Add to bag
		System.out.println("Add to bag\n");
		driver.findElement(By.xpath("//div[@class='main-cta-wrap-inner']//button")).click();

		//Search Sunglasses
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Sunglasses" + Keys.ENTER);

		List<WebElement> sunglasses = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']//span"));

		System.out.printf("\n%-60s","Sunglasses");
		System.out.println("\n====================================================================");
		for (int i = 0; i < sunglasses.size(); i++) {
			System.out.printf("\n%-60s",sunglasses.get(i).getText());
		}

		randomNumber = rand.nextInt(sunglasses.size());
		WebElement aRandomSunglass = sunglasses.get(randomNumber);
		expectedItemsInBag.add(aRandomSunglass.getText());
		System.out.println("\n\nSelecting sunglass: "+aRandomSunglass.getText());

		Actions action = new Actions(driver);
		action.moveToElement(aRandomSunglass).perform();
		action.moveToElement(aRandomSunglass.findElement(By.xpath("//div[@class='m-content__product-list__btn-wrap desktop-card-wrapper']"))).click().perform();
		
		//Click on bag
		driver.findElement(By.className("AddBagIcon")).click();
		
		//Find if we have the server error popup when opening the bag
		List<WebElement> serverErrorPopup = driver.findElements(By.xpath("//button[@type='button' and text()='Close']"));
		if(serverErrorPopup.size() > 0) {
			System.out.println("Closing the server error popup");
			serverErrorPopup.get(0).click();
		}
		
		String text = driver.findElement(By.xpath("//div[@class='page-info']")).getText();
		System.out.println("Bage page title: "+text);
		List<WebElement> actualItemsInBag = driver.findElements(By.xpath("//div[@class='product-name']"));
		
		if(expectedItemsInBag.size() == actualItemsInBag.size()) {
			System.out.println("Number of items in the bag is as expected");
			for (int i = 0; i < expectedItemsInBag.size(); i++) {
				if(expectedItemsInBag.get(i).equals(actualItemsInBag.get(i).getText())){
					System.out.println("Item " + expectedItemsInBag.get(i) + " is present in bag");
				}
			}
		} else {
			System.out.println("Number of items in bag does not match expected number");
		}
		
		//Click on proceed
		driver.findElement(By.xpath("//div[@class='sticky-bottom proceed-cart-btn']//button/span")).click();
		
		String grandTotal = driver.findElement(By.xpath("//div[@class='name' and text()='Grand Total']/following-sibling::div/span")).getText();
		
		System.out.println("The grand total is: "+grandTotal);
		
		//close the browser
		driver.quit();
	}
}
