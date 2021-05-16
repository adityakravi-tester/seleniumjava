package exercise.miscellaneous;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	@Test(dataProvider = "sendData")
	public void googleSearchTest(String greetings) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		driver.findElementByXPath("//*[@title='Search']").sendKeys(greetings, Keys.ENTER);
		
	}

	@DataProvider(parallel = true)
	public String[][] sendData(){
		return new String[][] {
			{"Hello"},
			{"Bonjour"},
			{"Ciao"},
			{"Hola"}
		};
	}
}
