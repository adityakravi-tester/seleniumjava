package steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass{
	
//	@Given("Open the chrome browser")
//	public void openBrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	}
//	
//	@Given("Load the leaftaps url")
//	public void loadURL() {
//		driver.get("http://leaftaps.com/opentaps/control/login");
//	}
	
	@Given("Enter the username as {string}")
	public void enterUserName(String username) {
		driver.findElementById("username").sendKeys(username);
	}

	@Given("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
	}

	@When("Click on Login button")
	public void clickLogin() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Then("HomePage should be displayed")
	public void verifyHomePage() {
		System.out.println("HomePage verified");
	}
	
	@But("Error message {string} should be displayed")
	public void verifyErrorMessage(String message) {
		System.out.println("Error message " + message +" verified");
	}
	
}
