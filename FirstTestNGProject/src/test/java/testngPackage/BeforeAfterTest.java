package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BeforeAfterTest {
  @Test
  public void secondtestcase() {
	  
	  System.out.println("second test case executed");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test executed");
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("After test executed");
  }
  @Test
  public void thirdestcase() {
	  
	  System.out.println("third test case executed");
  }
  @Test
  public void firsttestcase() {
	  
	  System.out.println("first test case executed");
  }
}
