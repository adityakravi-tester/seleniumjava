package exercise.daily;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sampletest {


  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();

    ChromeDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://downtowndallas.com/experience/stay/");

    driver.findElement(By.xpath("//*[@href='/wearedowntown/']")).click();

    driver.navigate().back();

    List<WebElement> address;

    List<String> hotelInfo = new ArrayList<String>();


    List<WebElement> hotels = driver.findElements(By.xpath("//*[@class='place-square__btn']"));

    for (int i = 0; i < hotels.size(); i++) {

      hotels = driver.findElements(By.xpath("//*[@class='place-square__btn']"));

      hotels.get(i).click();

      String hotelName = driver.findElement(By.xpath("//*[@class='place-name']")).getText();

      hotelInfo.add(hotelName);

      address = driver.findElements(By.xpath("//*[@class='place-info-address']//a"));

      for (WebElement eachAddress : address) {
        hotelInfo.add(eachAddress.getText());
      }
      driver.navigate().back();
    }

    hotelInfo.forEach(e -> System.out.println(e));
  }
}
