package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assignment1 {
	WebDriver driver;
	
  @Test
  public void verifyTheTitleOfThePage() {
	  
	  String expectedTitle="Obsqura Testing";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle,expectedTitle);
	  }
  
  @Test
  public void verifyTheLogoIsDisplayedOrNotInHomePage() {
	  
	WebElement logo=driver.findElement(By.xpath("(//img[@src='images/logo.png'])[1]"));
	Boolean check= logo.isDisplayed();
	Assert.assertTrue(check);
	 }
  @BeforeTest
  public void beforeTest() {
	  
	  driver=new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	   }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
