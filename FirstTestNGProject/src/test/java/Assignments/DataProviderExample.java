package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderExample {
	
	WebDriver driver;
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class)
  public void verifySuccessfulLogin(String uname, String passwd) {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(passwd);
	  WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action= new Actions(driver);
	  action.sendKeys(login,Keys.ENTER).build().perform();
	  
	  WebElement name=driver.findElement(By.xpath("(//*[text()='Dashboard'])[2]"));
	 Boolean check= name.isDisplayed();
	  Assert.assertTrue(check);
  }
	
  @Test(dataProvider = "unSuccessfulLogin",dataProviderClass = DataProviderClass.class)
  public void verifyUnSuccessfulLogin(String uname, String passwd) {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(passwd);
	  WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action= new Actions(driver);
	  action.sendKeys(login,Keys.ENTER).build().perform();
	  
	  WebElement alert=driver.findElement(By.xpath("//*[text()='Invalid credentials']"));
	  String expectedText="Invalid credentials";
	  String actualText=alert.getText();
	  System.out.println(actualText);
	  Assert.assertEquals(actualText, expectedText);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
