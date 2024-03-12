package com.SignupTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.Common.BaseClass;

public class SignupTC_1 extends BaseClass {
	 @Test(priority = 2, description = "Futurenation Signup with existing email")
	  public void SignUp() throws InterruptedException, IOException
	  
	  {
		   driver.get("https://platform.futurenation.gov.bd/");
		   Thread.sleep(2000);
		   		   
		   WebElement SignupBtn = driver.findElement(By.cssSelector("a.MuiButtonBase-root")); 
		   SignupBtn.click();
		   Thread.sleep(2000);
	   
		   WebElement EmailAddress = driver.findElement(By.id(":r0:"));
		   EmailAddress.sendKeys("m.test102@yopmail.com");
		   Thread.sleep(1000);
		   
		   WebElement SetPassword = driver.findElement(By.id(":r1:"));
		   SetPassword.sendKeys("Ahmed@212");
		   Thread.sleep(1000);
		   
		   WebElement RetypePassword = driver.findElement(By.id(":r2:"));
		   RetypePassword.sendKeys("Ahmed@212");
		   Thread.sleep(1000);
   
		   WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,250)", "");
		   js.executeScript("arguments[0].click();", button);
		   
		   Thread.sleep(2000);
		 
		   String ExpectedErrorMessage = "Email already exist";
		    
		   String ActualMessage = driver.findElement(By.xpath("//*[@id=\":r0:-helper-text\"]")).getText();
		    
		    if(ExpectedErrorMessage.contains(ActualMessage)) 
		    {
		    
		    	System.out.println("Test Case Passed, Sign up Failed.");
		    }
		    else 
		    {
		    	System.out.println("Test Case Failed, Bug Found");
		    }

	  }
	 
}	
