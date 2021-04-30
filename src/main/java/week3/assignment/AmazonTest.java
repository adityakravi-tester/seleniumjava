package week3.assignment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	public static void main(String[] args) throws ParseException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi mobiles", Keys.ENTER);;
		
		List<WebElement> redmiPhones = driver.findElements(By.xpath("//div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))]//h2//span"));
		
		//Only price
		List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))] //span[@class='a-price-whole']"));
		
		String highestPrice = getHighestPrice(phonePrices);
		
		//Take rupee symbol along with the price
		List<WebElement> prices = driver.findElements(By.xpath("//div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))]//span[@class='a-price-symbol' or@class='a-price-whole']/parent::span"));
		
		
		System.out.printf("%-150s%7s\n","Phones","Price");
		System.out.println("==================================================================================================================================================================");
		for (int i = 0; i < redmiPhones.size(); i++) {
			System.out.printf("\n%-150s%10s",redmiPhones.get(i).getText(),prices.get(i).getText());
		}
		
		System.out.println("\n\nHighest price smartphone(s)\n=================================================================================================================================================================");
		
		List<WebElement> costliestPhones = driver.findElements(By.xpath("//span[@class='a-price-whole' and text()='"+highestPrice+"']/ancestor::div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))]//h2//span"));
		
		for (WebElement costliestPhone : costliestPhones) {
			System.out.printf("\n%-150s%10s",costliestPhone.getText(),"Rs "+highestPrice);
		}
		
	}
	
	
	public static String getHighestPrice(List<WebElement> prices) {
		String highestPrice = "";
		List<Integer> integerPrices = new ArrayList<Integer>();
		for (WebElement eachPrice : prices) {
			integerPrices.add(Integer.parseInt(eachPrice.getText().replace(",", "")));
		}
		for (WebElement price : prices) {
			if(Integer.parseInt(price.getText().replace(",", "")) == Collections.max(integerPrices)) 
				highestPrice = price.getText();
		}
		return highestPrice;
	}

}
