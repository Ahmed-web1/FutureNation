package com.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Common.BaseClass;

public class SigninTC_1 extends BaseClass {
  @Test(priority = -1, description = "Signin with invalid email and invalid password")
  public void SignIn() throws InterruptedException {
	  
	   driver.get("https://platform.futurenation.gov.bd/");
	   
	   WebElement SignBtn = driver.findElement(By.cssSelector(".MuiButton-outlined"));
	   Thread.sleep(2000);	   
	   SignBtn.click();
	   	   
	   WebElement Email = driver.findElement(By.id("username"));
	   Email.sendKeys("test@test.com");
	   
	   WebElement Password = driver.findElement(By.name("password"));
	   Password.sendKeys("Password123");
	   Thread.sleep(2000);
   
	   WebElement SigninBtn = driver.findElement(By.cssSelector("#kc-login")); 
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,250)", "");
	   SigninBtn.click();
	   
	   String ExpectedErrorMessage = "Invalid username or password.";
	    
	   String ActualMessage = driver.findElement(By.xpath("//*[@id=\"input-error\"]")).getText();
	    
	    if(ExpectedErrorMessage.contains(ActualMessage)) 
	    {
	    
	    	System.out.println("Test Case Passed, Sign in failed.");
	    }
	    else 
	    {
	    	System.out.println("Test Case Failed, Bug Found");
	    }
	   
  }
  
}
