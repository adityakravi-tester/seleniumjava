package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadStepDefinition extends BaseClass{
  
  private String leadId;

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
    driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(formDetails.cell(0, 4));
  }

  @When("the user clicks on the submit button")
  @When("the user click on create lead button")
  public void clickSubmit() {
    driver.findElement(By.name("submitButton")).click();
  }

  @Given("the user is on view leads page")
  @Then("the user is redirected to view leads page")
  public void verifyViewLead() {
    asserts.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");
  }

  @Then("the user has duplicated the lead")  //Duplicate Lead step
  @Then("the user has edited the lead")      //Edit Lead Step
  @Then("the user has created a lead")       //Create Lead Step
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
      driver.findElement(By.xpath("//span[text()='Phone']")).click();
      searchElement = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
      break;
    case "emailAddress":
      driver.findElementByXPath("//span[text()='Email']").click();
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
    WebElement leadIdElement = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
    leadId = leadIdElement.getText();
    System.out.println("Lead Id is: " + leadId);
    leadIdElement.click();
  }

  @Given("the user edits the field {string}")
  public void editField(String fieldToEdit, DataTable newValues) {
    driver.findElement(By.linkText("Edit")).click();
    WebElement companyNameField = driver.findElement(By.id("updateLeadForm_companyName"));
    companyNameField.clear();
    companyNameField.sendKeys(newValues.cell(0, 0));
    driver.findElement(By.name("submitButton")).click();
  }

  @When("the user clicks on duplicate lead")
  public void clickDuplicateButton() {
    driver.findElement(By.linkText("Duplicate Lead")).click();
  }

  @When("the user click on delete lead button")
  public void clickDeleteLeadButton() {
    driver.findElement(By.linkText("Delete")).click();
  }

  @When("the user tries to find the deleted lead")
  public void findDeletedLead() {
    driver.findElement(By.linkText("Find Leads")).click();
    driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
  }
  
  @Then("the user should get {string} message")
  public void verifyLeadDeleted(String erroMessage) throws InterruptedException {
    Thread.sleep(3000);
    String text = driver.findElement(By.className("x-paging-info")).getText();
    if (text.equals(erroMessage)) {
        System.out.println("Text matched");
    } else {
        System.out.println("Text not matched/Multiple leads found with same input");
    }
  }
  
  @Given("the user clicks on merge lead")
  public void clickOnMergeLeads() {
    driver.findElement(By.linkText("Merge Leads")).click();
    asserts.assertEquals(driver.getTitle(), "Merge Leads | opentaps CRM", "The user is on merge lead page");
  }
  
  @Given("the user selects From Lead")
  public void selectFromLead(DataTable leadNames) {
    driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
    Set<String> allWindows = driver.getWindowHandles();
    List<String> allhandles = new ArrayList<String>(allWindows);
    driver.switchTo().window(allhandles.get(1));
    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(leadNames.cell(0, 0));
  }
  
  @Given("the user selects To Lead")
  public void selectToLead(DataTable leadNames) {
    
  }
}