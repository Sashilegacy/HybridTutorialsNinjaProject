package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
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
	 
	 
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginwithValidCredentials(String email, String password) {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfChangeYourPassword(),"Change Your Password is not displayed");
		
		
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	
	
	@Test(priority=2)
	public void verifywithInvalidCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generatewithemailstamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		//driver.findElement(By.id("input-password")).sendKeys("12345789");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
		
	}
	
	
	
	@Test(priority=3)
	public void verifywithvalidUsernameandInvalidPassword() {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	@Test(priority=4)
	public void verifywithInvalidEmailandValidPassword() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generatewithemailstamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
}
	@Test(priority=5)
	public void verifywithoutProvidingAnyCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickOnLoginButton();
		String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys("");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
}
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		  HomePage homePage=new HomePage(driver);
		  homePage.clickOnMyAccount();
		  homePage.selectLoginOption();
		
	}
 }
