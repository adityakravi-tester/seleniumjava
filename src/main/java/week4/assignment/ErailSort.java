package week4.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		//		Launch the browser

		//		Launch the URL - https://erail.in/

		//		Uncheck the check box - sort on date

		//		clear and type in the source station 

		//		clear and type in the destination station

		//		Find all the train names using xpath and store it in a list

		//		Use Java Collections sort to sort it and then print it

		//Setup browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
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
		Collections.sort(trainNames);
		
		System.out.println("Sorted train names : \n");
		for (String trainName : trainNames) {
			System.out.println(trainName);
		}

	}

}
