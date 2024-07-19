package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegistrationPage extends BaseClass {
	RegisterPage registerPage; 
	AccountSuccessPage accountSuccessPage;
	HomePage homePage;
	WebDriver driver;
	
	public RegistrationPage() {
		super();
	}
	
	@Test(priority=1)
	public void verifyRegisterwithMandatoryFields()  {
			
			/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			registerPage.enterEmailAddress(Utilities.generatewithemailstamp());
			registerPage.entertelephoneNumber(dataProp.getProperty("telephoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.selectPrivacyPolicy();
			AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();*/
		   accountSuccessPage= registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generatewithemailstamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
			
			
			//String actualSuccessHeading=accountSuccessPage.retrieveAccountSuccessPageHeading();
			Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		
		
		
		
	}
	@Test(priority=2)
	public void verifyRegisterwithAllFields()   {
		
		
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generatewithemailstamp());
		registerPage.entertelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		
		accountSuccessPage=registerPage.clickOnContinueButton();*/
		
		accountSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generatewithemailstamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		
		//String actualSuccessHeading=accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		
		
		
	}
	
	@Test(priority=3)
	public void verifyRegiserwithExistingEmailAddress() {
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.entertelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();*/
		accountSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//String actualWarning=registerPage.retrieveduplicateEmailAddressWarning();
		Assert.assertTrue(registerPage.retrieveduplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")));
		
		
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringwithoutProvidingAnyDetails() throws Exception   {
		
		
		registerPage.clickOnContinueButton();
		
		/*String actualPrivacyPolicyWarning=registerPage.retreivePrivacyPolicyWarning();
		Assert.assertTrue(registerPage.retreivePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning Message is not displayed");
		
		
		String actualFirstNameWarning=registerPage.retreiveFirstNameWarning();
		Assert.assertEquals(registerPage.retreiveFirstNameWarning(),dataProp.getProperty("firstNameWarning"),"First Name Warning Message is not displayed");
		
		
		String actualLastNameWarning=registerPage.retreiveLastNameWarning();
		Assert.assertEquals(registerPage.retreiveLastNameWarning(),dataProp.getProperty("lastNameWarning"),"Last Name Warning Message is not displayed");
		
		
		String actualEmailWarning=registerPage.retreiveEmailWarning();
		Assert.assertEquals(registerPage.retreiveEmailWarning(),dataProp.getProperty("emailWarning"), "E-Mail Warning Message is not displayed");
		
		
		String actualTelephoneWarning=registerPage.retreiveTelephoneNumberWarning();
		Assert.assertEquals(registerPage.retreiveTelephoneNumberWarning(),dataProp.getProperty("telephoneWarning"),"Telephone Warning Message is not displayed");
		
		
		String actualPasswordWarning=registerPage.retrievePasswordWarning();
		Assert.assertEquals(registerPage.retrievePasswordWarning(),dataProp.getProperty("passwordWarning"),"Password Warning Message is not displayed");*/
		Thread.sleep(3000);
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"),dataProp.getProperty("emailWarning"),dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")), "Warning Message(s) are not displayed");
		
}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void setup() {
		
				driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
				homePage=new HomePage(driver);
				/*homePage.clickOnMyAccount();
				registerPage = homePage.selectRegisterOption();*/
				
				registerPage=homePage.navigateToRegisterPage();
				
				
				}

}
