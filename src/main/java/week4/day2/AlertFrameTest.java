package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrameTest {

	public static void main(String[] args) throws InterruptedException {
		/*
		1. Load https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
			2. click Try it button
			3. Enter your name in the prompt alert
			4. Click Ok in the alert
			5. Verify the text below Try it button contains your name
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String textToPass = "Aditya";
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.sendKeys(textToPass);
		
		alert.accept();
		
		boolean expectedText = driver.findElementByXPath("//p[@id='demo']").getText().contains(textToPass);
		
		System.out.println(expectedText);
		
	}
}
