package week4.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundsTableTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/pages/table.html");
		
		//Number of columns
		
		int colCount = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td")).size();
		
		System.out.println("Number of cloumns: "+colCount);
		
		int rowCount = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[1]")).size();
		
		System.out.println("Number of rows excluding header: "+rowCount);
		
		String progress = driver.findElement(By.xpath("//table[@id='table_id']//tr/td[text()='Learn to interact with Elements']/following::td[1]")).getText();
		
		System.out.println("Progress value for \"Learn to interact with Elements\" is: " +progress);
		
		List<WebElement> progressElements = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
		List<Integer> progressCount = new ArrayList<Integer>();
		for (WebElement webElement : progressElements) {
			progressCount.add(Integer.parseInt(webElement.getText().replaceAll("%", "")));
		}	
		
		driver.findElement(By.xpath("//table[@id='table_id']//tr/td[contains(text(),'"+Collections.min(progressCount)+"')]/following-sibling::td/input")).click();
	}
}
