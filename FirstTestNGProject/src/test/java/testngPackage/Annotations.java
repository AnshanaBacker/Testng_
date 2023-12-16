package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Annotations {
  @Test
  public void testcase1() {
	  
	  System.out.println("testcase one is executed");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("before method executed");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method executed");
  }
  @Test
public void testcase2() {
	  
	  System.out.println("testcase two is executed");
}
  
  
}
