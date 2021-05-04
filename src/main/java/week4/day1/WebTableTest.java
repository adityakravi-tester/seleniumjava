package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://erail.in/");
		
		WebElement sourceDestination = driver.findElement(By.id("txtStationFrom"));
		sourceDestination.clear();
		sourceDestination.sendKeys("ms",Keys.ENTER,Keys.TAB,Keys.TAB,"mdu",Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		
		List<WebElement> trains = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
		
		int trainCount = trains.size();
		List<String> trainNames = new ArrayList<String>();
		
		for (int i = 1; i < trainCount; i++) {
			String trainName = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
			trainNames.add(trainName);
		}
		//Print all trains
		for (String trainName : trainNames) {
			System.out.println(trainName);
		}
		System.out.println("===================================================");
		
		//Find Duplicates
		Set<String> distinctTrains = new LinkedHashSet<String>();
		System.out.println("Duplicate Trains\n===========================================");
		for (String trainName : trainNames) {
			if(!distinctTrains.add(trainName)) {
				System.out.println(trainName + " is duplicate in this list");
			}
		}
	}
}
