package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundCalendarTest {

	public static void main(String[] args) throws IOException {
		
		String selectedDate = "10";
		
		//Setup browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Get the url for AUT
		driver.get("http://leafground.com/pages/Calendar.html");

		driver.findElement(By.id("datepicker")).click();
		
		int rowCount = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
		
		int colCount = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td")).size();
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j <= colCount; j++) {
				if(driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).getText().equals(selectedDate)) {
					driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).click();
					
					File source = driver.getScreenshotAs(OutputType.FILE);
					
					File destination = new File("./snaps/selectedData.png");
					
					FileUtils.copyFile(source, destination);
				}	
			}
		}
	}
}
