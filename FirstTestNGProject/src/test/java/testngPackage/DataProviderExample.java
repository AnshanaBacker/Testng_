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
import org.testng.annotations.DataProvider;

public class DataProviderExample {
	WebDriver driver;
  @Test(dataProvider = "unsucessfulLogin")
  public void verifuUnsuccessfulLogin(String username1, String password1) {
	  
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys(username1);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(password1);
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
  


  @DataProvider(name="unsucessfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "a" },
      new Object[] { "admin_123456", "admin" },
      new Object[] { "admin12345", "berdf" }
    };
  }
}
