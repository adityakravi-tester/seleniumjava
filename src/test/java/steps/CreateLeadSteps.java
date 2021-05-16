package steps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadSteps extends BaseClass{
	
//	@Given("the user opens the chrome browser and loads the url {string}")
//	public void openBrowserAndLaunchApp(String url) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get(url);
//	}
	
	@Given("the user enters the credentials and logs in")
	public void enterUserNamePassword(DataTable userCredentials) {
		
		String username = userCredentials.cell(0, 0);
		String password = userCredentials.cell(0, 1);
		System.out.println(username);
		
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Given("the user is on home page")
	public void verifyHomePage() {
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		System.out.println("User is on home page");
	}
	
	@Given("the user is on create lead page")
	public void verifyCreateLeadPage(){
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Given("the user enters the required details")
	public void enterRequiredDetails(DataTable formDetails) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(formDetails.cell(0, 0));
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(formDetails.cell(0, 1));
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(formDetails.cell(0, 2));
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(formDetails.cell(0, 3));
	}
	
	@When("the user click on create lead button")
	public void clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("the user is redirected to view leads page")
	public void verifyViewLead() {
		Assert.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");
	}
	
	@Then("the user has created a lead")
	public void verifyLeadCreated() {
		List<WebElement> companyWithId = driver.findElements(By.id("viewLead_companyName_sp"));
		Assert.assertEquals(companyWithId.size(), 1);
	}
}
