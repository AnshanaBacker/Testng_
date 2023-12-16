package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestngTest {
  @Test(priority=1)
  public void testGoogle() throws Exception {
	  
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  WebElement search=driver.findElement(By.name("q"));
	  search.sendKeys("testng",Keys.ENTER);
	
	  driver.close();
	  
	  
  }


@Test(priority=2)
public void testFacebook() throws Exception {
	  
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.facebook.com/login/");
	  driver.manage().window().maximize();
	  WebElement search=driver.findElement(By.xpath("//input[@name='email']"));
	  search.clear();
	 // search.sendKeys("HYR TUTORIALS",Keys.ENTER);
	
	  //title
	  String expectedTitle="Log in to Facebook";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");
	  
	  //Url
	  
	  String expectedUrl="https://www.facebook.com/login/";
	  String actualUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl,expectedUrl,"URL is mismatched");
	  
	  
	  //Border
	  
	  String expectedBorder="1px solid rgb(240, 40, 73)";
	  String actualBorder=driver.findElement(By.xpath("//input[@name='email']")).getCssValue("border");
	  Assert.assertEquals(actualBorder,expectedBorder,"border is mismatched");
	  
	  
	  
	  
	  
	 driver.close();
}
}