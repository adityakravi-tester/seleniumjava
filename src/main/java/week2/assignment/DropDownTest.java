package week2.assignment;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver();
		 */
		/*
		 * driver.manage().window().maximize();
		 * driver.navigate().to("http://www.leafground.com/pages/Dropdown.html");
		 * 
		 * driver.findElementById("dropdown1").sendKeys(Keys.END);
		 * 
		 * driver.findElementByName("dropdown2").sendKeys(Keys.END);
		 * 
		 * driver.findElementById("dropdown3").sendKeys(Keys.END);
		 * 
		 * driver.findElementByClassName("dropdown").sendKeys(Keys.END);
		 * 
		 * driver.findElementByXPath("//select[not(@*)]").sendKeys(Keys.END);
		 * 
		 * driver.findElementByXPath("//select[@multiple]").sendKeys(Keys.END);
		 */
		
		String text ="CTS(10323)";
		System.out.println(text.replaceAll("[^0-9]", ""));
	
	}

}
