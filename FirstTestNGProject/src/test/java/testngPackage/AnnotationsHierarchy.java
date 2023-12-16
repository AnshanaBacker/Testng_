package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsHierarchy {
  @Test
  public void orderConcept() {
	  
	  System.out.println("test case executed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("before method executed");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("after method executed");
  }

  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("before class executed");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("after class executed");
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("before test executed");
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("after test executed");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("before suite executed");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("after suite executed");
  }

}
