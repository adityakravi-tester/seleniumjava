package week7.day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromProperties {
  
  public static void main(String[] args) throws IOException {
    
    //Setup Config file path
    
    FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
    
    //Create property object
    
    Properties property = new Properties();
    
    //Load the data from property file to property object
    property.load(fis);
    
    WebDriverManager.chromedriver().setup();
    
    ChromeDriver driver = new ChromeDriver();
    
    driver.manage().window().maximize();
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.get(property.getProperty("url"));
    
    driver.findElementById("username").sendKeys(property.getProperty("username"));
    
    driver.findElementById("password").sendKeys(property.getProperty("password"));
    
    driver.findElementByClassName("decorativeSubmit").click();
    
    fis.close();
    
  }
}
