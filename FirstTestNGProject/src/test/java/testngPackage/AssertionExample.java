package testngPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AssertionExample {
	
	WebDriver driver;
  @Test
  public void verifyThePageOpenWhileHittingUrl() {
	  
	  String expectedUrl="https://selenium.obsqurazone.com/index.php";
	  String actualUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl,expectedUrl);//HardAssert//default and called directlty
	  
	   }
  
  @Test
  public void verifyThePageOpenWhileHittingUrl_softAssert() {
	  
	  String expectedUrl="https://selenium.obsqurazone.com/index.php";
	  String actualUrl=driver.getCurrentUrl();
	  
	  SoftAssert soft=new SoftAssert();
	  soft.assertEquals(actualUrl, expectedUrl);
	  soft.assertAll();//to generate exception
	  
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


