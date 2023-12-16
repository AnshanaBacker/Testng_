package testngPackage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
 

  @DataProvider(name="unsuccessfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "ad" },
      new Object[] { "admin123_4234", "admin" },
      new Object[] { "admin123_4", "b" }
    };
  }
  
  @DataProvider(name="login")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin", "admin" }
      
    };
  }
}

