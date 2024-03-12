package com.SignupTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.Common.BaseClass;

public class SignupTC_2 extends BaseClass {
	 @Test(priority = 3, description = "Futurenation Signup with valid email, valid set password and same retype password")
	  public void SignUp() throws InterruptedException, IOException
	  
	  {
		   driver.get("https://platform.futurenation.gov.bd/");
		   Thread.sleep(2000);
		   		   
		   WebElement SignupBtn = driver.findElement(By.cssSelector("a.MuiButtonBase-root")); 
		   SignupBtn.click();
		   Thread.sleep(2000);
	   
		   WebElement EmailAddress = driver.findElement(By.id(":r0:"));
		   EmailAddress.sendKeys("m.test106@yopmail.com");
		   Thread.sleep(1000);
		   
		   WebElement SetPassword = driver.findElement(By.id(":r1:"));
		   SetPassword.sendKeys("Ahmed@21");
		   Thread.sleep(1000);
		   
		   WebElement RetypePassword = driver.findElement(By.id(":r2:"));
		   RetypePassword.sendKeys("Ahmed@21");
		   Thread.sleep(2000);

		   WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,250)", "");
		   js.executeScript("arguments[0].click();", button);
		   
		   Thread.sleep(1000);
		 
		   String ExpectedErrorMessage = "Please check your inbox for an email from Futurenation.";
		    
		   String ActualMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div/p")).getText();
		    
		    if(ExpectedErrorMessage.contains(ActualMessage)) 
		    {
		    
		    	System.out.println("Test Case Passed, Sign up Successfully.");
		    }
		    else 
		    {
		    	System.out.println("Test Case Failed, Bug Found");
		    }

	  }
	 
}	
