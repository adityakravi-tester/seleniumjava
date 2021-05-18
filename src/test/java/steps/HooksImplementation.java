package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImplementation extends BaseClass{

  @Before
  public void setup() {
    asserts = new SoftAssert();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://leaftaps.com/opentaps/control/login");
  }

  @After
  public void tearDown() throws IOException {
    asserts.assertAll();
    //driver.close();
  }
}
