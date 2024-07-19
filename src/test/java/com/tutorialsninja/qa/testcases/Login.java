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
	 LoginPage loginPage;
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
		
		/*loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);*/
		//AccountPage accountPage = loginPage.clickOnLoginButton();
		
		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfChangeYourPassword(),"Change Your Password is not displayed");
		
		
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	
	
	@Test(priority=2)
	public void verifywithInvalidCredentials() {
		
		loginPage.login(Utilities.generatewithemailstamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Warning: No match for E-Mail Address and/or Password.");
		
		
		/*loginPage.enterEmailAddress(Utilities.generatewithemailstamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();*/
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		//driver.findElement(By.id("input-password")).sendKeys("12345789");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		//String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
		
	}
	
	
	
	@Test(priority=3)
	public void verifywithvalidUsernameandInvalidPassword() {
		
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Warning: No match for E-Mail Address and/or Password.");
		
		
		
		/*loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();*/
		//String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		//String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
		
		
	}
	
	@Test(priority=4)
	public void verifywithInvalidEmailandValidPassword() {
		
		loginPage.login(Utilities.generatewithemailstamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Warning: No match for E-Mail Address and/or Password.");
		
		/*loginPage.enterEmailAddress(Utilities.generatewithemailstamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();*/
		//String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generatewithemailstamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		//String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		
		
}
	@Test(priority=5)
	public void verifywithoutProvidingAnyCredentials() {
		
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.retrieveEmailPasswordWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Warning: No match for E-Mail Address and/or Password.");
		
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys("");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//String actualWarningMessage=loginPage.retrieveEmailPasswordWarningMessageText();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		//String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
}
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		  HomePage homePage=new HomePage(driver);
		/*  homePage.clickOnMyAccount();
		 loginPage=homePage.selectLoginOption();*/
		 loginPage= homePage.navigateToLoginPage();
		
	}
 }
