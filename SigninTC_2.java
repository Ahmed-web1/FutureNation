package com.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Common.BaseClass;

public class SigninTC_2 extends BaseClass {
  @Test(priority = 1, description = "Signin with valid email and valid password")
  public void SignIn() throws InterruptedException {
	  
	   driver.get("https://platform.futurenation.gov.bd/");
	   
	   WebElement SignBtn = driver.findElement(By.cssSelector(".MuiButton-outlined"));
	   Thread.sleep(2000);
	   
	   SignBtn.click();
	   	   
	   WebElement Email = driver.findElement(By.id("username"));
	   Email.sendKeys("m.test102@yopmail.com");
	   
	   WebElement Password = driver.findElement(By.name("password"));
	   Password.sendKeys("Ahmed@21");
	   Thread.sleep(2000);
	   
	   WebElement SigninBtn = driver.findElement(By.cssSelector("#kc-login")); 
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,250)", "");
	   SigninBtn.click();
	   
	   String ExpectedErrorMessage = "Let’s Setup your account";
	    
	   String ActualMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/h2")).getText();
	    
	    if(ExpectedErrorMessage.contains(ActualMessage)) 
	    {
	    
	    	System.out.println("Test Case Passed, Sign in Successfully.");
	    }
	    else 
	    {
	    	System.out.println("Test Case Failed, Bug Found");
	    }
	    
  }
  
}
