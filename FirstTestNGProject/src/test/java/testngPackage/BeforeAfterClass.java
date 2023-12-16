package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BeforeAfterClass {
  @Test
  public void firsttestcase() {
	  
	  System.out.println("first test case executed");
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("Before class executed");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("After class executed");
  }
  
  @Test
  public void secondtestcase() {
	  
	  System.out.println("second test case executed");
  }
  @Test
  public void thirdtestcase() {
	  
	  System.out.println("third test case executed");
  }
  
}
