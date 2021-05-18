package steps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadStepDefinition extends BaseClass{

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
    asserts.assertEquals(driver.getTitle(), "My Home | opentaps CRM", "Home page verified");
  }

  @Given("the user is on leads page")
  public void verifyLeadsPage() {
    driver.findElement(By.linkText("Leads")).click();
    asserts.assertEquals(driver.getTitle(), "My Leads | opentaps CRM", "Leads Page verified");
  }

  @Given("the user navigates to create lead page")
  public void verifyCreateLeadPage(){
    driver.findElement(By.linkText("Leads")).click();
    driver.findElement(By.linkText("Create Lead")).click();
    asserts.assertEquals(driver.getTitle(), "Create Lead | opentaps CRM", "Leads Page verified");
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
  
  @Given("the user is on view leads page")
  @Then("the user is redirected to view leads page")
  public void verifyViewLead() {
    asserts.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");
  }
  
  @Then("the user has edited the lead")
  @Then("the user has created a lead")
  public void verifyLeadCreated() {
    List<WebElement> companyWithId = driver.findElements(By.id("viewLead_companyName_sp"));
    asserts.assertEquals(companyWithId.size(), 1);
  }
  

  @Given("the user navigates to find leads page")
  public void verifyFindLeadsPage() {
    driver.findElement(By.linkText("Find Leads")).click();
    asserts.assertEquals(driver.getTitle(), "Find Leads | opentaps CRM");
    
  }
  
  @Given("the user finds the lead by {string}")
  public void findLeads(String searchParameter, DataTable formDetails) throws InterruptedException {
    WebElement searchElement = null;
    switch (searchParameter) {
    case "firstName": 
      searchElement = driver.findElementByXPath("(//input[@name='firstName' and @type='text'])[3]");
      break;
    case "phoneNumber":
      searchElement = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
      break;
    case "emailAddress":
      searchElement = driver.findElementByName("emailAddress");
      break;
    default:
      System.out.println("No such parameter found");
    }
    searchElement.sendKeys(formDetails.cell(0, 0));
    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
    Thread.sleep(2000);
  }
  
  @Given("the user selects a lead if it is found")
  public void selectFoundLead() {
    driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
  }
  
  @Given("the user edits the field {string}")
  public void editField(String fieldToEdit, DataTable newValues) {
    driver.findElement(By.linkText("Edit")).click();
    WebElement companyNameField = driver.findElement(By.id("updateLeadForm_companyName"));
    companyNameField.clear();
    companyNameField.sendKeys(newValues.cell(0, 0));
    driver.findElement(By.name("submitButton")).click();
  }
}