package week4.assignment;

import java.time.Duration;
/**
 * 1. Launch ChromeBrowser
2. Go to https://www.lenskart.com
3. Mouse Hover "Computer Glasses"-->MEN-->Click Premium Range
4. Click Round(Frame Shape)
5. Click on Frame color with highest count
6. Confirm the count shown in the frame color matches the displayed results count
7. Print the size of the first product (Hint: Mouse hover on the product to get the size)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LenskartTest {

	public static void main(String[] args) throws InterruptedException {
		//Setup browser
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.lenskart.com/");
		
		WebElement computerGlasses = driver.findElement(By.linkText("Computer Glasses"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(computerGlasses).moveToElement(driver.findElement(By.xpath("(//span[text()='men'])[2]"))).
			    click(driver.findElementByXPath("(//span[text()='PREMIUM RANGE'])[1]")).
			    perform();
		
		//Select round frame
		driver.findElement(By.xpath("//span[@title='Round']")).click();
		
		//Get colors
		Thread.sleep(5000);
		List<WebElement> frameColors = driver.findElements(By.xpath("//div[text()='FRAME COLOR']/following-sibling::ul/li"));
		
		//frameColors.forEach(e -> System.out.println(e.getText()));
		
		List<Integer> colorNums = new ArrayList<Integer>();
		for (WebElement frameColor : frameColors) {
			colorNums.add(Integer.parseInt(frameColor.getText().replaceAll("[^0-9]", "")));
		}
		
		//Click on color with max number of glasses
		driver.findElement(By.xpath("//div[text()='FRAME COLOR']/following-sibling::ul/li//span[contains(text(),'"+Collections.max(colorNums)+"')]")).click();
		
		//Find the number of search results
		int searchResultCount = driver.findElements(By.className("productWidgetBox_widgetImage")).size();
		System.out.println("The count of round black glasses is: "+ searchResultCount);
		
		if(searchResultCount == Collections.max(colorNums)) {
			System.out.println("The search results are same as the maximum number of glasses of the color type");
		}
		Thread.sleep(3000);
		
		builder.moveToElement(driver.findElementByClassName("productWidgetBox_widgetImage")).pause(Duration.ofSeconds(5)).perform();
		
		String sizeOfFirstGlass = driver.findElementByXPath("//p[contains(text(),'Size')]/span").getText();
		
		System.out.println("Size of first glass is: "+ sizeOfFirstGlass);
		
	}
}
