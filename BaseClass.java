package com.Common;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
  @BeforeClass
  public void browser_Config() {
	  
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  }
  @AfterClass
  public void closeTest()
  {
	  driver.quit();
  }
}
