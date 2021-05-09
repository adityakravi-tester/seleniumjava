package week4.assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFrameTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		int size = driver.findElementsByXPath("//iframe").size();
		
		System.out.println("Number of frames: "+ size);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string = js.executeScript("return window.length").toString();
		System.out.println("Frames using javascript: "+string);
		
	}
	
	
	public void countFrames() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		int size = driver.findElementsByTagName("iframe").size();
		int count = size;
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			count = count + driver.findElementsByTagName("iframe").size();
			driver.switchTo().defaultContent();
		}
		System.out.println(count);
	}
}
