package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utilities;

 public class Login extends BaseClass {
	 WebDriver driver;
	 public Login() {
		 super();
		 
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	
	@Test(priority=1)
	public void verifyLoginwithValidCredentials() {
		
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
		
		
		
	}
	
	@Test(priority=2)
	public void verifywithInvalidCredentials() {
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		driver.findElement(By.id("input-password")).sendKeys("12345789");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
		
	}
	
	
	
	@Test(priority=3)
	public void verifywithvalidUsernameandInvalidPassword() {
		
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	@Test(priority=4)
	public void verifywithInvalidEmailandValidPassword() {
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
}
	@Test(priority=5)
	public void verifywithoutProvidingAnyCredentials() {
		
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
}
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
		
	}
 }