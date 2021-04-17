package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplication {

	public static void main(String[] args) {
		//URL : 
		//ClassRoom: ========== 1. Set up the chromedriver 2. Open the Chrome Browser 3. Load the application url 4. Maximize the browser 5. Close the browser URL - http://leaftaps.com/opentaps/control/main Username - Demosalesmanager Password - crmsfa
		
		// Setup chromedriver
		WebDriverManager.chromedriver().setup();
		
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the application url
		driver.get("http://leaftaps.com/opentaps/control/main");
			
		//Maximize the browser window
		driver.manage().window().maximize();
		
		driver.findElementById("username");
		
		// Close the browser
		//driver.close();
	}
}
