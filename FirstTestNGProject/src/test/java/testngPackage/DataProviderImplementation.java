package testngPackage;

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

public class DataProviderImplementation {
	WebDriver driver;
  @Test(dataProvider = "login",dataProviderClass = DataProviderClass.class)
  public void successfulLogin(String uname,String passwd) {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(passwd);
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement admin=driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
	  String expectedText="Admin";
	  String actualText=admin.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
  }
  @Test(dataProvider = "unsuccessfulLogin",dataProviderClass = DataProviderClass.class)
  public void verifyUnSuccessfulLogin_InvalidUsername_ValidPassword(String uname,String passwd) {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(passwd);
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement alert=driver.findElement(By.xpath("//*[contains(text(),'Alert!')]"));
	  String expectedText="Alert!";
	  String actualText=alert.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
	    }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new ChromeDriver();
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
