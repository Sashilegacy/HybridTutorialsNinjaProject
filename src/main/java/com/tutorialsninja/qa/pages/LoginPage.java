package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//Objects
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage login(String username,String password) {
		emailAddressField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	
	public String retrieveEmailPasswordWarningMessageText() {
		String warningText=emailPasswordNotMatchingWarning.getText();
		return warningText;
	}
	
	
}
