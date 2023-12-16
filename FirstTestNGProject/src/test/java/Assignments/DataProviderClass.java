package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  
  @DataProvider(name="unSuccessfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"hwjhqwj" , "admin123" },
      new Object[] { "Admin", "backer" },
      new Object[] { "Adminasgdh", "bjh" }
    };
  }
  @DataProvider(name="SuccessfulLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" }
    };
  }
}
