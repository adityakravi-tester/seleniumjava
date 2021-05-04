package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcWindowHandlingTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElementByXPath("//form//button").click();
		
		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		
		String currentWindow = driver.getWindowHandle();
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		driver.findElementByXPath("//button[text()='Ok']").click();
		
		String supportMail = driver.findElementByXPath("//a[@href='mailto:flights@irctc.co.in']").getText().trim();
		
		System.out.println("Support email is:" +supportMail);
		
		driver.switchTo().window(currentWindow).close();
		
	}
}
