package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	
	@FindBy(id="input-firstname")
	private WebElement firstElementField;
   
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarning;
	
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarning;
	
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneNumberWarning;
	
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String retrievePasswordWarning() {
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	
	public String retreiveTelephoneNumberWarning() {
		String teleponeNumberWarningText=telephoneNumberWarning.getText();
		return teleponeNumberWarningText;
	}
	
	public String retreiveEmailWarning() {
		String emailWarningText=emailWarning.getText();
		return emailWarningText;
	}
	
	
	public String retreiveLastNameWarning() {
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	
	
	public String retreiveFirstNameWarning() {
		String firstNameWarningText=firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	
	
	
	
	public String retreivePrivacyPolicyWarning() {
		String privacyPolicyWarningText=privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
		
		
	}
	
	
	
	
	public void enterFirstName(String firstNameText) {
		firstElementField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
		
	}
	
	public void entertelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordConfirmText) {
		passwordConfirmField.sendKeys(passwordConfirmText);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption() {
		yesNewsLetterOption.click();
	}
	
	
	public String retrieveduplicateEmailAddressWarning() {
		String duplicateEmailAddressWarningText= duplicateEmailAddressWarning.getText();
		return duplicateEmailAddressWarningText;
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) {
		firstElementField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(passwordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithAllFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) {
		firstElementField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(passwordText);
		yesNewsLetterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean displayStatusOfWarningMessages(String expectedprivacyPolicyWarning,String expectedfirstNameWarning,String expectedlastNameWarning,String expectedemailWarning,String expectedtelephoneWarning,String expectedpasswordWarning)
	{
		//String actualPrivacyPolicyWarningText=privacyPolicyWarning.getText();
		boolean privacyPolicyWarningStatus=privacyPolicyWarning.getText().contains(expectedprivacyPolicyWarning);
		
		//String actualFirstNameWarningText=firstNameWarning.getText();
		boolean firstNameWarningStatus=firstNameWarning.getText().contains(expectedfirstNameWarning);
		
		//String actualLastNameWarningText=lastNameWarning.getText();
		boolean lastNameWarningStatus=lastNameWarning.getText().contains(expectedlastNameWarning);
		
		//String actualEmailWarningText=emailWarning.getText();
		boolean emailWarningStatus=emailWarning.getText().contains(expectedemailWarning);
		
		//String actualTelephoneWarningText=telephoneNumberWarning.getText();
		boolean telephoneWarningStatus=telephoneNumberWarning.getText().contains(expectedtelephoneWarning);
		
		//String actualPasswordWarningText=passwordWarning.getText();
		boolean passwordWarningStatus=passwordWarning.getText().contains(expectedpasswordWarning);
		
	
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
		
	
	}
	
}
