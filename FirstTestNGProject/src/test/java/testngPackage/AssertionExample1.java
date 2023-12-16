package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class AssertionExample1 {
	WebDriver driver;
  @Test
  public void verifySuccessfulLogin() {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("admin");
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement admin=driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
	  String expectedText="Admin";
	  String actualText=admin.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
	    }
  @Test
  public void verifyUnSuccessfulLogin_InvalidUsername_ValidPassword() {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("Admin123456");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("admin");
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement alert=driver.findElement(By.xpath("//*[contains(text(),'Alert!')]"));
	  String expectedText="Alert!";
	  String actualText=alert.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
	    }
  @Test
  public void verifyUnSuccessfulLogin_validUsername_InvalidPassword() {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("123456");
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement alert=driver.findElement(By.xpath("//*[contains(text(),'Alert!')]"));
	  String expectedText="Alert!";
	  String actualText=alert.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
	
	    }
  @Test
  public void verifyUnSuccessfulLogin_InvalidUsername_InvalidPassword() {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("Admin123456");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("123456");
	  WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
	  Actions action=new Actions(driver);
	  action.sendKeys(button,Keys.ENTER).build().perform();
	  
	  WebElement alert=driver.findElement(By.xpath("//*[contains(text(),'Alert!')]"));
	  String expectedText="Alert!";
	  String actualText=alert.getText();
	  Assert.assertEquals(actualText,expectedText,"text mismatched");
	  System.out.println(actualText);
	
	    }
  
  @Test
  public void verifyTheRemembermeCheckboxisCheckedorNotByDefault(){
	  
	 WebElement checkbox=driver.findElement(By.xpath("//label[@for='remember']"));
	 Boolean check=checkbox.isSelected();
	 Assert.assertFalse(check);
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
