package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.checkerframework.checker.units.qual.Time;
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

public class RegistrationPage extends BaseClass {
	WebDriver driver;
	
	public RegistrationPage() {
		super();
	}
	
	@Test(priority=1)
	public void verifyRegisterwithMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firsametName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String atcualHeading=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(atcualHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		
		
		
	}
	@Test(priority=2)
	public void verifyRegisterwithAllFields() {
		 
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String atcualHeading=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(atcualHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		
		
		
	}
	
	@Test(priority=3)
	public void verifyRegiserwithExistingEmailAddress() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")));
		
		
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringwithoutProvidingAnyDetails() {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning Message is not displayed");
		String actualFirstNameWarning=driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText();
		Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"),"First Name Warning Message is not displayed");
		
		String actualLastNameWarning=driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText();
		Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"),"Last Name Warning Message is not displayed");
		
		String actualEmailWarning=driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"), "E-Mail Warning Message is not displayed");
		
		String actualTelephoneWarning=driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText();
		Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telephoneWarning"),"Telephone Warning Message is not displayed");
		
		String actualPasswordWarning=driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"),"Password Warning Message is not displayed");
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void setup() {
		
				driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
				driver.findElement(By.xpath("//span[text()='My Account']")).click();
				driver.findElement(By.linkText("Register")).click();
			
	}

}
